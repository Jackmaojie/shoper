package shop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.exception.NameExistsException;
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
		try{
			cellphoneUserService.create(cellphoneUser);
		}catch(NameExistsException ex){
            System.out.println(ex.getMessage());
            bindingResult.rejectValue( // 手动添加校验错误
                    "username", // 指定错误字段
                    "form.cellphoneUserAdd.nameExists", // 错误码, i18n（国际化）
                    "用户名已占用"); // 如果错误码对应的消息没有找到，则使用此默认消息
			return "user-add";
		}
		
		return "redirect:/users/";
		
	}
	//=======================================================================================
}

