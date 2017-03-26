package io.xuexi.ut.mock.login;

public class LoginGuiWeb {

	private LoginBusiness loginBusiness;

	public void setLoginBusiness(LoginBusiness loginBusiness) {
		this.loginBusiness = loginBusiness;
	}
	
	public void login() {
		String name = "";	// get from HttpRequest
		String password = "";	// get from HttpRequest
		
		try {
			User user = loginBusiness.login(name, password);
			// do something when login success
		} catch (UserLoginException e) {
			// do something when login failure
			// for example, different response for different error
		}
	}
}
