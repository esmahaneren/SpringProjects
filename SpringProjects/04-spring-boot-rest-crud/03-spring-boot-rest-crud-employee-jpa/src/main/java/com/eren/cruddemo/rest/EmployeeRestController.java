package com.eren.cruddemo.rest;


import com.eren.cruddemo.entity.Employee;
import com.eren.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id  not found - "+ employeeId);
        }
        return employee;
    }

    // add mapping for POST / employees - add ne employee
    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
         // also just in case they pass an id in JSON ... set id to 0
         // this is to force a save of new item ... instead of update
        employee.setId(0);
        Employee savedEmployee = employeeService.save(employee);
        return savedEmployee;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        Employee updatedEmployee = employeeService.save(employee);

        return updatedEmployee;
    }

    // add mapping for DELETE /employees/{employeeId}
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee not found");
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;

    }
}
