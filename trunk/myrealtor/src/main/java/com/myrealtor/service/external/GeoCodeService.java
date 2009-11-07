package com.myrealtor.service.external;

import java.util.List;

import com.myrealtor.domain.beans.Address;
import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.service.BaseService;



public interface GeoCodeService extends BaseService {
	
	public void populateCoordinates(List<Apartment> apartmentList) throws Exception ;
	public void findCoordinate(Address address) throws Exception;

}
