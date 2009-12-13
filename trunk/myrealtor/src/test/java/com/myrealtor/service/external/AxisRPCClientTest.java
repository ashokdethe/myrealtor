package com.myrealtor.service.external;

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
		//AxisRPCClient a = new AxisRPCClient( Provider.DEFAULT_URL );
		
		for (int i = 0; i < 10; i++) {
			//AxisRPCClient a = new AxisRPCClient( Provider.DEFAULT_URL );
			AxisRPCClient a = new AxisRPCClient( "http://win2003:7001/apartment_management_webservice/services/webservice" );
			
			System.out.println( "\n\n\nStart Axis test " + (i + 1) );
			
			List<Apartment> l = a.findApartmentList("p1", "78727");
			System.out.println(l);
			for (Apartment apt : l) {
				System.out.println( apt.getAddress() + " " + apt.getNumber() );
			}
			
			a.serviceClient.cleanupTransport();
			
		}
		
		
		
	}

}
