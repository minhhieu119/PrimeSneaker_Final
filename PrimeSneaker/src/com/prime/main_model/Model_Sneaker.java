/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;


public class Model_Sneaker {
    private int id_Sneaker;
    private  Model_addNameProduct ten_SP;
    private Model_Category danhMuc;
    private Model_Brand hang;
    private Model_DeGiay deGiay;
    private Material chatLieu;
    private int soLuong;
    private String trangThai;

    public Model_Sneaker() {
    }

    public Model_Sneaker(int id_Sneaker, Model_addNameProduct ten_SP, Model_Category danhMuc, Model_Brand hang, Model_DeGiay deGiay, Material chatLieu, int soLuong, String trangThai) {
        this.id_Sneaker = id_Sneaker;
        this.ten_SP = ten_SP;
        this.danhMuc = danhMuc;
        this.hang = hang;
        this.deGiay = deGiay;
        this.chatLieu = chatLieu;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public int getId_Sneaker() {
        return id_Sneaker;
    }

    public void setId_Sneaker(int id_Sneaker) {
        this.id_Sneaker = id_Sneaker;
    }

    public Model_addNameProduct getTen_SP() {
        return ten_SP;
    }

    public void setTen_SP(Model_addNameProduct ten_SP) {
        this.ten_SP = ten_SP;
    }

    public Model_Category getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(Model_Category danhMuc) {
        this.danhMuc = danhMuc;
    }

    public Model_Brand getHang() {
        return hang;
    }

    public void setHang(Model_Brand hang) {
        this.hang = hang;
    }

    public Model_DeGiay getDeGiay() {
        return deGiay;
    }

    public void setDeGiay(Model_DeGiay deGiay) {
        this.deGiay = deGiay;
    }

    public Material getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(Material chatLieu) {
        this.chatLieu = chatLieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTrangThai() {
        if (this.trangThai == null){
            return "Đã ngừng bán";
        }
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    

    @Override
    public String toString() {
        return "Model_Sneaker{" + "id_Sneaker=" + id_Sneaker + ", ten_SP=" + ten_SP + ", danhMuc=" + danhMuc + ", hang=" + hang + ", deGiay=" + deGiay + ", chatLieu=" + chatLieu + ", soLuong=" + soLuong + ", trangThai=" + trangThai + '}';
    }   
}
