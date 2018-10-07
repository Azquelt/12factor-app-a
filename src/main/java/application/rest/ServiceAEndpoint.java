package application.rest;

import java.net.URI;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

@Path("/a")
@RequestScoped
public class ServiceAEndpoint {
	
	private int attempts = 0;
	
	@Inject
	@ConfigProperty(name = "serviceBUri")
	URI serviceBUri;

	@Retry(maxRetries = 3)
	@Produces("text/plain")
	@GET
	public String getResponse() {
		attempts++;
		ServiceBClient client = RestClientBuilder.newBuilder().baseUri(serviceBUri).build(ServiceBClient.class);
		
		return "Hello from ServiceA - attempts: " + attempts + "\n" + client.getServiceBResponse();
	}

}
