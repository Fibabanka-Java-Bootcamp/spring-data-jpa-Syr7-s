package org.kodluyoruz.controller;

import org.kodluyoruz.entities.User;
import org.kodluyoruz.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHomePage() {
        userService.userOperations();
        return "First user record was created.";
    }

    @GetMapping("/newUser")
    private String addUser() {
        userService.userAddToTheDatabase();
        return "User was added to the database.";
    }

    @GetMapping
    private String getUserByName(@RequestParam("name") String name) {
        User user = userService.getUser(name);
        if (user != null) {
            System.out.println(user);
            return name + " named user was received.";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, name + " named user is not found");

    }

    @GetMapping("/users")
    private String getAllUser() {
        List<User> userList = userService.getAllUsers();
        if (!userList.isEmpty()) {
            Arrays.stream(userList.toArray()).forEach(System.out::println);
            return "All users have been brought";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UserList is empty");
    }
}
