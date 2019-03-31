package atg.commerce.foo.restresources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import atg.commerce.CommerceException;
import atg.json.JSONObject;
import atg.service.jaxrs.RestException;
import atg.service.jaxrs.annotation.Endpoint;
import atg.service.jaxrs.annotation.RestResource;
import io.swagger.annotations.ApiOperation;

@RestResource(id = "EndecaRestResource")
@Path("/endeca")
public class EndecaRestResource {
	
	
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/endeca")
	@Endpoint(
			id = "/endeca/retrieveDataFromEndeca/#POST",
			isSingular = true,
			isValidatedByFramework=false,
			filterId = "sample-response"
	)
	@ApiOperation("Apply coupon to the current profile.")
	public JSONObject recieveDataFromEndeca(JSONObject pInputJson) throws RestException, CommerceException {

		JSONObject obj=new JSONObject();
        System.out.println("This is inside post "+pInputJson);
		//RepositoryItem profile = this.getProfile();
		//Map inputJson = (Map)RestUtils.getRestUtils().getResourceUpdateInfo().getUpdates();
		//String couponId = (String)inputJson.get("id");
		//this.mClaimableManager.claimCoupon(profile.getRepositoryId(), couponId);
		return obj;
	}
	

}
