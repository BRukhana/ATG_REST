package com.atg.test.compoent;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import atg.service.jaxrs.annotation.Endpoint;
import atg.service.jaxrs.annotation.RestResource;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.ServletUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestResource(id = "com.atg.test.compoent.CurrentOrderRestResource")
@Path("/bhavin")
@Api(value = "/categories", description = "Category related operations.")

public class TestResource {
	
	
	@GET
	@Endpoint(id = "/rukhana#GET", filterId = "categories-Default")
	@ApiOperation(value = "Get collection of categories.", notes = "If the parentItemId, parentItemType and parentPropertyName parameters are set, then the collection of categories of the parent are returned. ")
	public String getTestComponentValue(){
		DynamoHttpServletRequest request = ServletUtil.getCurrentRequest();
		TestRestComp testComponent = (TestRestComp) request.resolveName("/com/test/TestRestComp");
		return testComponent.getValue();
	}
}