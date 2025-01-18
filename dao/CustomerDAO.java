package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import bean.Customer;
import tool.Const;

public class CustomerDAO extends DAO {

	public Customer serch(String login, String password, Connection con) throws Exception {
		// return用オブジェクト作成
		Customer customer = null;
		//SQL文オブジェクト
		PreparedStatement st = null;
		//検索結果代入オブジェクト
		ResultSet rs = null;
		try {
			//コネクション取得用icオブジェクト作成
			InitialContext ic = new InitialContext();
			//データソース取得
			DataSource ds = (DataSource) ic.lookup(Const.DATASOURCE_URL);
			//コネクション取得
			con = ds.getConnection();
			//SQL文作成
			st = con.prepareStatement(tool.SqlTools.getSql(Const.SQL_LOGIN_SEARCH));
			st.setString(1, login);
			st.setString(2, password);
			//検索実施
			rs = st.executeQuery();
			//検索結果をオブジェクトに代入
			while (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt(Const.PARAM_ID));
				customer.setLogin(rs.getString(Const.PARAM_LOGIN));
				customer.setPassword(rs.getString(Const.PARAM_PASSWORD));
				customer.setEmail(rs.getString(Const.PARAM_EMAIL));
				customer.setL_name(rs.getString(Const.PARAM_L_NAME));
				customer.setF_name(rs.getString(Const.PARAM_F_NAME));
				customer.setTel(rs.getLong(Const.PARAM_TEL));
				customer.setPost_code(rs.getLong(Const.PARAM_POST_CODE));
				customer.setPrefecture(rs.getString(Const.PARAM_PREFECTURE));
				customer.setCity(rs.getString(Const.PARAM_CITY));
				customer.setO_address(rs.getString(Const.PARAM_O_ADDRESS));
			}
			return customer;

		} finally {
			//リザルトセット・ステートメント・コネクションのクローズ
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
		}
	}
}
