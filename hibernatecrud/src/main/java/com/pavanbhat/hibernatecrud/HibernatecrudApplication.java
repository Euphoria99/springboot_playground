package com.pavanbhat.hibernatecrud;

import com.pavanbhat.hibernatecrud.dao.AppDAO;
import com.pavanbhat.hibernatecrud.entity.Instructor;
import com.pavanbhat.hibernatecrud.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernatecrudApplication {

	public static void main(String[] args) {SpringApplication.run(HibernatecrudApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {
//			System.out.println("Hello world");

			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor = new Instructor("Pavan","Bhat", "pavan@gmail.com");

		//create the instructor details
		InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com/PavanCodes", "Learn new tech");


		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//Note: This will also details object
		//because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!..");
	}
}
