package io.xuexi.ut.mock.login;

public class UserNotExistException extends UserLoginException {

	private static final long serialVersionUID = 1L;

	public UserNotExistException(String message) {
		super(message);
	}

}
