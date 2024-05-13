package com.pavanbhat.dev.springboot_playground;

import com.pavanbhat.dev.springboot_playground.dao.StudentDAO;
import com.pavanbhat.dev.springboot_playground.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//		createStudent(studentDAO);

//		createMultipeStudent(studentDAO);

//		readStudent(studentDAO);

//		queryForStudents(studentDAO);

		queryForStudentsByLastName(studentDAO);
	};



	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Kang");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//query a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
	   }
   }
	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating a student object");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@fastnfurious.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipeStudent(StudentDAO studentDAO){

		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent1 = new Student("Vin","Diesel", "vindiesel@fastnfurious.com");
		Student tempStudent2 = new Student("Sung","Kang", "sungkang@fastnfurious.com");
		Student tempStudent3 = new Student("Sung","Kang", "sungkang@fastnfurious.com");


		//save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
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
