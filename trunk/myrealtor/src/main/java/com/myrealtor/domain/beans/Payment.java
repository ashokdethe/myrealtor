package com.myrealtor.domain.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String authorizationCode;
	protected double amount;
	

}
