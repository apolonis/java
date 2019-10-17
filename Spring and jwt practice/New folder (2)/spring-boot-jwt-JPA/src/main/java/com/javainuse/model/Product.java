package com.javainuse.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    private String name;

   // @ManyToOne/*(fetch = FetchType.LAZY,cascade = CascadeType.ALL)*/
   // @JoinColumn(name = "category_id", nullable = false)
   // @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
