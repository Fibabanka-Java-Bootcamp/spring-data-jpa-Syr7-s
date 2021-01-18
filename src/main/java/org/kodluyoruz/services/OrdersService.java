package org.kodluyoruz.services;

import org.kodluyoruz.entities.Address;
import org.kodluyoruz.entities.Orders;
import org.kodluyoruz.entities.User;
import org.kodluyoruz.repositories.OrdersRepo;
import org.kodluyoruz.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class OrdersService {
    private final OrdersRepo ordersRepo;
    private final UserRepo userRepo;

    public OrdersService(OrdersRepo ordersRepo, UserRepo userRepo) {
        this.ordersRepo = ordersRepo;
        this.userRepo = userRepo;
    }

    public void orderOperations(){
        User user  = new User();

        user.setName("Isa");
        Address address = new Address();
        address.setStreet("Gazo sokak");
        address.setNumber("7");
        address.setCity("Istanbul");
        user.setAddress(address);
        userRepo.save(user);

        Orders orders = new Orders();

        orders.setCreatedAt(LocalDate.of(2020,8,25));
        orders.setUser(user);
        orders.setTotal(24.45);
        ordersRepo.save(orders);

        System.out.println(orders);
    }
}
