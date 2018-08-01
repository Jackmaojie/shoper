package shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.model.CellphoneUser;
import shop.model.ShopCartItem;

public interface ShoppingCartMapper {

	void createItem(@Param("userId") Long userId, 
					@Param("cellphoneId") String cellphoneId, 
					@Param("amount") int amount);


	void incItemAmount(@Param("userId") Long userId, 
						@Param("cellphoneId") String cellphoneId, 
						@Param("amount") int amount);
	
	List<CellphoneUser> findUser();

	List<ShopCartItem> findAllItems(Long userId);


	void removeItem(@Param("userId") Long userId,
			@Param("cellphoneId") String cellphoneId);

	Integer findItemAmount(@Param("userId") Long userId,
							@Param("cellphoneId") String cellphoneId);


	void clear(Long userId);
}
