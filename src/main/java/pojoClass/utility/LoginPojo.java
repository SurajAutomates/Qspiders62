package pojoClass.utility;

public class LoginPojo {
	private String password;
	private String username;
	public LoginPojo(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}
	public LoginPojo() {
		super();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
