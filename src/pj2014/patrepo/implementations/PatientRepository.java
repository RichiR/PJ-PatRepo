package pj2014.patrepo.implementations;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pj.mi.rest2014.entities.Patient;
import pj.mi.rest2014.services.PatientDBServiceRemote;


@Singleton
@Path("/PatientenRepository")
public class PatientRepository {
	
	@EJB
	PatientDBServiceRemote patServ; // = new PatientDBService();
	
	
	
	public Patient[] findPatient(int ID, String firstname, String lastname, Date bday)
	{
		ArrayList<Patient> al_patient = new ArrayList<Patient>();
		//db search
		return al_patient.toArray(new Patient[al_patient.size()]);
	}
	
	@GET
	@Path("/{VersId}")//stimmt noch nicht mit path param überein
	@Produces("application/json")
	public Patient findPatientById(@PathParam("VersId") int VersId)
	{
		
		Patient result = patServ.findPatientById(VersId);
		return result;
		
		//return findPatient(id, null, null, null)[0];
	}
	
	
	
	//zu klaeren - wie ist das mit der id - db vergibt id, oder?

	
	@POST
	@Path("/createPat")


	public boolean addNewPatient(String firstname, String lastname, Date bday, boolean gender)

	{
		Patient pat = new Patient();
		pat.setBirthDate(bday);
		pat.setFirstName(firstname);
		pat.setName(lastname);
		pat.setGender(gender);
		//db add
		patServ.createPatient(pat);
		return true;
	}


	
}
