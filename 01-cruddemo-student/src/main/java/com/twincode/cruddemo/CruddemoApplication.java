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
			createStudent(studentDAO);
		};
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
