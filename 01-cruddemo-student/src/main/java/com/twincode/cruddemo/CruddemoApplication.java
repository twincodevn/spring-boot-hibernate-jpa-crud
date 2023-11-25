package com.twincode.cruddemo;

import com.twincode.cruddemo.dao.StudentDAO;
import com.twincode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
			readStudent(studentDAO);

		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student obj
		System.out.println("Creating new student obj...");
		Student tempStudent = new Student("Duc","Nguyen","duc123@gmail.com");
		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.out.println("Saved student with id: " + tempStudent.getId());
		// retrieve student based on the id
		System.out.println("Retrieving student with id: " + tempStudent.getId());
		Student myStudent = studentDAO.findById(tempStudent.getId());

		// display student
		System.out.printf("Found the student: " + myStudent);


		// display student
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 students objs...");
		Student s = new Student("Tuan","Dinh","tuandn2904@gmail.com");
		Student s2 = new Student("Bravee","06","bravee3000@gmail.com");
		// save the students obj
		System.out.println("Saving students");
		studentDAO.save(s);
		studentDAO.save(s2);

	}

	private void createStudent(StudentDAO studentDAO){
		// create the student obj
		System.out.println("Creating new student obj...");
		Student s = new Student("Twincode","vn","twincode.edu.vn@gmail.com");
		// save the student obj
		System.out.println("Saving the student");
		studentDAO.save(s);
		// display id of the saved student
		System.out.println("The id of new student added: " + s.getId());
	}


}
