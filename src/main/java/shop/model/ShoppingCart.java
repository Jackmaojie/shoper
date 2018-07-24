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



	public int totalCost(){
		int result=0;
		for(ShopCartItem item:cartItems){
			result+=item.getAmount() * item.getCellphone().getPrice();
		}
		return result;
	}
	
	public void setTotal(int total) {
		for(ShopCartItem item:cartItems){
			total+=item.getAmount() * item.getCellphone().getPrice();
		}
		this.total = total;
	}
	public int getTotal() {
		return total;
	}
		
}
