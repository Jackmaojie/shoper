package shop.mapper;

import java.util.List;

import shop.controller.form.ReceivingAddressForm;
import shop.model.ReceivingAddress;

public interface AddressMapper {

	void create(ReceivingAddressForm receivingAddressForm);

	List<ReceivingAddress> findAllAddress(Long userId);

	void updateAddress(ReceivingAddressForm  receivingAddressForm );

	ReceivingAddress findAddress(Long id);

	void deleteAddress(Long id);

	List<ReceivingAddress> findAllAddressOptions();
	
	

}
