package org.kodluyoruz.repositories;

import com.sun.xml.bind.v2.model.core.ID;
import org.kodluyoruz.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, ID> {
}
