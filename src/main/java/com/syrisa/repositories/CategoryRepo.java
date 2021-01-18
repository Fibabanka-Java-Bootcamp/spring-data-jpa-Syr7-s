package com.syrisa.repositories;

import com.syrisa.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {

}
