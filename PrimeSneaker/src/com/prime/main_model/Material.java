/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;

/**
 *
 * @author tt
 */
public class Material {
    private int maMaterial;
    private String nameMaterial;

    public Material(int maMaterial, String nameMaterial) {
        this.maMaterial = maMaterial;
        this.nameMaterial = nameMaterial;
    }

    public Material() {
    }

    public int getMaMaterial() {
        return maMaterial;
    }

    public void setMaMaterial(int maMaterial) {
        this.maMaterial = maMaterial;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    @Override
    public String toString() {
        return this.nameMaterial;
    }
    
}
