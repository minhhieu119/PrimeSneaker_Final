/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {

    private int order_Id;
    private String staff_id;
    private String voucher_id;
    private String nameCustomer;
    private String paymentMethod;
    private BigDecimal totalCost;
    private Date createdDay;

    public Bill() {
    }

    public Bill(int order_Id, String staff_id, String nameCustomer, String paymentMethod, Date createdDay, BigDecimal totalCost) {
        this.order_Id = order_Id;
        this.staff_id = staff_id;
        this.nameCustomer = nameCustomer;
        this.paymentMethod = paymentMethod;
        this.createdDay = createdDay;
    }

    public Bill(int order_Id, String staff_id, String voucher_id, String nameCustomer, String paymentMethod, BigDecimal totalCost, Date createdDay) {
        this.order_Id = order_Id;
        this.staff_id = staff_id;
        this.voucher_id = voucher_id;
        this.nameCustomer = nameCustomer;
        this.paymentMethod = paymentMethod;
        this.totalCost = totalCost;
        this.createdDay = createdDay;
    }

    public String getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(String voucher_id) {
        this.voucher_id = voucher_id;
    }

    
    
    public int getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(int order_Id) {
        this.order_Id = order_Id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
    }

    public Object[] toDataRow(int stt) {
        if (this.nameCustomer == null) {
            this.nameCustomer = "Khách lẻ";
        }
        if (this.voucher_id.equals("0")) {
            this.voucher_id = "";
        }

        return new Object[]{
            stt,
            this.order_Id,
            this.staff_id,
            this.voucher_id,
            this.nameCustomer,
            this.paymentMethod,
            this.totalCost,
            this.createdDay,};
    }

    @Override
    public String toString() {
        return "Bill{" + "order_Id=" + order_Id + ", staff_id=" + staff_id + ", voucher_id=" + voucher_id + ", nameCustomer=" + nameCustomer + ", paymentMethod=" + paymentMethod + ", totalCost=" + totalCost + ", createdDay=" + createdDay + '}';
    }

}
