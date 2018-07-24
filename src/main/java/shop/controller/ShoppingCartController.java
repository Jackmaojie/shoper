package shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import shop.model.ShopCartItem;
import shop.model.ShoppingCart;
import shop.service.ShoppingCartService;


@Controller
public class ShoppingCartController {
	
	
	
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	public ShoppingCartController(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	//-------------------------------购物车----------------------------------------------------------
	@RequestMapping(method=RequestMethod.POST,value="/uc/shop-cart/add")
	public String add(@RequestParam String cellphoneId,
					    //@AuthenticationPrincipal(expression="cellphoneUser") CellphoneUser user
			 			@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId
			){
		System.out.println("userId:"+userId+"------------------------"+"cellphoneId:"+cellphoneId);
/*		List<CellphoneUser> cellphoneUsers=shoppingCartService.findUser();
		for(CellphoneUser cellphoneUser:cellphoneUsers){
			System.out.println("cellphoneUser:"+cellphoneUser);
		}*/		
		shoppingCartService.addToCart(userId,cellphoneId,1);
		return "redirect:/users/"+cellphoneId;
	}
	//=================================================================================================
	//-----------------------------购物车详情--------------------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-cart")
	public String details(@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId,
							Model model){
		List<ShopCartItem> shopCartItems=shoppingCartService.findAllItems(userId);
		model.addAttribute("shoppingCart", new ShoppingCart(shopCartItems));
		return "shop-cart";
		
	}
	//===================================================================================================
	//---------------------------购物车删除----------------------------------------------------------------------
	@RequestMapping(method=RequestMethod.POST,value="/uc/shop-cart/removeItem")
	public String edit(@RequestParam String cellphoneId,
			@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId){
		shoppingCartService.removeItem(userId,cellphoneId);	
		return "redirect:/uc/shop-cart";	
	}
/*	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-cart/removeItem")
	public String delete(){
		return "shop-cart";
	}*/
	
	
	
}
