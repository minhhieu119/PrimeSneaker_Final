/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.model;

import java.util.Date;


public class Customer {
    private static String customerName;
    private static String phoneNumber;

    public Customer() {
    }

    public static String getCustomerName() {
        return customerName;
    }

    public static void setCustomerName(String customerName) {
        Customer.customerName = customerName;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        Customer.phoneNumber = phoneNumber;
    }

    
}