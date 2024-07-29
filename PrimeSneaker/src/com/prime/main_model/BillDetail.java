/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class BillDetail {

    private int order_Id;
    private String productName;
    private String sneakerDetailCode;
    private int quantity;
    private BigDecimal price;

    public BillDetail() {
    }

    public BillDetail(int order_Id, String productName, int quantity, BigDecimal price) {
        this.order_Id = order_Id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public BillDetail(int order_Id, String productName, String sneakerDetailCode, int quantity, BigDecimal price) {
        this.order_Id = order_Id;
        this.productName = productName;
        this.sneakerDetailCode = sneakerDetailCode;
        this.quantity = quantity;
        this.price = price;
    }
    
    

    public int getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public String getSneakerDetailCode() {
        return sneakerDetailCode;
    }

    public void setSneakerDetailCode(String sneakerDetailCode) {
        this.sneakerDetailCode = sneakerDetailCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
