package com.pavanbhat.dev.springboot_playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.pavanbhat.dev.springboot_playground",
				"com.pavanbhat.dev.utils"
		}
)
public class SpringbootPlaygroundApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootPlaygroundApplication.class, args
		);
	}

}
