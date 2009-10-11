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
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Address address;
	
	


}
