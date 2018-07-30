package shop.controller.form;

import javax.validation.constraints.NotNull;

public class OrderForm {
	@NotNull(message="不能为空")
	private Long receivingAddressId;

	public Long getReceivingAddressId() {
		return receivingAddressId;
	}

	public void setReceivingAddressId(Long receivingAddressId) {
		this.receivingAddressId = receivingAddressId;
	}


	
	
}
