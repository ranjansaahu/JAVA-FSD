package com.cgi.student;

import java.util.List;
import java.util.Scanner;

import com.cgi.student.model.Student;
import com.cgi.student.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("springconfiguration.xml");
        
        StudentService service = context.getBean("studentservice",StudentService.class);
        int ch;
        Scanner scan = new Scanner(System.in);
        Student student=null;
        
        do {
        	System.out.println("1->Add 2->Search  3->Modify  4->Delete  5->Dispaly all 6->Exit");
        	ch = scan.nextInt();
        	switch(ch) {
        	case 1: System.out.println("Enter student details : ");
        	        student = context.getBean("student",Student.class);
        	        student.setRollno(scan.nextInt());
        	        student.setName(scan.next());
        	        student.setPercentage(scan.nextFloat());
        	        service.addStudent(student);
        	        break;
        	case 2: System.out.println("Enter the roll number: ");
	                student = service.findById(scan.nextInt());
	                System.out.println(student);
	                break;
        	case 3: System.out.println("Enter the roll number to modify : ");
	                student = context.getBean("student",Student.class);
	                student = service.findById(scan.nextInt());
	                System.out.println("Enter new details : ");
	                student.setRollno(scan.nextInt());
	                student.setName(scan.next());
	                student.setPercentage(scan.nextFloat());
	                System.out.println(service.modifyStudent(student));
	                break;
        	case 4: System.out.println("Enter the roll number to delete details : ");
        	        service.deleteStudent(scan.nextInt());
        	        System.out.println("Details deleted : ");
        	        break;
        	case 5: List<Student> list = service.findAll();
        			System.out.println("Student details ..");
        			list.forEach(System.out::println);
        			break;
        	case 6: break;
        	}
        }while(ch!=6);
    }
}
