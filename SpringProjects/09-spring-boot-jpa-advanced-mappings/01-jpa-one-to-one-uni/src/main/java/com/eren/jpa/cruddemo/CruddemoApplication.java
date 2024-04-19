package com.eren.jpa.cruddemo;

import com.eren.jpa.cruddemo.dao.AppDao;
import com.eren.jpa.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){

		return runner ->{
			//createInstructor(appDao);
			//findInstructor(appDao);
			//deleteInstructor(appDao);
			//findInstructorDetail(appDao);
			//deleteInstructorDetail(appDao);
			//createInstructorWithCourses(appDao);
			//findInstructorWithCourses(appDao);
			//findCoursesForInstructor(appDao);
			//findInstructorWithCoursesJoinFetch(appDao);
			//updateInstructor(appDao);
			//updateCourse(appDao);
			//deleteCourse(appDao);
			//createCourseAndReviews(appDao);
			//retrieveCourseAndReviews(appDao);
			//deleteCourseAndReviews(appDao);
            //createCourseAndStudent(appDao);
			//retrieveCourseAndStudents(appDao);
			//retrieveStudentAndCourse(appDao);
			//updateStudent(appDao);
			deleteStudent(appDao);

		};
	}

	private void deleteStudent(AppDao appDao) {
		int id = 1;
		appDao.deleteStudentById(id);
		System.out.println("Done");
	}

	private void updateStudent(AppDao appDao) {
		int id = 1;
		Student student = appDao.findStudentAndCourseByStudentId(id);
		student.addCourse(new Course("Java 101"));
		appDao.update(student);
		System.out.println(student.getCourses());
	}

	private void retrieveStudentAndCourse(AppDao appDao) {
		int id = 1;
		Student student = appDao.findStudentAndCourseByStudentId(id);
		List<Course> courses = student.getCourses();
		System.out.println(student);
		System.out.println(courses);
	}

	private void retrieveCourseAndStudents(AppDao appDao) {
		int id = 10;
		Course course = appDao.findCourseAndStudentByCourseId(id);
		List<Student> students = course.getStudents();

		System.out.println(course);
		System.out.println(students);
	}

	private void createCourseAndStudent(AppDao appDao) {

		// create a course
		Course course = new Course("Pacman-How to Score One Million");

		//create a students
		Student student1 = new Student("John","Doe","john@luv2code.com");
		Student student2 = new Student("Jane","Tester","jane@luv2code.com");

		// add students to the course
		course.addStudent(student1);
		course.addStudent(student2);

		// save the course and associated students
		appDao.save(course);
		System.out.println(course);
		System.out.println(course.getStudents());
	}


	private void deleteCourseAndReviews(AppDao appDao) {
		int id = 10;
		appDao.deleteCourseById(id);
		System.out.println("Done");
	}

	private void retrieveCourseAndReviews(AppDao appDao) {
		int id = 10;
		Course course = appDao.findCourseAndReviewByCourseId(id);
		System.out.println(course);
		System.out.println(course.getReviews());

	}

	private void createCourseAndReviews(AppDao appDao) {
		//create a course
		Course course = new Course("Pacman-How to Score One Million");

		//add some reviews
		course.addReviews( new Review("Great course... loved it"));
		course.addReviews( new Review("Cool course"));
		course.addReviews( new Review("What a dumb course"));

		// save the course ... cascade all
		appDao.save(course);
		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void deleteCourse(AppDao appDao) {
		int id = 10;
		appDao.deleteCourseById(id);
		System.out.println("Done");
	}

	private void updateCourse(AppDao appDao) {
		int id = 10;
		Course courseById = appDao.findCourseById(id);
		courseById.setTitle("Hello Little Bird");
		appDao.update(courseById);
		System.out.println("Courses updated: " + courseById);

	}

	private void updateInstructor(AppDao appDao) {
		int id = 4;
		Instructor instructor = appDao.findInstructorById(id);
		instructor.setLastName("TESTER");
		appDao.update(instructor);
		System.out.println("Updated instructor :" + instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
		int id = 4;
		//find the instructor
		// retrieve Instructor and courses because we added Join Fetch in our query
		Instructor instructor = appDao.findInstructorByJoinFetch(id);
		System.out.println("The instructor :"+instructor);
		System.out.println("The associated courses :" + instructor.getCourses());

	}

	private void findCoursesForInstructor(AppDao appDao) {
		int id = 4;
		System.out.println("Finding instructor id" + id);
		Instructor instructor = appDao.findInstructorById(id);
		System.out.println("The instructor: " + instructor);

		//find courses for instructor
		// fetch type lazy so we have to do this manually
		System.out.println("Finding courses for the instructor id ");
		List<Course> courses = appDao.findCoursesByInstructorId(id);

		// associate the objects
		instructor.setCourses(courses);

		System.out.println("the associated courses : " + instructor.getCourses() );

	}

	private void findInstructorWithCourses(AppDao appDao) {
		int id = 4;
		System.out.println("Finding instructor id" + id);
		Instructor instructor = appDao.findInstructorById(id);
		System.out.println("The instructor: " + instructor);
		System.out.println("the assosiate courses : "+instructor.getCourses() );
	}

	private void createInstructorWithCourses(AppDao appDao) {

		Instructor instructor = new Instructor("Susan","Patel","susan@luv2code.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Video Games");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar-The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		instructor.add(course1);
		instructor.add(course2);

		// save the instructor ,this is also save courses for us
		appDao.save(instructor);
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int id = 4;
		appDao.deleteInstructorDetailById(id);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDao appDao) {
		int id = 1;
		InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 4;
		appDao.deleteInstructorById(id);
		System.out.println("Done");
	}

	private void findInstructor(AppDao appDao) {
		int id = 1;
		Instructor foundInstructorById = appDao.findInstructorById(id);
		System.out.println("Found instructor is :" + foundInstructorById);

	}

	private void createInstructor(AppDao appDao) {
		//Instructor instructor = new Instructor("Chad","Darby","darby@luv2code.com");
		//	InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 code");

		Instructor instructor = new Instructor("Madhu","Patel","madhuy@luv2code.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Guitar");

		// associate the objects
        instructor.setInstructorDetail(instructorDetail);
		System.out.println("Saving instructor: "+ instructor) ;

		// this will ALSO save the details object
		//because of CascadeType.ALL
		appDao.save(instructor);

	}
}
