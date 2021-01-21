package org.kodluyoruz.services;

import org.kodluyoruz.entities.Address;
import org.kodluyoruz.entities.User;
import org.kodluyoruz.repositories.UserRepo;
import org.springframework.stereotype.Component;
import java.util.List;
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

    public void userAddToTheDatabase(){
        User u = new User();
        u.setName("Fatih");

        Address address = new Address();
        address.setStreet("Adnan Kahveci Sokagi");
        address.setNumber("57");
        address.setCity("Istanbul");
        address.setZipcode(12);

        u.setAddress(address);
        repo.save(u);
    }

    public User getUser(String name){
        return repo.findByName(name);
    }

    public List<User> getAllUsers(){
        return (List<User>) repo.findAll();
    }
}
