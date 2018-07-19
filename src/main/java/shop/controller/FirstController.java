package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstController {
	
	@RequestMapping(method=RequestMethod.GET,value="/")
	public String index(){
		
		return "index";
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/")
	public String first(){
		
		return "index";
	}
	

}
