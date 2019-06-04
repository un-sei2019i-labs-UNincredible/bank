package co.edu.unal.unincredible.bank_app.dataAccess.repositories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import co.edu.unal.unincredible.bank_app.dataAccess.database.Database;
import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoMaster;
import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoSession;
import co.edu.unal.unincredible.bank_app.dataAccess.models.User;
import co.edu.unal.unincredible.bank_app.dataAccess.models.UserDao;

public class UserRepository {
	private UserDao user;
	
	public UserRepository(Context context) {
		Database helper = new Database(context, "notes-db");
		SQLiteDatabase db = helper.getWritableDatabase();
		DaoMaster daoMaster = new DaoMaster(db);
		DaoSession daoSession = daoMaster.newSession();
		user = daoSession.getUserDao();
	}
	
	public void update(User upd) {
		user.update(upd);
	}
	
	public void create(User ins) {
		user.insert(ins);
	}
	
	public void delete(User del) {
		user.delete(del);
	}
	
	public User read(String uid) {
		return user.queryBuilder().where(UserDao.Properties.Uid.eq(uid)).unique();
	}
	
	public List<User> read() {
		return user.queryBuilder().list();
	}
}
