package com.home.hibernate.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

/**
 * @author amit
 */
@Embeddable
public class Insurance
{
	

private String name;
   private String level;
   
         //@NaturalId(mutable = false)  can not with Emabaddbale only wth root class like person .java 
		@Column(name = "TEST_ID2")
          	private String testId;
	   
	
	
	public String getTestId() {
			return testId;
		}

   public Insurance()
   {
	   this.testId = UUID.randomUUID().toString();
   }

   public Insurance( String name, String level )
   {
      this.name = name;
      this.level = level;
      this.testId = UUID.randomUUID().toString();
   }

   public String getName()
   {
      return name;
   }

   public void setName( String name )
   {
      this.name = name;
   }

   public String getLevel()
   {
      return level;
   }

   public void setLevel( String level )
   {
      this.level = level;
   }

   @Override
   public String toString()
   {
      return "Company [name=" + name + ", level=" + level + "]";
   }

}
