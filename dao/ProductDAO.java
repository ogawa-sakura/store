package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

/**
 * 商品情報DAO
 * @author c3user
 *
 */
public class ProductDAO extends DAO {
	/**
	 * keywordを含むワードで検索
	 * @param keyword		検索キーワード
	 * @param con			コネクション
	 * @return				検索結果
	 * @throws Exception	発生例外・処理元へthrowする
	 */
	public List<Product> search(String keyword, Connection con) throws Exception {
		/** 戻り値用List */
		List<Product> list = new ArrayList<>();
		// 検索文取得用
		PreparedStatement st = null;
		// 検索結果入力用
		ResultSet rs = null;
		try {
			// SQL文作成	keywordを含むワードで検索
			st = con.prepareStatement(tool.SqlTools.getSql("SEL_B02"));
			st.setString(1, "%" + keyword + "%");
			// 検索結果をオブジェクトに代入
			rs = st.executeQuery();
			// listに検索結果を入力
			while (rs.next()) {
				Product product = new Product();
				product.setP_id(rs.getInt("P_ID"));
				product.setName(rs.getString("NAME"));
				product.setPrice(rs.getInt("PRICE"));
				list.add(product);
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
			st = con.prepareStatement(tool.SqlTools.getSql("INS_B01"));
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
