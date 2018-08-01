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

import shop.controller.form.OrderForm;
import shop.model.CellphoneOrder;
import shop.model.ReceivingAddress;
import shop.model.ShopCartItem;
import shop.model.ShoppingCart;
import shop.service.CellphoneOrderService;


@Controller
public class CellphoneOrderController {
	
	private CellphoneOrderService cellphoneOrderService;
	@Autowired	
	public CellphoneOrderController(CellphoneOrderService cellphoneOrderService) {
		this.cellphoneOrderService = cellphoneOrderService;
	}


	//---------------------------订单创建-------------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-order/ordermessage")
	public String details(@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId,
			Model model,
			@ModelAttribute OrderForm orderForm){
		prepareInAdd(userId, model);
		return "order-add";	
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/uc/shop-order/ordermessage")
	public String create(@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId,
						//bindingResult紧跟orderForm其后
						@ModelAttribute @Valid OrderForm orderForm,BindingResult bindingResult,
						Model model){
		if(bindingResult.hasErrors()){
			prepareInAdd(userId, model);
			return "order-add";
		}	
		CellphoneOrder cellphoneOrder= cellphoneOrderService.createOrder(userId,orderForm.getReceivingAddressId());
		return "redirect:/uc/shop-order/"+cellphoneOrder.getId();
		
	}
	//======================================================================================================
	//-----------------------------订单列表-----------------------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-order/")
	public String orderList(Model model,
								@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId){
		
		List<CellphoneOrder> cellphoneOrders=cellphoneOrderService.findAllOrder(userId);
		model.addAttribute("cellphoneOrders",cellphoneOrders);
		return "order-list";	
	}
	//===================================================================================================
	//-----------------------------订单详情-------------------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-order/{id}")
	public String orderDetails(@PathVariable Integer id,Model model,
								@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId){
		
		CellphoneOrder cellphoneOrder=cellphoneOrderService.findOneOrder(userId,id);
		model.addAttribute("cellphoneOrder",cellphoneOrder);
		return "order-details";	
	}
	
	//---------------------------prepareInAdd-----------------------------------------------------------
	/**
	 *请求前准备数据
	 */
	private void prepareInAdd(Long userId, Model model) {
		List<ShopCartItem> shopCartItems=cellphoneOrderService.findAllItems(userId);
		model.addAttribute("shoppingCart", new ShoppingCart(shopCartItems));
		List<ReceivingAddress> receivingAddresses=cellphoneOrderService.findAllAddress(userId);
		model.addAttribute("receivingAddresses", receivingAddresses);
	}
	//==================================================================================================
	//------------------------删除订单-------------------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-order/{id}/delete")
	public String delete(@PathVariable Integer id,
							@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId){
		cellphoneOrderService.delete(userId,id);
		return "redirect:/uc/shop-order/";	
	}
}	
