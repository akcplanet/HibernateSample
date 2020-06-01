package com.home.hibernate.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author amit  //@Enumerated(value=EnumType.STRING)
 */
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToMany
	@JoinTable(name = "CAR_CAROWNER", joinColumns = @JoinColumn(name = "CAR_OWNER_ID"), inverseJoinColumns = @JoinColumn(name = "CAR_ID"))
	private Collection<CarOwner> owners = new ArrayList<>(); // mappedBy="owners"

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<CarOwner> getOwners() {
		return owners;
	}

	public void setOwners(Collection<CarOwner> owners) {
		this.owners = owners;
	}

	  @Column(name = "creation_date", updatable = false)
	  @CreationTimestamp
	  @Temporal( TemporalType.TIMESTAMP )
	  protected Date createdOn;


	  @Column(name = "last_updated")
	  @UpdateTimestamp
	  @Temporal( TemporalType.TIMESTAMP  )
	  
	  protected Date lastUpdatedOn;

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	} 
	  
	 

}
