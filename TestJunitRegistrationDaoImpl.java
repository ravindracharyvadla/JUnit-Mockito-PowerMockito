package com.companyname.junit.dao;

import org.junit.Before;
import org.junit.Test;

import com.companyname.dao.RegistrationDaoImpl;
import com.companyname.model.RegistrationModel;

public class TestJunitRegistrationDaoImpl {

	private RegistrationDaoImpl regdaoimpl;
	
	RegistrationModel regmodel;
	
	@Before
	public void setUp(){
		regdaoimpl=new RegistrationDaoImpl();
		regmodel=new RegistrationModel();
	}
	
	@Test
	public void testRegistration(){
		regdaoimpl.registration(regmodel);
	}
}
