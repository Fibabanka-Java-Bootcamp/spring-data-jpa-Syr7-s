package org.kodluyoruz.services;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.entities.Book;
import org.kodluyoruz.repositories.AuthorRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
@Component
public class AuthorService {
    private final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void authorOperations(){
        Book b1 = new Book();
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Pro Spring 5");
        b1.setDescription("This book about Spring");
        b1.setPublishedDate(LocalDate.of(2001,9,23));
        b1.setAddedDate(LocalDate.of(2006,10,15));
        b1.setPrice(50.75);
        b1.setCurrency("₺");
        b1.setImageUrl("image2.jpg");

        Book b2 = new Book();
        b2.setIsbn(UUID.randomUUID().toString());
        b2.setName("Cloud Native Java");
        b2.setDescription("This book about Java");
        b2.setPublishedDate(LocalDate.of(2017,9,23));
        b2.setAddedDate(LocalDate.of(2018,10,15));
        b2.setPrice(50.75);
        b2.setCurrency("₺");
        b2.setImageUrl("image2.jpg");
        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        Author author = new Author();
        author.setName("Chris Schaefer");
        author.setRegisteredAuthorBook(books);
        authorRepo.save(author);
        System.out.println(author);
    }
}
