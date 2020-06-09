package com.home.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Manufacturer {
   

	@Id
//	@Column(name = "manufacturer_id")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    private String name;


    @ManyToOne
    private Person person;
    
    
	public Manufacturer() {
		super();
	}

	public Manufacturer(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
    
    
    
    
}

