package com.hibernate.createdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			
			//use session to create and save a pojo
			//create 3 student objects
			System.out.println("creating 3 neww student objects.....");
			Student tempStu1 = new Student("Dan","Clan","sclan@gmail.com");
			Student tempStu2 = new Student("Marge","Lessman","imcool@gmail.com");
			Student tempStu3 = new Student("Sebi","Kanczugowski","sebi@gmail.com");
			//start a transaction
			session.beginTransaction();
			//save student
			System.out.println("saving students.......");
			session.save(tempStu1);
			session.save(tempStu2);
			session.save(tempStu3);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("student saved!");
			//commit transaction
			
			
		}finally {
			
			factory.close();
			
		}

	}

}
