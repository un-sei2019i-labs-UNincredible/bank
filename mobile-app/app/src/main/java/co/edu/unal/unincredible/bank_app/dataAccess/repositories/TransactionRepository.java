package co.edu.unal.unincredible.bank_app.dataAccess.repositories;

import java.util.Date;

import co.edu.unal.unincredible.bank_app.dataAccess.models.Account;
import co.edu.unal.unincredible.bank_app.dataAccess.models.DaoSession;
import co.edu.unal.unincredible.bank_app.dataAccess.models.Transaction;
import co.edu.unal.unincredible.bank_app.dataAccess.models.TransactionDao;

public class TransactionRepository {

	private TransactionDao transactionDao;

	public TransactionRepository(DaoSession session) {
		this.transactionDao = session.getTransactionDao();
	}

	public Transaction createTransaction(Account source, Account receiver, int amount) {
		Date now = new Date();

		//source transaction
		Transaction srcTransaction = new Transaction(receiver.getUid(), source.getUid(), amount, now);

		//receiver transaction
		Transaction rcvTransaction = new Transaction(source.getUid(), receiver.getUid(), amount, now);

		this.transactionDao.insert(rcvTransaction);
		this.transactionDao.insert(srcTransaction);

		return srcTransaction;
	}
}
