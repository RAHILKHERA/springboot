package com.rahil.restcurddemo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rahil.restcurddemo.dao.EmployeeDAO;
import com.rahil.restcurddemo.entity.Employee;
import com.rahil.restcurddemo.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = employeeDAO.findById(theId);
        return theEmployee;
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        Employee employee = employeeDAO.save(theEmployee);
        return employee;
    }

    @Override
    @Transactional
    public void remove(int theId) {
        employeeDAO.remove(theId);
    }

}
