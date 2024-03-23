package com.rahil.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rahil.cruddemo.dao.StudentDao;
import com.rahil.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {

		return runner -> {
			// createStudent(studentDao);
			createMultipleStudents(studentDao);
			// readStudent(studentDao);
			// queryForStudents(studentDao);
			// queryForStudentsByFirstName(studentDao);
			// updateStudent(studentDao);
			// updateMultipleStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAllStudents(studentDao);

		};

	}

	private void deleteAllStudents(StudentDao studentDao) {

		// deleting all the students.

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDao.deleteAllStudents();
		System.out.println("Deleted : " + numRowsDeleted + " Students");
	}

	private void deleteStudent(StudentDao studentDao) {

		int studentId = 3;
		System.out.println("Deleting student id:" + studentId);
		studentDao.deleteStudent(studentId);
	}

	private void updateMultipleStudent(StudentDao studentDao) {
		int numRowsUpdated = studentDao.updateMultiple("CURD");

		System.out.println("Number of rows affected: " + numRowsUpdated);
	}

	private void updateStudent(StudentDao studentDao) {

		// retrive student based on the id: Primary key
		int studentId = 1;
		System.out.println("Retriving student with id :" + studentId);
		Student student = studentDao.findById(studentId);

		// change first name to "Scooby"
		System.out.println("Updating Student...	");
		student.setFirstName("John");

		// update the student
		studentDao.update(student);

		// display the updated student
		System.out.println("Update Student :" + student);
	}

	private void queryForStudentsByFirstName(StudentDao studentDao) {
		// get a list of students
		List<Student> theStudents = studentDao.findByFirstName("Daffy");

		// display list of students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDao studentDao) {
		// get a list of students.
		List<Student> theStudents = studentDao.findAll();
		// display list of students.
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDao studentDao) {
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy.duck@gmail.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDao.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved Student. Generated Id: " + theId);

		// retrive student based on id : primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDao.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDao studentDao) {
		System.out.println("Creating new student object....");
		Student tempStudent1 = new Student("abc", "Doe", "abc.doe@gmail.com");
		Student tempStudent2 = new Student("def", "Doe", "def.doe@gmail.com");
		Student tempStudent3 = new Student("ghi", "Doe", "ghi.doe@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);

	}

	private void createStudent(StudentDao studentDao) {

		// create the student object
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("Paul", "Doe", "paul.doe@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDao.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student. Generated Id" + tempStudent.getId());
	}
}
