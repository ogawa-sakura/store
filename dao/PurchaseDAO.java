package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Map;

import bean.Customer;
import bean.Item;
import tool.Const;

/**
 * 購入処理DAO
 * @author c3user
 *
 */
public class PurchaseDAO extends DAO {
	/**
	 * 購入処理
	 * @param cart			カート情報
	 * @param name			購入者名
	 * @param address		購入者住所
	 * @param con			コネクション
	 * @return				新設件数
	 * @throws Exception	発生例外
	 */
	public int insert(Map<Integer, Item> cart, Customer customer, String name, String address, Connection con)
			throws Exception {
		// 新設文取得用
		PreparedStatement purchaseStmt = null;
		PreparedStatement orderDescStmt = null;

		// SQL文作成用
		ResultSet rs = null;
		// SQL文作成用
		ResultSet rs2 = null;
		/* 新設件数 */
		int insCnt = 0;
		try {
			// SQL文作成
			purchaseStmt = con.prepareStatement(tool.SqlTools.getSql(Const.SQL_PURCHASE_INSERT2),
					PreparedStatement.RETURN_GENERATED_KEYS);
			orderDescStmt = con.prepareStatement(tool.SqlTools.getSql(Const.SQL_PURCHASE_INSERT3));
			for (Item item : cart.values()) {
				// purchaseテーブルの更新
				purchaseStmt.setString(1, customer.getLogin());
				purchaseStmt.executeUpdate();

				// purchaseテーブルに挿入されたorder_idを取得 
				rs2 = purchaseStmt.getGeneratedKeys();
				int order_id = 0;
				if (rs2.next()) {
					order_id = rs2.getInt(1);
				}

				// order_descテーブルを更新
				//オーダー番号
				orderDescStmt.setInt(1, order_id);
				//商品ID
				orderDescStmt.setInt(2, item.getProduct().getP_id());
				// 購入数
				orderDescStmt.setInt(3, item.getCount());

				// 名前・住所が入力されている場合、その住所を優先
				orderDescStmt.setString(4, name);
				orderDescStmt.setString(5, address);

				orderDescStmt.addBatch();
			}

			// 複数新設実行
			int[] arrays = orderDescStmt.executeBatch();
			// 新設件数をint配列からintへ集計する
			insCnt = Arrays.stream(arrays).sum();
		} finally {
			// リザルトセットのクローズ
			if (rs != null) {
				rs.close();
			}
			// ステートメントのクローズ
			if (orderDescStmt != null) {
				orderDescStmt.close();
			}
			if (purchaseStmt != null) {
				purchaseStmt.close();
			}
		}
		return insCnt;
	}

}
