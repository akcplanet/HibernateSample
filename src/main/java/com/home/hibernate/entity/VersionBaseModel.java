package com.home.hibernate.entity;

import javax.persistence.Version;


public abstract class VersionBaseModel<T> extends BaseModel<T> {
	
	@Version
	protected Integer version = Integer.valueOf(0);

	
	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}