package co.edu.unal.unincredible.bank_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.unal.unincredible.bank_app.businessLogic.controllers.LoginController;


public class LoginActivity extends AppCompatActivity {
	private EditText user, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		user = findViewById(R.id.user);
		password = findViewById(R.id.password);
	}


	public void login(View view) {

		String username = this.user.getText().toString();
		String password = this.password.getText().toString();

		LoginController loginControllerController = new LoginController(this);

		switch (loginControllerController.login(username, password)) {
			case NO_USER_OR_PASSWORD_WERE_GIVEN:

				Toast.makeText(this,
						getResources().getString(R.string.invalidField),
						Toast.LENGTH_SHORT)
						.show();
				break;

			case WRONG_USER:
				Toast.makeText(this, getResources().getString(R.string.wrongUser),
						Toast.LENGTH_SHORT)
						.show();
				break;

			case WRONG_PASSWORD:
				Toast.makeText(this, getResources().getString(R.string.wrongPassword),
						Toast.LENGTH_LONG)
						.show();
				break;

			case SUCCESS:
				Intent intent = new Intent(view.getContext(), HomeActivity.class);
				startActivityForResult(intent, 0);
				break;

			default:
				break;
		}

	}
}
