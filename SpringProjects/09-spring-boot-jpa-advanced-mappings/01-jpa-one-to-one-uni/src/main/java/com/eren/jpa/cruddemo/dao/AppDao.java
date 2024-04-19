package com.eren.jpa.cruddemo.dao;


import com.eren.jpa.cruddemo.entity.Course;
import com.eren.jpa.cruddemo.entity.Instructor;
import com.eren.jpa.cruddemo.entity.InstructorDetail;
import com.eren.jpa.cruddemo.entity.Student;

import java.util.List;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewByCourseId(int id);

    Course findCourseAndStudentByCourseId(int id);

    Student findStudentAndCourseByStudentId(int id);

    void update(Student student);

    void deleteStudentById(int id);
}
