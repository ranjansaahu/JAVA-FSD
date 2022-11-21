package org.cgi.repository;


import org.cgi.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {

    public Student addStudent(Student student);
    public Student modifyStudent(Student student);
    public Student deleteStudent(Integer studentid);
    public List<Student> findAll();
    public Student findById(Integer studentid);

}
