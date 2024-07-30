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
    private long totalCost;

    public Statistic() {
    }

    public Statistic(Date createdAt, long totalCost) {
        this.createdAt = createdAt;
        this.totalCost = totalCost;
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
