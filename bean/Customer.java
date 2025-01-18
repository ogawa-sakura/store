package bean;

import java.io.Serializable;

/**
 * 顧客情報格納用Bean
 * @author c3user
 *
 */
public class Customer implements Serializable {
	/* 顧客番号 */
	private int id;
	/* ログイン名 */
	private String login;
	/* パスワード */
	private String password;
	/* メールアドレス */
	private String email;
	/* 姓 */
	private String l_name;
	/* 名 */
	private String f_name;
	/* 電話番号 */
	private long tel;
	/* 郵便番号 */
	private long post_code;
	/* 都道府県名 */
	private String prefecture;
	/* 市町村名 */
	private String city;
	/* その他住所 */
	private String o_address;
	public int getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	public long getPost_code() {
		return post_code;
	}
	public void setPost_code(long post_code) {
		this.post_code = post_code;
	}
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getO_address() {
		return o_address;
	}
	public void setO_address(String o_address) {
		this.o_address = o_address;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
