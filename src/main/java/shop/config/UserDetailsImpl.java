package shop.config;

import java.util.Collection;



import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import shop.model.CellphoneUser;

public class UserDetailsImpl implements UserDetails{
	
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(CellphoneUser cellphoneUser){
		this.username=cellphoneUser.getUsername();
		this.password=cellphoneUser.getPassword();
		this.authorities=buildAuthorities(cellphoneUser);
	}
	
	private List<GrantedAuthority> buildAuthorities(CellphoneUser cellphoneUser) {

		return authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

	

}
