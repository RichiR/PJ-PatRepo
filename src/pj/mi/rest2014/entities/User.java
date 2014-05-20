package pj.mi.rest2014.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
	
  private int userId;
  
	private String password;
	private String userName;
	private String userFirstName;
	//private String [] database; //führt zu Problemen mit der DB, vorerst auskommentiert lassen
	
	public User() {}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Id
  @GeneratedValue
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/*public String [] getDatabase() {
		return database;
	}
	public void setDatabase(String [] database) {
		this.database = database;
	}*/

}
