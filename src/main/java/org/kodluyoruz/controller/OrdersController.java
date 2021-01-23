package org.kodluyoruz.controller;

import org.kodluyoruz.entities.Address;
import org.kodluyoruz.entities.Book;
import org.kodluyoruz.entities.Orders;
import org.kodluyoruz.entities.User;
import org.kodluyoruz.services.BookService;
import org.kodluyoruz.services.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersService ordersService;

    private final BookService bookService;

    public OrdersController(OrdersService ordersService, BookService bookService) {
        this.ordersService = ordersService;
        this.bookService = bookService;
    }

    @GetMapping("/home")
    public String getOrdersHome() {
        ordersService.orderOperations();
        return "Orders is getting.";
    }

    @GetMapping("/newOrder")
    public String newOrders() {
        ordersService.orderBookFromUser();
        return "The order is being placed.";
    }

    @GetMapping("/newOrder1")
    public String getOrderBook() {
        User user = new User();
        user.setName("Ahmet");

        Address address = new Address();
        address.setStreet("Ataturk Street");
        address.setNumber("57");
        address.setCity("Istanbul");
        user.setAddress(address);

        Book book = bookService.getBookByBookName("Jane Eyre");
        if (book != null) {
            List<Book> books = new ArrayList<>();
            books.add(book);

            Orders orders = new Orders();

            orders.setCreatedAt(LocalDate.now());
            orders.setUser(user);
            orders.setRegisteredOrderBook(books);
            orders.setTotal(20.00);

            ordersService.newOrderBook(user, orders);

            return user.getName() + " named user have a order.";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ordered books are not in the records.");
    }

    @GetMapping("/order/{userName}")
    public String getOrderByUserName(@PathVariable("userName") String userName) {
        Orders order = ordersService.getOrder(userName);
        if (order != null) {
            System.out.println(order);
            return userName + " named user order.";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The order is not found");
    }

    @GetMapping("/orders")
    public String getAllOrders() {
        List<Orders> ordersList = ordersService.getAllOrders();
        if (!ordersList.isEmpty()) {
            System.out.println("All Orders");
            Arrays.stream(ordersList.toArray()).forEach(System.out::println);
            return "All orders have been brought";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "OrdersList is empty.");

    }
}
