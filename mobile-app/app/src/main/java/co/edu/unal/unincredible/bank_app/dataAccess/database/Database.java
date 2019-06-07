package co.edu.unal.unincredible.bank_app.dataAccess.database;

import android.content.Context;

import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoMaster;

public class Database extends DaoMaster.OpenHelper {

	public Database(Context context) {
		super(context, "notes-db");
	}

	@Override
	public void onCreate(org.greenrobot.greendao.database.Database db) {
		super.onCreate(db);
		db.execSQL("insert into USER(uid,name,admin)values ('user','123456',0)");
	}
}


