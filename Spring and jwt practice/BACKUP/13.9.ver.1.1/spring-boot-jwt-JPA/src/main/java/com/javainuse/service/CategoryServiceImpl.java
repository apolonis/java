package com.javainuse.service;

import com.javainuse.model.Category;
import com.javainuse.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> getOne(Integer id) {
        return Optional.of(categoryRepository.getOne(id));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> create(Category category) {

        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public Optional<Category> update(Category category) {

        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
