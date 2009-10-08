
package com.myrealtor.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.myrealtor.domain.BaseEntity;

public interface BaseService extends Serializable {

	public BaseEntity merge(BaseEntity bean);

	public void delete(Long id, Class<? extends BaseEntity> entityClass);
	public BaseEntity findById(Long id, Class<? extends BaseEntity> beanClass);
	public BaseEntity load(Long id, Class<? extends BaseEntity> beanClass);

	public BaseEntity store(BaseEntity bean);
	
	public void flush();
	public void refresh(BaseEntity obj);
	public BaseEntity getReference(Long id, Class<? extends BaseEntity> beanClass);
	
	@SuppressWarnings("unchecked")
	public void initialize(Collection collection);
	
	@SuppressWarnings("unchecked")
	public List findAll(Class entityClass);


}