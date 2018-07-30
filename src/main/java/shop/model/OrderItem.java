package shop.model;


/**
 *手机订单项类
 */
public class OrderItem {
	private Integer orderItemID;
	private Cellphone cellphone;
	private Integer amount;
	
	public Integer getOrderItemID() {
		return orderItemID;
	}
	public void setOrderItemID(Integer orderItemID) {
		this.orderItemID = orderItemID;
	}
	public Cellphone getCellphone() {
		return cellphone;
	}
	public void setCellphone(Cellphone cellphone) {
		this.cellphone = cellphone;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	
}
