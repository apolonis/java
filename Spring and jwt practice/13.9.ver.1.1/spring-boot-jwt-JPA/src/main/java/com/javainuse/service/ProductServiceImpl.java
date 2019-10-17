package com.javainuse.service;

import com.javainuse.model.Product;
import com.javainuse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> getOne(Integer id) {
        return Optional.of(productRepository.getOne(id));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> create(Product product) {
        return Optional.of(productRepository.save(product));
    }

    @Override
    public Optional<Product> update(Product product) {
        return Optional.of(productRepository.save(product));
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
