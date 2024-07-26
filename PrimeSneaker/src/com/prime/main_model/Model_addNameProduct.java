/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;

/**
 *
 * @author tt
 */
public class Model_addNameProduct {
    private int product_id;
    private String product_name;

    public Model_addNameProduct() {
    }

    public Model_addNameProduct(int product_id, String product_name) {
        this.product_id = product_id;
        this.product_name = product_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return product_name;
    }
    
}
