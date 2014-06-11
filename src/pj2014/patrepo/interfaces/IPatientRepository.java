package pj2014.patrepo.interfaces;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pj2014.patrepo.entities.Patient;


@Path("/PatientRepository")
public interface IPatientRepository {
	@GET
	@Path("/findPat/firstname/{firstname}/lastname/{lastname}/bday/{Bday}")
	@Produces("application/json")
	public Patient[] findPatient(@PathParam("firstname") String firstname,@PathParam("lastname") String lastname, @PathParam("Bday") String BDay);
	
	@GET
	@Path("/{VersId}")
	@Produces("application/json")
	public Patient findPatientById(@PathParam("VersId") int VersId);
	
	@POST
	@Path("/createPat")
	public boolean addNewPatient(String firstname, String lastname, Date bday, boolean gender);
	
	

}
