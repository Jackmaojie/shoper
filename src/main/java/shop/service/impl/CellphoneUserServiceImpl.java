package shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import shop.exception.NameExistsException;
import shop.mapper.CellphoneUserMapper;
import shop.model.CellphoneUser;
import shop.service.CellphoneUserService;



@Service
public class CellphoneUserServiceImpl implements CellphoneUserService{
	
	private CellphoneUserMapper cellphoneUserMapper;
	
	 private PasswordEncoder passwordEncoder;
	
	@Autowired
	public CellphoneUserServiceImpl(CellphoneUserMapper cellphoneUserMapper,
			PasswordEncoder passwordEncoder) {
		this.cellphoneUserMapper = cellphoneUserMapper;
		this.passwordEncoder = passwordEncoder;
	}
	
	



	@Override
	public void create(CellphoneUser cellphoneUser) {	
        if (cellphoneUserMapper.usernameExists(cellphoneUser.getUsername())>0) {
            throw new NameExistsException();
        }		
		String passwordEncode=passwordEncoder.encode(cellphoneUser.getPassword());
		cellphoneUser.setPassword(passwordEncode);
		cellphoneUserMapper.create(cellphoneUser);
	}



}
