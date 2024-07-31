/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class VoucherAq {
//    private int id;

    private String voucherCode;
    private String voucherName;
    private boolean voucherType;
    private int voucherValue;
    private int quantity;
    private String status;
    private float maxDiscount;
    private long minOrderValue;
    private Date startDate;
    private Date endDate;

    public VoucherAq() {
    }

    public VoucherAq(String voucherCode, String voucherName, boolean voucherType, int voucherValue, int quantity, float maxDiscount, long minOrderValue, Date startDate, Date endDate) {
        this.voucherCode = voucherCode;
        this.voucherName = voucherName;
        this.voucherType = voucherType;
        this.voucherValue = voucherValue;
        this.quantity = quantity;
        this.maxDiscount = maxDiscount;
        this.minOrderValue = minOrderValue;
        this.startDate = startDate;
        this.endDate = endDate;
    }

//    public VoucherAq(String voucherCode, String voucherName, boolean voucherType, int voucherValue, int quantity, float maxDiscount, long minOrderValue, Date startDate, Date endDate) {
//        this.voucherCode = voucherCode;
//        this.voucherName = voucherName;
//        this.voucherType = voucherType;
//        this.voucherValue = voucherValue;
//        this.quantity = quantity;
//        this.maxDiscount = maxDiscount;
//        this.minOrderValue = minOrderValue;
//        this.startDate = startDate;
//        this.endDate = endDate;
//    }
//
//    
//
    public VoucherAq(String voucherCode, String voucherName, boolean voucherType, int voucherValue, int quantity, String status, float maxDiscount, long minOrderValue, Date startDate, Date endDate) {
        this.voucherCode = voucherCode;
        this.voucherName = voucherName;
        this.voucherType = voucherType;
        this.voucherValue = voucherValue;
        this.quantity = quantity;
        this.status = status;
        this.maxDiscount = maxDiscount;
        this.minOrderValue = minOrderValue;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public boolean isVoucherType() {
        return voucherType;
    }

    public void setVoucherType(boolean voucherType) {
        this.voucherType = voucherType;
    }

    public int getVoucherValue() {
        return voucherValue;
    }

    public void setVoucherValue(int voucherValue) {
        this.voucherValue = voucherValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public float getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(float maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public long getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(long minOrderValue) {
        this.minOrderValue = minOrderValue;
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

    @Override
    public String toString() {
        return "VoucherAq{" + "voucherCode=" + voucherCode + ", voucherName=" + voucherName + ", voucherType=" + voucherType + ", voucherValue=" + voucherValue + ", quantity=" + quantity + ", maxDiscount=" + maxDiscount + ", minOrderValue=" + minOrderValue + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }

    public String getTrangThaiByDate() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
    calendar.setTime(currentDate);
    calendar.add(Calendar.DATE,-1);
    Date tomorrow = calendar.getTime();

    if (quantity <= 0) {
        return "Hết hạn";
    } else if (endDate.before(tomorrow)) { // Nếu ngày kết thúc trước ngày mai thì chắc chắn là hết hạn
        return "Hết hạn";
    } else if (currentDate.before(startDate)) { // Nếu ngày hiện tại trước ngày bắt đầu thì sắp áp dụng
        return "Sắp áp dụng";
    } else { // Các trường hợp còn lại đều là "Đang áp dụng"
        return "Đang áp dụng";
    }
    }

}
