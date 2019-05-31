package co.edu.unal.unincredible.bank_app.dataAccess.models;

import java.util.Date;

public class Transaction {
	private String receiver;
	private  String source;
	private int amount;
	private Date date;

	public Transaction(String receiver, String source, int amount, Date date) {
		this.receiver = receiver;
		this.source = source;
		this.amount = amount;
		this.date = date;
	}

	public String getReceiver() {
		return receiver;
	}

	public String getSource() {
		return source;
	}

	public int getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}
}
