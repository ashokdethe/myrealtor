package com.myrealtor.spring.mvc.controller;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.context.request.WebRequest;

import com.myrealtor.domain.beans.User;
import com.myrealtor.service.UserService;

public class BaseController {

	protected final Log log = LogFactory.getLog(getClass());

	protected static SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

	
	@Resource(name = "userService")
	protected UserService userService;

	protected void setupCustomer(WebRequest request) {
		org.springframework.security.userdetails.User userdetails = (org.springframework.security.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("Trying to load user from DB " + userdetails.getUsername() + ".........");
		User user = userService.findByUsername(userdetails.getUsername());
		request.setAttribute("currentUser", user, WebRequest.SCOPE_REQUEST);
	}

	public User getCurrentCustomer(WebRequest req) {
		setupCustomer(req);
		return (User) req.getAttribute("currentUser", WebRequest.SCOPE_REQUEST);
	}

}