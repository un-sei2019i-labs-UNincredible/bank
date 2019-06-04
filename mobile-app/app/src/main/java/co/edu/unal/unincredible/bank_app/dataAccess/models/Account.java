package co.edu.unal.unincredible.bank_app.dataAccess.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
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

	//TODO: Build code

}
