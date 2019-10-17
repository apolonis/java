package com.javainuse.repository;

import com.javainuse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//    List<Product> findByCategoryId(int id);
//    Product findByName(String name);
}
