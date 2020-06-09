package org.alexis.hibernate.mapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

import org.hibernate.annotations.GenericGenerator;

@Entity


/*
 * @SecondaryTables({
 * 
 * @SecondaryTable(name="EMPLOYEE_DETAILS", pkJoinColumns
 * = @PrimaryKeyJoinColumn(name = "id")),
 * 
 * @SecondaryTable(name="EMP_HIST", pkJoinColumns = @PrimaryKeyJoinColumn(name =
 * "hist_id", referencedColumnName = "id")) })
 */
 

public class Certy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	private String id;

	//@Column(table = "EMP_HIST")
	private String name;


	//@Column(table = "EMPLOYEE_DETAILS")
	private String certyDetails;

	public Certy(String name, String certyDetails) {
		super();
		this.name = name;
		this.certyDetails = certyDetails;
	}

	public Certy() {
		super();
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

	public String getCertyDetails() {
		return certyDetails;
	}

	public void setCertyDetails(String certyDetails) {
		this.certyDetails = certyDetails;
	}

}
