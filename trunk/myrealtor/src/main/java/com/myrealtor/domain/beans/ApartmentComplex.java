package com.myrealtor.domain.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.validation.Errors;

@Entity
public class ApartmentComplex extends BaseEntity {

	public static final int MAX_NUMBER_UNITS = 30;

	private static final long serialVersionUID = 1L;	
	
	protected String name;
	protected int numberUnits = 1;
	protected double pricePerMonth;
	
	
//	@ManyToOne(optional = false)
//	@JoinColumns( { @JoinColumn(name = "provider_id", referencedColumnName = "id") })	
//	protected Provider owner;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Address address = new Address();
	

	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "apartmentComplex")
//	protected Set<Apartment> unitSet;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberUnits() {
		return numberUnits;
	}

	public void setNumberUnits(int numberUnits) {
		this.numberUnits = numberUnits;
	}

	public double getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

//	public Provider getOwner() {
//		return owner;
//	}
//
//	public void setOwner(Provider owner) {
//		this.owner = owner;
//	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/*
	public Set<Apartment> getUnitSet() {
		return unitSet;
	}

	public void setUnitSet(Set<Apartment> unitSet) {
		this.unitSet = unitSet;
	}
	*/
		
	public void validateApartmentComplexForm(Errors errors) {		
		 		
		if (numberUnits > MAX_NUMBER_UNITS) {
			errors.rejectValue("numberUnits", "", "Max numberUnits is " + MAX_NUMBER_UNITS + "!");			
		}		
		
		if (numberUnits <= 0) {
			errors.rejectValue("numberUnits", "", "Invalid numberUnits!");			
		}
		
	}
	
	
}
