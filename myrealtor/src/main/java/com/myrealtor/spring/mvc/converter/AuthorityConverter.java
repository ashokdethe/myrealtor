package com.myrealtor.spring.mvc.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.binding.convert.converters.StringToObject;

import com.myrealtor.domain.beans.Authority;

@Deprecated
public class AuthorityConverter extends StringToObject {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	

	public AuthorityConverter() {
		super(Authority.class);		
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object toObject(String string, Class targetClass) throws Exception {
		log.debug("toObject str: " + string + " - class: " + targetClass);
		Authority ret = new Authority();
		ret.setAuthority( string );
		return ret;
	}

	@Override
	protected String toString(Object object) throws Exception {
		log.debug("toString object: " + object);
		return ((Authority) object).getAuthority();
	}

}
