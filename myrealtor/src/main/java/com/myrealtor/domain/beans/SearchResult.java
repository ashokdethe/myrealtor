package com.myrealtor.domain.beans;

import java.util.List;

import javax.persistence.OneToMany;

//@Entity
public class SearchResult extends BaseEntity {
	
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany
	List<Apartment> apartmentList;

	public List<Apartment> getApartmentList() {
		return apartmentList;
	}

	public void setApartmentList(List<Apartment> apartmentList) {
		this.apartmentList = apartmentList;
	}
	
	

}
