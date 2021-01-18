package org.kodluyoruz.repositories;

import org.kodluyoruz.entities.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<Orders,Integer> {
}
