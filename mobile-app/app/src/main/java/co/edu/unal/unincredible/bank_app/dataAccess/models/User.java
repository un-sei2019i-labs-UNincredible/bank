package co.edu.unal.unincredible.bank_app.dataAccess.models;

public class User {
	private String uid;
	private Account account;
	private String displayName;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public User(String uid) {
		this.uid = uid;
	}

	public User(String uid, Account account) {
		this.uid = uid;
		this.account = account;
	}

	public User(String uid, Account account, String displayName) {
		this.uid = uid;
		this.account = account;
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void transfer(String receiver, int amount) {
		//TODO: transfer to another user
	}
}
