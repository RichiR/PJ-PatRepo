package pj2014.patrepo.interfaces;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public interface IUser {
	
	public String getPassword();
	public void setPassword(String password);
	
	@Id
	@GeneratedValue
	public int getUserId();
	
	public void setUserId(int userId);
	public String getUserFirstName();
	public void setUserFirstName(String userFirstName);
	public String getUserName();
	public void setUserName(String userName);
	
}
