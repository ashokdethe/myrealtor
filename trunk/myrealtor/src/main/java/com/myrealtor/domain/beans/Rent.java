package com.myrealtor.domain.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="rent")
public class Rent extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	protected Apartment apartment;
	
	@OneToOne
	protected User user;

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	

}
