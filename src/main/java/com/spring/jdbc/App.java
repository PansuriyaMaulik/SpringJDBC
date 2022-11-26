package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
        Student student = new Student();
        student.setId(7);
        student.setName("Jaypal");
        student.setCity("Nasik");

        int result = studentDao.insert(student);
        System.out.println("Data Inserted..."+result );

        //Update student object
        Student student1 = new Student();
        student1.setId(2);
        student1.setName("Raj");
        student1.setCity("Varanasi");

        int result1 = studentDao.change(student1);
        System.out.println("Data Changed.."+result1);
    }
}
