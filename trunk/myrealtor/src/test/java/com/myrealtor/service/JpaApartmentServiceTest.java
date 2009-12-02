package com.myrealtor.service;

import java.util.List;

import org.junit.Test;

import com.myrealtor.BasicTest;
import com.myrealtor.domain.beans.Apartment;

public class JpaApartmentServiceTest {

	@Test
	public void testFindCachedApartmentList() throws Exception {
		ApartmentService s = (ApartmentService) BasicTest.getApplicationContext().getBean("apartmentService");
		List<Apartment> l = s.findCachedApartmentList( "78727" );
		System.out.println(l);
	}
	
}