package com.home.hibernate.entity.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.home.hibernate.entity.Address;
import com.home.hibernate.entity.FourWheeler;
import com.home.hibernate.entity.Person;
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
			testSingleTableStrategy();
			testTablePerClassStrategy();
			testTableJoinedStrategy();
		    sessionFactory.close();

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

}
