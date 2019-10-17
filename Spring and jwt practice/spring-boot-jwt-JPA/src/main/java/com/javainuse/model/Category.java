package com.javainuse.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    private String name;
}
