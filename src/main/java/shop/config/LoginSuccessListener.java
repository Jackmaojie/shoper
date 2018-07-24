package shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import shop.mapper.CellphoneUserMapper;

@Component
public class LoginSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent>{
	
	//private CellphoneUserMapper cellphoneUserMapper;
	
	//@Autowired
	//public LoginSuccessListener(CellphoneUserMapper cellphoneUserMapper) {
		//this.cellphoneUserMapper = cellphoneUserMapper;
	//}




	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		UserDetailsImpl userDetails=(UserDetailsImpl)event.getAuthentication().getPrincipal();
		System.out.println("登录成功了");
		//userMapper.updateLastLoginTime(userDetails.getUser().getId(), new Date());
	}

}
