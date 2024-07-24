/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.model;

/**
 *
 * @author MSII
 */
public class CartQuantity {
    public static int quantity;

    public CartQuantity() {
    }

    public CartQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static int getQuantity() {
        return quantity;
    }

    public static void setQuantity(int quantity) {
        CartQuantity.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartQuantity{" + "quantity=" + quantity + '}';
    }
    
    
}
