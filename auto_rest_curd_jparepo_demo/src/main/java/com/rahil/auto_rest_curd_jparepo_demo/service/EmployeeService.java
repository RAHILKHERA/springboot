package com.rahil.auto_rest_curd_jparepo_demo.service;

import java.util.List;

import com.rahil.auto_rest_curd_jparepo_demo.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee thEmployee);

    void remove(int theId);
}
