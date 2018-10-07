package application.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

public interface ServiceBClient {
	
	@Path("/demo/b")
	@GET
	public String getServiceBResponse();

}
