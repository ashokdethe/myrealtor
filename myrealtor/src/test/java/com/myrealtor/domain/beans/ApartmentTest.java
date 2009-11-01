package com.myrealtor.domain.beans;

import java.util.ArrayList;
import java.util.List;




public class ApartmentTest {
	
	
	
	public static List<Apartment> createList() {
		List<Apartment> list = new ArrayList<Apartment>();		
		for (String var : AddressTest.ADDRESS_ARRAY) {
			Apartment apt = new Apartment( var );
//			Address a = new Address( var );
//			apt.setAddress( a );
			list.add( apt );
		}
		return list;
	}
	
	

}
