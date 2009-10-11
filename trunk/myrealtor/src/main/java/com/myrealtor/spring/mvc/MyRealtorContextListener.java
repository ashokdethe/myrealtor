/*******************************************************************************
**  Copyright (C) 2009 Lakeshore Data Management, Inc.  All rights reserved.
**  No part of this publication may be reproduced,
**  transcribed, translated or reduced to any electronic
**  medium without prior written consent of Lakeshore Data Management, Inc.,
**  Contact: info@lakeshoredata.com
**
** @author Edson Ricardo Amboni
**
**  Modifications:
**
** DATE                      WHO    DESCRIPTION
** -----------------------------------------------------------------------------
** 02/20/09                  RA     Original code
**
*******************************************************************************/


package com.myrealtor.spring.mvc;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myrealtor.domain.beans.BaseEntity;

public class MyRealtorContextListener implements ServletContextListener {
	
	protected final Log log = LogFactory.getLog(getClass());


	public void contextDestroyed(ServletContextEvent arg0) {		
		log.info("***********************************************************************");
		log.info("MyRealtor Destroyed Code Version: " + BaseEntity.CODE_VERSION);
		log.info("***********************************************************************");		
	}


	public void contextInitialized(ServletContextEvent arg0) {
		log.info("***********************************************************************");
		log.info("MyRealtor Initialized Code Version: " + BaseEntity.CODE_VERSION);
		log.info("***********************************************************************");			
	}
	
	
	

}