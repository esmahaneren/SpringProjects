package com.eren.cruddemo.dao;

import com.eren.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao{

    //define field for entityManager
    EntityManager entityManager ;

    //set up constructor injection
    @Autowired
    public EmployeeDaoImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee ", Employee.class);

        //execute  query and get result list
        List<Employee> employees = query.getResultList();

        // return the result
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get employee
        Employee employee = entityManager.find(Employee.class, id);

        //return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // save employee
        Employee savedEmployee = entityManager.merge(employee);

        //return the savedEmployee
        return savedEmployee;
    }

    @Override
    public void deleteById(int id) {
        // find employee by id
        Employee employee = entityManager.find(Employee.class, id);

        //remove employee
        entityManager.remove(employee);
    }
}
