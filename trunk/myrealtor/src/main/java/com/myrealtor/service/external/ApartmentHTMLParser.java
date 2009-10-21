package com.myrealtor.service.external;

import java.net.URL;
import java.util.List;

import com.myrealtor.domain.beans.Apartment;

public interface ApartmentHTMLParser {
	
	public List<Apartment> parse(URL url);

}
