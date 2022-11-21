package org.cgi;

import org.cgi.model.Student;
import org.cgi.repository.StudentRepository;
import org.cgi.repository.StudentRepositoryImpl;
import org.cgi.service.StudentService;
import org.cgi.service.StudentServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        Student student = null;
        int studentid = 0;
        Scanner scan = new Scanner(System.in);
        int ch;

        do {
            System.out.println("1->Add student  2->Modify  3->Delete   4->Search   5->Display all    6->Exit");
            ch = scan.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter student name and percentage");
                    student = new Student(scan.next(), scan.nextFloat());
                    studentService.addStudent(student);
                    break;
                case 2:
                    System.out.println("Enter the roll number to modify details: ");
                    student = studentService.findById(scan.nextInt());
                    System.out.println("Enter details: ");
                    student.setStudentname(scan.next());
                    student.setPercentage(scan.nextFloat());
                    // student = new Student(scan.next(),scan.nextFloat());
                    studentService.modifyStudent(student);
                    break;
                case 3:
                    System.out.println("Enter the roll number to delete details : ");
                    studentService.deleteStudent(scan.nextInt());
                    System.out.println("Details deleted : ");
                    break;
                case 4:
                    System.out.println("Enter the roll number: ");
                    student = studentService.findById(scan.nextInt());
                    System.out.println(student);
                    break;
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
