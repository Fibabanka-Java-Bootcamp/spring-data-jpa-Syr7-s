package com.syrisa.services;

import com.syrisa.entities.Address;
import com.syrisa.entities.User;
import com.syrisa.repositories.UserRepo;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public void userOperations() {
        User u = new User();
        u.setName("user");

        Address address = new Address();
        address.setStreet("Gazo sokak");
        address.setNumber("7");
        address.setCity("Istanbul");

        u.setAddress(address);

        repo.save(u);

        System.out.println(u.getId());

        System.out.println(repo.findAllByNameContainingIgnoreCase("se"));
    }
}
