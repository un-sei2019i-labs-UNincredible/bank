package co.edu.unal.unincredible.bank_app.dataAccess.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class User {
	
	@Property(nameInDb = "uid")
	@Id
	private String uid;
	
	@Property(nameInDb = "account")
	private Account account;
	
	@Property(nameInDb = "name")
	@NotNull
	private String displayName;
	
}
