package com.myrealtor.service.external;

import java.util.List; 

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.domain.beans.SearchCriteria;
import com.myrealtor.domain.beans.SearchResult;
import com.myrealtor.domain.beans.User;
import com.myrealtor.service.BaseService;

public interface ApartmentSearchService extends BaseService {
	
	public SearchResult search(SearchCriteria criteria) throws Exception;
	public List<Apartment> findApartmentList( String username, String zip ) throws Exception;
	public void rent(User user, String providerName, String aptNumber) throws Exception;  

}
