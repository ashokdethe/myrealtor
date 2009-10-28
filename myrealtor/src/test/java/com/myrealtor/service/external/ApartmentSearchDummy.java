package com.myrealtor.service.external;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.domain.beans.ApartmentTest;
import com.myrealtor.domain.beans.SearchCriteria;
import com.myrealtor.domain.beans.SearchResult;
import com.myrealtor.service.BaseServiceImpl;

@Service
public class ApartmentSearchDummy extends BaseServiceImpl implements ApartmentSearchService {
	
	@Resource (name = "googleGeoCodeService")
	GeoCodeService geoCode;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchResult search(SearchCriteria criteria) throws Exception {
		log.info("Executing dummy search: " + criteria);		
		SearchResult r = new SearchResult();
		r.setApartmentList( ApartmentTest.createList() );
		
		for (Apartment a : r.getApartmentList()) {
			geoCode.findCoordinate( a );		
		}
		
		return r;		
	}
	
}
