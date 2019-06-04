package co.edu.unal.unincredible.bank_app.dataAccess.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
	
	@Property(nameInDb = "uid")
	@Id
	private String uid;
	
	@Property(nameInDb = "name")
	@NotNull
	private String displayName;

	@Generated(hash = 1879096950)
	public User(String uid, @NotNull String displayName) {
		this.uid = uid;
		this.displayName = displayName;
	}

	@Generated(hash = 586692638)
	public User() {
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
	
}
