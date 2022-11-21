package org.cgi;

import org.cgi.config.HibernateConfig;
import org.cgi.config.SpringConfig;
import org.cgi.model.Address;
import org.cgi.model.Student;
import org.cgi.model.Subject;
import org.cgi.repository.StudentRepository;
import org.cgi.repository.StudentRepositoryImpl;
import org.cgi.service.StudentService;
import org.cgi.service.StudentServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class, HibernateConfig.class);

        StudentService studentService = context.getBean("studentService", StudentService.class);
        Student student = null;
        Address address = null;
        Scanner scan = new Scanner(System.in);
        int ch;

        do {
            System.out.println("1->Add student  2->Modify  3->Delete   4->Search   5->Display all    6->Exit");
            ch = scan.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter student name and percentage");
                    student = context.getBean("student", Student.class);
                    student.setStudentname(scan.next());
                    student.setPercentage(scan.nextFloat());

                    address = context.getBean("address", Address.class);
                    System.out.println("Enter address : ");
                    address.setAddressdetails(scan.next());

                    student.setAddress(address);

                    System.out.println("Enter number of subjects ");
                    int cnt = scan.nextInt();

                    for (int i = 0; i < cnt; i++) {
                        System.out.println("Enter subject name : ");
                        student.addSubject(new Subject(scan.next()));
                    }

                    studentService.addStudent(student);
                    break;
                case 3:
                    System.out.println("Enter student ID to delete :");
                    int studentid = scan.nextInt();
                    studentService.deleteStudent(studentid);
                case 5:
                    List<Student> list = studentService.getAllStudents();
                    list.forEach(System.out::println);
                    break;
                case 6:
                    break;
            }
        } while (ch != 6);
    }
}
