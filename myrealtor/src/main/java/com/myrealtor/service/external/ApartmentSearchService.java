package com.myrealtor.service.external;

import com.myrealtor.domain.beans.SearchCriteria;
import com.myrealtor.domain.beans.SearchResult;
import com.myrealtor.service.BaseService;

public interface ApartmentSearchService extends BaseService {
	
	public SearchResult search(SearchCriteria criteria) throws Exception;

}
