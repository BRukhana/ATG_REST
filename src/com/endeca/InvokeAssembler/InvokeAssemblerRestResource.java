package com.endeca.InvokeAssembler;

import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONObject;

import atg.commerce.CommerceException;
import atg.json.JSONException;
import atg.nucleus.GenericService;
import atg.service.jaxrs.DropletInvoker;
import atg.service.jaxrs.OParam;
import atg.service.jaxrs.Output;
import atg.service.jaxrs.RestException;
import atg.service.jaxrs.annotation.Endpoint;
import atg.service.jaxrs.annotation.RestResource;
import io.swagger.annotations.ApiOperation;


@RestResource(id = "InvokeAssemblerRestResource")
@Path("/endeca")
public class InvokeAssemblerRestResource extends GenericService{
	
	
@GET
@Path("/endecaRest")
@Consumes({"application/x-www-form-urlencoded"})
@Endpoint(id="/logixal#GET",filterId = "forgotPassword.forgotPasswordId",isSingular=true)
@ApiOperation("Forgot Password")
	public String endecaTest() throws RestException, ServletException {
	
	return "test";
	
}
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/fetchEndecaData")
	@Endpoint(
			id = "/endeca/fetchDataFromEndeca/#POST",
			isSingular = true,
			isValidatedByFramework=false,
			filterId = "tracking-update"
	)
	@ApiOperation("fetch data from endeca")
	public JSONObject updateTrackingInformation(JSONObject pInputJson) throws RestException, CommerceException {
		{
			
			System.out.println("Input JSON"+pInputJson);
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
			}
			 catch (org.json.JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

	}	


	
	
	

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/retrieveEndecaData")
	@Endpoint(
			id = "/retrieveEndecaData/#POST",
			isSingular = true,
			isValidatedByFramework=false,
			filterId = "tracking-update"
			)
	@ApiOperation("retrieve endeca information")
	public JSONObject retrieveEndecaData(JSONObject pInputJson) throws RestException, CommerceException {
		
		
		DropletInvoker dropletInvoker = new  DropletInvoker("/atg/endeca/assembler/droplet/InvokeAssembler");
		dropletInvoker.addInput("includePath", "/browse");
      //  dropletInvoker.addInput("pParamName2", pParamVal2);
        //dropletInvoker.addInput("pParamName3", pParamVal3);
		
		OParam oParamOutput = dropletInvoker.addOParam("output");
		oParamOutput.addOutput("contentItem", "contentItem");
        dropletInvoker.invoke();
        OParam oParamOutputResponse = dropletInvoker.getOParam("output");
		
        Output contentItem = oParamOutputResponse.getOutput("contentItem");
        
        System.out.println("contentItem  :::->>"+contentItem);
        
		return pInputJson;
	}
}
