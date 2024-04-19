package com.eren.demo.rest;

import com.eren.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;

    //define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public  void loadData(){
        studentList = new ArrayList<>();
        studentList.add(new Student("Harry","Potter"));
        studentList.add(new Student("Hermoine","Granger"));
        studentList.add(new Student("Ron","Weasley"));
    }

    // define endpoint for "/students" -returns a list of student

   @GetMapping("/students")
   public List<Student> getStudents(){

        return  studentList;
   }

   // define endpoint for "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check the studentId again list size
        if(studentId >= studentList.size()|| studentId < 0 ){
            throw  new StudentNotFoundException("Student id not found - " + studentId);
        }
        return studentList.get(studentId);

    }

    // Add an exception handler using @ExceptionHandler



}
