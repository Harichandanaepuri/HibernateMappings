package com.project;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			Student student=session.get(Student.class, 3);
			session.delete(student);
			session.getTransaction().commit();
			
			//another way to delete
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where first_name='chandana'").executeUpdate();
		
		
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
