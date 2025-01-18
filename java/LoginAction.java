/**
 * 
 */
package c24;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import dao.CustomerDAO;
import dao.DAO;
import tool.Action;
import tool.Const;

/**
 * ログイン管理アクション
 * @author c3user
 *
 */
public class LoginAction extends Action {

	@Override
	public String exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// コネクションオブジェクト作成
		HttpSession session = request.getSession();
		Connection con = null;
		try {
			// 各キーワード取得
			String login = request.getParameter(Const.PARAM_LOGIN);
			String password = request.getParameter(Const.PARAM_PASSWORD);
			// エラーメッセージオブジェクト作成
			List<String> errorList = new ArrayList<>();
			// 検索用オブジェクト作成
			CustomerDAO dao = new CustomerDAO();
			// コネクション取得
			con = DAO.getConnection();
			// id未入力かチェック
			if ("".equals(login)) {
				errorList.add(Const.MESSAGE_BLANK_LOGIN);
			}
			// pass未入力かチェック
			if ("".equals(password)) {
				errorList.add(Const.MESSAGE_BLANK_PASS);
			}
			if (errorList.isEmpty()) {
				// id,passをデータベースと照合
				Customer customer = dao.serch(login, password, con);
				if (customer != null) {
					session.setAttribute(Const.SESSION_CUSTOMER, customer);
					return Const.SESSION_LOGIN_OUT;
				} else {
					errorList.add(Const.MESSAGE_ERROR_LOGIN);
				}
			}
			// エラーメッセージをリクエスト属性に設定
			request.setAttribute(Const.SESSION_ERROR_LIST, errorList);
			return Const.SESSION_LOGIN_IN;
		} finally {
			// コネクションクローズ
			if (con != null) {
				con.close();
			}
		}
	}
}
