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
@DiscriminatorValue( "BIKE" )
@AttributeOverrides({  
    @AttributeOverride(name="id", column=@Column(name="BIke_ID")),  
    @AttributeOverride(name="name", column=@Column(name="Bike_name"))  
})  
public class TwoWheeler extends Vehicle
{
   private String steeringHandle;

   public String getSteeringHandle()
   {
      return steeringHandle;
   }

   public void setSteeringHandle( String steeringHandle )
   {
      this.steeringHandle = steeringHandle;
   }

}
