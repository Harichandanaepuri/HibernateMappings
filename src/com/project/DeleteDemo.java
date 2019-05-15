package com.project;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 1);
			session.delete(instructor);
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}
	}

}
