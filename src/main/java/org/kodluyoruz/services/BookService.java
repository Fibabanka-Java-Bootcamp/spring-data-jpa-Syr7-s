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
       // firstProcess();
        Author a1 = new Author();
        Author a2 = new Author();
        Author a3 = new Author();
        Author a4 = new Author();

        Category c1 = new Category();
        Category c2 = new Category();

        Book b1 = new Book();
        Book b2 = new Book();
        Book b3 = new Book();
        Book b4 = new Book();
        Book b5 = new Book();
        Book b6 = new Book();

        a1.setName("Lev Tolstoy");
        a2.setName("Fyodor Dostoyevski");
        a3.setName("Sait Faik Abasıyanık");
        a4.setName("Orhan Kemal");

        c1.setName("Novel");
        c2.setName("Story");

        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Savas ve Baris");
        b1.setDescription("Lev Tolstoy wrote in 1867.");
        b1.setPublishedDate(LocalDate.of(1867,7,11));
        b1.setAddedDate(LocalDate.of(1877,12,6));
        b1.setPrice(120.75);
        b1.setCurrency("₺");
        b1.setImageUrl("savasvebaris.jpg");

        b2.setIsbn(UUID.randomUUID().toString());
        b2.setName("Anna Karina");
        b2.setDescription("Lev Tolstoy wrote in 1877.");
        b2.setPublishedDate(LocalDate.of(1877,12,6));
        b2.setAddedDate(LocalDate.of(1900,6,25));
        b2.setPrice(150.00);
        b2.setCurrency("₺");
        b2.setImageUrl("annakarina.jpg");

        b3.setIsbn(UUID.randomUUID().toString());
        b3.setName("Suc ve Ceza");
        b3.setDescription("Dostoyevski wrote in 1866.");
        b3.setPublishedDate(LocalDate.of(1866,5,20));
        b3.setAddedDate(LocalDate.of(1900,10,12));
        b3.setPrice(160.00);
        b3.setCurrency("€");
        b3.setImageUrl("sucveceza.jpg");

        b4.setIsbn(UUID.randomUUID().toString());
        b4.setName("Karamazov Kardesler");
        b4.setDescription("Dostoyevski wrote in 1877.");
        b4.setPublishedDate(LocalDate.of(1880,10,12));
        b4.setAddedDate(LocalDate.of(1900,8,25));
        b4.setPrice(200.00);
        b4.setCurrency("$");
        b4.setImageUrl("karamazov.jpg");

        b5.setIsbn(UUID.randomUUID().toString());
        b5.setName("Son Kuslar");
        b5.setDescription("Sait Faik wrote in 1952.");
        b5.setPublishedDate(LocalDate.of(1952,5,11));
        b5.setAddedDate(LocalDate.of(1962,2,12));
        b5.setPrice(200.00);
        b5.setCurrency("₺");
        b5.setImageUrl("sonksular.jpg");

        b6.setIsbn(UUID.randomUUID().toString());
        b6.setName("Avare Yıllar");
        b6.setDescription("Orhan wrote in 1950.");
        b6.setPublishedDate(LocalDate.of(1950,10,12));
        b6.setAddedDate(LocalDate.of(1960,8,25));
        b6.setPrice(100.00);
        b6.setCurrency("₺");
        b6.setImageUrl("avareyillar.jpg");

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();
        List<Book> books4 = new ArrayList<>();

        books1.add(b1);
        books1.add(b2);
        books2.add(b3);
        books2.add(b4);
        books3.add(b5);
        books4.add(b6);

        a1.setRegisteredAuthorBook(books1);
        a2.setRegisteredAuthorBook(books2);
        a3.setRegisteredAuthorBook(books3);
        a4.setRegisteredAuthorBook(books4);

        c1.setBooks(books1);
        c1.setBooks(books2);
        c2.setBooks(books3);
        c2.setBooks(books4);

        b1.setCategory(c1);
        b2.setCategory(c1);
        b3.setCategory(c1);
        b4.setCategory(c1);
        b5.setCategory(c2);
        b6.setCategory(c2);

        categoryRepo.save(c1);
        categoryRepo.save(c2);

        authorRepo.save(a1);
        authorRepo.save(a2);
        authorRepo.save(a3);
        authorRepo.save(a4);

        bookRepo.save(b1);
        bookRepo.save(b2);
        bookRepo.save(b3);
        bookRepo.save(b4);






        Author authors = authorRepo.findAuthorByName("Orhan Kemal");
        System.out.println("*************************\n"+authors.getName()+"\n"+authors.getRegisteredAuthorBook()
        +"\n*************************");
        System.out.println("******************Books***************************");
        List<Book> books = (List<Book>) bookRepo.findAll();
        for (Book b:books){
            System.out.println(b);
        }
        System.out.println("Kitap Adına Gore Arama");
        Book bookByName =  bookRepo.findBookByName("Karamazov Kardesler");

        System.out.println(bookByName.getName()+" "+bookByName.getAuthors()+" "+bookByName.getCategory());

        List<Category> categories = (List<Category>) categoryRepo.findAll();
        System.out.println("Categories");
        for (Category c:categories) {
            System.out.println(c.getName());
        }

       /*
        System.out.println(c1);
        System.out.println(c2);
*/
    }

    private void firstProcess() {
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
        categoryRepo.save(category);
        System.out.println("Novel: ");
        System.out.println(category);
    }
}
