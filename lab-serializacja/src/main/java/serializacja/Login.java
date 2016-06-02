package serializacja;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Login implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 3749363258625093269L;
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

public Login(String username, String password, int age) {
	this.username = username;
	this.password = password;
	this.age = age;
};

public boolean equals(Object o) {
	Login login = (Login) o;
    
	if(this.username.equals(login.username) && this.password.equals(login.password) && this.age == login.age)
		return true;
	else 
		return false;
    
     // The rest goes here   
}

public Login() {
	this.username = UUID.randomUUID().toString();
	this.password = UUID.randomUUID().toString();
	this.age = new Random().nextInt(20000);
};

}