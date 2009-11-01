package com.myrealtor.service.external;

import java.net.URL;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.domain.beans.Provider;
import com.myrealtor.domain.beans.SearchCriteria;
import com.myrealtor.domain.beans.SearchResult;

@Service
public class ApartmentSearchServiceImpl implements ApartmentSearchService {
	
	@Resource (name = "googleGeoCodeService")
	GeoCodeService geoCode;
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchResult search( SearchCriteria criteria ) throws Exception {
		//TODO need to combine result from readOnly and regular apartments
		SearchResult r = new SearchResult();
		List<Apartment> list = findApartmentListReadOnly( criteria, null );
		geoCode.populateCoordinates( list );
		r.setApartmentList( list );
		return r;		
	}
	
	/**
	 * This method will access an external website
	 */
	protected List<Apartment> findApartmentListReadOnly(SearchCriteria criteria, List<Provider> providerList) throws Exception {
		log.debug( "findApartmentListReadOnly: " + criteria.getCriteria() );
		//TODO need to get providers from DB		
		ApartmentHTMLParser htmlParser = new ApartmentRatingsWebsiteParser();
		//List<Apartment> list = htmlParser.parse( new URL("http://www.apartmentratings.com/rate/SearchResults?action=post&query=78727&x=20&y=4") );
		List<Apartment> list = htmlParser.parse( new URL("http://www.apartmentratings.com/rate/SearchResults?action=post&x=20&y=4&query=" + criteria.getCriteria() ) );
		log.debug( "List<Apartment> list: " + list );
		return list;
	}
	
	protected List<Apartment> findApartmentList( List<Provider> providerList) {
		return null;
	}
	
	

}
