package com.myrealtor.service.external;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.domain.beans.Provider;

public class AxisRPCClientTest {

	@Test
	public void testRegisterProvider() {
		
	}

	@Test
	public void testFindApartmentList() throws Exception {
		AxisRPCClient a = new AxisRPCClient( Provider.DEFAULT_URL );
		
		for (int i = 0; i < 10; i++) {
			
			List<Apartment> l = a.findApartmentList("p1", "78727");
			System.out.println(l);
			for (Apartment apt : l) {
				System.out.println( apt.getAddress() + " " + apt.getNumber() );
			}
			
		}
		
		
		
	}

}
