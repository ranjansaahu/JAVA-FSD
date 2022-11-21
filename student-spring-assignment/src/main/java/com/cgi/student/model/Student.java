package com.cgi.student.model;

public class Student {
	
	private Integer rollno;
	private String name;
	private Float percentage;
	
	public Student() {
		super();
	}

	public Student(Integer rollno, String name, Float percentage) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.percentage = percentage;
	}

	public Integer getRollno() {
		return rollno;
	}

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + "]";
	}
	
	

}
