package com.movieflix.controller;

import com.movieflix.entity.Category;
import com.movieflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    public final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }
    @PostMapping
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);

    }

    @GetMapping("/{id}")
    public Category getCategoryId(@PathVariable Long id) {
        Optional<Category> optionalCategory = categoryService.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleterCategoryID(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
