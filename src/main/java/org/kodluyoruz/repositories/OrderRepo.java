package org.kodluyoruz.repositories;

import org.kodluyoruz.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order,Integer> {
}
