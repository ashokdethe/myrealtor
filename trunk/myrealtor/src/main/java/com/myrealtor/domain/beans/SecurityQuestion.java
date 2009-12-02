package com.myrealtor.domain.beans;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="securityquestion")
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
