package bean;

import java.io.Serializable;
/**
 * プロダクトクラス
 * @author c3user
 *
 */
public class Product implements Serializable {
	/** ID */
	private int p_id;
	/** 名前 */
	private String name;
	/** 値段 */
	private int price;
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
