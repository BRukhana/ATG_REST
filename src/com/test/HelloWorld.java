package com.test;

import atg.nucleus.GenericService;
import atg.nucleus.ServiceException;

public class HelloWorld extends GenericService{ 

	private String mFirstName;
	private String mLastName;
	
	@Override
	public void doStartService() throws ServiceException {
		
		
		System.out.println("Printing First Name and Last Name"+getFirstName() + getLastName());
		
		// TODO Auto-generated method stub
		super.doStartService();
	}
	
	

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
	
	
	
}
