package com.endeca.InvokeAssembler;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.json.JSONObject;
import atg.commerce.CommerceException;
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
