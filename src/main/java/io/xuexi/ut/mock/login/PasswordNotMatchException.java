package io.xuexi.ut.mock.login;

public class PasswordNotMatchException extends UserLoginException {

	private static final long serialVersionUID = 1L;

	public PasswordNotMatchException(String message) {
		super(message);
	}

}
