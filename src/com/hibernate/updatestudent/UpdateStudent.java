package com.hibernate.updatestudent;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			//need to start transactions
			session.beginTransaction();
			
			//get student by id
			Student stuQ = session.get(Student.class, 3 );
			System.out.println(stuQ);
			
			stuQ.setFirstName("Belzebub");
			
			
			session.createQuery("update Student set email='dk@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			
			
		}finally {
			factory.close();
		}

	}

}