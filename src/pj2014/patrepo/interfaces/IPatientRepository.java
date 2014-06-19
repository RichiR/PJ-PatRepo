package pj2014.patrepo.interfaces;

import java.text.ParseException;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import pj2014.patrepo.entities.Patient;


@Path("/PatientRepository")
public interface IPatientRepository {
	@GET
	@Path("/findPat")
	@Produces("application/json")
	public Patient[] findPatient(@QueryParam("firstname") String firstname,@QueryParam("lastname") String lastname,@QueryParam("Bday") String Bday) throws ParseException;
	
	@GET
	@Path("/{VersId}")
	@Produces("application/json")
	public Patient findPatientById(@PathParam("VersId") int VersId);
	
	@POST
	@Path("/createPat")
	public boolean addNewPatient(String firstname, String lastname, Date bday, boolean gender);
	
	

}
