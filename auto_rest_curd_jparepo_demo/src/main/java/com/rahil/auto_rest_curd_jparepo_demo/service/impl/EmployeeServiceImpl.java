package com.rahil.auto_rest_curd_jparepo_demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rahil.auto_rest_curd_jparepo_demo.entity.Employee;
import com.rahil.auto_rest_curd_jparepo_demo.error.EmployeeNotFoundException;
import com.rahil.auto_rest_curd_jparepo_demo.repo.EmployeeRepository;
import com.rahil.auto_rest_curd_jparepo_demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new EmployeeNotFoundException("Something went wrong.");
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee = employeeRepository.save(theEmployee);
        return employee;
    }

    @Override
    public void remove(int theId) {
        employeeRepository.deleteById(theId);
        ;
    }

}
