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
public class Voucher {
    private String voucherCode;
    private String voucherName;
    private double discountRate;
    private long discountAmount;
    private double maxDiscount;
    private long minOrderValue;
    private int quantity;
    private Date startDate, endDate;
    private Date created_at, updated_at;
    private String created_by, updated_by;

    public Voucher() {
    }

    public Voucher(String voucherName) {
        this.voucherName = voucherName;
    }

    public Voucher(String voucherCode, String voucherName, double discountRate, long discountAmount, double maxDiscount, long minOrderValue, int quantity, Date startDate, Date endDate, Date created_at, Date updated_at, String created_by, String updated_by) {
        this.voucherCode = voucherCode;
        this.voucherName = voucherName;
        this.discountRate = discountRate;
        this.discountAmount = discountAmount;
        this.maxDiscount = maxDiscount;
        this.minOrderValue = minOrderValue;
        this.quantity = quantity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.created_by = created_by;
        this.updated_by = updated_by;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public long getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(long discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public long getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(long minOrderValue) {
        this.minOrderValue = minOrderValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
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
    
    
}
