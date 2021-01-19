package org.kodluyoruz.repositories;

import org.kodluyoruz.entities.Author;
import org.kodluyoruz.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book,String> {
    Book findBookByName(String name);
}
