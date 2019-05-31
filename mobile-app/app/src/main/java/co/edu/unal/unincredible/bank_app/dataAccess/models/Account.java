package co.edu.unal.unincredible.bank_app.dataAccess.models;

import java.util.List;

public class Account {
	private int accountNumber;
	private int amount;
	private List<Transaction> transactions;

	public Account(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Account(int accountNumber, int amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public int getAmount() {
		return amount;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public Transaction createTransaction(String receiver, int amount){
		return  null;
	}


}
