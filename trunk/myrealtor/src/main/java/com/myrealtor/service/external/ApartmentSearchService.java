package com.myrealtor.service.external;

import com.myrealtor.domain.beans.SearchCriteria;
import com.myrealtor.domain.beans.SearchResult;

public interface ApartmentSearchService {
	
	public SearchResult search(SearchCriteria criteria);

}
