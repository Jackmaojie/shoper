package shop.service;

import java.util.List;

import shop.model.CellphoneUser;
import shop.model.ShopCartItem;

public interface ShoppingCartService {

	void addToCart(Long userId, String cellphoneId, int amount);

	List<CellphoneUser> findUser();

	List<ShopCartItem> findAllItems(Long userId);


	void removeItem(Long userId, String cellphoneId);

}
