package com.dje.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dje.pojo.User;
import com.dje.util.HibernateUtil;

public class HibernateTest {
	Session session = null;
	Transaction tx = null;
	@Before
	public void setUp() {
		try {
			session = HibernateUtil.getSession();
			tx = session.getTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	@Test
	public void testSave() {
		
	try {
		tx.begin();		
		User u = new User("Ð¡ÁùÁù",55);		
		session.save(u);		
		tx.commit();
	} catch (Exception e) {
		e.printStackTrace();
		if (tx!=null)
			tx.rollback();
	}	 
	}
	@After
	public void tearDown() {
		HibernateUtil.close();  
	}	
}
