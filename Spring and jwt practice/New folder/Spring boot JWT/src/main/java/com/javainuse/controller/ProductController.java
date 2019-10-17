package com.javainuse.controller;

import com.javainuse.dao.CategoryRepository;
import com.javainuse.dao.ProductRepository;
import com.javainuse.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Return all products //
    @GetMapping
    public List<Product> index(){
        return (List<Product>) productRepository.findAll();
    }

    //        // Add Products //
//        @PostMapping
//        public Product create(@RequestBody ProductPostDTO product){
//
//            Product product1 = new Product();
//            product1.setName(product.getName());
//
//            Category category = categoryRepository.findById(product.getCategoryId());
//
//            product1.setCategory(category);
//
//            productRepository.save(product1);
//            return product1;
//        }

//        @GetMapping("/getAllByCategory/{id}")
//        public List<Product> getAllByCatId(@PathVariable int id){
//                return productRepository.findByCategoryId(id);
//            }


//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable int id){
//        productRepository.deleteById(id);
//        return "Product deleted";
//    }
//    @DeleteMapping("/cat/{id}")
//    public void deleteCatId(@PathVariable int id){
//        List<Product> productList = productRepository.findByCategoryId(id);
//        for(int i=0; i<productList.size(); i++){
//            productRepository.delete(productList.get(i));
//        }
//    }

//    @GetMapping("/name/{name}")
//    public Product findName(@PathVariable String name){
//            return productRepository.findByName(name);
//    }

}
