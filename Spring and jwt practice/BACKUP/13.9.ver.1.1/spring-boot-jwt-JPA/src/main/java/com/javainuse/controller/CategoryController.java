package com.javainuse.controller;


import com.javainuse.dto.CategoryGetDTO;
import com.javainuse.dto.CategoryPostDTO;
import com.javainuse.model.Category;
import com.javainuse.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

    private CategoryService categoryService;
    private ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    //Return category by id
    @GetMapping("/{id}")
    public HttpEntity getById(@PathVariable int id){

        Optional<Category> optional = categoryService.getOne(id);

        if (!optional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modelMapper.map(optional.get(), CategoryGetDTO.class));
    }

    // Return all categories //
    @GetMapping
    public List<Category> index(){
        return categoryService.getAll();
    }

    // Add Category //
    @PostMapping
    public HttpEntity create(@RequestBody CategoryPostDTO categoryPostDTO){

        Category mapped = modelMapper.map(categoryPostDTO, Category.class);

        Optional<Category> optional = categoryService.create(mapped);

        return optional.<HttpEntity>map(c -> ResponseEntity.created(URI.create("/api/categories/"))
        .body(modelMapper.map(c, CategoryGetDTO.class)))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));

//        return optional.<HttpEntity>map(a -> ResponseEntity.created(URI.create("/api/v1/applicants"))
//                .body(modelMapper.map(a, ApplicantGetModel.class)))
//                .orElseGet(() -> new ResponseEntity<>(new ErrorResponse(BAD_REQUEST), HttpStatus.BAD_REQUEST));


    }


}
