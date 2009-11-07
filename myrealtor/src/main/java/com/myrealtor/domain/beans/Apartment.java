package com.myrealtor.domain.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;


@Entity
public class Apartment extends BaseEntity {
	
	public final String STATUS_VACANT = "VACANT";
	public final String STATUS_OCCUPIED = "OCCUPIED";

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional = false)
	@JoinColumns( { @JoinColumn(name = "apartmentcomplex_id", referencedColumnName = "id") })	
	protected ApartmentComplex apartmentComplex;
	
	@ManyToOne(optional = true)
	@JoinColumns( { @JoinColumn(name = "provider_id", referencedColumnName = "id") })	
	protected Provider owner;
	
	
	protected String number;
	protected boolean readOnly;
	protected String status = STATUS_VACANT;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Address address;
	

	public Apartment() {	
	}
	
	public Apartment(String addressStr) {
		this.address = new Address(addressStr);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	


}
