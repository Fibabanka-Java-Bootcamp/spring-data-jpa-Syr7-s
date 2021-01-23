package org.kodluyoruz.controller;

import org.kodluyoruz.entities.Category;
import org.kodluyoruz.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/home")
    public String getCategoryHome() {
        categoryService.categoryOperations();
        return "Category Operation is running";
    }

    @GetMapping("/newCategory")
    public String addCategory() {
        categoryService.categoryAddToTheDatabase();
        return "New category was added";
    }

    @GetMapping
    public String getCategory(@RequestParam("name") String name) {
        Category category = categoryService.getCategory(name);
        if (category != null) {
            System.out.println(category);
            return category.getName() + " named category was received";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, name + " named category is not found");
    }

    @GetMapping(value = "/categories")
    public String getAllCategory() {
        List<Category> categoryList = categoryService.getAllCategory();
        if (!categoryList.isEmpty()) {
            System.out.println("All categories are getting.");
            Arrays.stream(categoryList.toArray()).forEach(System.out::println);
            return "All categories have been brought.";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CategoryList is empty");
    }
}
