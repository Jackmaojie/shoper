package shop.model;

import java.util.List;

public class ShoppingCart {
	
	private List<ShopCartItem> cartItems;
	
	private int total;

	public ShoppingCart(List<ShopCartItem> shopCartItems) {
		this.cartItems=shopCartItems;
	}
	public List<ShopCartItem> getCartItems() {
		return cartItems;
	}



	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
		
}
