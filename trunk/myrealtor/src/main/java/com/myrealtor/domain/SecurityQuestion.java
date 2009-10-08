package com.myrealtor.domain;

import javax.persistence.Entity;


@Entity
public class SecurityQuestion extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	protected String question;
	
	

	public SecurityQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public SecurityQuestion(String question) {
		super();
		this.question = question;
	}



	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	

}
