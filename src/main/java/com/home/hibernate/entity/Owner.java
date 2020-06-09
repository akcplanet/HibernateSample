package com.home.hibernate.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author amit
 */
@Entity
public class Owner
{
   @Id
  // @GeneratedValue( strategy = GenerationType.AUTO )
   @GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
   private String               id;
   
   
   private String            name;
   
   @OneToMany( mappedBy = "owner" )
   private Collection<House> house = new ArrayList<House>();

   public String getId()
   {
      return id;
   }

   public void setId( String id )
   {
      this.id = id;
   }

   public Collection<House> getHouse()
   {
      return house;
   }

   public void setHouse( Collection<House> house )
   {
      this.house = house;
   }

   public String getName()
   {
      return name;
   }

   public void setName( String name )
   {
      this.name = name;
   }

   public Owner()
   {
      // TODO Auto-generated constructor stub
   }

   public Owner( String name )
   {
      this.name = name;
   }

}
