package com.myrealtor.domain.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "Authorities")
@Entity
public class Authority extends BaseEntity {
	
	public static final String ROLE_USER = "ROLE_USER";

	private static final long serialVersionUID = 1L;

	protected String username, authority;
	
	

	/**
	 * 
	 */
	public Authority() {
		authority = ROLE_USER;
	}

	/**
	 * @param username
	 * @param authority
	 */
	public Authority(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
