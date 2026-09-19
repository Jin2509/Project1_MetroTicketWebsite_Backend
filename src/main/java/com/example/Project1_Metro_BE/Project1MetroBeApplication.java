package com.example.Project1_Metro_BE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project1MetroBeApplication {

	public static void main(String[] args) {

		System.setProperty("user.timezone", "Asia/Ho_Chi_Minh");

		SpringApplication.run(Project1MetroBeApplication.class, args);
	}
}