package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student(id,name,city) values(?,?,?)";
        int res = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return res;
    }

    @Override
    public int change(Student student) {
        String query = "update student set name=? , city=? where id=?";
        int res = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return res;
    }

    @Override
    public Student getStudent(int studentId) {
        // Selecting single student data
        String query = "select * from student where id =?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from student";
        List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
        return students;
    }


}
