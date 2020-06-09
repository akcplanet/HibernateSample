package org.alexis.hibernate.mapping;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainExec {
	
	
	static Session session;
	static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}
	

	public static void main(String[] args) {
		try {
		buildSessionFactory().openSession();

		System.out.println("Starting Main");
		
		  session = sessionFactory.openSession();
	      session.beginTransaction();
	      
	      Company company= new Company("INFOSYS", "AGIPCSGST7");
	      Certy  certy = new Certy("CERTYTY", "CHECKALL");

	      company.setCertyct(certy);

	      
	      Phone  phone = new Phone("AirtEl", "9910432505");
	     
	   //   company.setPhonect(phone);
	    
	      
	      Address address= new  Address("Delhi", "N2ew Pune", "NO Country");
	      address.setCompany(company);
	     //  student.setAddressnew(new  Address("Del2hi", "New Pune", "NO Country"));
	   //    address.setStudent(student);
	      Student student = new Student("Tes2t2");
	       student.setAddressnew(address);
	       student.setPhonenew(phone);
	    
	    //  session.save(address);
	   //   session.save(phone);

	       Compra compra= new Compra("TESTCOmp1", "Test234Cpty");
	       
	       Certy  certy23 = new Certy("TEst34", "ATnew45");
	       Certy  certy24 =new Certy("TEst67", "ATnew342");
	       
	       Customer cust=new Customer("CustNAme","CustTAxt");
	       Customer cust23=new Customer("AmistNAme","JKSstTAxt");
	       compra.getLstDetalle().put(cust ,certy23);
	       
	       compra.getLstDetalle().put(cust23 ,certy24);
	       compra.getStrstr().put("STR1", "STRVal");
	       compra.getStrstr().put("STR2", "STRVal2");
	       
	      session.save(student);
	      session.save(certy23);
	      session.save(certy24);
	      session.save(cust);
	      session.save(cust23);
	      session.save(compra);
	      session.getTransaction().commit();
	      
	      session = sessionFactory.openSession();
	      
	      Query qry = session.createQuery("from Address p");

	      List l =qry.list();
	      System.out.println("Total Number Of Records : "+l.size());
	      Iterator it = l.iterator();


	}finally {
		if(session != null) {
		      session.close();
		      sessionFactory.close();
		}
	}
	}
}
