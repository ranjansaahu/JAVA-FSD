package org.cgi.service;

import org.cgi.model.Student;
import org.cgi.repository.StudentRepository;
import org.cgi.repository.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("studentService")
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

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
    public Student getStudent(Integer studentid) {
        return studentRepository.findById(studentid);
    }
}
