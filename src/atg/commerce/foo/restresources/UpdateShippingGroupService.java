package atg.commerce.foo.restresources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

import atg.commerce.CommerceException;
import atg.nucleus.GenericService;
import atg.service.jaxrs.RestException;
import atg.service.jaxrs.annotation.Endpoint;
import atg.service.jaxrs.annotation.RestResource;
import io.swagger.annotations.ApiOperation;

@RestResource(id = "UpdateShippingGroupService")
@Path("/shipping")
public class UpdateShippingGroupService extends GenericService  {



	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/updateTrackingInfo")
	@Endpoint(
			id = "/currentOrder/updateTrackingInfo/#POST",
			isSingular = true,
			isValidatedByFramework=false,
			filterId = "sample-response"
	)
	@ApiOperation("update shipping information.")
	public JSONObject updateTrackingInformation(JSONObject pInputJson) throws RestException, CommerceException {

		JSONObject obj=new JSONObject();
		if (this.isLoggingDebug()) {
			this.logDebug("Initiating claimCoupon endpoint");
		}

		try {
            obj.put("errorCode","500");
            obj.put("message","This is test response");
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
		return obj;
	}



	

	
}
