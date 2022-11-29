package com.hibernate.createdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		//create a session
		Session session = factory.getCurrentSession();
		
		try{
			
			//use session to create and save a pojo
			//create student object
			System.out.println("create new student object");
			Student tempStu = new Student("Diggy","fuckhead","imcool@gmail.com");
			//start a transaction
			session.beginTransaction();
			//save student
			System.out.println("saving student");
			session.save(tempStu);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("student saved");
			//commit transaction
			
			
		}finally {
			factory.close();
		}
	}

}
