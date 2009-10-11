package com.myrealtor.domain.beans;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class Rent extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	protected Apartment apartment;
	
	@OneToOne
	protected User user;
	
	
	
	

}
