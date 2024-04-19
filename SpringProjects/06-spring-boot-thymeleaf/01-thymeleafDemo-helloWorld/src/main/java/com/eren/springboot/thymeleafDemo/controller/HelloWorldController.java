package com.eren.springboot.thymeleafDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form
    @GetMapping("/showForm")

    public String showForm(){
        return "helloworld-form";
    }


    //need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // need a controller method to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

    // read the request parameter from the HTML form
        String studentName = request.getParameter("studentName");

        // convert the data to all caps
        studentName = studentName.toUpperCase();

        //create the message
       String result = "Yo " + studentName;

       // add message to the model
        model.addAttribute("message",result );

        return "helloworld";

    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName")String studentName, Model model){

        // convert the data to all caps
        studentName = studentName.toUpperCase();

        //create the message
        String result = "Hey My Friend from V3 " + studentName;

        // add message to the model
        model.addAttribute("message",result );

        return "helloworld";

    }
}
