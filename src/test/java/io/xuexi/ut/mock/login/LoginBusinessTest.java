package io.xuexi.ut.mock.login;

import io.xuexi.ut.mock.login.LoginBusiness;
import io.xuexi.ut.mock.login.PasswordNotMatchException;
import io.xuexi.ut.mock.login.User;
import io.xuexi.ut.mock.login.UserDao;
import io.xuexi.ut.mock.login.UserInactiveException;
import io.xuexi.ut.mock.login.UserNotExistException;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class LoginBusinessTest {

	private UserDao userDao;

	private LoginBusiness loginBusiness;

	@Before
	public void init() {
		userDao = EasyMock.createMock(UserDao.class);

		loginBusiness = new LoginBusiness();
		loginBusiness.setUserDao(userDao);
	}

	@Test
	public void testLoginSuccess() {
		final String name = "zhangsan";
		final String password = "password";

		User expectedUser = buildDefault(name, password);
		EasyMock.expect(userDao.get(name)).andReturn(expectedUser);
		userDao.updateLastLoginTime(eq(expectedUser.getId()), anyLong());
		EasyMock.expectLastCall();
		EasyMock.replay(userDao);

		User actureUser = loginBusiness.login(name, password);

		assertThat(actureUser, notNullValue());
		assertThat(actureUser.getName(), equalTo(expectedUser.getName()));
		assertThat(actureUser.getPassword(), nullValue());
		assertThat(actureUser.isActive(), equalTo(true));
		EasyMock.verify(userDao);
	}

	@Test(expected = UserNotExistException.class)
	public void testLoginFailureBecauseUserNotExist() {
		final String name = "zhangsan";
		final String password = "password";

		User expectedUser = null;
		EasyMock.expect(userDao.get(name)).andReturn(expectedUser);
		EasyMock.replay(userDao);

		try {
			loginBusiness.login(name, password);
		} finally {
			EasyMock.verify(userDao);
		}
	}

	@Test(expected = UserInactiveException.class)
	public void testLoginFailureBecauseUserInActive() {
		final String name = "zhangsan";
		final String password = "password";

		User expectedUser = buildDefault(name, password);
		// set active to false for the case that user is active
		expectedUser.setActive(false);
		EasyMock.expect(userDao.get(name)).andReturn(expectedUser);
		EasyMock.replay(userDao);

		try {
			loginBusiness.login(name, password);
		} finally {
			EasyMock.verify(userDao);
		}
	}

	@Test(expected = PasswordNotMatchException.class)
	public void testLoginFailureBecausePasswordNotMatch() {
		final String name = "zhangsan";
		final String password = "password";

		User expectedUser = buildDefault(name, password);
		// set different password for the case that password not match
		expectedUser.setPassword("not_match_password");
		EasyMock.expect(userDao.get(name)).andReturn(expectedUser);
		EasyMock.replay(userDao);

		try {
			loginBusiness.login(name, password);
		} finally {
			EasyMock.verify(userDao);
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testLoginFailureBecauseUnexpectedException() {
		final String name = "zhangsan";
		final String password = "password";

		EasyMock.expect(userDao.get(name)).andThrow(new RuntimeException("error in login"));
		EasyMock.replay(userDao);

		try {
			loginBusiness.login(name, password);
		} finally {
			EasyMock.verify(userDao);
		}
	}

	private User buildDefault(String name, String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setActive(true);
		user.setId(1);
		user.setLastLoginTime(System.currentTimeMillis() - 100000);
		return user;
	}
}
