package shop.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mapper.ShoppingCartMapper;
import shop.model.CellphoneUser;
import shop.model.ShopCartItem;
import shop.service.ShoppingCartService;

@Service
@Transactional
public class ShoppingCartServicImpl implements ShoppingCartService{
	
	private ShoppingCartMapper shoppingCartMapper;
	
	@Autowired
	public ShoppingCartServicImpl(ShoppingCartMapper shoppingCartMapper) {
		this.shoppingCartMapper = shoppingCartMapper;
	}


	@Override
	public void addToCart(Long userId, String cellphoneId, int amount) {
		if(shoppingCartMapper.itemExists(userId,cellphoneId)){
			shoppingCartMapper.incItemAmount(userId,cellphoneId,amount);
		}else{
			shoppingCartMapper.createItem(userId, cellphoneId, amount);
		}
	}


	@Override
	public List<CellphoneUser> findUser() {

		return shoppingCartMapper.findUser();
	}


	@Override
	public List<ShopCartItem> findAllItems(Long userId) {

		return shoppingCartMapper.findAllItems(userId);
	}




	@Override
	public void removeItem(Long userId, String cellphoneId) {
		shoppingCartMapper.removeItem(userId,cellphoneId);
		
	}

}
