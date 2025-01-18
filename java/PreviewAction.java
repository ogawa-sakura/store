/**
 * 
 */
package c25;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.Action;
import tool.Const;

/**
 * 購入前セッション確認アクション
 * @author c3user
 *
 */
public class PreviewAction extends Action {

	@Override
	public String exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// セッション取得
		HttpSession session = request.getSession();
		// ログインセッション情報があるか確認
		if (session.getAttribute(Const.SESSION_CUSTOMER) == null) {
			return Const.SESSION_LOGIN_NULL;
		}
		// カートセッション情報があるか確認
		@SuppressWarnings("unchecked")
		Map<Integer, Item> cart = (Map<Integer, Item>) session.getAttribute(Const.PARAM_CART);
		if (cart == null || cart.size() == 0) {
			return Const.SESSION_CART_NULL;
		}
		return Const.SESSION_PURCHASE_IN;
	}
}
