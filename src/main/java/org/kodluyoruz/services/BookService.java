package org.kodluyoruz.services;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.entities.Book;
import org.kodluyoruz.repositories.AuthorRepo;
import org.kodluyoruz.repositories.BookRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Component
public class BookService {
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;

    public BookService(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public void bookOperation() {
        Author author = new Author();
        author.setName("Laurentiu Spilca");

        Book book = new Book();
        book.setIsbn(UUID.randomUUID().toString());
        book.setName("Spring Security");
        book.setDescription("This book about Spring");
        book.setPublishedDate(LocalDate.of(2019, 7, 11));
        book.setAddedDate(LocalDate.of(2021, 1, 1));
        book.setPrice(180.78);
        book.setCurrency("₺");
        book.setImageUrl("image4.jpg");
        List<Author> authorList = new ArrayList<>();
        authorList.add(author);
        book.setAuthors(authorList);

        List<Book> books = new ArrayList<>();
        books.add(book);
        author.setRegisteredAuthorBook(books);
        System.out.println("Authors from Book Service");
        authorRepo.save(author);
        bookRepo.save(book);
        System.out.println(author);

       /* System.out.println("Book from Book Service");
        System.out.println(book);*/
        Book book1 = bookRepo.findBookByName("Spring Security");
        System.out.println(book1);
        System.out.println("**********************************");
        Author book1Author= authorRepo.findAuthorByName("Laurentiu Spilca");
        System.out.println(book1Author.getRegisteredAuthorBook());
        /*
        System.out.println("Find Book By Author Name");

        Author bookAuthor = bookRepo.findBookByAuthors(authorList);
        System.out.println(bookAuthor.getName());*/
    }
}
