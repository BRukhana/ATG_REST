package atg.commerce.foo.restresources;

import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import atg.nucleus.GenericService;
import atg.service.jaxrs.RestException;
import atg.service.jaxrs.annotation.Endpoint;
import atg.service.jaxrs.annotation.RestResource;
import io.swagger.annotations.ApiOperation;

@RestResource(id = "LSForgotPasswordUsersRestResource")
@Path("/LSforgotPassword")
public class CurrentOrderRestResource extends GenericService {
	
		
	@GET
	@Path("/forgotPassword")
	@Consumes({"application/x-www-form-urlencoded"})
	@Endpoint(id="/logixal#GET",filterId = "forgotPassword.forgotPasswordId",isSingular=true)
	@ApiOperation("Forgot Password")
		public String forgotPassword() throws RestException, ServletException {
		
		return "test";
		
	}
	
	
		
}

