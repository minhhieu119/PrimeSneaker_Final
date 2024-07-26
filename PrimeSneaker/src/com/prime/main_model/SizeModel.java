/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;


public class SizeModel {
    private int id_Size;
    private double size_Number;

    public SizeModel() {
    }

    public int getId_Size() {
        return id_Size;
    }

    public double getSize_Number() {
        return size_Number;
    }

    @Override
    public String toString() {
        return size_Number+"";
    }

    public void setId_Size(int id_Size) {
        this.id_Size = id_Size;
    }

    public void setSize_Number(double size_Number) {
        this.size_Number = size_Number;
    }
    
}
