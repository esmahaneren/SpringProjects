package com.eren.springdemo.mvc.crud.service;

import com.eren.springdemo.mvc.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
