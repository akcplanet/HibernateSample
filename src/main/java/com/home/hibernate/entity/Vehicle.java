package com.home.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.DiscriminatorType;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;;

/**
 * @author amit
 */
@Entity
@Table(name = "VEHICLE")
@DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING) // only for single testSingleTableStrategy
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE) // testSingleTableStrategy test case																							// test case
 @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) //testTablePerClassStrategy test case
// @Inheritance(strategy=InheritanceType.JOINED) //testTableJoinedStrategy test case
public class Vehicle implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue( strategy = GenerationType.AUTO )
	// @SequenceGenerator(initialValue = 9999, name = "idgen", sequenceName =
	// "parentseq", allocationSize = 1)
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(name = "VEHICLE_ID")
	private String id;

	
	@Version protected Integer version;
	
	// @GeneratedValue( strategy = GenerationType.AUTO )
	// @SequenceGenerator(initialValue = 9999, name = "idgen", sequenceName =
	// "parentseq", allocationSize = 1)
	//@GenericGenerator(name = "uuid2", strategy = "uuid2")
	//@GeneratedValue(generator = "uuid2")
	//@Column(name = "VEHICLE_ID2")
//	private String id2;

	@Column(name = "VEHICLE_NAME")
	private String name;

	public Vehicle() {

	}

	public Vehicle(String name) {
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

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + "]";
	}

}
