package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.model.Cellphone;
import shop.service.CellphoneService;


@Controller
public class CellphoneController {
	
	private CellphoneService cellphoneService;
	@Autowired
	public CellphoneController(CellphoneService cellphoneService) {
		this.cellphoneService = cellphoneService;
	}
	//----------------------手机搜索------------------------------------------------------------------------

	//===============================================================================================
	//---------------------------------------------------------------------------------------------
	
	
	//-----------------------------列表-----------------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/users/")
	public String list(Model model){
		List<Cellphone> cellphones=cellphoneService.findAll();
		model.addAttribute("cellphones", cellphones);
		return "cellphone-list";
	}
	//================================================================================================
	//-----------------------------详情---------------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/users/{id}")
	public String details(@PathVariable String id,Model model){
		Cellphone cellphone=cellphoneService.findOne(id);
		model.addAttribute("cellphone", cellphone);
		return "cellphone-details";
		
	}
	//==============================================================================
	
	
	
}
