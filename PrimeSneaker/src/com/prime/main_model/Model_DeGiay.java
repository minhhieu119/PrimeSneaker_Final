/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;

/**
 *
 * @author tt
 */
public class Model_DeGiay {
    private int maDeGiay;
    private String tenDeGiay;

    public Model_DeGiay() {
    }

    public Model_DeGiay(String tenDeGiay) {
        this.tenDeGiay = tenDeGiay;
    }

    public Model_DeGiay(int maDeGiay, String tenDeGiay) {
        this.maDeGiay = maDeGiay;
        this.tenDeGiay = tenDeGiay;
    }

    public int getMaDeGiay() {
        return maDeGiay;
    }

    public void setMaDeGiay(int maDeGiay) {
        this.maDeGiay = maDeGiay;
    }

    public String getTenDeGiay() {
        return tenDeGiay;
    }

    public void setTenDeGiay(String tenDeGiay) {
        this.tenDeGiay = tenDeGiay;
    }

    @Override
    public String toString() {
        return this.tenDeGiay;
    }
    
    
}
