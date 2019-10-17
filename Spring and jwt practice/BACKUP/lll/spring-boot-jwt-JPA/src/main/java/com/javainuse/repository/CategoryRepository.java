package com.javainuse.repository;

import com.javainuse.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

   Category findById(int id);

    List<Category> findAllById(int id);
}
