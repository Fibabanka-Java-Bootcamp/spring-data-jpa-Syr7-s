package org.kodluyoruz;

import org.kodluyoruz.services.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("org.kodluyoruz");
        appContext.refresh();

        UserService userService = (UserService) appContext.getBean("userService");
        userService.userOperations();

        CategoryService categoryService = (CategoryService) appContext.getBean("categoryService");
        categoryService.categoryOperations();

        BookService bookService = (BookService) appContext.getBean("bookService");
        bookService.bookOperation();

        OrdersService ordersService = (OrdersService) appContext.getBean("ordersService");
        ordersService.orderOperations();

        ordersService.orderBookFromUser();
        //  AuthorService authorService = (AuthorService) appContext.getBean("authorService");
        //  authorService.authorOperations();

        appContext.close();
    }
}
