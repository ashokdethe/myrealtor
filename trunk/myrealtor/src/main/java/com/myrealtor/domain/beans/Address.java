package com.myrealtor.domain.beans;

import java.util.StringTokenizer;

import javax.persistence.Entity;


@Entity
public class Address extends BaseEntity {

	private static final long serialVersionUID = 1L;

	protected String address1, address2, city, state, zip;
	protected String latitude, longitude;
	

	public Address() {	
	}

	//6511 Melrose Trl # B, Austin, TX 78727
	public Address(String str) {
		StringTokenizer token = new StringTokenizer(str, ",");
		this.address1 = token.nextToken().trim();		
		this.city = token.nextToken().trim();
		String stateAndZip = token.nextToken().trim();		
		this.state = stateAndZip.split(" ")[0];
		this.zip = stateAndZip.split(" ")[1];
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String toString() {
    	return address1 + " " + city + " " + zip;    	
    }
	
	
	
	

}
