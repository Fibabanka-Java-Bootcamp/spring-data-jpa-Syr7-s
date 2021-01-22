package org.kodluyoruz.controller;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/{authorName}", method = RequestMethod.GET)
    public String getAuthor(@PathVariable("authorName") String authorName) {
        Author author = authorService.getAuthor(authorName);
        if (author != null){
            System.out.println(author);
            return author.getName()+" named writer info was received.";
        }else
            return "Writer is not found";
    }

    @RequestMapping(value = "/allAuthors",method = RequestMethod.GET)
    public String getAllAuthors(){
        System.out.println("All writers are getting....");
        List<Author> authorList = authorService.getAllAuthors();
        Arrays.stream(authorList.toArray()).forEach(System.out::println) ;
        return "All writers have been brought.";
    }
}
