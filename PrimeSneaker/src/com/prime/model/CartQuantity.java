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
    public static boolean cancel;

    public CartQuantity() {
    }

    public static boolean isCancel() {
        return cancel;
    }

    public static void setCancel(boolean cancel) {
        CartQuantity.cancel = cancel;
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
