package com.home.hibernate.entity;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Source;
import org.hibernate.annotations.SourceType;

/**
 * @author amit
 */
@Entity
@Table(name = "PERSON")

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	// it will automatically Increase value
	
	
	@Version
	protected Integer version;
	
	

	
	
	//@Version
	//@Source(value = SourceType.DB)
	//private Date version;

	@NaturalId(mutable = false)
	@Column(name = "TEST_ID2")
	private String testId;

	public String getTestId() {
		return testId;
	}
// can not set this value for security
	/*
	 * public void setTestId(String testId) { this.testId = testId; }
	 */

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GenericGenerator(name = "uuid2", strategy = "uuid2")
	// @GeneratedValue(generator = "uuid2")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "JOINED_DATE")
	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET")),
			@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE")),
			@AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PINCODE"))

	})
	private Address officeAddress;

	@Embedded
	private Address homeAddress;

	@ElementCollection(fetch = FetchType.EAGER) // Uncomment the ( fetch = FetchType.EAGER ) for testing
												// testEagerLoading
	@JoinTable(name = "PERSON_INSURANCES", joinColumns = @JoinColumn(name = "PERSON_ID"))
	private Collection<Insurance> insurances = new ArrayList<Insurance>();

	@ElementCollection
	@MapKeyColumn(name = "name")
	@Column(name = "value")
	@CollectionTable(name = "test_Marks", joinColumns = @JoinColumn(name = "PERSON_ID"))
	@BatchSize(size = 20)
	private Map<String, String> testMarks = new HashMap<String, String>(); // maps from attribute name to value

	public Map<String, String> getTestMarks() {
		return testMarks;
	}

	public void setTestMarks(Map<String, String> testMarks) {
		this.testMarks = testMarks;
	}

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	//@MapKeyJoinColumn
	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="carMap_id")
//	@MapKeyColumn(name="id")
	private Map<Long, Manufacturer> carMap = new HashMap<Long, Manufacturer>();

	public Map<Long, Manufacturer> getCarMap() {
		return carMap;
	}

	public void setCarMap(Map<Long, Manufacturer> carMap) {
		this.carMap = carMap;
	}

	@OneToOne
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle vehicle;

	@OneToMany
	@JoinTable(name = "PERSON_PHONES", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "PHONE_ID"))
	private Collection<Phone> phones = new ArrayList<>();

	public Person() {

	}

	public Person(String firstName, String lastName, String email, Date joinedDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.joinedDate = joinedDate;
		this.testId = UUID.randomUUID().toString();

	}

	public Collection<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Collection<Insurance> getInsurances() {
		return insurances;
	}

	public void setInsurances(Collection<Insurance> insurance) {
		this.insurances = insurance;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", joinedDate="
				+ joinedDate + ", officeAddress=" + officeAddress + ", homeAddress=" + homeAddress + ", insurances="
				+ insurances + ", vehicle=" + vehicle + ", phones=" + phones + "]";
	}

}
