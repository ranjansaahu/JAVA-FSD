package org.cgi.service;

import org.cgi.model.Student;
import org.cgi.repository.StudentRepository;
import org.cgi.repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceImpl(){
        studentRepository = new StudentRepositoryImpl();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    @Override
    public Student modifyStudent(Student student) {
        return studentRepository.modifyStudent(student);
    }

    @Override
    public Student deleteStudent(Integer studentid) {
        return studentRepository.deleteStudent(studentid);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer studentid) {
        return studentRepository.findById(studentid);
    }
}
