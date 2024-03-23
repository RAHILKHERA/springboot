package com.rahil.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = { "com.rahil.util", "com.rahil.springcoredemo" })
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(SpringcoredemoApplication.class);
		springApplication.run(args);
	}

}
