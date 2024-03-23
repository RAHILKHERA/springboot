package com.rahil.restcurddemo.dao;

import java.util.List;

import com.rahil.restcurddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void remove(int id);
}
