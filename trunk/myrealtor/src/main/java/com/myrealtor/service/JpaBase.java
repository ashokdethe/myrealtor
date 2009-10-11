package com.myrealtor.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import com.myrealtor.domain.beans.BaseEntity;

public class JpaBase implements BaseService { 

	private static final long serialVersionUID = 1L; 
	protected final Log log = LogFactory.getLog(getClass());

	protected EntityManager em;
	
	

	@PersistenceContext
	public void setEntityManager(EntityManager mgr) {		
		this.em = mgr;
	}
	
	@Override	
	public BaseEntity load(Long id, Class<? extends BaseEntity> beanClass) {
		log.debug("load id: " + id + " - beanClass: " + beanClass);
		log.debug("em.getDelegate(): " + em.getDelegate());
		
		//FIXME Not working: Classcast exception!!!!
		return (BaseEntity) ((Session)em).load(beanClass, id);
		
	}
	
	@Override	
	public BaseEntity findById(Long id, Class<? extends BaseEntity> beanClass) {
		return em.find(beanClass, id);
	}	
	
	
	public void flush() {		
		em.flush();		
	}
	
	
	@SuppressWarnings("unchecked")
	public void initialize(Collection collection) {
		/*
		((Session)em).getIdentifier(null);
		HibernateProxyHelper.getClassWithoutInitializingProxy(null);
		*/
		
		
		Hibernate.initialize(collection); //Needs to use Hibernate. There is no similar approach for the EntityManager (JPA)		
	}	
	
	public void refresh(BaseEntity obj) {		
		em.refresh(obj);		
	}	
	
	@Transactional
	public BaseEntity merge(BaseEntity bean) {		
		return em.merge(bean);		
	}	
	
	public BaseEntity getReference(Long id, Class<? extends BaseEntity> beanClass) {		
		return em.getReference(beanClass, id);		
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List findAll(Class entityClass) {	
		List list = em.createQuery("select obj from " + entityClass.getSimpleName() + " obj").getResultList();		
		return list;	
	}	
	
	
	@Transactional
	public void delete(Long id, Class<? extends BaseEntity> entityClass) {
		BaseEntity obj = em.find(entityClass, id);
		if (obj != null) {
			log.info("Remove: " + obj);
			em.remove(obj);
		}
	}
	
	
	@Transactional
	public BaseEntity store(BaseEntity bean) {
		log.info("store: " + bean);
		BaseEntity merged = em.merge(bean);
		em.flush();
		return merged;
	}



}
