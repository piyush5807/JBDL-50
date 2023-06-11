package com.example.minor1;

import com.example.minor1.models.Book;
import com.example.minor1.models.Genre;
import com.example.minor1.models.Student;
import com.example.minor1.repositories.BookRepository;
import com.example.minor1.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Minor1Application implements CommandLineRunner{

	@Autowired
	BookRepository bookRepository;

	@Autowired
	StudentRepository studentRepository;

	private static Logger logger = LoggerFactory.getLogger(Minor1Application.class);

	// Command Line runner

	public static void main(String[] args) {
		SpringApplication.run(Minor1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student student = Student.builder()
//				.name("ABC")
//				.email("abc@google.com")
//				.build();
//
//		student = studentRepository.save(student);
//
//		Book book = Book.builder()
//				.name("Intro to Java")
//				.genre(Genre.PROGRAMMING)
//				.student(student)
//				.build();
//
//		bookRepository.save(book);

//		Student student1 = studentRepository.findById(1).get();
//		List<Book> bookList = student1.getBookList();
//
//		logger.info("book size = {}",  bookList.size());
//		logger.info("student = {}", student1);
	}
}
