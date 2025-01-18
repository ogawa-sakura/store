/**
 * 
 */
package c24;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import dao.RegisterDAO;
import tool.Action;
import tool.Const;

/**
 * 新規ID登録アクション
 * @author c3user
 *
 */
public class RegisterAction extends Action {

	@Override
	public String exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection con = null;
		// エラーメッセージオブジェクト作成
		List<String> registerErrorList = new ArrayList<>();
		try {
			// 各キーワード取得
			String login = request.getParameter(Const.PARAM_LOGIN);
			String password = request.getParameter(Const.PARAM_PASSWORD);
			String email = request.getParameter(Const.PARAM_EMAIL);
			String l_name = request.getParameter(Const.PARAM_L_NAME);
			String f_name = request.getParameter(Const.PARAM_F_NAME);
			String tel_unchecked = request.getParameter(Const.PARAM_TEL);
			String post_code_unchecked = request.getParameter(Const.PARAM_POST_CODE);
			String prefecture = request.getParameter(Const.PARAM_PREFECTURE);
			String city = request.getParameter(Const.PARAM_CITY);
			String o_address = request.getParameter(Const.PARAM_O_ADDRESS);

			// 各キーワードチェック：ログイン名PASSチェック：6文字以上、かつ英数字記号(_-.)を一つ以上含む
			checkParameter(registerErrorList, login, "ログイン名", 6, Const.PARAM_REGEX_PATTERN_LOGINPASS);
			checkParameter(registerErrorList, password, "パスワード", 6, Const.PARAM_REGEX_PATTERN_LOGINPASS);
			// 各キーワードチェック：メールアドレスチェック：4文字以上、xxx@xx.xxの形式と合致するもの
			checkParameter(registerErrorList, email, "メールアドレス", 4, Const.PARAM_REGEX_PATTERN_MAIL);
			// 各キーワードチェック：null
			checkParameter(registerErrorList, l_name, "姓");
			checkParameter(registerErrorList, f_name, "名");
			checkParameter(registerErrorList, prefecture, "都道府県");
			checkParameter(registerErrorList, city, "市町村");
			checkParameter(registerErrorList, o_address, "その他住所");
			// 各キーワードチェック：int値に文字列が入ってないか、文字数は正しいか
			long tel = checkIntParameter(registerErrorList, tel_unchecked, "電話番号", 11);
			long post_code = checkIntParameter(registerErrorList, post_code_unchecked, "郵便番号", 7);

			// 新設用オブジェクト作成
			RegisterDAO dao = new RegisterDAO();
			// コネクション取得
			con = DAO.getConnection();
			// オートコミットオフ
			con.setAutoCommit(false);
			if (registerErrorList.isEmpty()) {
				// 各種キーワードを元にid新設実施
				dao.insert(login, password, email, l_name, f_name, tel, post_code, prefecture, city, o_address, con);
				con.commit();
				registerErrorList.add(Const.MESSAGE_SUCCESS_REGISTER);
			} else {
				// エラーメッセージをリクエスト属性に設定
				request.setAttribute(Const.SESSION_REGISTER_ERROR_LIST, registerErrorList);
				return Const.SESSION_REGISTER;
			}
			// 追加成功メッセージをリクエスト属性に設定
			request.setAttribute(Const.SESSION_ERROR_LIST, registerErrorList);
			return Const.SESSION_LOGIN_IN;

		} catch (Exception e) {
			if (con != null) {
				con.rollback();
			}
			registerErrorList.add(Const.MESSAGE_ERROR_REGISTER);
			// エラーメッセージをリクエスト属性に設定
			request.setAttribute(Const.SESSION_REGISTER_ERROR_LIST, registerErrorList);
			return Const.SESSION_REGISTER;
		} finally {
			// コネクションクローズ
			if (con != null) {
				con.close();
			}
		}
	}

	private void checkParameter(List<String> errorList, String param, String paramName) {
		if (param == null || param.isEmpty()) {
			errorList.add(paramName + "が入力されていません。");
		}
	}

	private void checkParameter(List<String> errorList, String param, String paramName, int minLength,
			String regexPattern) {
		if (param == null || param.isEmpty()) {
			errorList.add(paramName + "が入力されていません。");
		} else {
			if (minLength > 0 && param.length() < minLength) {
				errorList.add(paramName + "は" + minLength + "文字以上で入力してください。");
			}
			if (regexPattern != null) {
				Pattern pattern = Pattern.compile(regexPattern);
				Matcher matcher = pattern.matcher(param);
				if (!matcher.matches()) {
					errorList.add(paramName + "は指定された形式で入力してください。");
				}
			}
		}
	}

	private long checkIntParameter(List<String> errorList, String param, String paramName, int length) {
		long reslt = 0;
		if (param == null || param.isEmpty()) {
			errorList.add(paramName + "が入力されていません。");
		} else {
			try {
				reslt = Long.parseLong(param);
				if (length != param.length()) {
					errorList.add(paramName + "は" + length + "文字で入力してください。");
				}
			} catch (NumberFormatException e) {
				errorList.add(paramName + "は数値のみで入力してください。");
			}
		}
		return reslt;
	}

}
