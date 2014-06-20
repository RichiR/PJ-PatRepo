package pj2014.patrepo.interfaces;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public interface IPatient {
	
	@Id
	@GeneratedValue
	public int getId();
	
	public void setId(int id);
	
	public String getName();
	
	public void setName(String name);
	
	public String getFirstName();
	
	public void setFirstName(String firstName);
	
	public String getBirthDate();
	
	public void setBirthDate(String birthDate);
	
	public void setGender(String gender);
	
	public String getGender();
}
