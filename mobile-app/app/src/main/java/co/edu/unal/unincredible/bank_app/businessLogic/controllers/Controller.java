package co.edu.unal.unincredible.bank_app.businessLogic.controllers;

import android.content.Context;

import co.edu.unal.unincredible.bank_app.dataAccess.database.Database;
import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoSession;

abstract class Controller {
	DaoSession daoSession;

	public Controller(Context context) {
		this.daoSession = new Database(context).getNewDaoSession();
	}
}
