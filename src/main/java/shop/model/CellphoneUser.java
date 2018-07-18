package shop.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CellphoneUser {
	private Long id;

	private String username;
	@NotNull(message="必填")
	private Gender gender;

	private String password;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
