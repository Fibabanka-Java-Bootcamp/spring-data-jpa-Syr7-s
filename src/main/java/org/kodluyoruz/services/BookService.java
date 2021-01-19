package org.kodluyoruz.services;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.repositories.BookRepo;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public void bookOperation(){
        Author author = new Author();
        author.setName("Laurentiu Spilca");

    }
}
