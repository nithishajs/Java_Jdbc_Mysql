package com.student.Main;
import java.util.*;
import com.student.dao.*;
import com.student.pojo.*;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name :");
		String userName = sc.next();
		
		System.out.println("Welcome To Student Management App : "+userName);
		
		int userChoice;
		
		do {
			
			System.out.println("*********Student Mangement App*********");
			System.out.println("Press 1: Add Student");
			System.out.println("Press 2: List Student");
			System.out.println("Press 3: View Student");
			System.out.println("Press 4: Update Student");
			System.out.println("Press 5: Delete Student");
			System.out.println("Press 6: EXIT App");
			
			System.out.println("Press your Choice :");
			userChoice=sc.nextInt();
			sc.nextLine();
			
			switch(userChoice) {
			
			case 1:
				
				System.out.println("Enter Student Name :");
				String name = sc.next();
				
				System.out.println("Enter Student Age :");
				int age = sc.nextInt();
				
				StudentPojo sd = new StudentPojo(name, age);
				
				boolean b = StudentDao.insertData(sd);
				
				if(b) {
					
					System.out.println("Student record inserted Succssfully..");
	                System.out.println("Student Record:"+sd);
					
				}else {
					
					System.out.println("Student error occured while inserting...please try Again");
				}
			break;
			
			
			case 2:
				StudentDao.listData();
			break;
			
			
			case 3:
				
				System.out.println("Enter Student id :");
				int id = sc.nextInt();
				
				StudentDao.viewData(id);
			break;
			
			
			case 4:
				
				System.out.println("Press 1 to update name");
				System.out.println("Press 2 to update age");
				
				int val = sc.nextInt();
				
				if(val==1) {
					System.out.println("Enter student name to update");
					String name1 = sc.next();
					
					System.out.println("Enter ID to identify Student");
					int id1 = sc.nextInt();
					
					StudentPojo sp = new StudentPojo();
					sp.setStudentName(name1);
					int age1 = sp.getStudentAge();
					
					boolean b1 = StudentDao.updatetData(val,id1,name1,sp,age1);
					
				    if(b1) {
				    	
				    	System.out.println("Student name Updated Successfully...");
				    }else {
				    	System.out.println("Something Went Wrong Please try Again!");
				  }
					
				}else if(val==2) {
					System.out.println("Enter student age to update");
					int age1 = sc.nextInt();
					
					System.out.println("Enter ID to identify Student");
					int id1 = sc.nextInt();
					
					StudentPojo sp = new StudentPojo();
					sp.setStudentAge(age1);
					String name1 = sp.getStudentName();
					
					boolean b1 = StudentDao.updatetData(val,id1,name1,sp,age1);
					
				    if(b1) {
				    	
				    	System.out.println("Student age Updated Successfully...");
				    }else {
				    	System.out.println("Something Went Wrong Please try Again!");
				  }
				}
				
			break;
			
			
			case 5:
				
				System.out.println("Enter Student id to delete :");
				int sid = sc.nextInt();
				
				boolean d =StudentDao.deleteData(sid);
				
				 if(d) {
					  System.out.println("Student Of ID " + sid + " Record Deleted... ");
				  }else {
					  System.out.println("Something Went Wrong.. Please try Again!");
				  }
				
			break;
			
			
			case 6:
				
				System.out.println("Thank You For Using Application...If You Enjoyed, Please Experience It Again! " + userName);
			break;
		
			
			default:
				System.out.println("Invalid input please press correct input!");
			
			}
			
		}while(userChoice!=6);

	}

}
