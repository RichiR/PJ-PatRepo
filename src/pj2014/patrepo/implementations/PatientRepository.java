package pj2014.patrepo.implementations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pj2014.patrepo.entities.Patient;
import pj2014.dbservices.interfaces.PatientDBServiceRemote;


@Singleton
@Path("/PatientenRepository")
public class PatientRepository {
	
	@EJB
	PatientDBServiceRemote patServ; // = new PatientDBService();
	
	//Aufruf durch: localhost:8080/einstieg2014/rest/findPat/firstname/Max/lastname/Mustermann/bday/1980-07-01 0000:00:00
	@GET
	@Path("/findPat/firstname/{firstname}/lastname/{lastname}/bday/{Bday}")
	@Produces("application/json")
	public Patient[] findPatient(@PathParam("firstname") String firstname,@PathParam("lastname") String lastname,@PathParam("Bday") String Bday) throws ParseException
	{
		 SimpleDateFormat strToDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
			Date bday = strToDate.parse(Bday);
			ArrayList<Patient> search_patients = new ArrayList<Patient>();
			//db search
			search_patients =patServ.findPatientByName( firstname, lastname,bday );

		return search_patients.toArray(new Patient[search_patients.size()]);
	}
	
	@GET
	@Path("/{VersId}")//stimmt noch nicht mit path param �berein
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
