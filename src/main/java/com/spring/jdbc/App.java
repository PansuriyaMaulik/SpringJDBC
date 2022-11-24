package com.spring.jdbc;

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
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

        //Insert data into database --- Query
        String query = "insert into student(id,name,city) values(?,?,?)";

        //Fire Query
        int result = template.update(query, 4, "Ajay", "Nagpur");
        System.out.println("Number of recorded inserted.." +result);
    }
}
