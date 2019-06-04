package co.edu.unal.unincredible.bank_app.dataAccess.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;

@Entity
public class Transaction {
	@NotNull
	@Property(nameInDb = "receiver")
	private String receiver;

	@NotNull
	@Property(nameInDb = "source")
	private String source;

	@NotNull
	@Property(nameInDb = "amount")
	private int amount;

	@NotNull
	@Property(nameInDb = "date")
	private Date date;

	@Generated(hash = 468412022)
	public Transaction(@NotNull String receiver, @NotNull String source, int amount,
	                   @NotNull Date date) {
		this.receiver = receiver;
		this.source = source;
		this.amount = amount;
		this.date = date;
	}

	@Generated(hash = 750986268)
	public Transaction() {
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
