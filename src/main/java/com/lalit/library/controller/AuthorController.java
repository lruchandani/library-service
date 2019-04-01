package com.lalit.library.controller;

import com.lalit.library.command.AuthorCommand;
import com.lalit.library.entity.Author;
import com.lalit.library.repository.AuthorRepository;
import com.lalit.library.response.AuthorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping(path = "authors" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Author>>  getAuthors(){
        return ResponseEntity.ok(authorRepository.findAll());
    }

    @PostMapping(path = "authors" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorResponse> add(@RequestBody AuthorCommand authorCommand){
        Author author=authorRepository.save(new Author(authorCommand));
        return ResponseEntity.ok(new AuthorResponse(author));
    }

    @GetMapping(path = "authors/{authorId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorResponse>  getAuthor(@PathVariable("authorId") String authorId){
        Author author = authorRepository.getOne(UUID.fromString(authorId));
        return ResponseEntity.ok(new AuthorResponse(author));
    }

}
