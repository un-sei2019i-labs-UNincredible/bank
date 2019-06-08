package co.edu.unal.unincredible.bank_app.dataAccess.repositories;

import java.util.List;

import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoSession;
import co.edu.unal.unincredible.bank_app.dataAccess.models.User;
import co.edu.unal.unincredible.bank_app.dataAccess.models.UserDao;

public class UserRepository {
	private UserDao user;

	public UserRepository(DaoSession session) {
		user = session.getUserDao();
	}

	public void update(User user) {
		this.user.update(user);
	}

	public void create(User user) {
		this.user.insert(user);
	}

	public void delete(User user) {
		this.user.delete(user);
	}

	public User getUserById(String uid) {
		return this.user.queryBuilder().where(UserDao.Properties.Uid.eq(uid)).unique();
	}

	public List<User> getUsers() {
		return this.user.queryBuilder().list();
	}

	public boolean isPassword(User user, String password) {
		return user.getPassword().equals(password);
	}

	public boolean isPassword(String uid, String password) {
		return this.getUserById(uid).getPassword().equals(password);
	}
}
