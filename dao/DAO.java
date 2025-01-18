package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;
/**
 * DAO共通クラス
 * @author c3user
 *
 */
public class DAO {
	/** DataSource保存用 */
	private static DataSource ds;
	
	/**
	 * コネクション取得
	 * @return				コネクション
	 * @throws Exception	発生例外
	 */
	public static Connection getConnection() throws Exception{
		if (ds == null) {
			//コネクション取得用icオブジェクト作成
			InitialContext ic = new InitialContext();
			//データソース取得
			ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
		}
		//コネクション取得
		return ds.getConnection();
	}
}
