package com.javainuse.model;

public class ProductPostDTO  {
    private String name;
    private int categoryId;

    public ProductPostDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
