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
public class Order {
    private int orderId;
    private int userId;
    private String orderQrCode;
    private String userName;
    private String customerName;
    private String voucherName;
    private int paymentMethod;
    private long totalCost, receivedCash, change;
    private int quantity;
    private String status;
    private String note;
    private Date created_at, update_at;
    private String created_by, updated_by;

    public Order() {
    }

    public Order(int orderId, int userId, int quantity, String status, Date created_at) {
        this.orderId = orderId;
        this.userId = userId;
        this.quantity = quantity;
        this.status = status;
        this.created_at = created_at;
    }
    
    

    public Order(int userId, String orderQrCode, String userName, String customerName, String voucherName, int paymentMethod, long totalCost, long receivedCash, long change, String status, String note) {
        this.userId = userId;
        this.orderQrCode = orderQrCode;
        this.userName = userName;
        this.customerName = customerName;
        this.voucherName = voucherName;
        this.paymentMethod = paymentMethod;
        this.totalCost = totalCost;
        this.receivedCash = receivedCash;
        this.change = change;
        this.status = status;
        this.note = note;
    }

    public Order(int userId, String orderQrCode, String userName, String customerName, String voucherName, int paymentMethod, long totalCost, long receivedCash, long change, String status, String note, Date created_at, Date update_at, String created_by, String updated_by) {
        this.userId = userId;
        this.orderQrCode = orderQrCode;
        this.userName = userName;
        this.customerName = customerName;
        this.voucherName = voucherName;
        this.paymentMethod = paymentMethod;
        this.totalCost = totalCost;
        this.receivedCash = receivedCash;
        this.change = change;
        this.status = status;
        this.note = note;
        this.created_at = created_at;
        this.update_at = update_at;
        this.created_by = created_by;
        this.updated_by = updated_by;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderQrCode() {
        return orderQrCode;
    }

    public void setOrderQrCode(String orderQrCode) {
        this.orderQrCode = orderQrCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    public long getReceivedCash() {
        return receivedCash;
    }

    public void setReceivedCash(long receivedCash) {
        this.receivedCash = receivedCash;
    }

    public long getChange() {
        return change;
    }

    public void setChange(long change) {
        this.change = change;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
    
    
    
    
}
