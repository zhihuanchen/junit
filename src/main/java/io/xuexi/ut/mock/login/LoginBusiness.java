package io.xuexi.ut.mock.login;

public class LoginBusiness {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User login(String name, String password) {
		User user = userDao.get(name);
		if (user == null) {
			throw new UserNotExistException("user " + name + " not exist");
		}

		if (!user.isActive()) {
			throw new UserInactiveException("user " + name + " is inactive");
		}

		if (!user.getPassword().equals(password)) {
			throw new PasswordNotMatchException("user " + name + " is inactive");
		}

		userDao.updateLastLoginTime(user.getId(), System.currentTimeMillis());

		// unset password
		user.setPassword(null);

		return user;
	}

}
