package org.kodluyoruz.controller;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.entities.Book;
import org.kodluyoruz.entities.Category;
import org.kodluyoruz.services.BookService;
import org.kodluyoruz.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/bookHome",method = RequestMethod.GET)
    public String getBookHome(){
        bookService.bookOperation();
        return "İlk kitap kayıtları olusturuldu.";
    }

    @RequestMapping(value = "/addBook",method = RequestMethod.GET)
    public String addBook(){
        Author author = new Author();
        author.setName("Charlotte Bronte");

        Category category = categoryService.getCategory("Novel");
        //String categoryName = category.getName();

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

    @RequestMapping(value = "/{bookName}",method = RequestMethod.GET)
    public String getBookByBookName(@PathVariable("bookName") String bookName){
        Book book = bookService.getBookByBookName(bookName);
        System.out.println(book.getName()+"\n"+book.getAuthors());
        return book.getName()+" adlı kitap getirildi.";
    }

    @RequestMapping(value = "/addNewBook",method = RequestMethod.GET)
    public String getNewBook(){
        bookService.oneBookIsMoreThanOneAuthor();
        return "Bir kitabın birden fazla yazarı olabilir.";
    }
}
