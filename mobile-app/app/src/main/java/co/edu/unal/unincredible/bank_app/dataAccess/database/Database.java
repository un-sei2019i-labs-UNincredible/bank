package co.edu.unal.unincredible.bank_app.dataAccess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoMaster;
import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoSession;

public class Database extends DaoMaster.OpenHelper {

	private Context context;

	public Database(Context context) {
		super(context, "notes-db");
		this.context = context;
	}

	@Override
	public void onCreate(org.greenrobot.greendao.database.Database db) {
		super.onCreate(db);
		db.execSQL("insert into USER(uid,name,admin,password)values ('admin','Administrator',1,'123456')");

		db.execSQL("insert or replace into USER(uid,name,admin,password)values ('user','123456',0, '123456')");
		db.execSQL("insert or replace into USER(uid,name,admin,password)values ('user2',':v',0, '123456')");

		db.execSQL("insert or replace into ACCOUNT(uid,amount)values ('user',10000)");
		db.execSQL("insert or replace into ACCOUNT(uid,amount)values ('user2',0)");
	}

	public DaoSession getNewDaoSession() {
		Database helper = new Database(this.context);
		SQLiteDatabase db = helper.getWritableDatabase();
		DaoMaster daoMaster = new DaoMaster(db);
		return daoMaster.newSession();
	}
}


