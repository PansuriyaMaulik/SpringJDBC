package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program Started....!" );

        //Spring JDBC => JdbcTemplate
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        //Create student object
      //  Student student = new Student();
      //  student.setId(8);
      //  student.setName("Alay");
      //  student.setCity("Jain");

      //  int result = studentDao.insert(student);
      //  System.out.println("Data Inserted..."+result );

        //Update student object
      //  Student student1 = new Student();
      //  student1.setId(1);
      //  student1.setName("Jigar");
      //  student1.setCity("Mavani");

      //  int result1 = studentDao.change(student1);
      //  System.out.println("Data Changed..."+result1);

        //Delete student object
      //  Scanner sc=new Scanner(System.in);

      //  System.out.println("Enter the Student ID you want to Delete:");
      //  int id=sc.nextInt();
      //  sc.close();

      //  int result2=studentDao.delete(id);
      //  System.out.println("No of Record deleted..."+result2);

        //Select Single data
        Student student = studentDao.getStudent(7);
        System.out.println(student);

    }
}
