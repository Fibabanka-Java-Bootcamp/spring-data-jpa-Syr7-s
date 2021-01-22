package org.kodluyoruz.services;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.entities.Book;
import org.kodluyoruz.repositories.AuthorRepo;
import org.kodluyoruz.repositories.BookRepo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AuthorService {
    private final AuthorRepo authorRepo;
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author getAuthor(String authorName){
        return authorRepo.findAuthorByName(authorName);
    }

    public List<Author> getAllAuthors (){
        return (List<Author>) authorRepo.findAll();
    }
}
