package com.home.hibernate.entity;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CarTest {

	@Id
	@Column(name = "ID")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	private String name;
	
//	@Enumerated(EnumType.STRING)
  //  @Column(length = 10)
 //   private Gender gender;

 //   @Temporal(TemporalType.DATE)
  //  @Column(name = "dob")
  //  private Date dateOfBirth;
	
	
	public CarTest(String name) {
		super();
		this.name = name;
	}

	
	public CarTest() {
		super();

	}
	
	

//	@ManyToOne
//	@JoinTable(name = "PERSON_CARTEST", joinColumns = @JoinColumn(name = "ID"), inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
	private Person person;

//	@ManyToOne
//	@JoinColumn(name = "manufacturer_id")
//	@JoinTable(name = "MAN_CARTEST", joinColumns = @JoinColumn(name = "ID"), inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
	private Manufacturer manufacturer;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}