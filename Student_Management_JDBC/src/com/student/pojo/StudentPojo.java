package com.student.pojo;

public class StudentPojo {
	
	private int studentId;
	private String studentName;
	private int studentAge;
	
	public StudentPojo(int studentId, String studentName, int studentAge) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public StudentPojo(String studentName, int studentAge) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public StudentPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	
	
	
	
	

}
