package com.custom.component;

import java.util.HashMap;
import java.util.Map;

import atg.nucleus.GenericService;

public class LocationLookupService extends GenericService {

	private Map<String,String> mLocationToStoreMap=new HashMap();
	
	public String retrieveStoreIdFromLocation(String locationId){
	
		
		vlogDebug("location Id recieved :: {0}", locationId);
		
		String storeId=getLocationToStoreMap().get(locationId);
		if(storeId==null) {
			return "defaultStore";
		}else {
			vlogDebug("retrning store id ::::> {0}", storeId);
			return storeId;
		}

	}

	public Map<String, String> getLocationToStoreMap() {
		return mLocationToStoreMap;
	}

	public void setLocationToStoreMap(Map<String, String> mLocationToStoreMap) {
		this.mLocationToStoreMap = mLocationToStoreMap;
	}
	
	
}
