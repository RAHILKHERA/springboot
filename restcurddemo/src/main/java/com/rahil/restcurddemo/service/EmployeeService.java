package com.rahil.restcurddemo.service;

import java.util.List;

import com.rahil.restcurddemo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee thEmployee);

    void remove(int theId);
}
