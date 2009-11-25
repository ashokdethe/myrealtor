package com.myrealtor.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrealtor.domain.beans.Apartment;


@Service("apartmentService")
@Repository
public class JpaApartmentService extends JpaBaseServiceImpl implements ApartmentService {


	private static final long serialVersionUID = 1L;
	
	@Override
	@Transactional
	public void storeApartmentList(List<Apartment> list) {
		for (Apartment apt : list) {
			em.persist( apt );			
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Apartment> findCachedApartmentList(String criteria) {
		Query query = em.createQuery("select obj from Apartment obj where obj.address.zip = :zip and readOnly = 'true' ");
		query.setParameter("zip", criteria);
		return query.getResultList();
	}
	
	

}