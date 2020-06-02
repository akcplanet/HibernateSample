package com.home.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LazyInitializationException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.home.hibernate.entity.Address;
import com.home.hibernate.entity.Car;
import com.home.hibernate.entity.CarOwner;
import com.home.hibernate.entity.FourWheeler;
import com.home.hibernate.entity.House;
import com.home.hibernate.entity.Insurance;
import com.home.hibernate.entity.Owner;
import com.home.hibernate.entity.Person;
import com.home.hibernate.entity.Phone;
import com.home.hibernate.entity.TwoWheeler;
import com.home.hibernate.entity.Vehicle;

/**
 * @author amit
 */
@Ignore
public class TestAmit	
{
   private static SessionFactory sessionFactory = null;

   @BeforeClass
   public static void setUp() throws Exception
   {
      sessionFactory = new Configuration().configure().buildSessionFactory();

   }

   @AfterClass
   public static void tearDown() throws Exception
   {
      sessionFactory.close();
   }



   @Test
   public void testRetriveOnePerson()
   {
      System.out.println( "testRetriveOnePerson begins .......This is \"R\" of CRUD" );

      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Person p = session.get(Person.class, 16L);
      Person p2 = session.get(Person.class, 19L);

      System.out.println( "Retrieved person from DB is " + p );
      Query query = session.getNamedQuery( "Phone.byId" );
      query.setInteger( "id", 5 );
      List<Phone> list = (List<Phone>) query.list();
      System.out.println( "Size of list is " + list.size() );
    
      assertEquals( 16L, p.getId() );
      System.out.println( "testRetriveOnePerson ends ......." );

   }

}
