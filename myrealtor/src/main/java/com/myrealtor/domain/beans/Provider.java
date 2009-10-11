package com.myrealtor.domain.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity
public class Provider extends User {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	protected Set<ApartmentComplex> apartmentComplexSet;	
	

}
