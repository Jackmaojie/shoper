package shop.mapper;

import shop.model.CellphoneUser;

public interface CellphoneUserMapper {
	
	void create(CellphoneUser cellphoneUser);

	CellphoneUser findOneByUsername(String username);

}
