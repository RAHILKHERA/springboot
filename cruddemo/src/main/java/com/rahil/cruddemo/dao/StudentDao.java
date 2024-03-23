package com.rahil.cruddemo.dao;

import java.util.List;

import com.rahil.cruddemo.entity.Student;

public interface StudentDao {
    void save(Student thStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    void update(Student student);

    int updateMultiple(String lastName);

    void deleteStudent(Integer id);

    int deleteAllStudents();
}
