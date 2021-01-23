package org.kodluyoruz.controller;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String getAuthor(@RequestParam("authorName") String authorName) {
        Author author = authorService.getAuthor(authorName);
        if (author != null){
            System.out.println(author);
            return author.getName()+" named writer info was received.";
        }throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Writer is not found");//return "Writer is not found";
    }

    @GetMapping("/authors")
    public String getAllAuthors(){
        List<Author> authorList = authorService.getAllAuthors();
        if (!authorList.isEmpty()){
            System.out.println("All writers are getting....");
            Arrays.stream(authorList.toArray()).forEach(System.out::println) ;
            return "All writers have been brought.";
        }throw new ResponseStatusException(HttpStatus.NOT_FOUND,"AuthorList is empty");

    }
}
