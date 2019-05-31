package co.edu.unal.unincredible.bank_app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.unal.unincredible.bank_app.dataAccess.database.Database;


public class LoginActivity extends AppCompatActivity {
	private EditText user, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		user = findViewById(R.id.user);
		password = findViewById(R.id.password);
	}


	public void search(View view) {
		Database admin = new Database(this, "administracion", null, 1);
		SQLiteDatabase sqLiteDatabase = admin.getReadableDatabase();

		String username = this.user.getText().toString();

		if (!username.isEmpty()) {

			Cursor cursor = sqLiteDatabase.rawQuery
					("select password from users where user = ?", new String[]{username});

			//
			if (cursor.moveToFirst()) {

				if (cursor.getString(0).equals(this.password.getText().toString())) {

					Intent intent = new Intent(view.getContext(), HomeActivity.class);
					startActivityForResult(intent, 0);


				} else {
					Toast.makeText(this, getResources().getString(R.string.wrongPassword), Toast.LENGTH_LONG).show();
				}

				sqLiteDatabase.close();
			} else {
				Toast.makeText(this, getResources().getString(R.string.wrongUser), Toast.LENGTH_SHORT).show();
				sqLiteDatabase.close();
			}

			cursor.close();

		} else {
			Toast.makeText(this, getResources().getString(R.string.invalidField), Toast.LENGTH_SHORT).show();
		}
	}
}
