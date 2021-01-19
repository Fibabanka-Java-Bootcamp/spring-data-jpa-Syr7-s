package org.kodluyoruz.repositories;

import org.kodluyoruz.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author,Integer> {
}
