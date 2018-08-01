package shop.controller;

import java.math.BigDecimal;
import java.util.Date;
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



import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import shop.controller.form.OrderForm;
import shop.model.CellphoneOrder;
import shop.model.OrderState;
import shop.model.ReceivingAddress;
import shop.model.ShopCartItem;
import shop.model.ShoppingCart;
import shop.service.CellphoneOrderService;


@Controller
public class CellphoneOrderController {
	
	private CellphoneOrderService cellphoneOrderService;
	
	private AlipayClient alipayClient;
	@Autowired	
	public CellphoneOrderController(
			CellphoneOrderService cellphoneOrderService,
			AlipayClient alipayClient
			) {
		this.cellphoneOrderService = cellphoneOrderService;
		this.alipayClient=alipayClient;
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
	//==================================================================================================
	//----------------------订单支付(支付宝支付)-------------------------------------------------------------------
	@RequestMapping(method=RequestMethod.POST,
			value="/uc/shop-order/{id}/pay",
			produces="text/html;charset=UTF-8")// 非常重要，支付宝api响应是html片段（不含编码）
	@ResponseBody
	public String pay(@AuthenticationPrincipal(expression="cellphoneUser.id") Long userId,
			@PathVariable Integer id) throws AlipayApiException{
		CellphoneOrder cellphoneOrder = cellphoneOrderService.findOneOrder(userId, id);
		if(cellphoneOrder.getState()!=OrderState.Created){
			throw new IllegalStateException("只有Created状态的订单才能发起支付");
		}
		//订单总额(元)
		BigDecimal totalAmount=BigDecimal.valueOf(cellphoneOrder.totalCost()).divide(BigDecimal.valueOf(100));	
		
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest(); // 即将发送给支付宝的请求（电脑网站支付请求）
        alipayRequest.setReturnUrl("http://shop.me/shop/uc/orders/sync-pay-cb"); // 浏览器端完成支付后跳转回商户的地址（同步通知）
        alipayRequest.setNotifyUrl("http://shop.me/shop/async-pay-cb"); // 支付宝服务端确认支付成功后通知商户的地址（异步通知）
        alipayRequest.setBizContent("{" +
            "    \"out_trade_no\":\"" + id.toString() + "-" + new Date().getTime() + "\"," + // 商户订单号，加时间戳是为了避免测试时订单号重复
            "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + // 产品码，固定
            "    \"total_amount\":" + totalAmount.toString() + "," + // 订单总金额（元）
            "    \"subject\":\"shop手机商城订单支付\"," + // 订单标题
            "    \"body\":\"TODO 显示订单项概要\"" + // 订单描述
            "  }"); // 填充业务参数
        
        // 直接将完整的表单html输出到页面
        return alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成支付表单
	}
	//==================================================================================================
	//--------------------------支付成功后----------------------------------------------------------------------
	@RequestMapping(method=RequestMethod.GET,value="/uc/shop-order/pay-ok")
	public String payOk(@RequestParam("out_trade_no") String orderNumber,
	                        Model model) {
	     Long orderId = Long.valueOf(orderNumber.split("-")[0]); // 如 3-1533093080374
	     model.addAttribute("orderId", orderId);
	     return "order-pay-ok";  
	}
}	
