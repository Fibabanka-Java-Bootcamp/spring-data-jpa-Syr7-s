package org.kodluyoruz.services;


import org.kodluyoruz.entities.Category;
import org.kodluyoruz.repositories.CategoryRepo;
import org.springframework.stereotype.Component;
import org.kodluyoruz.entities.Book;
import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;
import java.util.List;
@Component
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void categoryOperations() {

        Book b1 = new Book();
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Spring in Action");
        b1.setDescription("This book about Spring");
        b1.setPublishedDate(LocalDate.of(1998,8,10));
        b1.setAddedDate(LocalDate.of(2002,10,15));
        b1.setPrice(150.45);
        b1.setCurrency("₺");
        b1.setImageUrl("image1.jpg");

        Category c1 = new Category();
        c1.setName("Computer Science");
        c1.setBooks(Collections.singletonList(b1));

        categoryRepo.save(c1);
        System.out.println(c1);
    }
    public void categoryAddToTheDatabase(){
        Book b2 = new Book();
        b2.setIsbn(UUID.randomUUID().toString());
        b2.setName("Araba Sevdası");
        b2.setDescription("This book a turkish novel.");
        b2.setPublishedDate(LocalDate.of(1898,8,10));
        b2.setAddedDate(LocalDate.of(2001,10,15));
        b2.setPrice(151.45);
        b2.setCurrency("₺");
        b2.setImageUrl("arabasevdasi.jpg");

        Category c2 = new Category();
        c2.setName("Turkish Novel");
        c2.setBooks(Collections.singletonList(b2));

        categoryRepo.save(c2);
        System.out.println(c2);
    }

    public Category getCategory(String name){
        return categoryRepo.findByName(name);
    }
    public List<Category> getAllCategory(){
        return (List<Category>) categoryRepo.findAll();
    }
}
