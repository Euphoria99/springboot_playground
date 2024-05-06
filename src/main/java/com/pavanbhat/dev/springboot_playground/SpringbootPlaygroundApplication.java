package com.pavanbhat.dev.springboot_playground;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public CommandLineRunner commandLineRunner(String[] args){

		//java lambda expression
		return runner -> {
			System.out.println("hello world from runner");
		};
	}

}
