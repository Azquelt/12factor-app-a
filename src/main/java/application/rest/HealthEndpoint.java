package application.rest;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@ApplicationScoped
@Health
public class HealthEndpoint implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
		return HealthCheckResponse.named("serviceA").up().build();
	}

}
