package com.oms.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.json.JSONException;
import org.json.JSONObject;
import atg.commerce.CommerceException;
import atg.nucleus.GenericService;
import atg.service.jaxrs.DropletInvoker;
import atg.service.jaxrs.OParam;
import atg.service.jaxrs.Output;
import atg.service.jaxrs.RepresentationModel;
import atg.service.jaxrs.RepresentationModel.Builder;
import atg.service.jaxrs.RestException;
import atg.service.jaxrs.annotation.Endpoint;
import atg.service.jaxrs.annotation.RestResource;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import oracle.net.aso.p;

@RestResource(id = "TrackingInformationService")
@Path("/trackingInfo")
public class TrackingInformationService extends GenericService{

	
	@GET
	@Path("/retrieveTracking")
	@Endpoint(id = "/retrieveTracking/#GET", isSingular = true, filterId = "tracking-info")
	@ApiOperation("This method would retrieve tracking information")
	public RepresentationModel getTrackingInfo(@ApiParam(required = true)@PathParam("orderId") String pOrderId) {

		if (atg.core.util.StringUtils.isNotBlank(pOrderId)) {

			// business logic

			TrackingInfoPayLoad infoPayLoad = new TrackingInfoPayLoad();
			infoPayLoad.setTackingNo("tr12345");
			infoPayLoad.setTrackingUrl("http://fedex.com?tr=12345");

			Builder builder = new RepresentationModel.Builder().state(infoPayLoad);
			return builder.build();

		}else{
			TrackingInfoPayLoad infoPayLoad = new TrackingInfoPayLoad();
			infoPayLoad.setErrorCode("404");
			infoPayLoad.setErrorMsg("Order Id not specified");
			
			Builder builder = new RepresentationModel.Builder().state(infoPayLoad);
			return builder.build();

		}
	
	}
	
	
/*
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/updateTrackingInfo")
	@Endpoint(
			id = "/currentOrder/updateTrackingInfo/#POST",
			isSingular = true,
			isValidatedByFramework=false,
			filterId = "tracking-update"
	)
	@ApiOperation("update tracking information")
	public JSONObject updateTrackingInformation(JSONObject pInputJson) throws RestException, CommerceException {
		{
			JSONObject resObj=new JSONObject();
			try {

				if(pInputJson==null) {

					resObj.put("errorCode", "500");
					resObj.put("errorMsg", "Input Json null");

				}else {

					String trackingNo=(String) pInputJson.get("trackingNo");
					String trackingUrl=pInputJson.getString("trackingUrl");

					resObj.put("trackNo", trackingNo);
					resObj.put("trackUrl", trackingUrl);
					resObj.put("updateStatus", "Data Updated Successfully");

					return 	resObj;	

				}
			} catch (JSONException je) {

				vlogError("Error in processing request",je );

			}

			return null;
		}

	}	
*/
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/getEndecaInfo")
	@Endpoint(
			id = "/endeca/getEndecaInfo/#POST",
			isSingular = true,
			isValidatedByFramework=false,
			filterId = "endeca-response"
	)
	@ApiOperation("fetch endeca info")
	public JSONObject updateTrackingInformation(JSONObject pInputJson) throws RestException, CommerceException {
		{
			try {

		
				DropletInvoker dropletInvoker = new  DropletInvoker("/atg/endeca/assembler/droplet/InvokeAssembler");

				if(pInputJson==null)
				{
					System.out.println("=========================Input Json is null===============");
				}
					
				if(pInputJson.get("includePath")!=null) {
					System.out.println("Include Path ::->"+pInputJson.get("includePath"));
					dropletInvoker.addInput("includePath", pInputJson.get("includePath"));
				}else if(pInputJson.get("contentCollection")!=null) {
				
					System.out.println("Include Path ::->"+pInputJson.get("contentCollection"));
					
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

			} catch (JSONException je) {

				vlogError("Error in processing request",je );

			}

			return null;
		}

	}		
	
	
}