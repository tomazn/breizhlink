package Breizhlink;

public class user {
	
	private String login;
	private String password;
	private int id;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassward(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public user(String login, String password, int id) {
		this.login = login;
		this.password = password;
		this.id = id;
	}

	
}
