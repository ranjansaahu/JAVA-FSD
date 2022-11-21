package org.cgi.service;

import org.cgi.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public Student addStudent(Student student);
    public Student modifyStudent(Student student);
    public Student deleteStudent(Integer studentid);
    public List<Student> getAllStudents();
    public Student findById(Integer studentid);
}
