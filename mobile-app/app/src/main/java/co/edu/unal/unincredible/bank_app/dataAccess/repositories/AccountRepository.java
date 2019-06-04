package co.edu.unal.unincredible.bank_app.dataAccess.repositories;

import co.edu.unal.unincredible.bank_app.dataAccess.models.Account;
import co.edu.unal.unincredible.bank_app.dataAccess.models.AccountDao;
import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoSession;

public class AccountRepository {

	private AccountDao accountDao;

	/*
	 * TODO:
	 *
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

	public Account getAccountById(String uid) {
		return this.accountDao.queryBuilder().where(AccountDao.Properties.Uid.eq(uid)).unique();
	}

	public void updateAccount(Account account) {
		this.accountDao.update(account);
	}


}
