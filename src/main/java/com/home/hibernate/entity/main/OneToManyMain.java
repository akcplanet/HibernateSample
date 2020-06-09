package com.home.hibernate.entity.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.home.hibernate.entity.Address;
import com.home.hibernate.entity.FourWheeler;
import com.home.hibernate.entity.Insurance;
import com.home.hibernate.entity.Manufacturer;
import com.home.hibernate.entity.Person;
import com.home.hibernate.entity.Phone;
import com.home.hibernate.entity.TwoWheeler;
import com.home.hibernate.entity.Vehicle;

public class OneToManyMain {
	
	static Session session;
	static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration File
		Configuration configObj = new Configuration();
	//	configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, ServiceRegistry Is Being Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		// Creating Hibernate SessionFactory Instance
	//	sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}

	public static void main(String[] args) {
		    buildSessionFactory().openSession();

			System.out.println("Starting Main");
			
			//testSingleTableStrategy();
			//testTablePerClassStrategy();
			//testTableJoinedStrategy();
			testSaveOperation();
			//testEmbeddedObjectWithAttributeOverride();
		//	testElementCollection();
		    sessionFactory.close();

	}
	
	 public static void testSaveOperation()
	   {
	      System.out.println( "testSaveOperation begins ........ This is \"C\" of CRUD" );
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      
	      
	      
	      
	      Person person = new Person( "James", "Bond", "007@jamesbond.com", new java.util.Date() );
	      
	        Map<String,String> mapnew= new HashMap<String, String>();
	        mapnew.put("TestAmit",	 "Again TestFIles2");
	        mapnew.put("1TestAmit",	 "1Again TestFIles2");
	        mapnew.put("3TestAmit",	 "3Again TestFIles2");
	        
	      person.setTestMarks(mapnew);
	      
	      Manufacturer manufacturer = new Manufacturer("TEST_CAR_MAN");
	      
	      person.getCarMap().put(100L, manufacturer);
	      manufacturer.setPerson(person);
	      
	      Person person2 = new Person( "Forest", "Gump", "forestgump@jamesbond.com", new java.util.Date() );
	      
	      person2.getTestMarks().putAll(new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;
				{
					put("MArjAmit",	 "89Again TestFIles2");
					put("MaretyAmit",	 "ddAgain TestFIles2");
					put("LUkaAmit",	 "CCAgain TestFIles2");
				}
			});
	      Manufacturer manufacturer2 = new Manufacturer("TEST_2MAp_MAN");
	      person2.getCarMap().put(200L, manufacturer2);
	      manufacturer2.setPerson(person2);
	    
	      Person person3 = new Person( "Amit", "Kumar", "amitgump@jamesbond.com", new java.util.Date() );
	      
	      Insurance insurance = new Insurance( "ABC", "400" );
	      Insurance insurance1 = new Insurance( "XYZ", "500" );
	      person.getInsurances().add( insurance );
	      person.getInsurances().add( insurance1 );
	      
	      
	      Address addr1 = new Address( "Baker street", "Bangalore", "Karnataka", "560034" );
	      Address addr2 = new Address( "Walker street", "Chennai", "Tamil Nadu", "560021" );

	      person.setHomeAddress( addr1 );
	      person.setOfficeAddress( addr2 );
	      
	      Vehicle vehicle = new Vehicle( "Ferrari" );
	      person3.setVehicle( vehicle );
	    
	      TwoWheeler bike = new TwoWheeler();
	      bike.setSteeringHandle( "bike steering handle" );
	      bike.setName( "pulsar" );
	      person2.setVehicle( bike );
	      
	      FourWheeler car = new FourWheeler();
	      car.setName( "alto" );
	      car.setSteeringWheel( "car steering wheel" );
	      person.setVehicle( car );
	      
	      session.save( car );
	      session.save( bike );
	      session.save( vehicle );
	   //   session.save(manufacturer);
	      
	      Phone p = new Phone( "samsung" );
	      Phone p2 = new Phone( "Apple" );
	      person.getPhones().add( p );
	      person.getPhones().add( p2 );
	      
	      
	      session.save( person );
	      session.save( person2 );
	      session.save( person3 );
	      session.save( p );
	      session.save( p2 );
	      session.getTransaction().commit();
	      
	      session.beginTransaction();

	      Person pxt = session.get( Person.class, 1L );
	      pxt.setFirstName("Updated ANme");
	      session.save( person );
	      session.getTransaction().commit();
	      System.out.println( "Retrieved person from DB is " + pxt );
	      session.close();
	      
	      System.out.println( "testSaveOperation ends ......." );
	     

	   }
	  
	   public static void testSingleTableStrategy()
	   {
	      System.out.println( "testSingleTableStrategy begins. Uncomment @Inheritance(strategy=InheritanceType.SINGLE_TABLE) in Vehicle class" );
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();

	      Vehicle v = new Vehicle( "Ferrari" );
	      TwoWheeler bike = new TwoWheeler();
	      bike.setSteeringHandle( "bike steering handle" );
	      bike.setName( "pulsar" );

	      FourWheeler car = new FourWheeler();
	      car.setName( "alto" );
	      car.setSteeringWheel( "car steering wheel" );

	      session.save( car );
	      session.save( bike );
	      session.save( v );
	      session.getTransaction().commit();
	      session.close();
	      System.out.println( "testSingleTableStrategy ends ......." );

	   }

	 
	   public static void testTablePerClassStrategy()
	   {
	      System.out.println( "testTablePerClassStrategy begins. Uncomment @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) in Vehicle class " );
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();

	      Vehicle v = new Vehicle( "Ferrari" );
	      TwoWheeler bike = new TwoWheeler();
	      bike.setSteeringHandle( "bike steering handle" );
	      bike.setName( "pulsar" );

	      FourWheeler car = new FourWheeler();
	      car.setName( "alto" );
	      car.setSteeringWheel( "car steering wheel" );

	      session.save( car );
	      session.save( bike );
	      session.save( v );
	      session.getTransaction().commit();
	      session.close();
	      System.out.println( "testTablePerClassStrategy ends ......." );

	   }

	   
	   public static void testTableJoinedStrategy()
	   {
	      System.out.println( "testTableJoinedStrategy begins. Uncomment @Inheritance(strategy=InheritanceType.JOINED) in Vehicle class " );
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();

	      Vehicle v = new Vehicle( "Ferrari" );
	      TwoWheeler bike = new TwoWheeler();
	      bike.setSteeringHandle( "bike steering handle" );
	      bike.setName( "pulsar" );

	      FourWheeler car = new FourWheeler();
	      car.setName( "alto" );
	      car.setSteeringWheel( "car steering wheel" );

	      session.save( car );
	      session.save( bike );
	      session.save( v );
	      session.getTransaction().commit();
	      session.close();
	      System.out.println( "testTableJoinedStrategy ends ......." );

	   }

	   
	   public  static void testEmbeddedObjectWithAttributeOverride()
	   {
	      System.out.println( "testEmbeddedObjectWithAttributeOverride begins" );
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      Person person = new Person( "James", "Bond", "007@jamesbond.com", new java.util.Date() );

	      Address addr1 = new Address( "Baker street", "Bangalore", "Karnataka", "560034" );
	      Address addr2 = new Address( "Walker street", "Chennai", "Tamil Nadu", "560021" );

	      person.setHomeAddress( addr1 );
	      person.setOfficeAddress( addr2 );

	      session.save( person );
	      session.getTransaction().commit();
	      session.close();
	      System.out.println( "testEmbeddedObjectWithAttributeOverride ends ......." );

	   }
	   
	   public static void testElementCollection()
	   {
	      System.out.println( "testElementCollection begins" );
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      Person person = new Person( "James", "Bond", "007@jamesbond.com", new java.util.Date() );

	      Insurance insurance = new Insurance( "ABC", "400" );
	      Insurance insurance1 = new Insurance( "XYZ", "500" );
	      person.getInsurances().add( insurance );
	      person.getInsurances().add( insurance1 );

	      session.save( person );
	      session.getTransaction().commit();
	      session.close();
	      System.out.println( "testElementCollection ends ......." );

	   }
	   
	   
	   public static void testLazyLoading()
	   {
	      System.out.println( "testLazyLoading begins ......." );
	      testElementCollection();
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      Person p = session.get( Person.class, 1L );
	      session.getTransaction().commit();
	      session.close();
	      System.out.println( "Test case is passed if the LazyInitializationException occurs, if there is no expception next line will have the list of insurances" );
	      System.out.println( p.getInsurances() );
	      System.out.println( "testLazyLoading ends ......." );

	   }


	   public static void testEagerLoading()
	   {
	      System.out.println( "testEagerLoading begins ......Prequsite is change the fetch type to eager for insurances variable in Person class. @ElementCollection(fetch=FetchType.EAGER)" );
	      testElementCollection();
	      Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      Person p = session.get( Person.class, 1L );
	      session.getTransaction().commit();
	      session.close();
	      System.out.println( "Test case is passed if there is no LazyInitializationException occurs, if there is no expception next line will have the list of companies" );
	      System.out.println( p.getInsurances() );
	      System.out.println( "testEagerLoading ends ......." );

	   }

}
