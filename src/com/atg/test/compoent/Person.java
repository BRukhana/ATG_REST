package com.atg.test.compoent;

import atg.nucleus.GenericService;

public class Person extends GenericService {

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

		if(isLoggingDebug()){
			logDebug("The full name is"+getFirstName()+" :: "+getLastName());
		}


	}

}
