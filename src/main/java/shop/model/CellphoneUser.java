package shop.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CellphoneUser {
	private Long id;
	@Pattern(regexp = "[0~9a~zA~Z_-]{2,64}",message="2~64位，仅限数字字母、下划线、连字符")
	private String username;
	@NotNull(message="必填")
	private Gender gender;
	@Pattern(regexp = "[\\p{Digit}\\p{Alpha}\\p{Punct}]{6,64}", message = "6~64位，仅限数字字母、英文标点符号")
	private String password;
	
	private String lastdate;
	
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
	public String getLastdate() {
		return String.valueOf(lastdate);
	}
	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
	
	
	
}
