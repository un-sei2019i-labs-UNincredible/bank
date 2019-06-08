package co.edu.unal.unincredible.bank_app.businessLogic.controllers;

import android.content.Context;

import co.edu.unal.unincredible.bank_app.dataAccess.models.User;
import co.edu.unal.unincredible.bank_app.dataAccess.repositories.UserRepository;

public class LoginController extends Controller {

	public enum LoginStatus {
		SUCCESS,
		NO_USER_OR_PASSWORD_WERE_GIVEN,
		WRONG_USER,
		WRONG_PASSWORD
	}

	private UserRepository userRepository;


	public LoginController(Context context) {
		super(context);
		this.userRepository = new UserRepository(this.daoSession);
	}


	//TODO: implement this method and solve the problems in LoginActivity
	public LoginStatus login(String username, String password) {

		if (username != null && password != null && !username.isEmpty() && !password.isEmpty()) {

			//we get the user from the repository
			User user = this.userRepository.getUserById(username);

			if (user != null) {

				// we verify the password twice

				return this.userRepository.isPassword(user, password) &&
						this.userRepository.isPassword(username, password) ?
						LoginStatus.SUCCESS :
						LoginStatus.WRONG_PASSWORD;
			} else {
				return LoginStatus.WRONG_USER;
			}

		} else {
			return LoginStatus.NO_USER_OR_PASSWORD_WERE_GIVEN;
		}
	}
}
