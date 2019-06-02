package com.rest.component;

import atg.nucleus.GenericService;

public class RestComponent extends GenericService{

	public Address findAddress(String id) {
		  Address address = new Address();

          address.setState("TX");
          address.setCity("Irving");
          return address;
		
		
		
		
		
	}
	
	
	
}
