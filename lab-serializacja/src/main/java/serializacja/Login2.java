package serializacja;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

public class Login2 implements Externalizable, Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 2131231L;
	String username;
	String password;
	int age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Login2(String username, String password, int age) {
		this.username = username;
		this.password = password;
		this.age = age;
	};

	public boolean equals(Object o) {
		Login2 login = (Login2) o;

		if (this.username.equals(login.username) && this.password.equals(login.password) && this.age == login.age)
			return true;
		else
			return false;
	}

	public Login2() {
		this.username = UUID.randomUUID().toString();
		this.password = UUID.randomUUID().toString();
		this.age = new Random().nextInt(20000);
	};

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.username);
		out.writeObject(this.password);
		out.writeInt(this.age);
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.username = (String) in.readObject();
		this.password = (String) in.readObject();
		this.age = (int) in.readInt();

	}

}