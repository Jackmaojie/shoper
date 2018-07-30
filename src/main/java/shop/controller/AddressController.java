package shop.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.controller.form.ReceivingAddressForm;
import shop.model.CellphoneUser;
import shop.model.ReceivingAddress;
import shop.service.AddressService;


@Controller
public class AddressController {
	
	private AddressService addressService;
	
	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	//------------------------------adressadd----------------------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-address/add")
	public String add(@ModelAttribute ReceivingAddressForm receivingAddressForm,Model model){
		prepareInAdd(model);
		return "address-add";
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/uc/shop-address/add")
	public String create(@ModelAttribute @Valid ReceivingAddressForm receivingAddressForm,
							BindingResult bindingResult,Model model,
							@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId){
		if(bindingResult.hasErrors()){
			prepareInAdd(model);
			return "address-add";
		}
		//把登陆用户id放入receivingAddressForm中
		CellphoneUser user=new CellphoneUser();
		user.setId(userId);
		receivingAddressForm.setCellphoneUser(user);
		addressService.create(receivingAddressForm);
		
		return "redirect:/uc/shop-address/";	
	}
	//=======================================================================================================
	//-------------------------------address列表---------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-address/")
	public String list(Model model,@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId){
		
		
		List<ReceivingAddress> receivingAddresses=addressService.findAllAddress(userId);
		
		model.addAttribute("receivingAddresses", receivingAddresses);
		
		return "address-list";
		
	}
	//============================================================================================
	private void prepareInAdd(Model model) {
		List<ReceivingAddress> ReceivingAddressOptions=addressService.findAllAddressOptions();
		model.addAttribute("ReceivingAddressOptions", ReceivingAddressOptions);
	}
	//------------------------------address修改---------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-address/{id}/edit")
	public String update(@PathVariable Long id,@ModelAttribute ReceivingAddressForm receivingAddressForm1,
							Model model){
		ReceivingAddress receivingAddress=addressService.findAddress(id);
		ReceivingAddressForm receivingAddressForm=ReceivingAddressForm.fromrAddress(receivingAddress);
		model.addAttribute("receivingAddressForm", receivingAddressForm);
		prepareInAdd(model);
		return "address-add";
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/uc/shop-address/{id}/edit")
	public String edit(@PathVariable Long id,@ModelAttribute @Valid ReceivingAddress receivingAddress,
									BindingResult bindingResult,
							Model model){
		if(bindingResult.hasErrors()){
			prepareInAdd(model);
			return "address-add";
		}
		System.out.println("地址id"+id);
		ReceivingAddressForm receivingAddressForm=ReceivingAddressForm.fromrAddress(receivingAddress);
		addressService.updateAddress(receivingAddressForm);
		return "redirect:/uc/shop-address/";	
	}
	//========================================================================================
	//--------------------------删除---------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-address/{id}/delete")
	public String delete(@PathVariable Long id){
		addressService.deleteAddress(id);
		return "redirect:/uc/shop-address/";
		
	}
	
	
}
