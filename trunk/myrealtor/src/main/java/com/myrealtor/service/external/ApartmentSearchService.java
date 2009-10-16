package com.myrealtor.service.external;

import com.myrealtor.domain.SearchCriteria;
import com.myrealtor.domain.SearchResult;

public interface ApartmentSearchService {
	
	public SearchResult search(SearchCriteria criteria);

}
