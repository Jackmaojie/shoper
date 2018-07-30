package shop.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.controller.form.ReceivingAddressForm;
import shop.mapper.AddressMapper;
import shop.model.CellphoneUser;
import shop.model.ReceivingAddress;
import shop.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	private AddressMapper addressMapper;
	
	@Autowired
	public AddressServiceImpl(AddressMapper addressMapper) {

		this.addressMapper = addressMapper;
	}



	@Override
	public void create(ReceivingAddressForm receivingAddressForm) {
		addressMapper.create(receivingAddressForm);
	}





	@Override
	public void updateAddress(ReceivingAddressForm receivingAddressForm ) {
		addressMapper.updateAddress(receivingAddressForm );
		
	}

	@Override
	public ReceivingAddress findAddress(Long id) {
		
		return addressMapper.findAddress(id);
	}

	@Override
	public void deleteAddress(Long id) {
		addressMapper.deleteAddress(id);
	}



	@Override
	public List<ReceivingAddress> findAllAddress(Long userId) {
		List<ReceivingAddress> receivingAddresses=addressMapper.findAllAddressOptions();
		for(ReceivingAddress address:receivingAddresses){
			CellphoneUser cellphoneUser=new CellphoneUser();
			cellphoneUser.setId(userId);
			address.setCellphoneUser(cellphoneUser);
		}	
		return addressMapper.findAllAddress(userId);
	}



	@Override
	public List<ReceivingAddress> findAllAddressOptions() {

		return addressMapper.findAllAddressOptions();
	}

}
