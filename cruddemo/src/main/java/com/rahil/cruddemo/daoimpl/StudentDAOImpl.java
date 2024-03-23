package com.rahil.cruddemo.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rahil.cruddemo.dao.StudentDao;
import com.rahil.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDao {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student thStudent) {
        entityManager.persist(thStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by firstName desc", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        // create query
        // :theData is the Named Parameter. The named parameters are prefixed with
        // colon:
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student where firstName=:theData",
                Student.class);

        theQuery.setParameter("theData", firstName);

        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int updateMultiple(String lastName) {
        Query query = entityManager.createQuery("UPDATE Student SET lastName=:lastName");
        query.setParameter("lastName", lastName);
        int numRowsUpdated = query.executeUpdate();
        return numRowsUpdated;
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {

        // retrive the student
        Student student = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAllStudents() {
        int numRowsDeleted = entityManager.createQuery("DELETE from Student").executeUpdate();
        return numRowsDeleted;
    }

}
