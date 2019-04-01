package com.lalit.library.controller;

import com.lalit.library.entity.Author;
import com.lalit.library.entity.Book;
import com.lalit.library.repository.AuthorRepository;
import com.lalit.library.repository.BookRepository;
import com.lalit.library.response.AuthorResponse;
import com.lalit.library.response.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping(path = "books" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok(bookRepository.findAll());
    }


    @PostMapping(path = "books" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> add(@RequestBody com.lalit.library.command.BookCommand bookCommand){
        Book book=bookRepository.save(Book.BookBuilder.aBook()
                                    .withAuthorRepository(authorRepository)
                                    .withBookCommand(bookCommand)
                                    .build());
        return ResponseEntity.ok(new BookResponse(book));
    }

    @GetMapping(path = "books/{bookId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse>  getAuthor(@PathVariable("bookId") String bookId){
        Book book = bookRepository.getOne(UUID.fromString(bookId));
        return ResponseEntity.ok(new BookResponse(book));
    }
}
