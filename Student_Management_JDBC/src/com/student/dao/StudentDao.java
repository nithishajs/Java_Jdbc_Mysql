package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.student.dbconnection.DbConnect;
import com.student.pojo.StudentPojo;

public class StudentDao {
	
	public static boolean insertData(StudentPojo sp) {
		
		boolean b = false;
		
		try {
			
			Connection con = DbConnect.createcon();
			final String query="INSERT INTO students(sname,sage) VALUES(?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, sp.getStudentName());
			ps.setInt(2, sp.getStudentAge());
			ps.executeUpdate();
			b=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
		
	}
	
	
	public static void listData() {
		
		try {
			
			Connection con = DbConnect.createcon();
			final String query="SELECT * FROM students";
			
			Statement pt = con.createStatement(); 
			ResultSet rs = pt.executeQuery(query); 
			
			System.out.println("ID\tName\tAge");
			while(rs.next()) { 
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) +"\t" + rs.getInt(3));
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static boolean viewData(int id) {
		
		boolean b = false;
		
		try {
			
			Connection con = DbConnect.createcon();
			final String query="SELECT * FROM students WHERE sid=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) { 
				
				System.out.println("Student ID: " + rs.getInt(1)  + " \nStudent Name: " + rs.getString(2) + " \nStudent Age: " +  rs.getInt(3));
			
			}
			b=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
		
	}
	
	public static boolean updatetData(int val,int id,String name,StudentPojo sp,int age) {
		
		boolean b = false;
		
		try {
			
			Connection con = DbConnect.createcon();
			if(val ==1) {
				
				final String query="UPDATE students SET sname=? WHERE sid=?";				
				PreparedStatement pt = con.prepareStatement(query);
				
				pt.setString(1, name );
				pt.setInt(2, id );
				pt.executeUpdate();
				b=true;
			}else {
				
				final String query="UPDATE students SET sage=? WHERE sid=?";				
				PreparedStatement pt = con.prepareStatement(query);
				
				pt.setInt(1, age );
				pt.setInt(2, id );
				pt.executeUpdate();
				b=true;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
		
	}

	public static boolean deleteData(int id) {
		
		boolean b = false;
		
		try {
			
			Connection con = DbConnect.createcon();
			final String query="DELETE FROM students WHERE sid=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			b=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
		
	}
}
