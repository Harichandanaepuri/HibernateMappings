package com.project;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			Student s=new Student("Harichandana","Epuri","hari@gmail.com");
			session.beginTransaction();
			
			List<Student> students=(List<Student>) session.createQuery("from Student").list();
			for(Student s1:students)
			{
				System.out.println(s1.toString());
			}
			
			session.save(s);
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
