package com.spring.jdbc.dao;

import com.spring.jdbc.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        //Insert data into database --- Query
        String query = "insert into student(id,name,city) values(?,?,?)";
        int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return result;
    }

    @Override
    public int change(Student student) {
        //Updating data
        String query ="update student set name=? , city=? where id=?";
        int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return result;
    }

    @Override
    public int delete(int studentId) {
        //delete data
        String query ="delete from student where id=?";
        int result = this.jdbcTemplate.update(query, studentId);
        return result;
    }

    @Override
    public Student getStudent(int studentId) {
        //Selecting Single student data
        String query ="select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        //fetch all the data from db
        String query="Select * from student";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        List<Student> student = this.jdbcTemplate.query(query, rowMapper);
        return student;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
