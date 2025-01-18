package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Customer;
import bean.CustomerInf;
import bean.Product;
import tool.Const;

/**
 *顧客情報表示DAO
 * @author c3user
 *
 */
public class CustomerInfDAO extends DAO {
	/**
	 * keywordを含むワードで検索
	 * @param keyword		検索キーワード
	 * @param con			コネクション
	 * @return				検索結果
	 * @throws Exception	発生例外・処理元へthrowする
	 */
	public List<CustomerInf> search(Customer customer, Connection con) throws Exception {
		/** 戻り値用List */
		List<CustomerInf> list = new ArrayList<>();
		// 検索文取得用
		PreparedStatement st = null;
		// 検索結果入力用
		ResultSet rs = null;
		try {
			// SQL文作成	keywordを含むワードで検索
			st = con.prepareStatement(tool.SqlTools.getSql(Const.SQL_CUSTOMER_SEARCH));
			st.setString(1, customer.getLogin());
			// 検索結果をオブジェクトに代入
			rs = st.executeQuery();
			// listに検索結果を入力
			while (rs.next()) {
				CustomerInf customerInf = new CustomerInf();
				customerInf.setOrder_id(rs.getInt("order_id"));
				customerInf.setIns_datetime(rs.getTimestamp("ins_datetime"));
				customerInf.setP_id(rs.getInt("p_id"));
				customerInf.setName(rs.getString("name"));
				customerInf.setSum_price(rs.getInt("sum_price"));
				customerInf.setOrder_count(rs.getInt("order_count"));
				customerInf.setSend_name(rs.getString("send_name"));
				customerInf.setSend_address(rs.getString("send_address"));
				list.add(customerInf);
			}
		} finally {
			// リザルトセットのクローズ
			if (rs != null) {
				rs.close();
			}
			// ステートメントのクローズ
			if (st != null) {
				st.close();
			}
		}
		return list;
	}

	/**
	 * productよりNAME・PRICEを取得し新設
	 * @param product		新設対象データ
	 * @param con			コネクション
	 * @return				新設件数
	 * @throws Exception	発生例外・処理元へthrowする
	 */
	public int insert(Product product, Connection con) throws Exception {
		/** 戻り値用int */
		int insCnt;
		// 追加文取得用
		PreparedStatement st = null;
		try {
			// SQL文作成	productよりNAME・PRICEを取得し作成
			st = con.prepareStatement(tool.SqlTools.getSql(Const.SQL_PRODUCT_INSERT));
			st.setString(1, product.getName());
			st.setInt(2, product.getPrice());
			//新設実施・新設処理件数をオブジェクトに代入
			insCnt = st.executeUpdate();
		} finally {
			// ステートメントのクローズ
			if (st != null) {
				st.close();
			}
		}
		return insCnt;
	}
}
