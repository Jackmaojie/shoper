package shop.service;

import java.util.List;

import shop.model.CellphoneOrder;
import shop.model.ReceivingAddress;
import shop.model.ShopCartItem;

public interface CellphoneOrderService {

	List<ShopCartItem> findAllItems(Long userId);

	List<ReceivingAddress> findAllAddress(Long userId);

	List<ShopCartItem> orderDetails(Long userId);

	CellphoneOrder createOrder(Long userId, Long receivingAddressId);

	CellphoneOrder findOneOrder(Long userId, Integer id);

	List<CellphoneOrder> findAllOrder(Long userId);

	void delete(Long userId,Integer id);



}
