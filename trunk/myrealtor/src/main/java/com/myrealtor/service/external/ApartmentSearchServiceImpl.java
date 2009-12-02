package com.myrealtor.service.external;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.domain.beans.Provider;
import com.myrealtor.domain.beans.Rent;
import com.myrealtor.domain.beans.SearchCriteria;
import com.myrealtor.domain.beans.SearchResult;
import com.myrealtor.domain.beans.User;
import com.myrealtor.service.ApartmentService;
import com.myrealtor.service.UserService;

@Service
public class ApartmentSearchServiceImpl implements ApartmentSearchService { 

	private static final long serialVersionUID = 1L;

	@Resource(name = "googleGeoCodeService")
	GeoCodeService geoCode;

	@Resource(name = "userService")
	protected UserService userService;

	@Resource(name = "apartmentService")
	protected ApartmentService apartmentService;

	protected final Log log = LogFactory.getLog(getClass());

	public SearchResult search(SearchCriteria criteria) throws Exception {
		SearchResult r = new SearchResult();

		List<Apartment> list = findApartmentListReadOnly(criteria);

		List<Provider> providerList = userService.findAllProviders();
		log.debug("providerList: " + providerList);
		List<Apartment> aptlist = findApartmentList(providerList, criteria);
		list.addAll(aptlist);

		r.setApartmentList(list);

		return r;
	}

	/**
	 * This method will access an external website. This http provider is
	 * registered in the code
	 */
	protected List<Apartment> findApartmentListReadOnly(SearchCriteria criteria) throws Exception {
		List<Apartment> list = new ArrayList<Apartment>();
		log.debug("findApartmentListReadOnly: " + criteria.getCriteria());
		boolean isError = false;

		try {
			ApartmentHTMLParser htmlParser = new ApartmentRatingsWebsiteParser();
			
			// List<Apartment> list = htmlParser.parse( new URL("http://www.apartmentratings.com/rate/SearchResults?action=post&query=78727&x=20&y=4") );
			
			list = htmlParser.parse(new URL("http://www.apartmentratings.com/rate/SearchResults?action=post&x=20&y=4&query=" + criteria.getCriteria()));
			log.debug("List<Apartment> list: " + list);
			geoCode.populateCoordinates(list);

			// Check if it was already cached
			List<Apartment> cachedList = apartmentService.findCachedApartmentList( criteria.getCriteria() );
			if (cachedList == null || cachedList.isEmpty()) {
				log.info("Caching apartments website " + criteria.getCriteria());
				apartmentService.storeApartmentList(list);
			}

		} catch (Exception e) {
			log.error(e, e);
			isError = true;
		}

		if ( isError || list.isEmpty() ) { //Try to get the data from cache
			log.warn("Trying cache for apartment website " + criteria.getCriteria());
			list = apartmentService.findCachedApartmentList( criteria.getCriteria() );
		}

		return list;
	}

	protected List<Apartment> findApartmentList(List<Provider> providerList, SearchCriteria criteria) throws Exception {
		log.debug("findApartmentList criteria: " + criteria.getCriteria() + " - providerList: " + providerList);

		List<Apartment> list = new ArrayList<Apartment>();
		AxisRPCClient axis = null;

		for (Provider p : providerList) {

			axis = new AxisRPCClient(p.getUrl());
			List<Apartment> listByProvider = axis.findApartmentList(p.getUsername(), criteria.getCriteria());

			if (listByProvider.size() > 0) {
				// Only add 1 because the Address is the same
				list.add(listByProvider.get(0));
			} else {
				log.warn("Provider " + p + " does not have apartment!");
			}

		}

		return list;
	}

	public List<Apartment> findApartmentList(String username, String zip) throws Exception {
		log.debug("findApartmentList username: " + username);

		Provider provider = (Provider) userService.findByUsername(username);
		AxisRPCClient axis = new AxisRPCClient(provider.getUrl());
		List<Apartment> listByProvider = axis.findApartmentList(provider.getUsername(), zip);

		return listByProvider;
	}

	@Override	
	public void rent(User user, String providerName, String aptNumber) throws Exception { 
		log.debug("rent username: " + providerName);
		Provider provider = (Provider) userService.findByUsername(providerName);
		AxisRPCClient axis = new AxisRPCClient( provider.getUrl() );
		
		Apartment apt = axis.rent(provider.getUsername(), aptNumber);
		Rent rent = new Rent();
		rent.setUser( user );
		
		rent.setApartment(apt);
		
		apt.setOwner(provider);
		apt.setAddress( provider.getApartmentComplex().getAddress() );
		
		userService.store( rent );
	}

}
