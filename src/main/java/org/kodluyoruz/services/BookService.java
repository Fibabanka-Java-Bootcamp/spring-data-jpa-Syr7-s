package org.kodluyoruz.services;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.entities.Book;
import org.kodluyoruz.entities.Category;
import org.kodluyoruz.repositories.AuthorRepo;
import org.kodluyoruz.repositories.BookRepo;
import org.kodluyoruz.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class BookService {
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;
    private CategoryRepo categoryRepo;

    public BookService(BookRepo bookRepo, AuthorRepo authorRepo, CategoryRepo categoryRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
    }

    public void bookOperation() {
        Author author = new Author();
        Category category = new Category();
        category.setName("Novel");
        author.setName("Tolstoy");

        Book book = new Book();
        book.setIsbn(UUID.randomUUID().toString());
        book.setName("Savas Baris");
        book.setDescription("The Roman");
        book.setPublishedDate(LocalDate.of(1867, 7, 11));
        book.setAddedDate(LocalDate.of(2002, 1, 1));
        book.setPrice(180.78);
        book.setCurrency("₺");
        book.setImageUrl("image4.jpg");

        Book book1 = new Book();
        book1.setIsbn(UUID.randomUUID().toString());
        book1.setName("Anna Karina");
        book1.setDescription("The Roman");
        book1.setPublishedDate(LocalDate.of(1877, 8, 23));
        book1.setAddedDate(LocalDate.of(2004, 1, 1));
        book1.setPrice(190.45);
        book1.setCurrency("₺");
        book1.setImageUrl("image5.jpg");
        List<Author> authorList = new ArrayList<>();
        authorList.add(author);
        book.setAuthors(authorList);

        List<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        author.setRegisteredAuthorBook(books);
        System.out.println("Authors from Book Service");
        authorRepo.save(author);
        bookRepo.save(book);
        bookRepo.save(book1);
        System.out.println(author);

        category.setBooks(books);
       /* System.out.println("Book from Book Service");
        System.out.println(book);*/
        Book book2 = bookRepo.findBookByName("Savas Baris");
        System.out.println(book2);
        System.out.println("**********************************");
        Author book1Author= authorRepo.findAuthorByName("Tolstoy");
        System.out.println(book1Author.getRegisteredAuthorBook());
        System.out.println("Novel: ");
        System.out.println(category);




    }
}
