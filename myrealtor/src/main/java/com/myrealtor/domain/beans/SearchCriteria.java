package com.myrealtor.domain.beans;


//@Entity
public class SearchCriteria extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String criteria;

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

}
