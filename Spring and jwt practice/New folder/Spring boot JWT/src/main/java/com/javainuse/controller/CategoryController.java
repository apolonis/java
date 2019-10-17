package com.javainuse.controller;

import com.javainuse.dao.CategoryRepository;
import com.javainuse.dao.ProductRepository;
import com.javainuse.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    // Return all categories //
    @GetMapping
    public List<Category> index(){
        return (List<Category>) categoryRepository.findAll();
    }

    // Add Category //
//    @PostMapping
//    public Category create(@RequestBody Category cat){
//        categoryRepository.save(cat);
//        return cat;
//    }
//
//    @GetMapping("/{id}")
//    public Category getById(@PathVariable int id){
//        Category category = categoryRepository.findById(id);
//        return category;
//    }

}
