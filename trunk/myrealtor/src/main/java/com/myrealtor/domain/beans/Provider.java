package com.myrealtor.domain.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;



@Entity
public class Provider extends User {
	
	public static final String DEFAULT_URL = "http://127.0.0.1:8080/apartment_management_webservice/services/webservice";

	public static final String PROVIDER_TYPE_PARSER = "TYPE_PARSER";
	public static final String PROVIDER_TYPE_WEBSERVICE = "TYPE_WEBSERVICE";
	
	private static final long serialVersionUID = 1L;
	
	protected String url = DEFAULT_URL;
	protected String htmlParserName;
	protected String providerType = PROVIDER_TYPE_WEBSERVICE;
	

	@OneToOne(cascade = CascadeType.ALL)
	protected ApartmentComplex apartmentComplex = new ApartmentComplex(); 

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
