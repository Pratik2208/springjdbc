package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/config.xml");
        StudentDao studentDao  = context.getBean("studentdao",StudentDao.class);

        // Setting value of Student Object
//        Student student = new Student();
//        student.setId(999);
//        student.setName("cena");
//        student.setCity("Jamnagar");
//
//        int result = studentDao.insert(student);
//        System.out.println("student added " + result);

        // Updating value of Student into database
//        Student student = new Student();
//        student.setId(666);
//        student.setName("Vicky");
//        student.setCity("Ahmedabad");
//
//        int update = studentDao.change(student);
//        System.out.println("Updated " + update);

//        Student student = studentDao.getStudent(111);
//        System.out.println(student);

        List<Student> students = studentDao.getAllStudents();
        for(Student s : students){
            System.out.println(s);
        }


    }
}
