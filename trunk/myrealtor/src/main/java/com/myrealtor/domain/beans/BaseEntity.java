package com.myrealtor.domain.beans;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@MappedSuperclass
public class BaseEntity implements Serializable {
	
	public static final String CODE_VERSION = "0.0.9";
	
	@Transient
	protected final Log log = LogFactory.getLog(getClass());

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Version
	private Long version;
	
	//Date does not work with Axis2 (Axiom)
//	@Temporal(value=TemporalType.TIMESTAMP)
//	private Date creationDate = new Date();
//	
//	public Date getCreationDate() {
//		return creationDate;
//	}
//		
//
//	public void setCreationDate(Date creationDate) {
//		this.creationDate = creationDate;
//	}

	@Transient
	protected int tempId;
	
	
	public int getTempId() {
		return tempId;
	}

	public void setTempId(int tempId) {
		this.tempId = tempId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	

	public Long getVersion() {
		return version;
	}

	/**
	 * Indicates if this object was already stored in the DB or it's new
	 * 
	 * @return
	 */
	@Transient
	public boolean getNew() {
		return id == null;
	}


	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " - id: " + id + " - version: " + version;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;				
		int varId = (id == null) ? 0 : id.intValue();		
		result = prime * result + (int) (varId ^ (varId >>> 32));		
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final BaseEntity other = (BaseEntity) obj;	
		if (id != other.id)
			return false;
		if (tempId != other.tempId) 
			return false;
		return true;
	}
	
	
}
