package org.kodluyoruz.controller;

import org.kodluyoruz.entities.User;
import org.kodluyoruz.services.BookService;
import org.kodluyoruz.services.CategoryService;
import org.kodluyoruz.services.OrdersService;
import org.kodluyoruz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        userService.userOperations();
        return "First user record was created.";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    private String addUser() {
        userService.userAddToTheDatabase();
        return "User was added to the database.";
    }

    @RequestMapping(value = "/userGet/{name}", method = RequestMethod.GET)
    private String getUserByName(@PathVariable("name") String name) {
        User user = userService.getUser(name);
        if (user != null) {
            System.out.println(user);
            return name + " named user was received.";
        }
        return name + " named user is not found.";

    }

    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    private String getAllUser() {
        List<User> userList = userService.getAllUsers();
        if (!userList.isEmpty()) {
            Arrays.stream(userList.toArray()).forEach(System.out::println);
            return "All users have been brought";
        }
        return "UserList is empty";

    }
}
