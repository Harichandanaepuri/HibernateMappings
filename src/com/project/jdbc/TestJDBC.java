package com.project.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {

		String jdbc_url="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String password="hbstudent";
		try {
			System.out.println("connecting to database"+jdbc_url);
			Connection conn=DriverManager.getConnection(jdbc_url,user,password);
			System.out.println("connection succesful");
			
		}
		catch(Exception e)
		{
			
		}
	}

}
