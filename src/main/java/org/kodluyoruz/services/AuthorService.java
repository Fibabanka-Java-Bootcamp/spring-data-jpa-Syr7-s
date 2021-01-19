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

    public void authorOperations() {
        Book b1 = new Book();
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Pro Spring 5");
        b1.setDescription("This book about Spring");
        b1.setPublishedDate(LocalDate.of(2001, 9, 23));
        b1.setAddedDate(LocalDate.of(2006, 10, 15));
        b1.setPrice(50.75);
        b1.setCurrency("₺");
        b1.setImageUrl("image2.jpg");

        Book b2 = new Book();
        b2.setIsbn(UUID.randomUUID().toString());
        b2.setName("Cloud Native Java");
        b2.setDescription("This book about Java");
        b2.setPublishedDate(LocalDate.of(2017, 9, 23));
        b2.setAddedDate(LocalDate.of(2018, 10, 15));
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
        System.out.println("**********************************************");
        Author author2 = new Author();

        Book b3 = new Book();
        b3.setIsbn(UUID.randomUUID().toString());
        b3.setName("Spring MicroService");
        b3.setDescription("This book about Spring");
        b3.setPublishedDate(LocalDate.of(2015, 6, 10));
        b3.setAddedDate(LocalDate.of(2020, 5, 15));
        b3.setPrice(50.75);
        b3.setCurrency("₺");
        b3.setImageUrl("image2.jpg");
        List<Book> books1 = new ArrayList<>();
        books1.add(b3);

        author2.setName("John Camell");
        author2.setRegisteredAuthorBook(books1);

        authorRepo.save(author2);
        System.out.println(author2);
        System.out.println("*********Veritabanı Sorgusu");
        Author author1 = authorRepo.findAuthorByName("Chris Schaefer");
        System.out.println(author1.getRegisteredAuthorBook());



    }
}
