package com.eren.springdemo.mvc.crud.dao;

import com.eren.springdemo.mvc.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
