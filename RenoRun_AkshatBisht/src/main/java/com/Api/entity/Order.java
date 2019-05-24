package com.Api.entity;

import javax.persistence.*;

public class Order {
    @Id
    private int order_id;
    private int product_id;
    private String color;
    private String email;

    /*Order(int order_id,int product_id, String color,String email){
        this.order_id=order_id;
        this.product_id=product_id;
        this.color=color;
        this.email=email;
    }*/

    @ManyToOne
    @JoinColumn
    private Product product;

    public Order(){}

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id=product_id;
    }

    public int getorder_id() {
        return order_id;
    }

    public void setorder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
