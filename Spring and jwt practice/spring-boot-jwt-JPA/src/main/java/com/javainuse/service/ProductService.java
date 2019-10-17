package com.javainuse.service;

import com.javainuse.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getOne (Integer id);

    List<Product> getAll();

    Optional<Product> create (Product product);

    Optional<Product> update (Product product);

    void delete (Integer id);
}
