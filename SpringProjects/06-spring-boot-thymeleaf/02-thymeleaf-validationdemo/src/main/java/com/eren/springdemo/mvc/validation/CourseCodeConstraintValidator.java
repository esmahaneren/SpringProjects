package com.eren.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


// creating custom validation rule in here
public class CourseCodeConstraintValidator implements ConstraintValidator <CourseCode,String>{

    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       // custom validation rule
        boolean result;

        if(s != null){
        result = s.startsWith(coursePrefix);
        }
        else{
            result = true; // because not required it can be null
        }

        return result;
    }
}
