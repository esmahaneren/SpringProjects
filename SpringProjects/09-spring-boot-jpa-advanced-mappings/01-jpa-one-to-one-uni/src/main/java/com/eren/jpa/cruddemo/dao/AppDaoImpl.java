package com.eren.jpa.cruddemo.dao;

import com.eren.jpa.cruddemo.entity.Course;
import com.eren.jpa.cruddemo.entity.Instructor;
import com.eren.jpa.cruddemo.entity.InstructorDetail;
import com.eren.jpa.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AppDaoImpl implements AppDao{

    private EntityManager entityManager;


@Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager= entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
       entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        return instructor;
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        //retrieve the instructor
        Instructor instructor = entityManager.find(Instructor.class, id);

        // get the courses
        List<Course> courses = instructor.getCourses();

        //break associations of all courses for instructor
        for(Course tempCourse : courses){
            tempCourse.setInstructor(null);
        }
        //delete the instructor (only the instructor not the courses associated with)
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        return instructorDetail;
    }


    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        // remove the associated object reference
        //break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

       //create query
        TypedQuery query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);

        //execute query
        List<Course> courses = query.getResultList();
        return  courses;
    }

    @Override
    public Instructor findInstructorByJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from  Instructor  i  join fetch  i.courses " +
                        " join fetch i.instructorDetail where i.id = :data",Instructor.class);
               query.setParameter("data", id);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        return course;
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
       // create query
        TypedQuery<Course> query = entityManager.createQuery("SELECT C FROM  Course  C JOIN FETCH  C.reviews WHERE C.id = :data", Course.class);
        query.setParameter("data", id);
        // execute query
        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentByCourseId(int id) {
        // create query
        TypedQuery<Course> query = entityManager.createQuery("SELECT C FROM  Course  C JOIN FETCH  C.students WHERE C.id = :data", Course.class);
        query.setParameter("data", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCourseByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT S FROM  Student  S JOIN FETCH S.courses WHERE S.id = :data", Student.class);
        query.setParameter("data", id);
        Student student = query.getSingleResult();
        return student;

    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
