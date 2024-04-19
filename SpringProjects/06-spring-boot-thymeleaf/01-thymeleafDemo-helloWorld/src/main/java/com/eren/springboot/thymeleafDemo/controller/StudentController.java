package com.eren.springboot.thymeleafDemo.controller;

import com.eren.springboot.thymeleafDemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}") // uses for inject app.properties values
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;



    @GetMapping("/showStudentForm")
    public String showForm(Model model ){
        //create a new Student object
        Student theStudent = new Student();

        // add student object to the model
        model.addAttribute("student",theStudent);
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("systems", systems);
        // attributeName using for the th:each loop (list of languages)

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student")Student theStudent){

        // log the input at  data
        System.out.println("theStudent: "+theStudent.getFirstName() +""+ theStudent.getLastName() +""+theStudent.getCountry());

        return  "student-confirmation";


    }


}
