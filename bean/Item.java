package bean;

import java.io.Serializable;
/**
 * 個数情報と商品情報を持つクラス
 * @author c3user
 *
 */
public class Item implements Serializable {
	/* 商品情報been */
	private Product product;
	/* 商品個数 */
	private int count;
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
