
package com.myrealtor.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.myrealtor.domain.beans.SecurityQuestion;
import com.myrealtor.domain.beans.User;

public interface UserService extends BaseService {

	@Transactional
	public User store(User user);
	
	public User findByUsername(String number);
	public List<SecurityQuestion> findAllSecurityQuestion();
	public User findBySecurityQuestion(String answer, String email, long securityQuestionId); 

}
