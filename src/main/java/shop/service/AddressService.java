package shop.service;

import java.util.List;

import javax.validation.Valid;

import shop.controller.form.ReceivingAddressForm;
import shop.model.ReceivingAddress;

public interface AddressService {

	void create(ReceivingAddressForm receivingAddressForm);

	List<ReceivingAddress> findAllAddress(Long userId);

	void updateAddress(ReceivingAddressForm receivingAddressForm);

	ReceivingAddress findAddress(Long id);

	void deleteAddress(Long id);
	
	List<ReceivingAddress> findAllAddressOptions();
}	
