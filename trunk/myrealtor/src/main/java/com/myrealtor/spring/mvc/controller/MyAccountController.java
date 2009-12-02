package com.myrealtor.spring.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.domain.beans.SecurityQuestion;
import com.myrealtor.domain.beans.User;
import com.myrealtor.domain.beans.UserValidator;
import com.myrealtor.spring.mvc.editor.BaseEntityEditor;

@SessionAttributes("user")
@Controller 
public class MyAccountController extends BaseController {
	

    @SuppressWarnings("unchecked")
	@InitBinder
    public void initBinder(WebDataBinder dataBinder, WebRequest request) {    	
    	List<SecurityQuestion> list = (List<SecurityQuestion>) request.getAttribute("securityQuestionList", WebRequest.SCOPE_REQUEST);
        dataBinder.registerCustomEditor(SecurityQuestion.class, new BaseEntityEditor( list ) );
    }
    
    
	@ModelAttribute("securityQuestionList")
	protected List<SecurityQuestion> setupSecurityQuestionList(WebRequest request) {
		List<SecurityQuestion> list = userService.findAllSecurityQuestion();		
		request.setAttribute("securityQuestionList", list, WebRequest.SCOPE_REQUEST);
		return list;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void index(Model model, WebRequest request) throws Exception {
		log.debug("index");		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void update(Model model, WebRequest request) throws Exception {
		log.debug("update");
		User user = userService.findByUsername( request.getUserPrincipal().getName() );
		
		model.addAttribute("user", user );
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void list(Model model, WebRequest request) throws Exception {
		log.debug("list ...");
		
		List<Apartment> list = apartmentService.findApartmentList( request.getUserPrincipal().getName() );
				
		model.addAttribute( "apartmentList", list );				
	}

	
	
	@RequestMapping(method = RequestMethod.POST)
	public String update(@ModelAttribute User user, BindingResult result, Model model, WebRequest request, SessionStatus status) throws Exception {
		log.debug("update user: " + user);
		
		String view = "myaccount/index";
		UserValidator.validatePassword(user, result);
		if ( result.hasErrors() ) {
			log.error( "Error validating user ..." );
			view = "myaccount/update";
		} else {
			log.info( "Storing user ..." );
			userService.store(user);		
			status.setComplete();
		}
		
		return view;		
	}

    
	


}
