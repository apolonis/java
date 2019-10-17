package com.javainuse.service;

import com.javainuse.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<Category> getOne (Integer id);

    List<Category> getAll();

    Optional<Category> create (Category category);

    Optional<Category> update (Category category);

    void delete (Integer id);
}
