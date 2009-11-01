package com.myrealtor.service.external;

import java.net.URL;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myrealtor.domain.beans.Apartment;

public abstract class ApartmentHTMLParser {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	public abstract List<Apartment> parse(URL url) throws Exception;

}
