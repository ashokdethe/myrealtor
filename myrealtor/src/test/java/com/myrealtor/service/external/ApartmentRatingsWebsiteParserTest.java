package com.myrealtor.service.external;

import java.net.URL;

import org.junit.Test;

public class ApartmentRatingsWebsiteParserTest {

	@Test
	public void testParse() throws Exception {
		//http://www.apartmentratings.com/rate/SearchResults?action=post&query=78727&x=20&y=4
		
		ApartmentRatingsWebsiteParser a = new ApartmentRatingsWebsiteParser();
		a.parse( new URL("http://www.apartmentratings.com/rate/SearchResults?action=post&query=78727&x=20&y=4") );
		
		
	}

}
