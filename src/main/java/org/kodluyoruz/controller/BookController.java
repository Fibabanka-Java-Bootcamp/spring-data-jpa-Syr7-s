package org.kodluyoruz.controller;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.entities.Book;
import org.kodluyoruz.entities.Category;
import org.kodluyoruz.services.BookService;
import org.kodluyoruz.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;
import java.util.List;
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    private final CategoryService categoryService;

    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping("/home")
    public String getBookHome(){
        bookService.bookOperation();
        return "First book records were created.";
    }

    @GetMapping("/newBook")
    public String addBook(){
        Author author = new Author();
        author.setName("Charlotte Bronte");

        Category category = categoryService.getCategory("Novel");

        Book book = new Book();
        book.setIsbn(UUID.randomUUID().toString());
        book.setName("Jane Eyre");
        book.setDescription("Charlotte Bronte wrote in 1847.");
        book.setPublishedDate(LocalDate.of(1847, 1, 11));
        book.setAddedDate(LocalDate.of(2005, 12, 6));
        book.setPrice(50.00);
        book.setCurrency("$");
        book.setImageUrl("janeeyre.jpg");
        book.setCategory(category);
        bookService.addBook(author,book);

        return "Book is save";
    }

    @GetMapping()
    public String getBookByBookName(@RequestParam("bookName") String bookName){
        Book book = bookService.getBookByBookName(bookName);
        if (book != null){
            System.out.println("All books are getting.");
            System.out.println(book.getName()+"\n"+book.getAuthors());
            return book.getName()+" named book was received.";
        }throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The book is not found.");

    }

    @GetMapping("/newBook1")
    public String getNewBook(){
        bookService.oneBookIsMoreThanOneAuthor();
        return "A book can have more than one author.";
    }

    @GetMapping("/books")
    public String getAllBooks(){
        List<Book> bookList = bookService.getAllBooks();
        if (!bookList.isEmpty()) {
            Arrays.stream(bookList.toArray()).forEach(System.out::println);
            return "All books have been brought.";
        }throw new ResponseStatusException(HttpStatus.NOT_FOUND,"BookList is empty.");

    }
}
