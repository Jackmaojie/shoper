package shop.model;

import java.util.ArrayList;
import java.util.List;

/**
 *手机订单类
 */
public class CellphoneOrder {
	
	private Integer id;
	private Long userId;
	private ReceivingAddress receivingAddress;
	private String createtime;
	private List<OrderItem> orderItems=new ArrayList<OrderItem>();
	private OrderState state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public ReceivingAddress getReceivingAddress() {
		return receivingAddress;
	}
	public void setReceivingAddress(ReceivingAddress receivingAddress) {
		this.receivingAddress = receivingAddress;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public OrderState getState() {
		return state;
	}
	public void setState(OrderState state) {
		this.state = state;
	}
	public int totalCost(){
		int result=0;
		for(OrderItem item:orderItems){
			result+=item.getAmount() * item.getCellphone().getPrice();
		}
		return result;
	}
    public String stateText() {
        switch (state) {
        case Created:
            return "待支付";
            
        case Paid:
            return "待发货";
            
        case Shipped:
            return "已发货";
            
        case Delivered:
            return "已送达";
            
        case Commented:
            return "已评论";
            
        case Canceled:
            return "已取消";

        default:
            return "?" + state;
        }
    }
}
