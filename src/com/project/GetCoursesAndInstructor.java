package com.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;

public class GetCoursesAndInstructor {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();	
			Instructor inst=session.get(Instructor.class,1);
			
			System.out.println(inst.getCourses());
			session.getTransaction().commit();
			
		}
		finally
		{
			session.close();
			factory.close();
		}
		
	}

}
