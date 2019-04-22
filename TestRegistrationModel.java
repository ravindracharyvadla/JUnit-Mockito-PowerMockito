package com.companyname.junit.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.companyname.model.RegistrationModel;

public class TestRegistrationModel {

	RegistrationModel model;
	
	@Before
	public void setUp(){
		model=new RegistrationModel();
		model.setEmployeeId(1122);
		model.setUserName("James");
		model.setPassword("james");
		model.setEmailId("james@gmail.com");
		model.setContactNumber("9876543210");
	}
	
	@Test
	public void testRegistrationModel(){
		
		Assert.assertEquals(1122, model.getEmployeeId());
		Assert.assertEquals("James", model.getUserName());
		Assert.assertEquals("james", model.getPassword());
		Assert.assertEquals("james@gmail.com", model.getEmailId());
		Assert.assertEquals("9876543210", model.getContactNumber());
	}
	
	@After
	public void shutDown(){
		System.out.println("--closed--");
	}
}
