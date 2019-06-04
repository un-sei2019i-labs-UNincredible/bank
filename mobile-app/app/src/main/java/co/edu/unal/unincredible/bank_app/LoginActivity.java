package co.edu.unal.unincredible.bank_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.unal.unincredible.bank_app.dataAccess.models.User;
import co.edu.unal.unincredible.bank_app.dataAccess.repositories.UserRepository;


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
		
		
		String username = this.user.getText().toString();
		
		if (!username.isEmpty()) {
			UserRepository userRepository = new UserRepository(this);
			User test = userRepository.read(username);
			
			
			//
			if (!test.getUid().isEmpty()) {
				
				if (test.getDisplayName().equals(this.password.getText().toString())) {
					
					Intent intent = new Intent(view.getContext(), HomeActivity.class);
					startActivityForResult(intent, 0);
					
					
				} else {
					Toast.makeText(this, getResources().getString(R.string.wrongPassword), Toast.LENGTH_LONG).show();
				}
				
			} else {
				Toast.makeText(this, getResources().getString(R.string.wrongUser), Toast.LENGTH_SHORT).show();
				
			}
			
		} else {
			Toast.makeText(this, getResources().getString(R.string.invalidField), Toast.LENGTH_SHORT).show();
		}
	}
}
