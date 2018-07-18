package shop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.model.CellphoneUser;
import shop.service.CellphoneUserService;

@Controller
public class CellphoneUserController {
	
	private CellphoneUserService cellphoneUserService;
	@Autowired
	public CellphoneUserController(CellphoneUserService cellphoneUserService) {
		this.cellphoneUserService = cellphoneUserService;
	}
	
	
	//----------------------Useradd---------------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/users/add")
	public String add(@ModelAttribute CellphoneUser cellphoneUser){
		
		return "user-add";
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/users/add")
	public String create(@ModelAttribute @Valid CellphoneUser cellphoneUser,
							BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "user-add";
		}
		cellphoneUserService.create(cellphoneUser);
		return "redirect:/users/";
		
	}
	//=======================================================================================
}

