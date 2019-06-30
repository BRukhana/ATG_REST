package com.custom.formhandler;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.droplet.GenericFormHandler;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;

public class UpdateTrackingInfoFormHandler extends GenericFormHandler {

	private String mTrackingId;
	private String mTrackingUrl;
	private String mSuccessUrl;
	private String mErrorUrl;
	
	public boolean handleUpdateTrackingInformation(DynamoHttpServletRequest pRequest,DynamoHttpServletResponse pResponse) throws ServletException, IOException {
		
		vlogDebug("Inside  update tracking info formhandler");
		
		vlogDebug("the tracking url is in format {0} ",mTrackingUrl);
		
		
		
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
}
