package com.oms.services;

public class TrackingInfoPayLoad {

	private String mTrackingUrl;
	private String mTackingNo;
	private String mErrorMsg;
	private String mErrorCode;
	
	
	public String getTackingNo() {
		return mTackingNo;
	}
	public void setTackingNo(String mTackingNo) {
		this.mTackingNo = mTackingNo;
	}
	public String getTrackingUrl() {
		return mTrackingUrl;
	}
	public void setTrackingUrl(String mTrackingUrl) {
		this.mTrackingUrl = mTrackingUrl;
	}
	public String getErrorMsg() {
		return mErrorMsg;
	}
	public void setErrorMsg(String mErrorMsg) {
		this.mErrorMsg = mErrorMsg;
	}
	public String getErrorCode() {
		return mErrorCode;
	}
	public void setErrorCode(String mErrorCode) {
		this.mErrorCode = mErrorCode;
	}
}
