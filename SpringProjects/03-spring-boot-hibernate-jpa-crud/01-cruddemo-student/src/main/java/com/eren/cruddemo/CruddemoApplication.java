package com.eren.cruddemo;

import com.eren.cruddemo.dao.StudentDao;
import com.eren.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner ->{
			//createStudent(studentDao);
			createMultipleStudent(studentDao);
			//readStudent(studentDao);
			//queryForStudent(studentDao);
			//queryForStudentByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllStudent(studentDao);
		};
	}

	private void deleteAllStudent(StudentDao studentDao) {
		int numRowsDeleted = studentDao.deleteAll();
		System.out.println(numRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDao) {
		Long id = 3L;
		studentDao.delete(id);

	}

	private void updateStudent(StudentDao studentDao) {
		// retrieve student based on the id: primary key
		Long id = 1L;
		Student student = studentDao.findById(id);

		// set firstname something else
		student.setFirstName("Cedric");
		//update the database
		studentDao.update(student);
		//display the updated student
		System.out.println(student);
	}

	private void queryForStudentByLastName(StudentDao studentDao) {
		List<Student> student = studentDao.findByLastName("Doe");
		for (Student tempStudent : student){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDao studentDao) {
		// get a list of students
		List<Student> studentList = studentDao.findAll();

		// display list of student
		for (Student tempStudent : studentList){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {
		//create a student object
		Student student = new Student("Mary","Jane","maryjane@gmail.com");
		//save the database
		studentDao.save(student);

		//retrieve from database by id and display
		Long studentId = student.getId();
		Student newStudent = studentDao.findById(studentId);
		System.out.println(newStudent.toString());

	}

	private void createMultipleStudent(StudentDao studentDao) {
		Student student1 = new Student("John","Doe","johndoe@gmail.com");
		Student student2 = new Student("Julie","Doe","juliedoe@gmail.com");
		Student student3 = new Student("Jake","Doe","jakedoe@gmail.com");
		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
	}

	private void createStudent(StudentDao studentDao){
		//create the student object
		Student student = new Student("Jane","Doe","janedoe@gmail.com");

		//save the student object
		studentDao.save(student);

		//display the student id
		System.out.println("Saved student.Generated id :" + student.getId());

	}

}
