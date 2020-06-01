package com.home.hibernate.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public  class AbstractBaseModel<T> {
	protected T primaryKey;
}