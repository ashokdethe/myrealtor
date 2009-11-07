package com.myrealtor.domain.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;



@Entity
public class Provider extends User {

	public static final String PROVIDER_TYPE_PARSER = "TYPE_PARSER";
	public static final String PROVIDER_TYPE_WEBSERVICE = "TYPE_WEBSERVICE";
	
	private static final long serialVersionUID = 1L;
	
	protected String url;
	protected String htmlParserName;
	protected String providerType = PROVIDER_TYPE_WEBSERVICE;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
//	protected Set<ApartmentComplex> apartmentComplexSet;
	
	//@OneToOne(cascade = CascadeType.ALL, mappedBy = "owner")
	@OneToOne(cascade = CascadeType.ALL)
	protected ApartmentComplex apartmentComplex;

	public Provider() {
		role = ROLE_PROVIDER;	
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtmlParserName() {
		return htmlParserName;
	}

	public void setHtmlParserName(String htmlParserName) {
		this.htmlParserName = htmlParserName;
	}

	public String getProviderType() {
		return providerType;
	}

	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}

	public ApartmentComplex getApartmentComplex() {
		return apartmentComplex;
	}

	public void setApartmentComplex(ApartmentComplex apartmentComplex) {
		this.apartmentComplex = apartmentComplex;
	}
	
	
	

}
