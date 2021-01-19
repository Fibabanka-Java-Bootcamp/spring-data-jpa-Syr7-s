package org.kodluyoruz.repositories;

import org.kodluyoruz.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,String> {
}
