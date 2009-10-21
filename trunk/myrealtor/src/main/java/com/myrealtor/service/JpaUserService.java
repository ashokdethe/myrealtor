package com.myrealtor.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrealtor.domain.beans.Provider;
import com.myrealtor.domain.beans.SecurityQuestion;
import com.myrealtor.domain.beans.User;


@Service("userService")
@Repository
public class JpaUserService extends JpaBase implements UserService {

	
	private static final long serialVersionUID = 1L;
	
	public User findByUsername(String number) {
		Query query = em.createQuery("select obj from User obj where obj.flyNumber = :number ");
		query.setParameter("number", number);
		User ret = (User) query.getSingleResult();		
		return ret;		
	}
	
	public User findBySecurityQuestion(String answer, String email, long securityQuestionId) { 
		Query query = em.createQuery("select obj from User obj where obj.question.id = :securityQuestionId and lower(obj.securityAnswer) = :answer and obj.email = :email");
		query.setParameter("answer", answer.toLowerCase());
		query.setParameter("email", email);
		query.setParameter("securityQuestionId", securityQuestionId);
		User ret = (User) query.getSingleResult();		
		return ret;		
	}	
	

	@Transactional
	public User store(User user) {
		//user.getAuthority().setUsername( user.getUsername() );
		em.persist(user);
		return user;
	}	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SecurityQuestion> findAllSecurityQuestion() {
		List<SecurityQuestion> list = em.createQuery("select obj from SecurityQuestion obj order by obj.question").getResultList();		
		return list;	
	}

	@Override
	public List<Provider> findAllProviders() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}