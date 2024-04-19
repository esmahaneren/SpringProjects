package com.eren.cruddemo.dao;

import com.eren.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);
    Student findById(Long id);

    List<Student> findAll();
    List <Student> findByLastName(String lastName);
   void update(Student student);

   void delete(Long id);
   int deleteAll();

}
