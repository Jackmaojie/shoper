package shop.mapper;

import shop.model.CellphoneUser;

public interface CellphoneUserMapper {
	
	void create(CellphoneUser cellphoneUser);

	CellphoneUser findOneByUsername(String username);
	
	void updatelastdate(CellphoneUser cellphoneUser);

	Integer usernameExists(String username);

}
