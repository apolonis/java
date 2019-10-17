package com.javainuse.controller;


import com.javainuse.model.Product;
import com.javainuse.repository.CategoryRepository;
import com.javainuse.model.Category;
import com.javainuse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @PostMapping
    public Category create(@RequestBody Category cat){
        categoryRepository.save(cat);
        return cat;
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id){
        Category category = categoryRepository.findById(id);
        return category;
    }

    @DeleteMapping("/cat/{id}")
    public void deleteCatId(@PathVariable int id){
        List<Product> productList = productRepository.findByCategoryId(id);

        for(int i=0; i<productList.size(); i++){
            productRepository.delete(productList.get(i));
        }
        categoryRepository.deleteById(id);
    }

//    @DeleteMapping("/delete/{id}")
//    public void deleteByCategoryId(@PathVariable int id){
//
//        List<Product> productList = productRepository.findByCategoryId(id);
//
//        List<Category> categoryList = categoryRepository.findAllById(id);
//
//        //Category category = categoryRepository.findById(id);
//
//        for(int j=0; j<categoryList.size(); j++){
//
//            categoryRepository.delete(categoryList.get(j));
////            if(category.getId().equals(categoryList.get(j).getParent_id())){
////                categoryRepository.delete(category);
////            }
//        }
//
//        for(int i=0; i<productList.size(); i++){
//            productRepository.delete(productList.get(i));
//        }




   // }
   @DeleteMapping("/categ/{id}")
   public void deleteCatIdPar(@PathVariable int id){
       List<Product> productList = new ArrayList<>();
       List<Category> categoryList = categoryRepository.findAll();

//       for(int i=0; i<productList.size(); i++){
//           productRepository.delete(productList.get(i));
//       }

       for (int i=0; i<categoryList.size(); i++){
           if(categoryList.get(i).getParent_id()==id){
                productList = productRepository.findByCategoryId(categoryList.get(i).getId());
               for(int j=0; j<productList.size(); j++){
                   productRepository.delete(productList.get(j));
               }

               categoryRepository.delete(categoryList.get(i));
           }
       }

       categoryRepository.deleteById(id);
   }

//    @GetMapping("/vrati/{id}")
//    public List<Category> vratiIh(@PathVariable int id){
//        List<Category> categoryList = categoryRepository.findAll();
//        List<Category> categVrati = new ArrayList<>();
//        for (int i=0; i<categoryList.size(); i++){
//            if(categoryList.get(i).getParent_id()==id){
//                categVrati.add(categoryList.get(i));
//              }
//        }
//        return  categVrati;
//    }
//    @GetMapping("/vratinamprod/{id}")
//    public List<Product> vratiIhSvi(@PathVariable int id) {
//        List<Product> productList = new ArrayList<>();
//        List<Product> productList2 = new ArrayList<>();
//        List<Category> categoryList = categoryRepository.findAll();
//        for (int i = 0; i < categoryList.size(); i++) {
//            if (categoryList.get(i).getParent_id() == id) {
//                productList = productRepository.findByCategoryId(categoryList.get(i).getId());
//                for (int j = 0; j < productList.size(); j++) {
//                   productList2.add(productList.get(j));
//                }
//
//            }
//
//        }
//        return productList2;
//    }
}
