package com.custom.droplet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;

import atg.core.util.StringUtils;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.DynamoServlet;

public class StoreLookupCustom extends DynamoServlet{

	private Map<String,String> mStoreLocations;
	
	@Override
	public void service(DynamoHttpServletRequest req, DynamoHttpServletResponse res)
			throws ServletException, IOException {
	
		String storeId=req.getParameter("storeId");
		vlogDebug("Inside StoreLookupCustom : Store Id {0}", storeId);
		if(StringUtils.isNotBlank(storeId)) {
			
			String storeValue=getStoreLocations().get(storeId);
			vlogDebug("Store Value :: > {0}", storeValue);
			req.setParameter("element", storeValue);
			req.serviceLocalParameter("output", req, res);
			
		}else {
			vlogDebug("store id null returninng error");
			req.setParameter("errorMsg", "No Store Id Found");
			req.serviceLocalParameter("error", req, res);
		}
	}

	public Map<String,String> getStoreLocations() {
		return mStoreLocations;
	}

	public void setStoreLocations(Map<String,String> mStoreLocations) {
		this.mStoreLocations = mStoreLocations;
	}
	
}
