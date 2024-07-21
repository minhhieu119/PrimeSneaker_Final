/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;

import java.util.Date;

/**
 *
 * @author MSII
 */
public class SneakerDetail {
    private int sneakerId;
    private String sneakerCode;
    private String sneakerName;
    private long price;
    private int quantity;
    private String brand;
    private String category;
    private String material;
    private String sole;
    private String color;
    private float size;
    private Date created_at, update_at;
    private String created_by, updated_by;

    public SneakerDetail() {
    }

    public SneakerDetail(String sneakerCode, String sneakerName, long price, int quantity, String brand, String category, String material, String sole, String color, float size) {
        this.sneakerCode = sneakerCode;
        this.sneakerName = sneakerName;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.category = category;
        this.material = material;
        this.sole = sole;
        this.color = color;
        this.size = size;
    }

    public SneakerDetail(String sneakerCode, String sneakerName, long price, int quantity, String brand, String category, String material, String sole, String color, float size, Date created_at, Date update_at, String created_by, String updated_by) {
        this.sneakerCode = sneakerCode;
        this.sneakerName = sneakerName;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.category = category;
        this.material = material;
        this.sole = sole;
        this.color = color;
        this.size = size;
        this.created_at = created_at;
        this.update_at = update_at;
        this.created_by = created_by;
        this.updated_by = updated_by;
    }

    public int getSneakerId() {
        return sneakerId;
    }

    public void setSneakerId(int sneakerId) {
        this.sneakerId = sneakerId;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSole() {
        return sole;
    }

    public void setSole(String sole) {
        this.sole = sole;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    @Override
    public String toString() {
        return "SneakerDetail{" + "sneakerCode=" + sneakerCode + ", sneakerName=" + sneakerName + ", price=" + price + ", quantity=" + quantity + ", brand=" + brand + ", category=" + category + ", material=" + material + ", sole=" + sole + ", color=" + color + ", size=" + size + ", created_at=" + created_at + ", update_at=" + update_at + ", created_by=" + created_by + ", updated_by=" + updated_by + '}';
    }
    
   
    
    
}
