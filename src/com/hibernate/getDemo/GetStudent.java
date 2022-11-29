package com.hibernate.getDemo;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.Student;

public class GetStudent {

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
			
			//get all students from Student table
			//createQuery uses HQL a type of subset language that uses sql
			List<Student> stuList = session.createQuery("from Student").getResultList();
			for(Student stu: stuList) {
				System.out.println("\n" + stu);
			}
			
			//query for first_name Diggy
			List<Student> diggyStu = session.createQuery("from Student where first_name='Diggy'").getResultList();
			for(Student stu: diggyStu) {
				System.out.println("\n" + stu);
			}
			
			//for first_name Diggy or last_name Lessman
			List<Student> multiStu = session.createQuery("from Student where first_name='Diggy' OR last_name='Lessman'").getResultList();
			for(Student stu: multiStu) {
				System.out.println("\n" + stu);
			}
			
			
			
		}finally {
			factory.close();
		}

	}

}
