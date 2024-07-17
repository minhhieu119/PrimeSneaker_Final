/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;

/**
 *
 * @author MSII
 */
public class SneakerCart {
    private String sneakerCode;
    private String sneakerName;
    private int quantity;
    private long price;
    private String brand;
    private String color;
    private float size;

    public SneakerCart() {
    }

    public SneakerCart(String sneakerCode, String sneakerName, int quantity, long price, String brand, String color, float size) {
        this.sneakerCode = sneakerCode;
        this.sneakerName = sneakerName;
        this.quantity = quantity;
        this.price = price;
        this.brand = brand;
        this.color = color;
        this.size = size;
    }

    public String getSneakerCode() {
        return sneakerCode;
    }

    public void setSneakerCode(String sneakerCode) {
        this.sneakerCode = sneakerCode;
    }

    public String getSneakerName() {
        return sneakerName;
    }

    public void setSneakerName(String sneakerName) {
        this.sneakerName = sneakerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
    
    
    
    
}
