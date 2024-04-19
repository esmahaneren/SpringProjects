package com.eren.cruddemo.service;


import com.eren.cruddemo.dao.EmployeeRepository;
import com.eren.cruddemo.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public  EmployeeServiceImp(EmployeeRepository employeeRepository){

        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        Employee employee = null;
        if (byId.isPresent()){
            employee =byId.get();
        }
        else{
            //we didn't find the employee
            throw  new RuntimeException("Did not find  employee");
        }
        return employee;
    }


    @Override
    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }


    @Override
    public void deleteById(int id) {
     employeeRepository.deleteById(id);
    }
}
