package com.rahil.postgrescurddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rahil.postgrescurddemo.dao.StudentDao;
import com.rahil.postgrescurddemo.entity.Student;

@SpringBootApplication
public class PostgrescurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgrescurddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner getCommandLineRunner(StudentDao studentDao) {

		return runner -> {
			// createStudent(studentDao);
			// createMultipleStudents(studentDao);
			// nextval('student_id_seq'::regclass)

			readStudent(studentDao);
		};
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
