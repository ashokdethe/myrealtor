package com.myrealtor.service.external;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.myrealtor.domain.beans.Provider;
import com.myrealtor.service.UserService;

@Service
public class ApartmentManagementServiceImpl implements ApartmentManagementService {
	
	@Resource (name = "googleGeoCodeService")
	GeoCodeService geoCode;
	
	@Resource (name = "userService")
	UserService userService;
	
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void registerProvider(Provider provider) throws Exception {
		log.debug("registerProvider: " + provider);
		
		//TODO validate address
		geoCode.findCoordinate( provider.getApartmentComplex().getAddress() );
		
		//TODO call webservice

		userService.store(provider);		
	}
	

}
