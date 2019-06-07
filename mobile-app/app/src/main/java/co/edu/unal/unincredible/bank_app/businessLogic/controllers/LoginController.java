package co.edu.unal.unincredible.bank_app.businessLogic.controllers;

import android.content.Context;

import co.edu.unal.unincredible.bank_app.dataAccess.repositories.UserRepository;

public class LoginController extends Controller{

	private UserRepository userRepository;


	public LoginController(Context context) {
		super(context);
		this.userRepository = new UserRepository(this.daoSession);
	}


	//TODO: implement this method and solve the problems in LoginActivity
	public boolean login(String username, String Password){


		return true;
	}
}
