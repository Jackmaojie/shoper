package shop.controller.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import shop.model.CellphoneUser;
import shop.model.ReceivingAddress;

public class ReceivingAddressForm {
	private Long id;
	private CellphoneUser cellphoneUser;
	@NotNull(message="不能为空")
	private String receivingname;
	@Size(min=11,message="最少十一位数字")
	private String phonenumber;
	@NotNull(message="不能为空")
	private String detailedaddress;
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
	public ReceivingAddress toReceivingAddress() {
		ReceivingAddress receivingAddress=new ReceivingAddress();
		receivingAddress.setId(id);
		receivingAddress.setCellphoneUser(cellphoneUser);
		receivingAddress.setReceivingname(receivingname);
		receivingAddress.setPhonenumber(phonenumber);
		receivingAddress.setReceivingname(receivingname);
		return receivingAddress;
	}
	
	public static ReceivingAddressForm fromrAddress(ReceivingAddress receivingAddress){
		ReceivingAddressForm receivingAddressForm=new ReceivingAddressForm();
		receivingAddressForm.setId(receivingAddress.getId());
		receivingAddressForm.setCellphoneUser(receivingAddress.getCellphoneUser());
		receivingAddressForm.setReceivingname(receivingAddress.getReceivingname());
		receivingAddressForm.setPhonenumber(receivingAddress.getPhonenumber());
		receivingAddressForm.setDetailedaddress(receivingAddress.getDetailedaddress());
		return receivingAddressForm;
		
	}
	
}
