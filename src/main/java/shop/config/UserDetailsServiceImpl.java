package shop.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shop.mapper.CellphoneUserMapper;
import shop.model.CellphoneUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private CellphoneUserMapper cellphoneUserMapper;
	
	
	public UserDetailsServiceImpl(CellphoneUserMapper cellphoneUserMapper) {
		this.cellphoneUserMapper = cellphoneUserMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("用户名:"+username);
		CellphoneUser cellphoneuser = cellphoneUserMapper.findOneByUsername(username);
        cellphoneUserMapper.updatelastdate(cellphoneuser);
        CellphoneUser cellphoneUser=cellphoneUserMapper.findOneByUsername(username);
        if (cellphoneUser == null) { // 按照接口要求，用户名不存在时必须抛异常UsernameNotFoundException
            throw new UsernameNotFoundException("用户名不存在: " + username);
        } 
        
        // 从mapper得到的是实体operator，需要转换成springsecurity所需的UserDetails对象
        return new UserDetailsImpl(cellphoneUser);
	}

}
