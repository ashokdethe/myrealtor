package com.myrealtor.spring.mvc; 

import javax.annotation.Resource; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.myrealtor.domain.beans.BaseEntity;
import com.myrealtor.domain.beans.User;
import com.myrealtor.service.UserService;


public class MyRealtorInterceptor extends HandlerInterceptorAdapter {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Resource(name="userService")
	protected UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.debug("Interceptor preHandle(): " + handler);
		
		
		request.getSession().setAttribute("version", BaseEntity.CODE_VERSION);
		
		try {
			//setupCustomer(request);
		} catch (Exception e) {			
			log.error(e, e);
		}
		
		return super.preHandle(request, response, handler);
	}

	protected void setupCustomer(HttpServletRequest request) {
		//User user = (User) request.getSession().getAttribute("currentUser");
		
		//if (user == null) {
			log.info("Setup attributes in the HttpSesion....");
			
			org.springframework.security.userdetails.User userdetails = (org.springframework.security.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			log.info("Trying to load user from DB " + userdetails.getUsername() + ".........");
			User user = userService.findByUsername(userdetails.getUsername());
			
			
			/*
			String varStr = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			log.info("Trying to load user from DB " + varStr + ".........");
			user = userService.findByFlyNumber( varStr );
			*/							
			
			request.getSession().setAttribute("currentUser", user);						
		/*
		} else {
			user = (User) userService.merge(user);
			userService.refresh(user);
			request.getSession().setAttribute("currentUser", user);
			
		}
		*/
	}
	
	

}
