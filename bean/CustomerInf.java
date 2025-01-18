package bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 顧客注文情報格納用Bean
 * @author c3user
 *
 */
public class CustomerInf implements Serializable {
	/* 注文番号 */
	private int order_id;
	/* 注文日時 */
	private Timestamp ins_datetime;
	/* 商品番号 */
	private int p_id;
	/* 商品名 */
	private String name;
	/* 合計金額 */
	private int sum_price;
	/* 注文数 */
	private int order_count;
	/* 送付先名 */
	private String send_name;
	/* 送付住所 */
	private String send_address;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Timestamp getIns_datetime() {
		return ins_datetime;
	}
	public void setIns_datetime(Timestamp ins_datetime) {
		this.ins_datetime = ins_datetime;
	}
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
	public int getSum_price() {
		return sum_price;
	}
	public void setSum_price(int sum_price) {
		this.sum_price = sum_price;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	public String getSend_name() {
		return send_name;
	}
	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}
	public String getSend_address() {
		return send_address;
	}
	public void setSend_address(String send_address) {
		this.send_address = send_address;
	}

	
	
	
}
