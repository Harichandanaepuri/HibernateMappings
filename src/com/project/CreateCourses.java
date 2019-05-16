package com.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;

public class CreateCourses {

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
			Course c1=new Course("course1");
			Course c2=new Course("course2");
			inst.add(c1);
			inst.add(c2);
			session.save(c1);
			session.save(c2);
			session.getTransaction().commit();
			
		}
		finally
		{
			session.close();
			factory.close();
		}
		
	}

}
