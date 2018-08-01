package shop.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.model.CellphoneOrder;
import shop.model.OrderItem;


public interface CellphoneOrderMapper {


	void createOrder(CellphoneOrder cellphoneOrder);

	void addItem(OrderItem orderItem);

	CellphoneOrder fingOneOrder(@Param("userId") Long userId,
								@Param("id") Integer id);

	List<CellphoneOrder> findAllOrder(Long userId);

	void delete(@Param("id") Integer id,
				@Param("userId") Long userId);

	
	void deleteItem(@Param("id") Integer id,
					@Param("cellphoneId") String cellphoneId);
	
	

}
