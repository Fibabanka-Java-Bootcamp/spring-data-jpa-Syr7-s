package org.kodluyoruz.repositories;

import org.kodluyoruz.entities.Orders;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface OrdersRepo extends CrudRepository<Orders,Integer> {
    Orders findByUser_Name(String userName);
}
