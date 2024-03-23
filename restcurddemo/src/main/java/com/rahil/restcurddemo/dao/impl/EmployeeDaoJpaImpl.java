package com.rahil.restcurddemo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rahil.restcurddemo.dao.EmployeeDAO;
import com.rahil.restcurddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);

        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        // if the id == 0,then save/insert else update
        Employee updatedEmployee = entityManager.merge(employee);
        return updatedEmployee;
    }

    @Override
    public void remove(int theId) {
        Employee thEmployee = findById(theId);
        entityManager.remove(thEmployee);
    }

}
