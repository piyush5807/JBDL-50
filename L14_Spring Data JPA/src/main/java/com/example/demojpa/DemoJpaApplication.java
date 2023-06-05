package com.example.demojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class DemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	// DTO - Data transfer object - (This is used as a request response POJO for communication b/w different services)
	// DAO layer / Repository - Data access object layer --> underlying DB

}
