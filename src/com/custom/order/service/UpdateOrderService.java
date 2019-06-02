package com.custom.order.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import atg.commerce.CommerceException;
import atg.commerce.order.Order;
import atg.commerce.order.OrderManager;
import atg.nucleus.GenericService;
import atg.service.jaxrs.annotation.Endpoint;
import atg.service.jaxrs.annotation.RestResource;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
	
	
}
