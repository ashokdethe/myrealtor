package com.myrealtor.domain;

import javax.persistence.Entity;


@Entity
public class Address extends BaseEntity {

	private static final long serialVersionUID = 1L;

	protected String address1, address2, city, state, zip;	
	
	

}
