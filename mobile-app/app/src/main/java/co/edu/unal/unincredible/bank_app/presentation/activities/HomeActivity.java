package co.edu.unal.unincredible.bank_app.presentation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.edu.unal.unincredible.bank_app.R;
import co.edu.unal.unincredible.bank_app.dataAccess.database.Database;
import co.edu.unal.unincredible.bank_app.dataAccess.models.User;
import co.edu.unal.unincredible.bank_app.dataAccess.repositories.UserRepository;

public class HomeActivity extends AppCompatActivity {
	private User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);

		TextView welcome = findViewById(R.id.welcome);

		//show username
		welcome.append(" " + this.user.getDisplayName());

		// we get the actual user from LoginActivity
		String username = getIntent().getStringExtra("uid");
		this.user = new UserRepository(new Database(this).getNewDaoSession())
				.getUserById(username);



	}

	public void sendMoney(View view){
		Intent intent = new Intent(view.getContext(), SendMoneyActivity.class);

		intent.putExtra("uid", this.user.getUid());
		startActivityForResult(intent, 0);
	}
}
