package co.edu.unal.unincredible.bank_app;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseSQLITE extends SQLiteOpenHelper {

    DatabaseSQLITE(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (user text primary key , password text )");
        db.execSQL("insert into users(user,password)values ('user','123456')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //TODO: Implement this method
    }
}


