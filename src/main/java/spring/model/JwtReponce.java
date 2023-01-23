package spring.model;

public class JwtReponce {

	String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JwtReponce(String token) {
		super();
		this.token = token;
	}

	public JwtReponce() {
		super();
		// TODO Auto-generated constructor stub
	}

}
