package co.edu.unal.unincredible.bank_app.dataAccess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoMaster;
import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoSession;

public class Database extends DaoMaster.OpenHelper {

	public Database(Context context) {
		super(context, "notes-db");
	}

	@Override
	public void onCreate(org.greenrobot.greendao.database.Database db) {
		super.onCreate(db);
		db.execSQL("insert into USER(uid,name,admin)values ('user','123456',0)");
	}

	public DaoSession getNewDaoSesion(Context context) {
		Database helper = new Database(context);
		SQLiteDatabase db = helper.getWritableDatabase();
		DaoMaster daoMaster = new DaoMaster(db);
		DaoSession daoSession = daoMaster.newSession();

		return daoSession;

	}
}


