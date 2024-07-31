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
public class Statistic {
    private Date createdAt;
    private int month;
    private int date;
    private long totalCost;
    private Integer quantity;

    public Statistic() {
    }

    public Statistic(Date createdAt, long totalCost) {
        this.createdAt = createdAt;
        this.totalCost = totalCost;
    }

    public Statistic(Date createdAt, long totalCost, Integer quantity) {
        this.createdAt = createdAt;
        this.totalCost = totalCost;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
    
    

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Statistic{" + "createdAt=" + createdAt + ", totalCost=" + totalCost + '}';
    }
    
    
}
