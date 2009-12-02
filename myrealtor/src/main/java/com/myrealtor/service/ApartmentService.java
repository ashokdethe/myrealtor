
package com.myrealtor.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.myrealtor.domain.beans.Apartment;

public interface ApartmentService extends JpaBaseService {

	@Transactional
	public void storeApartmentList(List<Apartment> list);

	public List<Apartment> findCachedApartmentList(String criteria);
	public List<Apartment> findApartmentList(String username);
	

}
