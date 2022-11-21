package org.cgi.repository;

import org.cgi.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository{

    private SessionFactory sessionFactory;

    public StudentRepositoryImpl(){
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public void closeConnection(){
        sessionFactory.close();
    }

    @Override
    public Student addStudent(Student student) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
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

        Student student = session.get(Student.class,studentid);

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
