package com.project;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		try
		{
			Session session=factory.getCurrentSession();
			session.beginTransaction();
			Student s=session.get(Student.class, 1);
			s.setFirstName("new student");
			session.getTransaction().commit();
			
			
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='upd@gmail.com'").executeUpdate();
		
		
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}
	}

}
