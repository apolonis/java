package com.javainuse.repository;

import com.javainuse.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

 //   Category findById(int id);

}
