package com.custom.formhandler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;

import com.atg.test.compoent.Person;

import atg.droplet.DropletException;
import atg.droplet.GenericFormHandler;
import atg.nucleus.ServiceMap;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;

public class UpdateTrackingInfoFormHandler extends GenericFormHandler {

	private String mTrackingId;
	private String mTrackingUrl;
	private String mSuccessUrl;
	private String mErrorUrl;
	private List<String> mUrl;
	private ServiceMap mUrlMap;
	private String mMapKey;
	
	public boolean handleUpdateTrackingInformation(DynamoHttpServletRequest pRequest,DynamoHttpServletResponse pResponse) throws ServletException, IOException {
		
		vlogDebug("Inside  update tracking info formhandler");
		
		
		vlogDebug("the tracking url is in format {0} ",mTrackingUrl);
		
		if(StringUtils.isBlank(getTrackingId())) {
			addFormException(new DropletException("Tracking id is blank"));
		}
		
		if(StringUtils.isBlank(getTrackingUrl())) {
			addFormException(new DropletException("Tracking url is blank"));
		}
		
		vlogDebug("Url List is as follows {0}", getUrl());
		
		
// 		vlogDebug("Map Key {0}", getMapKey());
		
// 		getUrlMap().get(getMapKey());
		
// 		vlogDebug("Map value  {0}",getUrlMap().get(getMapKey()));
		
// 		if(getUrlMap().get(getMapKey()) instanceof Person){
// 			((Person) getUrlMap().get(getMapKey())).printFullName();
			
// 		}
		
		return checkFormRedirect(getSuccessUrl(), getErrorUrl(), pRequest, pResponse);
		
	}

	public String getSuccessUrl() {
		return mSuccessUrl;
	}

	public void setSuccessUrl(String mSuccessUrl) {
		this.mSuccessUrl = mSuccessUrl;
	}

	public String getErrorUrl() {
		return mErrorUrl;
	}

	public void setErrorUrl(String mErrorUrl) {
		this.mErrorUrl = mErrorUrl;
	}

	public String getTrackingId() {
		return mTrackingId;
	}

	public void setTrackingId(String mTrackingId) {
		this.mTrackingId = mTrackingId;
	}

	public String getTrackingUrl() {
		return mTrackingUrl;
	}

	public void setTrackingUrl(String mTrackingUrl) {
		this.mTrackingUrl = mTrackingUrl;
	}

	public List<String> getUrl() {
		return mUrl;
	}

	public void setUrl(List<String> mUrl) {
		this.mUrl = mUrl;
	}

	public ServiceMap getUrlMap() {
		return mUrlMap;
	}

	public void setUrlMap(ServiceMap mUrlMap) {
		this.mUrlMap = mUrlMap;
	}

	public String getMapKey() {
		return mMapKey;
	}

	public void setMapKey(String mMapKey) {
		this.mMapKey = mMapKey;
	}
}
