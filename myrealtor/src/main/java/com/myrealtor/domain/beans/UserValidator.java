package com.myrealtor.domain.beans;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.myrealtor.service.UserService;

@Component
public class UserValidator {
	
	@Resource(name = "userService")
	protected UserService userService;
	
	protected final Log log = LogFactory.getLog(getClass());

	public void validateUserForm(User user, Errors errors) {		
		validatePassword(user, errors);
		
		if (user.getLastName().length() < 2) {
			errors.rejectValue("lastName", "", "Last name needs to be greater than 1 character.");			
		}
		boolean isAlpha = true;
		for (int i = 0; i < user.getUsername().length(); i++) {
			if (! Character.isLetterOrDigit( user.getUsername().charAt( i ) )  ) {
				isAlpha = false;
				break;
			}
		}
		
		if ( ! isAlpha ) {
			log.error("Username can only have letter and/or digit: " + user.getUsername());
			errors.rejectValue("username", "", "Username can only have letter and/or digit.");
		}
		
		boolean validUserName = userService.isValidUserName( user.getUsername() );
		if (! validUserName) {
			log.error("Duplicate username: " + user.getUsername() );
			errors.rejectValue("username", "", "Username is not unique. Please choose another one.");			
		}
		
	}

	public static void validatePassword(User user, Errors errors) {
		if ( user.getPassword() == null || user.getConfirmPwd() == null ) {
			errors.rejectValue("password", "", "Password or Confirm Password cannot be null!");			
		} else if (! user.getPassword().equals(user.getConfirmPwd())) {			
			errors.rejectValue("password", "", "Password does not match!");			
		}
	}
	
	
}
