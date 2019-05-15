package com.project;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			//create
			Student s=new Student("xyz","j","yz@gmail.com");
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			
			//read
			session=factory.getCurrentSession();
			session.beginTransaction();
			Student student=session.get(Student.class, s.getId());
			System.out.println(student.toString());
			
			//read with condition
			List<Student> students=(List<Student>) session.createQuery("from Student where"
														+" last_name='epuri' ").getResultList();
			System.out.println(students);
		}
		finally
		{
			session.close();
			factory.close();
		}
	}

}
