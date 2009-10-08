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
import org.springframework.web.context.request.WebRequest;

import com.myrealtor.domain.SecurityQuestion;
import com.myrealtor.domain.User;
import com.myrealtor.spring.mvc.editor.BaseEntityEditor;

@Controller 
public class UserController extends BaseController {
	

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
	public void recoverPasswordForm(Model model, WebRequest request) {
		log.trace("recoverPasswordForm");
		model.addAttribute("user", new User() );
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String recoverPasswordResult(@ModelAttribute User customerQuery, BindingResult result, Model model, WebRequest request) {
		String view = "user/recoverPasswordResult";
		try {
			log.trace("recoverPasswordResult customerQuery.getEmail(): " + customerQuery.getEmail() + " - customerQuery.getSecurityAnswer(): " + customerQuery.getSecurityAnswer() + " - customerQuery.getQuestion().getId(): " + customerQuery.getQuestion().getId()   );
			User user = userService.findBySecurityQuestion(customerQuery.getSecurityAnswer(), customerQuery.getEmail(), customerQuery.getQuestion().getId());
			model.addAttribute("user", user);
		} catch (Exception e) {
			log.error(e, e);
			result.rejectValue("email", "", "No match was found for your criteria! Please try again.");
			view = "user/recoverPasswordForm";
		}
		return view;
	}	
	
	


}
