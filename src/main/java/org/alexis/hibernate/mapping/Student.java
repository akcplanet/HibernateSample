package org.alexis.hibernate.mapping;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.GenericGenerator;


@Entity
//@PrimaryKeyJoinColumn(name = "empid")

public class Student implements Serializable {

	 private static final long serialVersionUID = 1L;
	
	
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	private String id;

	private String name;
	
	

//	@OrderBy("firstName asc")
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "nee_id")
	private Phone phonenew;

	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	//@JoinColumn(name = "address_id")
 //  @JoinColumn(name="ClassA_Id", referencedColumnName="id", nullable=true)

	@MapsId
	/*
	 * @JoinTable(name = "MY_JOIN_TABLE", joinColumns = {
	 * 
	 * @JoinColumn(name = "ENTITYA_FK", referencedColumnName = "id") },
	 * inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "ENTITYB_FK", referencedColumnName = "id", unique = true)
	 * } )
	 */
	//
	
	
	//@PrimaryKeyJoinColumn(name = "yee_id")
//	@MapsId("company_certyct_id")
//	@JoinColumn(name = "yee_id")
	private Address addressnew;
	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Phone getPhonenew() {
		return phonenew;
	}

	public void setPhonenew(Phone phonenew) {
		this.phonenew = phonenew;
	}

	public Address getAddressnew() {
		return addressnew;
	}

	public void setAddressnew(Address addressnew) {
		this.addressnew = addressnew;
	}



}
