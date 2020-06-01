package com.home.hibernate.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author amit
 */
@Entity
@DiscriminatorValue( "CAR" )
@AttributeOverrides({  
    @AttributeOverride(name="id", column=@Column(name="CAR_ID")),  
    @AttributeOverride(name="name", column=@Column(name="CAR_name"))  
})  
public class FourWheeler extends Vehicle
{
   private String steeringWheel;

   public String getSteeringWheel()
   {
      return steeringWheel;
   }

   public void setSteeringWheel( String steeringWheel )
   {
      this.steeringWheel = steeringWheel;
   }

}
