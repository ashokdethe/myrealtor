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
import com.myrealtor.domain.beans.SearchCriteria;
import com.myrealtor.domain.beans.SearchResult;
import com.myrealtor.service.UserService;

@Service
public class ApartmentSearchServiceImpl implements ApartmentSearchService {
	
	@Resource (name = "googleGeoCodeService")
	GeoCodeService geoCode;
	
	
	@Resource(name = "userService")
	protected UserService userService;
	
	//Map<String, AxisRPCClient> clientMap = new Hashtable<String, AxisRPCClient>();

	
	protected final Log log = LogFactory.getLog(getClass());
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchResult search( SearchCriteria criteria ) throws Exception {
		//TODO need to combine result from readOnly and regular apartments
		SearchResult r = new SearchResult();
		
		List<Apartment> list = new ArrayList<Apartment>();
		
		try {
			list = findApartmentListReadOnly( criteria, null );
			geoCode.populateCoordinates( list );			
		} catch (Exception e) {
			log.error(e, e);			
		}
		
		
		List<Provider> providerList = userService.findAllProviders();
		log.debug("providerList: " + providerList);
		List<Apartment> aptlist = findApartmentList(providerList, criteria);
		list.addAll( aptlist );
		
		r.setApartmentList( list );
			
		return r;		
	}
	
	/**
	 * This method will access an external website
	 */
	protected List<Apartment> findApartmentListReadOnly(SearchCriteria criteria, List<Provider> providerList) throws Exception {
		log.debug( "findApartmentListReadOnly: " + criteria.getCriteria() );
		//TODO need to get providers from DB		
		ApartmentHTMLParser htmlParser = new ApartmentRatingsWebsiteParser();
		//List<Apartment> list = htmlParser.parse( new URL("http://www.apartmentratings.com/rate/SearchResults?action=post&query=78727&x=20&y=4") );
		List<Apartment> list = htmlParser.parse( new URL("http://www.apartmentratings.com/rate/SearchResults?action=post&x=20&y=4&query=" + criteria.getCriteria() ) );
		log.debug( "List<Apartment> list: " + list );
		return list;
	}
	
	protected List<Apartment> findApartmentList( List<Provider> providerList, SearchCriteria criteria) throws Exception {
		log.debug( "findApartmentList criteria: " + criteria.getCriteria() + " - providerList: " + providerList);
		
		List<Apartment> list = new ArrayList<Apartment>();
		AxisRPCClient axis = null;
		
		for (Provider p : providerList) {
			
			axis = new AxisRPCClient( p.getUrl() );
			List<Apartment> listByProvider = axis.findApartmentList(p.getUsername(), criteria.getCriteria());
			
			if (listByProvider.size() > 0) {
				//Only add 1  because the Address is the same
				list.add(  listByProvider.get(0) );				
			} else {
				log.warn("Provider " + p + " does not have apartment!");				
			}
						
		}
		
		return list;
	}
	
	public List<Apartment> findApartmentList( String username, String zip ) throws Exception {
		log.debug( "findApartmentList username: " + username);
		
		
		//Provider provider = (Provider) userService.findById(providerId, Provider.class);
		Provider provider = (Provider) userService.findByUsername(username);
		AxisRPCClient axis = new AxisRPCClient( provider.getUrl() );
		List<Apartment> listByProvider = axis.findApartmentList(provider.getUsername(), zip );
		
		return listByProvider;
		
	}
	
	

}
