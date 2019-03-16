package atg.commerce.foo.restresources;

import javax.servlet.ServletException;
import javax.ws.rs.*;

import atg.commerce.CommerceException;

import atg.nucleus.GenericService;
import atg.service.jaxrs.DropletInvoker;
import atg.service.jaxrs.OParam;
import atg.service.jaxrs.Output;
import atg.service.jaxrs.RestException;
import atg.service.jaxrs.annotation.Endpoint;
import atg.service.jaxrs.annotation.RestResource;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.json.JSONException;

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
	@ApiOperation("Apply coupon to the current profile.")
	public JSONObject claimCoupon(JSONObject pInputJson) throws RestException, CommerceException {

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

        System.out.println("This is inside post ");
		//RepositoryItem profile = this.getProfile();
		//Map inputJson = (Map)RestUtils.getRestUtils().getResourceUpdateInfo().getUpdates();
		//String couponId = (String)inputJson.get("id");
		//this.mClaimableManager.claimCoupon(profile.getRepositoryId(), couponId);
		return obj;
	}



	
/*	
	@POST
	@Path("/{shippingGroupId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Endpoint(id="/shipping/updateTrackingInfo/{shippingGroupId}#POST",filterId = "sample-response",isSingular=true)
	@ApiOperation("Update Tracking Info")
		public RepresentationModel updateTrackingInfo(JSONObject pInputJson) throws RestException, ServletException {
		
		
		System.out.println("JSON OBJECT"+pInputJson);
		String shippingGroupId="122";
		if(shippingGroupId=="100") {
			
			String errorMessage = "No ship group found";
			vlogDebug("Error: {0}", new Object[]{errorMessage});
			throw new RestException("404", errorMessage);
			
		}
		
		// builder = (new Builder()).state("bhavin");
		CustomPayload payload= new CustomPayload();
		payload.setErrorCode("500");
	
		payload.setMessage("Unable to process the requrest");
		Builder	builder = new RepresentationModel.Builder().state(payload);
		return builder.build();
		
}
	
	@POST
	@Path("/testUser")
	@Endpoint(id = "/testUser/#POST", isSingular = true, filterId = "updateUser",isValidatedByFramework=false)
	public RepresentationModel updateUser()
			throws RestException, RepositoryException, ServletException {

		System.out.println("====================================================");
		
		CustomPayload payload= new CustomPayload();
		payload.setErrorCode("500");
	
		payload.setMessage("Unable to process the requrest");
		Builder	builder = new RepresentationModel.Builder().state(payload);
		return builder.build();

				
				
				
	}
	
	
	@POST
	@Path("/checkoutCustom")
	@Endpoint(id = "/checkoutCustom/#POST", isSingular = true, validatorId = "cart.checkout", filterId = "cart-Default")
	@ApiOperation("Checkout the current order in the cart.")
	public String checkout(@QueryParam("allowEmptyOrders") Boolean pAllowEmptyOrders,
			JSONObject pInputJson) throws RestException, CommerceException, ServletException {
		RestResourceUpdateInfo checkoutUpdateInfo = RestUtils.getRestUtils().getResourceUpdateInfo();
		
		
System.out.println("====================================================");
		
		CustomPayload payload= new CustomPayload();
		payload.setErrorCode("500");
	
		payload.setMessage("Unable to process the requrest");
		Builder	builder = new RepresentationModel.Builder().state(payload);

		return "bhavin";
	
	}
	
*/	
	
	@POST
	@Path("/retrieveEndecaContent")
	@Endpoint(id = "/retrieveEndecaContent/#POST", isSingular = true,filterId = "endeca-response",isValidatedByFramework=false)
	@ApiOperation("Retrieve Content from endeca")
	public JSONObject retrieveEndecaContent(JSONObject pInputJson) throws RestException, CommerceException, ServletException, JSONException {
		DropletInvoker dropletInvoker = new  DropletInvoker("/atg/endeca/assembler/droplet/InvokeAssembler");

		if(pInputJson==null)
		{
			System.out.println("=========================Input Json is null===============");
		}
			
		if(pInputJson.get("includePath")!=null) {
			dropletInvoker.addInput("includePath", pInputJson.get("includePath"));
		}else if(pInputJson.get("contentCollection")!=null) {
			dropletInvoker.addInput("contentCollection", pInputJson.get("contentCollection"));
		}
	
		OParam oParamOutput = dropletInvoker.addOParam("output");
		oParamOutput.addOutput("contentItem", "contentItem");
		dropletInvoker.invoke();
		OParam oParamOutputResponse = dropletInvoker.getOParam("output");

		Output contentItem = oParamOutputResponse.getOutput("contentItem");

		System.out.println("contentItem  :::->>"+contentItem.getObject());

		String jsonString=contentItem.getObject().toString();
		
		JSONObject obj=new JSONObject();
		obj.put("contentItem", jsonString);
		
		return obj;

	}
	
}
