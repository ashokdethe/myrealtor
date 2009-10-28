package com.myrealtor.service.external;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.domain.beans.ApartmentTest;

public class GoogleGeoCodeServiceTest {

	@Test
	public void testFindCoordinate() throws Exception {
		
		GoogleGeoCodeService g = new GoogleGeoCodeService();
		List<Apartment> list = ApartmentTest.createList();
		
		g.findCoordinate( list.get(0) );
		
	}

}
