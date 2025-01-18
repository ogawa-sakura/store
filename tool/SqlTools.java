package tool;

import java.util.ResourceBundle;

/**
 * SQL文を取得するクラス
 * @author c3intl
 *
 */
public class SqlTools {

	/** プロパティファイル */
	private final static String SQL_PROPERTY = "sqlProperty";

	/**
	 * SQL取得するメソッド
	 * @param key	SQLプロパティからSQLを取得するキー
	 * @return	SQL文
	 * @exception SQL文が取得できなかった場合
	 */
	public static String getSql(String key) throws Exception {
		ResourceBundle resourceBundle = ResourceBundle.getBundle(SQL_PROPERTY);
		return resourceBundle.getString(key);
	}
}
