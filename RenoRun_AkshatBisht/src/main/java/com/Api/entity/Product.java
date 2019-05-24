package com.Api.entity;


public class Product {

    private int product_id;
    private String name;
    private String description;
    private Double price;

    public Product(int product_id, String name, String description, Double price) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Product(){}

    public int getProduct_id() { return product_id;}

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }






}
