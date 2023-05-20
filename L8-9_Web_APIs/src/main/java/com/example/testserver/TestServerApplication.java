package com.example.testserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class TestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestServerApplication.class, args);
	}

	/**
	 * 1. I will get an error as there are 2 embedded containers / servers added in the classpath
	 * 2. Tomcat server will run
	 * 3. Jetty server will run
	 */

}
