package com.myrealtor.domain.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;


@Entity
public class Apartment extends BaseEntity { 

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional = false)
	@JoinColumns( { @JoinColumn(name = "apartmentcomplex_id", referencedColumnName = "id") })	
	protected ApartmentComplex apartmentComplex;
	
	@ManyToOne(optional = true)
	@JoinColumns( { @JoinColumn(name = "provider_id", referencedColumnName = "id") })	
	protected Provider owner;
	
	
	protected String number;
	protected boolean readOnly;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	


}
