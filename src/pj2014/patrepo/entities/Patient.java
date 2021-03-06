package pj2014.patrepo.entities;

//import java.util.Date;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import pj2014.patrepo.interfaces.IPatient;

@Entity
public class Patient implements Serializable, IPatient {
	
	private int insuranceId;
	private String name, firstName;
	private boolean gender;
	//TODO: vllt noch gender als Attribut?
	
	private String birthDate;
	//TODO auskommentieren wenn Klasse vorhanden (Beziehung nötig? abklären)
	//private Document[] documents;
	
	//default - Constructor 
	//public Patient() {}
	
	@Id
	@GeneratedValue
	public int getId() {
		return insuranceId;
	}
	
	public void setId(int id) {
		this.insuranceId = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public boolean getGender() {
		return gender;
	}
}
