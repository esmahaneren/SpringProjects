package com.eren.springdemo.mvc.crud.service;


import com.eren.springdemo.mvc.crud.dao.EmployeeRepository;
import com.eren.springdemo.mvc.crud.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

private EmployeeRepository repository;

 @Autowired
 public EmployeeServiceImpl(EmployeeRepository repository){
    this.repository = repository;
}
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = repository.findById(id);
        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }
        else{
            throw  new RuntimeException("Did not find employee id:"+ id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
