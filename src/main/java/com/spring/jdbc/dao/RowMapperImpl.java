package com.spring.jdbc.dao;

import com.spring.jdbc.entites.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImpl implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt(1));
        student.setName(resultSet.getString(2));
        student.setCity(resultSet.getString(3));
        return student;
    }
}
