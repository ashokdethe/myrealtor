package com.myrealtor.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller 
public class ExceptionController extends BaseController {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public void accessDenied(Model model, WebRequest request) {		
//		User userDetail = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.warn("accessDenied: " + request.getParameterMap());
//		model.addAttribute(userDetail);
		
	}
	
	


}
