package com.myrealtor.service.external;

import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.myrealtor.domain.beans.Address;
import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.service.BaseServiceImpl;

//@Service
public class GoogleGeoCodeService extends BaseServiceImpl implements GeoCodeService { 

	//Key for localhost
	public static final String GOOGLE_KEY_PARAMETER = "key=ABQIAAAA0-70fEREB0bsUCfT2s76ZxTwM0brOpm-All5BF6PoaKBxRWWERT53KrunpiWSWcDWKLphA0P7n2XZw";
	public static final String HTTP_GOOGLE_GEO = "http://maps.google.com/maps/geo";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String key = GOOGLE_KEY_PARAMETER;
	
	

	
	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public void populateCoordinates(List<Apartment> apartmentList) throws Exception {		
		for (Apartment apartment : apartmentList ) {			
			findCoordinate(apartment.getAddress());								
		}
	}


	public void findCoordinate(Address address) throws Exception {
		log.debug("findCoordinate: " + address.toString());
		String parms = "?q=" + URLEncoder.encode(address.toString(), "UTF-8") + "&output=xml&sensor=false&" + getKey();
		String urlStr = HTTP_GOOGLE_GEO + parms;
				
		URL url = new URL(urlStr);
		SAXReader reader = new SAXReader();
		Document doc = reader.read( url );		
		
		//TODO Need to have code = 200
		Node nodeCode = doc.selectSingleNode( "//*[local-name()='code']" );		
		String code = nodeCode.getText();
		log.debug("code: " + code);	        

		Node nodeCoord = doc.selectSingleNode( "//*[local-name()='LatLonBox']" );
		String lat = nodeCoord.valueOf( "@north" );
		String lon = nodeCoord.valueOf( "@east" );
		log.debug("lat: " + lat + " - long: " + lon);

		address.setLatitude(lat);
		address.setLongitude(lon);
	}

		
}
