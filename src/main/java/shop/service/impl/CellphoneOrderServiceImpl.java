package shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mapper.AddressMapper;
import shop.mapper.CellphoneOrderMapper;
import shop.mapper.ShoppingCartMapper;
import shop.model.Cellphone;
import shop.model.CellphoneOrder;
import shop.model.OrderItem;
import shop.model.OrderState;
import shop.model.ReceivingAddress;
import shop.model.ShopCartItem;
import shop.model.ShoppingCart;
import shop.service.CellphoneOrderService;

@Service
@Transactional
public class CellphoneOrderServiceImpl implements CellphoneOrderService {
	
	private CellphoneOrderMapper cellphoneOrderMapper;
	
	private ShoppingCartMapper shoppingCartMapper;
	
	private AddressMapper addressMapper;
	
	@Autowired
	public CellphoneOrderServiceImpl(CellphoneOrderMapper cellphoneOrderMapper,
			ShoppingCartMapper shoppingCartMapper, AddressMapper addressMapper) {
		this.cellphoneOrderMapper = cellphoneOrderMapper;
		this.shoppingCartMapper = shoppingCartMapper;
		this.addressMapper = addressMapper;
	}


	@Override
	public List<ShopCartItem> findAllItems(Long userId) {

		return shoppingCartMapper.findAllItems(userId);
	}

	@Override
	public List<ReceivingAddress> findAllAddress(Long userId) {

		return addressMapper.findAllAddress(userId);
	}


	@Override
	public List<ShopCartItem> orderDetails(Long userId) {

		return null; //cellphoneOrderMapper.orderDetails(userId);
	}


	@Override
	public CellphoneOrder createOrder(Long userId, Long receivingAddressId) {
		//订单表
		CellphoneOrder cellphoneOrder=new CellphoneOrder();
		cellphoneOrder.setUserId(userId);
		cellphoneOrder.setState(OrderState.Created);
		ReceivingAddress receivingAddress=new ReceivingAddress();
		receivingAddress.setId(receivingAddressId);
		cellphoneOrder.setReceivingAddress(receivingAddress);
		
		cellphoneOrderMapper.createOrder(cellphoneOrder);
		
		//订单项表
		List<ShopCartItem> shopCart=shoppingCartMapper.findAllItems(userId);
		for(ShopCartItem item:shopCart){
			OrderItem orderItem=new OrderItem();
			orderItem.setOrderItemID(cellphoneOrder.getId());
			System.out.println("订单id"+cellphoneOrder.getId());
			orderItem.setCellphone(item.getCellphone());
			orderItem.setAmount(item.getAmount());
			cellphoneOrderMapper.addItem(orderItem);
		}
		shoppingCartMapper.clear(userId);
		
		return cellphoneOrder;
	}


	@Override
	public CellphoneOrder findOneOrder(Long userId, Integer id) {

		return cellphoneOrderMapper.fingOneOrder(userId,id);
	}


	@Override
	public List<CellphoneOrder> findAllOrder(Long userId) {

		return cellphoneOrderMapper.findAllOrder(userId);
	}


	@Override
	public void delete(Long userId,Integer id) {
		CellphoneOrder cellphoneOrder=cellphoneOrderMapper.fingOneOrder(userId, id);
		for(OrderItem item:cellphoneOrder.getOrderItems()){
			cellphoneOrderMapper.deleteItem(id, item.getCellphone().getId());
		}
		cellphoneOrderMapper.delete(id,userId);
		
	}

}
