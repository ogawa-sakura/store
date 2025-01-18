/**
 * 
 */
package c25;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import bean.Product;
import tool.Action;
import tool.Const;

/**
 * 商品追加アクション
 * @author c3user
 *
 */
public class CartAddAction extends Action {

	@Override
	public String exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// セッション取得
		HttpSession session = request.getSession();
		// 追加商品ID取得
		int id = Integer.parseInt(request.getParameter(Const.PARAM_ID));
		// 追加数取得
		int count = Integer.parseInt(request.getParameter(Const.PARAM_COUNT));
		// カート数量変更か確認(0：追加、1：変更)
		int change = Integer.parseInt(request.getParameter(Const.PARAM_CHANGE));
		// カート情報を取得
		@SuppressWarnings("unchecked")
		Map<Integer, Item> cart = (LinkedHashMap<Integer, Item>) session.getAttribute(Const.PARAM_CART);
		// カートページで数量変更時
		if (change == Const.SESSION_CART_CHANGE) {
			for (Item item : cart.values()) {
				if (item.getProduct().getP_id() == id) {
					item.setCount(count);
					// 合計値をセッションに設定
					setSum(cart, session);
					return Const.SESSION_CART;
				}
			}
		}
		// カート情報が無ければ新規作成
		if (cart == null) {
			cart = new LinkedHashMap<>();
			session.setAttribute(Const.PARAM_CART, cart);
		}
		// 既にカートに商品が存在するか確認してあれば個数に追加
		for (Item item : cart.values()) {
			if (item.getProduct().getP_id() == id) {
				item.setCount(item.getCount() + count);
				// 合計値をセッションに設定
				setSum(cart, session);
				return Const.SESSION_PRODUCT;
			}
		}
		// カートに無い商品の新規追加処理
		@SuppressWarnings("unchecked")
		List<Product> list = (List<Product>) session.getAttribute(Const.PARAM_LIST);
		if (list == null) {
			return Const.SESSION_CART;
		}
		for (Product product : list) {
			if (product.getP_id() == id) {
				Item item = new Item();
				item.setProduct(product);
				item.setCount(count);
				cart.put(id, item);
				break;
			}
		}
		// 合計値をセッションに設定
		setSum(cart, session);
		return Const.SESSION_PRODUCT;

	}
}
