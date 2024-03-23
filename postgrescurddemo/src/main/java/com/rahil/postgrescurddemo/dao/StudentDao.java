package com.rahil.postgrescurddemo.dao;

import com.rahil.postgrescurddemo.entity.Student;

public interface StudentDao {

    public void save(Student theStudent);

    Student findById(Integer id);
}
