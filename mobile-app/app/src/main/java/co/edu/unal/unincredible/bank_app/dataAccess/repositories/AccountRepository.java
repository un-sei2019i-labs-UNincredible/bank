package co.edu.unal.unincredible.bank_app.dataAccess.repositories;

import co.edu.unal.unincredible.bank_app.dataAccess.models.Account;
import co.edu.unal.unincredible.bank_app.dataAccess.models.AccountDao;
import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoSession;

public class AccountRepository {

	private AccountDao accountDao;

	/*
	* TODO:
	*
	* getAccountById()
	* updateAccount()
	* deleteAccount()
	*
	* */

	public AccountRepository(DaoSession session) {
		this.accountDao = session.getAccountDao();
	}

	public Account createAccount(String uid, int amount) {
		Account account = new Account(uid, amount);
		this.accountDao.insert(account);
		return account;

	}


}
