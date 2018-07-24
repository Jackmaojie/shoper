package shop.config;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import shop.model.CellphoneUser;

public class UserDetailsImpl extends User{
	
	private static final long serialVersionUID = 10000000;
	private CellphoneUser cellphoneUser;
    
    public UserDetailsImpl(CellphoneUser cellphoneUser) {
        super(cellphoneUser.getUsername(), 
        		cellphoneUser.getPassword(), 
              true, true, true, true, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));            
        this.cellphoneUser = cellphoneUser;
    }

	public CellphoneUser getCellphoneUser() {
		return cellphoneUser;
	}

}
	



