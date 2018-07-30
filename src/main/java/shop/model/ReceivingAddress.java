package shop.model;



/**
 *手机商城用户收货地址类
 */
public class ReceivingAddress {
	private Long id;
	private CellphoneUser cellphoneUser;
	private String receivingname;
	private String phonenumber;
	private String detailedaddress;
	private Long userId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CellphoneUser getCellphoneUser() {
		return cellphoneUser;
	}
	public void setCellphoneUser(CellphoneUser cellphoneUser) {
		this.cellphoneUser = cellphoneUser;
	}
	public String getReceivingname() {
		return receivingname;
	}
	public void setReceivingname(String receivingname) {
		this.receivingname = receivingname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getDetailedaddress() {
		return detailedaddress;
	}
	public void setDetailedaddress(String detailedaddress) {
		this.detailedaddress = detailedaddress;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
