package com.myrealtor.domain.beans;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "Authorities")
@Entity
public class Authority extends BaseEntity {
	
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_PROVIDER = "ROLE_PROVIDER";

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
	public Authority(String username) {		
		this.username = username;		
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
	
	@Transient
	public String[] getAuthorityArray() {
		return new String[] {ROLE_USER, ROLE_PROVIDER};
	}

}
