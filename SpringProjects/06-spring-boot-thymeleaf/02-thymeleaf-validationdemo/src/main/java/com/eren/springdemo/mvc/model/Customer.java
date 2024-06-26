package com.eren.springdemo.mvc.model;

import com.eren.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotBlank
    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String lastName;


    @Pattern(regexp = "^[a-zA-Z0-9]{5}" ,message = "only 5 chars/digits")
    private String postalCode;

    @NotNull(message = "is required")
    @Min(value = 0,message = "must be greater than or equal to zero")
    @Max(value = 10,message = "must be less than or equal to zero")
    private Integer freePasses;

    @CourseCode
    private String courseCode;

    public Customer(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
