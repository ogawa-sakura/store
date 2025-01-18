package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import tool.Const;

/**
 * ID新設DAO
 * @author c3user
 *
 */
public class RegisterDAO extends DAO {
	/**
	 * IDとPASSを元に新設実施するメソッド
	 * @param id			ID
	 * @param pass			パスワード
	 * @param con			コネクション
	 * @return				新設件数
	 * @throws Exception	発生例外
	 */
	public int insert(String login, String pass, String email, String l_name, String f_name, long tel,
			long post_code, String prefecture, String city, String o_address,Connection con) throws Exception {
		// 新設文取得用
		PreparedStatement st = null;
		// SQL文作成用
		ResultSet rs = null;
		/* 新設件数 */
		int insCnt = 0;
		try {
			// SQL文作成
			st = con.prepareStatement(tool.SqlTools.getSql(Const.SQL_LOGIN_INSERT));
			st.setString(1, login);
			st.setString(2, pass);
			st.setString(3, email);
			st.setString(4, l_name);
			st.setString(5, f_name);
			st.setLong(6, tel);
			st.setLong(7, post_code);
			st.setString(8, prefecture);
			st.setString(9, city);
			st.setString(10, o_address);
			
			
			
			// 新設件数をオブジェクトに代入
			insCnt = st.executeUpdate();

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
		return insCnt;
	}

}
