package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.daos.TestDAO;

@SpringBootApplication
@RestController
public class Application {
	
	@Autowired
	TestDAO testDAO;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/test")
	public void test() {
		testDAO.databaseConnection();
	}
}
