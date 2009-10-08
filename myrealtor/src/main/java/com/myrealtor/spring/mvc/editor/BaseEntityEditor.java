package com.myrealtor.spring.mvc.editor;

import java.beans.PropertyEditorSupport;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.myrealtor.domain.BaseEntity;


public class BaseEntityEditor extends PropertyEditorSupport {

	Map<Long, BaseEntity> map;	
	
	public BaseEntityEditor() {
		super();	
	}

	public BaseEntityEditor(List<? extends BaseEntity> list) {
		initMap(list);
	}

	protected void initMap(List<? extends BaseEntity> list) {
		this.map = new Hashtable<Long, BaseEntity>();
		for (BaseEntity obj : list) {
			if (! obj.getNew()) {
				map.put(obj.getId(), obj);				
			}			
		}
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long key = Long.parseLong(text);
		BaseEntity o = map.get(key);
		super.setValue(o);
	}

}
