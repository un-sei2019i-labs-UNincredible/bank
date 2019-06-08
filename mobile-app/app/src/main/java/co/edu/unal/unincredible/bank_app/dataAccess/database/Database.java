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
	}

	public DaoSession getNewDaoSession() {
		Database helper = new Database(this.context);
		SQLiteDatabase db = helper.getWritableDatabase();
		DaoMaster daoMaster = new DaoMaster(db);
		return daoMaster.newSession();
	}
}


