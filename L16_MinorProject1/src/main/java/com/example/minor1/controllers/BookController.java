package com.example.minor1.controllers;

import com.example.minor1.dtos.CreateBookRequest;
import com.example.minor1.dtos.SearchBookRequest;
import com.example.minor1.models.Book;
import com.example.minor1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void createBook(@RequestBody @Valid CreateBookRequest createBookRequest){
        // author --> book
        // book --> author --> map book to the author

        bookService.createOrUpdate(createBookRequest.to());

    }

    @GetMapping("/book")
    public List<Book> getBooks(@RequestBody @Valid SearchBookRequest searchBookRequest) throws Exception {

        return bookService.find(
                searchBookRequest.getSearchKey(),
                searchBookRequest.getSearchValue()
        );

    }

    // localhost:8080/book?key=author_name&value=Peter
    // localhost:8080/book?key=genre&value=FICTIONAL

}
