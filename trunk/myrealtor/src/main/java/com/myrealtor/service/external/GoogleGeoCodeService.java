package com.myrealtor.service.external;

import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.service.BaseServiceImpl;

@Service
public class GoogleGeoCodeService extends BaseServiceImpl implements GeoCodeService {

	public static final String GOOGLE_KEY_PARAMETER = "key=ABQIAAAA0-70fEREB0bsUCfT2s76ZxTwM0brOpm-All5BF6PoaKBxRWWERT53KrunpiWSWcDWKLphA0P7n2XZw";
	public static final String HTTP_GOOGLE_GEO = "http://maps.google.com/maps/geo";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	public void populateCoordinates(List<Apartment> apartmentList) throws Exception {
		
		for (Apartment apartment : apartmentList ) {			
			
			String parms = "?q=" + URLEncoder.encode(apartment.getAddress().toString(), "UTF-8") + "&output=xml&sensor=false&" + GOOGLE_KEY_PARAMETER;
			String urlStr = HTTP_GOOGLE_GEO + parms;		
			
//			String xmlStr = getURLContent(urlStr);
//			log.debug( "xmlStr: " + xmlStr );
//			StringReader sr = new StringReader( xmlStr );
					
			
			URL url = new URL(urlStr);
			SAXReader reader = new SAXReader();
	        Document doc = reader.read( url );		
			
		    //TODO Need to have code = 200
	        Node nodeCode = doc.selectSingleNode( "//*[local-name()='code']" );		
			String code = nodeCode.getText();
			log.debug("code: " + code);
	        
	        //doc.selectNodes("//*[local-name()='foo']"
	        //List l3 = doc.selectNodes("//*[local-name()='LatLonBox']");
			Node nodeCoord = doc.selectSingleNode( "//*[local-name()='LatLonBox']" );
			String lat = nodeCoord.valueOf( "@north" );
			String lon = nodeCoord.valueOf( "@east" );
			log.debug("lat: " + lat + " - long: " + lon);

			//Coordinate ret = new Coordinate(lat, lon);
			apartment.getAddress().setLatitude(lat);
			apartment.getAddress().setLongitude(lon);
								
		}

	}
	
//	protected Document parse(URL url) throws Exception {		
//        SAXReader reader = new SAXReader();
//        Document document = reader.read(url);
//        
//        return document;
//    }

	

	
	
}
