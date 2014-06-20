package pj2014.patrepo.implementations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import pj2014.patrepo.entities.Patient;
import pj2014.dbservices.interfaces.PatientDBServiceRemote;
import pj2014.dbservices.factories.PatientDBServiceProxyFactory;
import pj2014.patrepo.interfaces.IPatientRepository;
import pj2014.patrepo.entities.*;

@Singleton
@Remote(IPatientRepository.class)
public class PatientRepository implements IPatientRepository {
	
//	@EJB Statt dessen -> Proxy holen wie bei den anderen Integrationsbeispielen
	PatientDBServiceRemote patServ; // = new PatintDBService();
	
	public PatientDBServiceRemote getDBService(){
		// hier: Proxy holen aus der PatientDBServiceRemote.
																							
		PatientDBServiceRemote proxy = PatientDBServiceProxyFactory.getProxy("http://localhost:8080/dbservices/PatientDBService/");
		return proxy;
	}
	
	//Aufruf durch: localhost:8080/einstieg2014/rest/findPat/firstname/Max/lastname/Mustermann/bday/1980-07-01 0000:00:00
	/*@GET
	//@Path("/findPat/firstname/{firstname}/lastname/{lastname}/bday/{Bday}")
	@Path("/findPat")
	@Produces("application/json")*/
	//public Patient[] findPatient(@PathParam("firstname") String firstname,@PathParam("lastname") String lastname,@PathParam("Bday") String Bday) throws ParseException
	public Patient[] findPatient(@QueryParam("firstname") String firstname,@QueryParam("lastname") String lastname,@QueryParam("Bday") String Bday) throws ParseException
	{
		SimpleDateFormat strToDate = new SimpleDateFormat("yyyy-MM-dd");
		
		Date bday = strToDate.parse(Bday);
		ArrayList<Patient> search_patients = new ArrayList<Patient>();
			//db search
			search_patients =getDBService().findPatientByName( firstname, lastname,bday );
		
		System.out.println("HIER Patientenergebnisse: " + search_patients.get(0).getFirstName() + search_patients.get(0).getName());
		return search_patients.toArray(new Patient[search_patients.size()]);
	}
	

	public Patient findPatientById(@PathParam("VersId") int VersId)
	{
		Patient result = getDBService().findPatientById(VersId);
		return result;

	}
	
	
	
	//zu klaeren - wie ist das mit der id - db vergibt id, oder?

	
	/*@POST
	@Path("/createPat")*/


	public Patient addNewPatient(String firstname, String lastname, String bday, String gender)

	{
		Patient pat = new Patient();
		pat.setBirthDate(bday);
		pat.setFirstName(firstname);
		pat.setName(lastname);
		pat.setGender(gender);
		
		return getDBService().createPatient(pat);
		
		
	}


	
}
