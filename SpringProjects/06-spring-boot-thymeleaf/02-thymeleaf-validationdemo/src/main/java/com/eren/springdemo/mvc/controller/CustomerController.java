package com.eren.springdemo.mvc.controller;

import com.eren.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

//  Model allows us to share info between Controllers and view pages
    @GetMapping("/")
    public String showCustomerForm(Model model){

        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processCustomerForm(@Valid @ModelAttribute("customer")Customer customer, BindingResult bindingResult){
        System.out.println("Binding results: "+ bindingResult.toString());



        if(bindingResult.hasErrors()){
            return "customer-form";
        }
        else{
        return "customer-confirmation";
        }
    }
}
