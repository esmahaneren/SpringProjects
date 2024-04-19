package com.eren.sprinboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage") // based on config class
    public String showMyLoginPage(){

        return "fancy-login"; // view name
    }


    // add request mapping for /access-denied

    @GetMapping("/access-denied") // based on config class
    public String showAccessDenied(){

        return "access-denied"; // view name
    }


}
