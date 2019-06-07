package co.edu.unal.unincredible.bank_app.dataAccess.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class User {
	
	@Property(nameInDb = "uid")
	@Id
	private String uid;
	
	@Property(nameInDb = "name")
	@NotNull
	private String displayName;
	
	@Property(nameInDb = "admin")
	@NotNull
	private boolean admin;

	@Property(nameInDb = "password")
	@NotNull
	private String password;

	@Generated(hash = 1476049323)
	public User(String uid, @NotNull String displayName, boolean admin,
			@NotNull String password) {
		this.uid = uid;
		this.displayName = displayName;
		this.admin = admin;
		this.password = password;
	}
	
	@Keep
	public User() {
		this.admin = false;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
