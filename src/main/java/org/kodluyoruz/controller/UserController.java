package org.kodluyoruz.controller;

import org.kodluyoruz.entities.User;
import org.kodluyoruz.services.BookService;
import org.kodluyoruz.services.CategoryService;
import org.kodluyoruz.services.OrdersService;
import org.kodluyoruz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userProcess")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookService bookService;
    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        userService.userOperations();

        //categoryService.categoryOperations();


        bookService.bookOperation();


        ordersService.orderOperations();

        ordersService.orderBookFromUser();
        return "Veritabanı Islemleri Yapıldı.";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    private String addUser() {
        userService.userAddToTheDatabase();
        return "User veritabanına eklendi.";
    }

    @RequestMapping(value = "/userGet/{name}", method = RequestMethod.GET)
    private String getUserByName(@PathVariable("name") String name) {
        User user = userService.getUser(name);
        System.out.println(user);
        return "User getirildi.";
    }

    @RequestMapping(value = "/allUser",method = RequestMethod.GET)
    private String getAllUser() {
        List<User> users = userService.getAllUsers();
        System.out.println(users);
        return "Tum kullanıcılar getirildi.";
    }
}
