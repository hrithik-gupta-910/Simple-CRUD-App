package com.love2code.cruddemo.dao;

import com.love2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student thestudent);

    Student findId(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
