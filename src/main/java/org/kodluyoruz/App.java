package org.kodluyoruz;

import org.kodluyoruz.services.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("org.kodluyoruz");
        appContext.refresh();

        UserService userService = (UserService) appContext.getBean("userService");
        userService.userOperations();

        CategoryService categoryService = (CategoryService) appContext.getBean("categoryService");
        categoryService.categoryOperations();

        OrdersService ordersService = (OrdersService) appContext.getBean("ordersService");
        ordersService.orderOperations();

      //  AuthorService authorService = (AuthorService) appContext.getBean("authorService");
      //  authorService.authorOperations();
        BookService bookService = (BookService) appContext.getBean("bookService");
        bookService.bookOperation();
        appContext.close();
    }
}
