package com.myrealtor.domain.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;


@Entity
public class Apartment extends BaseEntity {
	
	public static final String STATUS_VACANT = "VACANT";
	public static final String STATUS_OCCUPIED = "OCCUPIED";

	private static final long serialVersionUID = 1L;
	
//	@ManyToOne(optional = false)
//	@JoinColumns( { @JoinColumn(name = "apartmentcomplex_id", referencedColumnName = "id") })	
//	protected ApartmentComplex apartmentComplex;
	
	@ManyToOne(optional = true)
	@JoinColumns( { @JoinColumn(name = "provider_id", referencedColumnName = "id") })	
	protected Provider owner;
	
	protected double pricePerMonth;
	
	protected String number;
	protected boolean readOnly = true;
	protected String status = STATUS_VACANT;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Address address;
	

	public Apartment() {	
	}
	
	public Apartment(String addressStr) {
		this.address = new Address(addressStr);
	}
	
	public Apartment(Provider provider, int i) {
		setAddress(provider.getApartmentComplex().getAddress());
		setOwner(provider);		
		setTempId(i);
		setNumber("10" + i);
		setPricePerMonth(provider.getApartmentComplex().getPricePerMonth() + (i * 35));
		setReadOnly( false );
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
	public double getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

//	public ApartmentComplex getApartmentComplex() {
//		return apartmentComplex;
//	}
//
//	public void setApartmentComplex(ApartmentComplex apartmentComplex) {
//		this.apartmentComplex = apartmentComplex;
//	}

	public Provider getOwner() {
		return owner;
	} 

	public void setOwner(Provider owner) {
		this.owner = owner;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	


}
