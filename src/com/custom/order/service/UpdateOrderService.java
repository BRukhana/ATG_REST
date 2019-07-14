package com.custom.order.service;

import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import atg.commerce.CommerceException;
import atg.commerce.order.Order;
import atg.commerce.order.OrderManager;
import atg.core.util.StringUtils;
import atg.droplet.DropletException;
import atg.droplet.FormHandlerExecutor;
import atg.nucleus.GenericService;
import atg.service.jaxrs.DropletInvoker;
import atg.service.jaxrs.OParam;
import atg.service.jaxrs.Output;
import atg.service.jaxrs.RestException;
import atg.service.jaxrs.annotation.Endpoint;
import atg.service.jaxrs.annotation.RestResource;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.core.Response.Status;

@RestResource(id = "CustomOrderUpdateService")
@Path("/UpdateOrderService")
public class UpdateOrderService extends GenericService {

	
	private OrderManager mOrderManager;
	
	
	public OrderManager getOrderManager() {
		return mOrderManager;
	}


	public void setOrderManager(OrderManager mOrderManager) {
		this.mOrderManager = mOrderManager;
	}


	@GET
	@Path("/testMethod")
	@Consumes({"application/x-www-form-urlencoded"})
	@Endpoint(id="/test#GET",filterId = "forgotPassword.forgotPasswordId",isSingular=true)
	@ApiOperation("test method")
	public String updateOrder(){
		
		return "test"+getAbsoluteName();
	}
	
	
	@GET
	@Path("/retrieveOrder/{orderId}")
	@Consumes({"application/x-www-form-urlencoded"})
	@Endpoint(id="/{orderId}#GET",filterId = "forgotPassword.forgotPasswordId",isSingular=true)
	@ApiOperation("test method")
	public String retrieveOrder(@ApiParam(required = true) @PathParam("orderId") String pOrderId){
		
		
		try {
			vlogDebug("order id {0}", pOrderId);
			Order order=getOrderManager().loadOrder(pOrderId);
			
			
			ObjectMapper Obj = new ObjectMapper(); 
			
			 String jsonStr = Obj.writeValueAsString(order);
			 
			 return jsonStr;
			
		} catch (CommerceException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch ( JsonProcessingException e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return null;
		
	}
	
	
	@POST
	@Path("/updateTrackingInformation")
	@Consumes({"application/x-www-form-urlencoded"})
	@Endpoint(id = "/updateTrackingInformation#POST", filterId = "forgotPassword.forgotPasswordId")
	@ApiOperation("Authenticate a user.")
	@ApiResponses({
			@ApiResponse(code = 401, message = "Failure: Authentication failure, see response message for details.")})
	public String updateTracking(@FormParam("trackingId") @ApiParam(value = "tracking id",  required = true) String pTrackingId,
			@FormParam("trackingUrl") @ApiParam(value = "tracking url",  required = true) String pTrackingUrl,
			@FormParam("mapKey") @ApiParam(value = "Map Key",  required = true) String pMapKey) throws ServletException{
		
		FormHandlerExecutor formHandlerExecutor = new FormHandlerExecutor("/com/training/UpdateTrackingInformationFormHandler","updateTrackingInformation");
		
		formHandlerExecutor.addInput("trackingUrl", pTrackingUrl);
		formHandlerExecutor.addInput("trackingId", pTrackingId);
		formHandlerExecutor.addInput("mapKey", pMapKey);
		
		formHandlerExecutor.processFormHandlerResult(formHandlerExecutor.execute());
		
		return "test"+getAbsoluteName();
	}
	
	
	@GET
	@Path("/{storeId}")
	@Endpoint(id = "/storeLookup/{storeId}#GET", isSingular = true)
	@ApiOperation("Returns a specific closeness qualifier for the given closeness qualifier id.")
	public String getStoreInformation(@PathParam("storeId") String pStoreId) {

		DropletInvoker invoker = new DropletInvoker("/com/test/StoreLookupCustom");
		vlogDebug("Store Id {0}", pStoreId);
		
		invoker.addInput("storeId", pStoreId);

		OParam oParamOutput = invoker.addOParam("output");
		Output result = oParamOutput.addOutput("element", "element");
		OParam oParamError = invoker.addOParam("error");
		Output error = oParamError.addOutput("errorMsg", "errorMsg");
		invoker.invoke();
		if (error.getObject() != null) {
			throw new RestException(Status.BAD_REQUEST.getStatusCode(), error.getObject().toString());
		} else {
			
			vlogDebug("result {0}", result);
			
			return (String) result.getObject();
		}
	}
	
}
