package com.myrealtor.spring.mvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.convert.converters.StringToDate;
import org.springframework.binding.convert.service.DefaultConversionService;
import org.springframework.stereotype.Service;

import com.myrealtor.service.UserService;

@Service("customConversionService")
public class ConversionService extends DefaultConversionService {
	
	
	protected UserService baseService; 
	
	
	public UserService getBaseService() {		
		return baseService;
	}


	public void setBaseService(UserService baseService) {
		this.baseService = baseService;
	}
	
	

	@Autowired
	public ConversionService(UserService baseService) {	
		super();
		this.baseService = baseService;
		addCustomConverters(); 
	}


	
    protected void addCustomConverters() {     
       //addConverter("authorityConverter", new AuthorityConverter() );
       addConverter("securityQuestionConverter", new SecurityQuestionConverter(baseService) );
       

       // registers a custom converter reference-able by id and applied when requested
       StringToDate stringToDate = new StringToDate();
       stringToDate.setPattern("MM-dd-yyyy");
       addConverter("shortDate", stringToDate);
    }


	

}