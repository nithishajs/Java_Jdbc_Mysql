package com.student.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnect {
	
static Connection con;
	
	public static Connection createcon() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			//create connection
			
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/JDBC_TEST";
			
			con= DriverManager.getConnection(url, user, password);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	

}
