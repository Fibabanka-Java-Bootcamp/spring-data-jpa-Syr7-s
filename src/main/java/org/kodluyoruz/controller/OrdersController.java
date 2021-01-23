package org.kodluyoruz.controller;

import org.kodluyoruz.entities.Address;
import org.kodluyoruz.entities.Book;
import org.kodluyoruz.entities.Orders;
import org.kodluyoruz.entities.User;
import org.kodluyoruz.services.BookService;
import org.kodluyoruz.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/ordersHome", method = RequestMethod.GET)
    public String getOrdersHome() {
        ordersService.orderOperations();
        return "Orders is getting.";
    }

    @RequestMapping(value = "/ordersAdd", method = RequestMethod.GET)
    public String newOrders() {
        ordersService.orderBookFromUser();
        return "The order is being placed.";
    }

    @RequestMapping(value = "/orderBook", method = RequestMethod.GET)
    public String getOrderBook() {
        User user = new User();
        user.setName("Timur");

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
        }throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Ordered books are not in the records.");/* else {
            return "Ordered books are not in the records.";
        }*/
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public String getOrderByUserName(@PathVariable("userName") String userName) {
        Orders order = ordersService.getOrder(userName);
        if (order != null) {
            System.out.println(order);
            return userName + " named user order.";
        }throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The order is not found");//return "The order is not found";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getAllOrders() {
        List<Orders> ordersList = ordersService.getAllOrders();
        if (!ordersList.isEmpty()) {
            System.out.println("All Orders");
            Arrays.stream(ordersList.toArray()).forEach(System.out::println);
            return "All orders have been brought";
        }throw new ResponseStatusException(HttpStatus.NOT_FOUND,"OrdersList is empty.");//return "OrdersList is empty";

    }
}
