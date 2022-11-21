package org.cgi.repository;

import org.cgi.model.Student;
import org.cgi.model.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public void closeConnection(){
        sessionFactory.close();
    }

    @Override
    public Student addStudent(Student student) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(student.getAddress());

        for(Subject subject : student.getSubjects()){
            session.save(subject);
        }

        session.save(student);

        session.getTransaction().commit();

        return student;
    }

    @Override
    public Student modifyStudent(Student student) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();

        return student;
    }

    @Override
    public Student deleteStudent(Integer studentid) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student();
        session.delete(student);
        session.getTransaction().commit();

        return student;
    }

    @Override
    public List<Student> findAll() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Student> list = session.createQuery("from Student").list();

        return list;
    }

    @Override
    public Student findById(Integer studentid) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = session.get(Student.class,studentid);

        return student;
    }
}
