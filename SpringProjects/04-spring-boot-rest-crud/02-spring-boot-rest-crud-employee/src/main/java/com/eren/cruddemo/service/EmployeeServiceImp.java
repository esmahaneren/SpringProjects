package com.eren.cruddemo.service;

import com.eren.cruddemo.dao.EmployeeDao;
import com.eren.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeDao employeeDao;

    @Autowired
    public  EmployeeServiceImp(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
     employeeDao.deleteById(id);
    }
}
