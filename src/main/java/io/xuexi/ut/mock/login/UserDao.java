package io.xuexi.ut.mock.login;

public interface UserDao {

	void create(User user);

	void remove(int id);

	User get(String name);

	void update(User user);

	void updateLastLoginTime(int id, long lastLoginTime);
}
