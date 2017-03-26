package io.xuexi.ut.mock.login;

public class UserLoginException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserLoginException(String message) {
		super(message);
	}

	public UserLoginException(String message, Exception cause) {
		super(message, cause);
	}
}
