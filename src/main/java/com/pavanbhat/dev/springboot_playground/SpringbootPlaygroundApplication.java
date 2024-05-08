package com.pavanbhat.dev.springboot_playground;

import com.pavanbhat.dev.springboot_playground.dao.StudentDAO;
import com.pavanbhat.dev.springboot_playground.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//s3: update the main app
@SpringBootApplication()
//@SpringBootApplication(
//		scanBasePackages = {
//				"com.pavanbhat.dev.springboot_playground",
//				"com.pavanbhat.dev.utils"
//		}
//)
public class SpringbootPlaygroundApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootPlaygroundApplication.class, args
		);
	}

	//executed after spring beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

	return runner -> {
		createStudent(studentDAO);
	};

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul","Walker", "paulwalker@fastnfurious.com");

		//save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);

		//display the id of student object
		System.out.println("Saved student. Generated id " + tempStudent.getId());

	}

}
