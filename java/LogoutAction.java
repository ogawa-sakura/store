/**
 * 
 */
package c24;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;
import tool.Const;

/**
 * ログアウト管理アクション
 * @author c3user
 *
 */
public class LogoutAction extends Action {

	@Override
	public String exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// セッションオブジェクト作成
		HttpSession session = request.getSession();
		// セッション情報があればログアウト
		if (session.getAttribute(Const.SESSION_CUSTOMER) != null) {
			session.removeAttribute(Const.SESSION_CUSTOMER);
			return Const.SESSION_LOGOUT_OUT;
		}
		// セッション情報なしの場合エラーページへ
		return Const.SESSION_LOGOUT_ERROR;
	}
}
