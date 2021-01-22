package org.kodluyoruz.services;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.entities.Book;
import org.kodluyoruz.repositories.AuthorRepo;
import org.kodluyoruz.repositories.BookRepo;
import org.springframework.stereotype.Component;


@Component
public class AuthorService {
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    public AuthorService(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    public Author getAuthor(String authorName){
        return authorRepo.findAuthorByName(authorName);
    }
}
