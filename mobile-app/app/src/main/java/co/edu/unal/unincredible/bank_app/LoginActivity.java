package co.edu.unal.unincredible.bank_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;
import android.content.Intent;


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
		DatabaseSQLITE admin = new DatabaseSQLITE(this, "administracion", null, 1);
		SQLiteDatabase BaseDeDatabase = admin.getReadableDatabase();

		String username = this.user.getText().toString();

		if (!username.isEmpty()) {

			Cursor fila = BaseDeDatabase.rawQuery
					("select password from users where user = ?", new String[]{username});

			//
			if (fila.moveToFirst()) {

				if (fila.getString(0).equals(this.password.getText().toString())) {

					Intent intent = new Intent(view.getContext(), HomeActivity.class);
					startActivityForResult(intent, 0);


				} else {
					Toast.makeText(this, getResources().getString(R.string.wrongPassword), Toast.LENGTH_LONG).show();
				}

				BaseDeDatabase.close();
			} else {
				Toast.makeText(this, getResources().getString(R.string.wrongUser), Toast.LENGTH_SHORT).show();
				BaseDeDatabase.close();
			}

		} else {
			Toast.makeText(this, getResources().getString(R.string.invalidField), Toast.LENGTH_SHORT).show();
		}
	}
}
