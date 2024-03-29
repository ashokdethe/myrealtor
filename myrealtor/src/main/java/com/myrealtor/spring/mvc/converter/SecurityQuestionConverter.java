package com.myrealtor.spring.mvc.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.binding.convert.converters.StringToObject;

import com.myrealtor.domain.beans.SecurityQuestion;
import com.myrealtor.service.JpaBaseService;


public class SecurityQuestionConverter extends StringToObject {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	protected JpaBaseService baseService;

	public SecurityQuestionConverter(JpaBaseService obj) {
		super(SecurityQuestion.class);
		this.baseService = obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object toObject(String string, Class targetClass) throws Exception {
		SecurityQuestion securityQuestion = null;
		try {
			log.debug("toObject string: " + string + " - targetClass: " + targetClass);			
			securityQuestion = (SecurityQuestion) baseService.findById(Long.parseLong(string), SecurityQuestion.class);
			log.debug("securityQuestion: " + securityQuestion + " - securityQuestion.getName(): " + securityQuestion.getQuestion() );
		} catch (Exception e) {
			log.error(e, e);
		}
		return securityQuestion;
	}

	@Override
	protected String toString(Object object) throws Exception {
		log.debug("toString object: " + object);
		return ((SecurityQuestion) object).getQuestion() ;
	}

}
