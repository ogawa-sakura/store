/**
 * 
 */
package c25;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.Action;
import tool.Const;

/**
 * 商品削除アクション
 * @author c3user
 *
 */
public class CartRemoveAction extends Action {
	@Override
	public String exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// セッション取得
		HttpSession session = request.getSession();
		// 削除商品ID取得
		int id = Integer.parseInt(request.getParameter(Const.PARAM_ID));
		// カート情報を取得
		@SuppressWarnings("unchecked")
		Map<Integer, Item> cart = (LinkedHashMap<Integer, Item>) session.getAttribute(Const.PARAM_CART);
		// セッション切れなどでカートが存在しない場合の処理 
		if (cart == null) {
			return Const.SESSION_CART;
		}
		// idがSESSION_CART_DELETEの場合カート内全削除
		if (id == Const.SESSION_CART_DELETE) {
			session.removeAttribute(Const.PARAM_CART);
		} else {
			// IDを元にカート情報から１件削除
			for (Item item : cart.values()) {
				if (item.getProduct().getP_id() == id) {
					cart.remove(id);
					break;
				}
			}
		}
		// 合計値をセッションに設定
		setSum(cart, session);
		return Const.SESSION_CART;
	}
}
