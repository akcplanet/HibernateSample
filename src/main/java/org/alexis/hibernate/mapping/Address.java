package org.alexis.hibernate.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@PrimaryKeyJoinColumn
public class Address {

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	private String empid;

	private String City;

	private String street;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  //  @MapsId
//	@JoinColumn(name = "compAdd_id")
	private Company company;
	

	// @Transient
	private String country;

	@OneToOne(mappedBy = "addressnew", cascade = CascadeType.ALL)
	private Student student;

	public Address(String city, String street, String country) {
		super();
		City = city;
		this.street = street;
		this.country = country;
	}

	public Address() {
		super();
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
