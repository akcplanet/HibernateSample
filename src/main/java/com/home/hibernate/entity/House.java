package com.home.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author amit
 */
@Entity
public class House
{
   @Id
  // @GeneratedValue( strategy = GenerationType.AUTO )
   @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
   private String    id;
   
   
   private String name;
   @ManyToOne
   @JoinColumn( name = "OWNER_ID" )
   private Owner  owner; // mappedBy

   public String getId()
   {
      return id;
   }

   public void setId( String id )
   {
      this.id = id;
   }

   public Owner getOwner()
   {
      return owner;
   }

   public void setOwner( Owner owner )
   {
      this.owner = owner;
   }

   public String getName()
   {
      return name;
   }

   public void setName( String name )
   {
      this.name = name;
   }

   public House()
   {
      // TODO Auto-generated constructor stub
   }

   public House( String name )
   {
      this.name = name;
   }

}
