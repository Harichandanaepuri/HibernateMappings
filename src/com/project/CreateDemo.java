package com.project;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Instructor;
import com.project.entity.InstructorDetail;
import com.project.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			Instructor inst=new Instructor("chandana","Epuri","chandana@gmail.com");
			InstructorDetail inst_detail=new InstructorDetail("youtube.com", "my website");
			inst.setInstructordetail(inst_detail);
			session.beginTransaction();
			session.save(inst);
			session.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}
	}

}
