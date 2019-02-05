package com.atg.test.compoent;

import atg.nucleus.GenericService;
import atg.nucleus.ServiceException;

public class HelloWorld extends GenericService{
	
	private String mFirstName;
	private String mLastName;
	
	public String getFirstName() {
		return mFirstName;
	}
	public void setFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}
	public String getLastName() {
		return mLastName;
	}
	public void setLastName(String mLastName) {
		this.mLastName = mLastName;
	}
	
	public void printFullName(){
		
		String fullName=getFirstName()+" "+getLastName();
		
		if(isLoggingDebug()){
			logDebug("The full Name is "+fullName);
		}
		
	}
	

	@Override
	public void doStartService() throws ServiceException {
		// TODO Auto-generated method stub
		super.doStartService();
		
		if(isLoggingInfo()){
			logInfo("The compoent "+getClass().getSimpleName()+" is startted !!!!!!!!!");
			
		}
	}

}
