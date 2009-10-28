package com.myrealtor.service.external;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.service.BaseService;



public interface GeoCodeService extends BaseService {
	
	public Coordinate findCoordinate(Apartment apartment) throws Exception ;

}
