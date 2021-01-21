package org.kodluyoruz.controller;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            return author.getName()+" adli yazarın bilgileri getirildi.";
        }else
            return "Yazar bulunamadi.";
    }
}
