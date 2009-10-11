package com.myrealtor.domain.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ApartmentComplex extends BaseEntity {

	private static final long serialVersionUID = 1L;	
	
	protected String name;
	protected int numberUnits;
	
	
	@ManyToOne(optional = false)
	@JoinColumns( { @JoinColumn(name = "provider_id", referencedColumnName = "id") })	
	protected Provider owner;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "apartmentComplex")
	protected Set<Apartment> unitSet;

	
	
}
