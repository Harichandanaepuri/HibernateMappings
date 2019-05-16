package com.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Course;
import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;

public class CreateInstructor {

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
			Instructor inst=new Instructor("chandu","E","chandanaEpuri@gmail.com");
			InstructorDetail inst_detail=new InstructorDetail("yahoo.com", "gamer");
			inst.setInstructordetail(inst_detail);
			session.beginTransaction();
			session.save(inst);
			session.getTransaction().commit();
			
		}
		finally
		{
			session.close();
			factory.close();
		}
		
	}

}
