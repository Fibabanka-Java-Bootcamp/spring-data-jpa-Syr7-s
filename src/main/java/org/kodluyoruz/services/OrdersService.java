package org.kodluyoruz.services;

import org.kodluyoruz.entities.Address;
import org.kodluyoruz.entities.Book;
import org.kodluyoruz.entities.Orders;
import org.kodluyoruz.entities.User;
import org.kodluyoruz.repositories.BookRepo;
import org.kodluyoruz.repositories.OrdersRepo;
import org.kodluyoruz.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
public class OrdersService {
    private final OrdersRepo ordersRepo;
    private final UserRepo userRepo;
    private final BookRepo bookRepo;

    public OrdersService(OrdersRepo ordersRepo, UserRepo userRepo, BookRepo bookRepo) {
        this.ordersRepo = ordersRepo;
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    public void orderOperations() {
        User user = new User();

        user.setName("Isa");
        Address address = new Address();
        address.setStreet("Gazo sokak");
        address.setNumber("7");
        address.setCity("Istanbul");
        user.setAddress(address);
        userRepo.save(user);

        Orders orders = new Orders();

        orders.setCreatedAt(LocalDate.of(2020, 8, 25));
        orders.setUser(user);
        orders.setTotal(24.45);
        ordersRepo.save(orders);

        System.out.println(orders);
    }

    public void orderBookFromUser() {
        Book book = bookRepo.findBookByName("Savas ve Baris");
        Book book1 = bookRepo.findBookByName("Karamazov Kardesler");
        if (book != null && book1 !=null){
            List<Book> books  = new ArrayList<>();
            User user = new User();
            user.setName("Mehmet");

            Address address = new Address();
            address.setStreet("Palmiye Street");
            address.setNumber("57");
            address.setCity("Istanbul");
            user.setAddress(address);

            userRepo.save(user);

            books.add(book);
            books.add(book1);
            Orders orders = new Orders();

            orders.setCreatedAt(LocalDate.of(2021,1,19));
            orders.setUser(user);
            orders.setRegisteredOrderBook(books);
            orders.setTotal(25.00);

            ordersRepo.save(orders);

            Orders orders1 = ordersRepo.findByUser_Name("Mehmet");
            System.out.println("Mehmet adlı kullanıcının Kitap Siparisleri");
            System.out.println(orders1.getRegisteredOrderBook());

        }

    }
    public void newOrderBook(User user, Orders orders){
        userRepo.save(user);
        ordersRepo.save(orders);
    }
    public Orders getOrder(String userName){
        return ordersRepo.findByUser_Name(userName);
    }
    public List<Orders> getAllOrders(){
        return (List<Orders>) ordersRepo.findAll();
    }
}
