package com.jdbc.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBCDemo {
	
	public static void insertData() throws SQLException {
		
		final String url="jdbc:mysql://localhost:3306/JDBC_TEST";
		final String username="root";
		final String password="root";
		
		String sname = "Nithish";
		int sage=21;
		final String query="INSERT INTO students(sname,sage) VALUES(?,?);";
		
		Connection con = DriverManager.getConnection(url,username,password); //Establish the connection to mysql
		PreparedStatement pt = con.prepareStatement(query); // for insert update delete variable data 
		

		pt.setString(1, sname );// columntype(order,variabledata)
		pt.setInt(2, sage );
		
		int row = pt.executeUpdate();// result will integer for excute update
		System.out.println("Row gets affected---"+row);
		
	}
	
	public static void readData() throws SQLException {
		
		final String url="jdbc:mysql://localhost:3306/JDBC_TEST";
		final String username="root";
		final String password="root";
		
		
		final String query="SELECT * FROM students";
		
		Connection con = DriverManager.getConnection(url,username,password); //Establish the connection to mysql
		Statement pt = con.createStatement(); //for read all data in sql also use prepared statement
		ResultSet rs = pt.executeQuery(query); // result set for excute query 
		
		System.out.println("ID\tName\tAge");
		while(rs.next()) { // it will check all data in table
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) +"\t" + rs.getInt(3));
		}
		
	}
	
	public static void updateData() throws SQLException {
		
		final String url="jdbc:mysql://localhost:3306/JDBC_TEST";
		final String username="root";
		final String password="root";
		
		int id = 7;
		String sname = "Ram";
		
		final String query="UPDATE students SET sname=? WHERE sid=?";
		
		Connection con = DriverManager.getConnection(url,username,password);//Establish the connection to mysql
		PreparedStatement pt = con.prepareStatement(query);// for insert update delete variable data 
		
		pt.setString(1, sname );// columntype(order,variabledata)
		pt.setInt(2, id );
		
		
		int row = pt.executeUpdate();// result will integer for excute update
		System.out.println("Row gets updated---"+row);
		
	}
	
	public static void deleteData() throws SQLException {
		
		final String url="jdbc:mysql://localhost:3306/JDBC_TEST";
		final String username="root";
		final String password="root";

		int id=1;
		final String query="DELETE FROM students WHERE sid=?";
		
		Connection con = DriverManager.getConnection(url,username,password);//Establish the connection to mysql
		PreparedStatement pt = con.prepareStatement(query);// for insert update delete variable data 
	
		pt.setInt(1, id );// columntype(order,variabledata)
		
		int row = pt.executeUpdate();// result will integer for excute update
		System.out.println("Row gets deleted---"+row);
		
	}
	
	
	public static void storeProcedure() throws SQLException {
		
		final String url="jdbc:mysql://localhost:3306/JDBC_TEST";
		final String username="root";
		final String password="root";

		
		
		Connection con = DriverManager.getConnection(url,username,password);//Establish the connection to mysql
		CallableStatement pt = con.prepareCall("{call getList()}");// for store procedure use statement
	
		ResultSet rs = pt.executeQuery(); // result set for excute query 
		
		System.out.println("ID\tName\tAge");
		while(rs.next()) { // it will check all data in table
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) +"\t" + rs.getInt(3));
		}
		
	}
	
	
	public static void storeProcedureView() throws SQLException {
		
		final String url="jdbc:mysql://localhost:3306/JDBC_TEST";
		final String username="root";
		final String password="root";

		
		int id = 8 ;
		Connection con = DriverManager.getConnection(url,username,password);//Establish the connection to mysql
		CallableStatement pt = con.prepareCall("{call getView(?)}");// for store procedure use statement
		pt.setInt(1, id);
		ResultSet rs = pt.executeQuery(); // result set for excute query 
		
		System.out.println("ID\tName\tAge");
		while(rs.next()) { // it will check all data in table
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) +"\t" + rs.getInt(3));
		}
		
		con.close();
		
	}
	
	public static void storeProcedureName() throws SQLException {
		
		final String url="jdbc:mysql://localhost:3306/JDBC_TEST";
		final String username="root";
		final String password="root";

		
		int id = 2 ;
		Connection con = DriverManager.getConnection(url,username,password);//Establish the connection to mysql
		CallableStatement pt = con.prepareCall("{call getName(?,?)}");// for store procedure use statement
		pt.setInt(1, id);
		pt.registerOutParameter(2, Types.VARCHAR);
		pt.executeUpdate(); // result set for excute query 
		
		System.out.println(pt.getString(2));
		con.close();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			insertData();
//			updateData();
//			deleteData();
//			storeProcedure();
//			storeProcedureView();
//			storeProcedureName();
			
			readData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
