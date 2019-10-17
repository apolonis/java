package com.javainuse.controller;

import com.javainuse.dto.ProductGetDTO;
import com.javainuse.dto.ProductPostDTO;
import com.javainuse.model.Category;
import com.javainuse.model.Product;
import com.javainuse.repository.ProductRepository;
import com.javainuse.service.CategoryService;
import com.javainuse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products/")
    public class ProductController {

        private ProductService productService;
        private CategoryService categoryService;
        private ModelMapper modelMapper;
        private ProductRepository productRepository;

        @Autowired
        public ProductController(ProductService productService,
                                 ModelMapper modelMapper,
                                 CategoryService categoryService,
                                 ProductRepository productRepository) {
            this.productService = productService;
            this.modelMapper = modelMapper;
            this.categoryService = categoryService;
            this.productRepository = productRepository;
        }

    //Return products by id
    @GetMapping("/{id}")
    public HttpEntity getById(@PathVariable int id) {

        Optional<Product> optional = productService.getOne(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modelMapper.map(optional.get(), ProductGetDTO.class));
    }

    // Return all products //
    @GetMapping
    public List<Product> index() {
        List<Product> optional = productService.getAll();


        return productService.getAll();
    }

    // Add product //
    @PostMapping
    public HttpEntity create(@RequestBody ProductPostDTO productPostDTO) {

        Product mapped = modelMapper.map(productPostDTO, Product.class);
        mapped.setId(null);

        Optional<Category> optionalCategory = categoryService.getOne(productPostDTO.getCategoryId());;

        if (!optionalCategory.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        mapped.setCategory(optionalCategory.get());

        Optional<Product> optional = productService.create(mapped);

        return optional.<HttpEntity>map(p -> ResponseEntity.created(URI.create("/api/products/"))
                .body(modelMapper.map(p, ProductGetDTO.class)))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    //Show products by category id
    @GetMapping("/productsByCategoryId/{id}")
    public List<Product> vrati(@PathVariable int id){

        return productRepository.findByCategoryId(id);

    }

    //Update product by id
    @PutMapping("/update/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product){

            Product foundProductById = productRepository.findById(id);
            foundProductById.setName(product.getName());
            foundProductById.setCategory(product.getCategory());

            return foundProductById;

    }


}


