package com.eren.springdemo.mvc.crud.controller;



import com.eren.springdemo.mvc.crud.entity.Employee;
import com.eren.springdemo.mvc.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    // add mapping for the "/list" employees

    @GetMapping("/list")
    public String listEmployees(Model model){
        // get the employees from db
        List<Employee> employeeList = service.findAll();

        // add to the spring model
        model.addAttribute("employees", employeeList);

        return "employees/list-employees";

    }



    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        service.save(employee);
        return "redirect:/employees/list";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id")int id,Model model){
        Employee foundEmployee = service.findById(id);
        model.addAttribute("employee", foundEmployee);
        return  "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id")int id){
        service.deleteById(id);
        return "redirect:/employees/list";
    }

}
