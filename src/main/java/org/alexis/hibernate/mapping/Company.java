package org.alexis.hibernate.mapping;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
//@PrimaryKeyJoinColumn
@Table(
        name="COMPANY", 
        uniqueConstraints=
            @UniqueConstraint(columnNames={"pan"})
    )
public class Company implements Serializable {

	 private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	private String id;

	private String name;
	
	private String pan;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@MapsId
	private Certy certyct;
	
	public Certy getCertyct() {
		return certyct;
	}

	public void setCertyct(Certy certyct) {
		this.certyct = certyct;
	}

	public Company(String name, String pan) {
		super();
		this.name = name;
		this.pan = pan;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
