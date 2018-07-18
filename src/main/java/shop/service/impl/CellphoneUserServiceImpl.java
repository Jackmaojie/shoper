package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.mapper.CellphoneUserMapper;
import shop.model.CellphoneUser;
import shop.service.CellphoneUserService;


@Service
public class CellphoneUserServiceImpl implements CellphoneUserService{
	
	private CellphoneUserMapper cellphoneUserMapper;
	
	@Autowired
	public CellphoneUserServiceImpl(CellphoneUserMapper cellphoneUserMapper) {
		this.cellphoneUserMapper = cellphoneUserMapper;
	}



	@Override
	public void create(CellphoneUser cellphoneUser) {
		cellphoneUserMapper.create(cellphoneUser);
		
	}

}
