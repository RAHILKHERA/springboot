package com.rahil.auto_rest_curd_jparepo_demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahil.auto_rest_curd_jparepo_demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
