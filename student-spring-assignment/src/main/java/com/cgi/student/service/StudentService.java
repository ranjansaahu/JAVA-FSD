package com.cgi.student.service;

import java.util.ArrayList;
import java.util.List;

import com.cgi.student.model.Student;

public class StudentService {
	
	private List<Student> studentlist = new ArrayList<Student>();
	
	public Student addStudent(Student student) {
		try {
			studentlist.add(student);
		}catch(Exception e) {
			return null;
		}
		return student;
	}
	
	public Student modifyStudent(Student student) {
		
		for(int i=0;i<studentlist.size();i++) {
			if(studentlist.get(i).getRollno().equals(student.getRollno())) {
				studentlist.set(i, student);
				return student;
			}
		}
		return null;
	}
	
	public Student deleteStudent(Integer rollno) {
		
		for(int i=0;i<studentlist.size();i++) {
			if(studentlist.get(i).getRollno().equals(rollno)) {
				Student student = studentlist.get(i);
				studentlist.remove(i);
				return student;
			}
		}
		return null;
		
	}
	
	public Student findById(Integer rollno) {
		
		for(int i=0;i<studentlist.size();i++) {
			if(studentlist.get(i).getRollno().equals(rollno)) {
				Student student = studentlist.get(i);
				return student;
			}
		}
		return null;
	}
	
	public List<Student> findAll(){
		return studentlist;
	}

}
