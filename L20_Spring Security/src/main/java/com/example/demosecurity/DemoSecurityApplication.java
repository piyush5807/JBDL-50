package com.example.demosecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		System.out.println(passwordEncoder.encode("nitish1234"));
//		System.out.println(passwordEncoder.encode("karan1234"));
//		System.out.println(passwordEncoder.encode("pankaj1234"));


}
