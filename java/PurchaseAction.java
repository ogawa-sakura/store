/**
 * 
 */
package c25;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import bean.Item;
import dao.DAO;
import dao.PurchaseDAO;
import tool.Action;
import tool.Const;

/**
 * 購入アクション
 * @author c3user
 *
 */
public class PurchaseAction extends Action {
	@Override
	public String exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// セッション取得
		HttpSession session = request.getSession();
		Connection con = null;
		// エラーメッセージオブジェクト作成
		List<String> purchaseErrorList = new ArrayList<>();
		try {
			// 各キーワード取得
			String name = request.getParameter(Const.PARAM_NAME);
			String address = request.getParameter(Const.PARAM_ADDRESS);
			String confirm = request.getParameter(Const.PARAM_PURCHASE_CONFIRM);
			Customer customer = (Customer) session.getAttribute(Const.SESSION_CUSTOMER);
			String customerName = customer.getL_name() + customer.getF_name();
			String customerAddress = customer.getPrefecture() + customer.getCity() + customer.getO_address();
			// 新設用オブジェクト作成
			PurchaseDAO dao = new PurchaseDAO();
			// コネクション取得
			con = DAO.getConnection();
			// オートコミットオフ
			con.setAutoCommit(false);

			// 名前未入力かチェック
			if ("".equals(name)) {
				purchaseErrorList.add(Const.MESSAGE_BLANK_NAME);
			}
			// 住所未入力かチェックW
			if ("".equals(address)) {
				purchaseErrorList.add(Const.MESSAGE_BLANK_ADDRESS);
			}

			// カート情報を取得
			@SuppressWarnings("unchecked")
			Map<Integer, Item> cart = (LinkedHashMap<Integer, Item>) session.getAttribute(Const.PARAM_CART);
			// セッション切れなどでカートが存在しない場合の処理 
			if (cart == null) {
				return Const.SESSION_CART;
			}
			if (purchaseErrorList.isEmpty()) {
				// コンファーム画面を経由してないか確認
				if (Const.PARAM_PURCHASE_N.equals(confirm)) {
					// コンファームフラグをセット
					request.setAttribute(Const.PARAM_PURCHASE_CONFIRM, Const.PARAM_PURCHASE_Y);
					return Const.SESSION_PURCHASE_IN;
				}
				// name,住所を元に新設実施
				int insCnt = dao.insert(cart, customer, name, address, con);
				// 新設件数とカート件数が同じか確認
				if (insCnt == cart.size()) {
					con.commit();
					// カートセッション情報を削除
					session.removeAttribute(Const.PARAM_CART);
					// 合計値セッション情報を削除
					session.removeAttribute(Const.SESSION_SUMPRICE);
					session.removeAttribute(Const.SESSION_SUMCOUNT);
					// コンファームフラグをリセット
					request.setAttribute(Const.PARAM_PURCHASE_CONFIRM, Const.PARAM_PURCHASE_N);
				} else {
					if (con != null) {
						con.rollback();
					}
					return Const.SESSION_PURCHASE_ERROR;
				}
			} else {
				// エラーメッセージをリクエスト属性に設定
				request.setAttribute(Const.SESSION_PURCHASE_ERROR_LIST, purchaseErrorList);
				return Const.SESSION_PURCHASE_IN;
			}
			return Const.SESSION_PURCHASE_OUT;
		} catch (Exception e) {
			if (con != null) {
				con.rollback();
			}
			return Const.SESSION_PURCHASE_ERROR;
		} finally {
			// コネクションクローズ
			if (con != null) {
				con.close();
			}
		}
	}
}
