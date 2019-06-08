package co.edu.unal.unincredible.bank_app.dataAccess.models;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;

@Entity
public class Account {
	private String uid;

	@Id
	@ToOne(joinProperty = "uid")
	private User user;

	@Property(nameInDb = "amount")
	private int amount;

	@ToMany(joinProperties = {
			@JoinProperty(name = "uid", referencedName = "source"),
			@JoinProperty(name = "uid", referencedName = "receiver")
	})
	private List<Transaction> transactions;

	/**
	 * Used to resolve relations
	 */
	@Generated(hash = 2040040024)
	private transient DaoSession daoSession;

	/**
	 * Used for active entity operations.
	 */
	@Generated(hash = 335469827)
	private transient AccountDao myDao;

	@Generated(hash = 1320934433)
	public Account(String uid, int amount) {
		this.uid = uid;
		this.amount = amount;
	}

	@Generated(hash = 882125521)
	public Account() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Generated(hash = 1867105156)
	private transient String user__resolvedKey;

	/**
	 * To-one relationship, resolved on first access.
	 */
	@Keep
	public User getUser() {
		String __key = this.uid;
		if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
			final DaoSession daoSession = this.daoSession;
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			UserDao targetDao = daoSession.getUserDao();
			User userNew = targetDao.load(__key);
			synchronized (this) {
				user = userNew;
				user__resolvedKey = __key;
			}
		}
		return user;
	}

	/**
	 * called by internal mechanisms, do not call yourself.
	 */
	@Generated(hash = 370057071)
	public void setUser(User user) {
		synchronized (this) {
			this.user = user;
			uid = user == null ? null : user.getUid();
			user__resolvedKey = uid;
		}
	}

	/**
	 * To-many relationship, resolved on first access (and after reset).
	 * Changes to to-many relations are not persisted, make changes to the target entity.
	 */
	@Generated(hash = 1222797465)
	public List<Transaction> getTransactions() {
		if (transactions == null) {
			final DaoSession daoSession = this.daoSession;
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			TransactionDao targetDao = daoSession.getTransactionDao();
			List<Transaction> transactionsNew = targetDao._queryAccount_Transactions(uid,
					uid);
			synchronized (this) {
				if (transactions == null) {
					transactions = transactionsNew;
				}
			}
		}
		return transactions;
	}

	/**
	 * Resets a to-many relationship, making the next get call to query for a fresh result.
	 */
	@Generated(hash = 1751056821)
	public synchronized void resetTransactions() {
		transactions = null;
	}

	/**
	 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
	 * Entity must attached to an entity context.
	 */
	@Generated(hash = 128553479)
	public void delete() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.delete(this);
	}

	/**
	 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
	 * Entity must attached to an entity context.
	 */
	@Generated(hash = 1942392019)
	public void refresh() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.refresh(this);
	}

	/**
	 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
	 * Entity must attached to an entity context.
	 */
	@Generated(hash = 713229351)
	public void update() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.update(this);
	}

	/** called by internal mechanisms, do not call yourself. */
	@Generated(hash = 1812283172)
	public void __setDaoSession(DaoSession daoSession) {
		this.daoSession = daoSession;
		myDao = daoSession != null ? daoSession.getAccountDao() : null;
	}

}
