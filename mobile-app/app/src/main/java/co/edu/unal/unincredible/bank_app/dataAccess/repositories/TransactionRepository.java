package co.edu.unal.unincredible.bank_app.dataAccess.repositories;

import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoSession;
import co.edu.unal.unincredible.bank_app.dataAccess.models.TransactionDao;

public class TransactionRepository {

	private TransactionDao transactionDao;

	/*
	 * TODO:
	 *
	 * createTransaction()
	 * */

	public TransactionRepository(DaoSession session){
		this.transactionDao = session.getTransactionDao();
	}


}
