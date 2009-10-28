package com.myrealtor.service.external;

import java.util.List;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.domain.beans.Provider;
import com.myrealtor.domain.beans.SearchCriteria;
import com.myrealtor.domain.beans.SearchResult;

public class ApartmentSearchServiceImpl implements ApartmentSearchService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchResult search(SearchCriteria criteria) {
		return null;		
	}
	
	protected List<Apartment> findApartmentListReadOnly( List<Provider> providerList) {
		return null;
	}
	
	protected List<Apartment> findApartmentList( List<Provider> providerList) {
		return null;
	}
	
	

}
