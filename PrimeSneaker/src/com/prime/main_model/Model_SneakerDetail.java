/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;

/**
 *
 * @author tt
 */
public class Model_SneakerDetail {
    private int maSPCT;
    private Model_addNameProduct tenSP;
    private long giaSP;
    private int soLuong;
    private String code_sneaker;
    private Model_Category danhMuc;
    private Model_Brand hang;
    private Model_Color mauSac;
    private Material chatLieu;
    private SizeModel kichCo;
    private Model_DeGiay deGiay;
    private String trangThai;

    public Model_SneakerDetail() {
    }

    public Model_SneakerDetail(int maSPCT, Model_addNameProduct tenSP, long giaSP, int soLuong, String code_sneaker, Model_Category danhMuc, Model_Brand hang, Model_Color mauSac, Material chatLieu, SizeModel kichCo, Model_DeGiay deGiay, String trangThai) {
        this.maSPCT = maSPCT;
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.soLuong = soLuong;
        this.code_sneaker = code_sneaker;
        this.danhMuc = danhMuc;
        this.hang = hang;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.kichCo = kichCo;
        this.deGiay = deGiay;
        this.trangThai = trangThai;
    }

    public int getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(int maSPCT) {
        this.maSPCT = maSPCT;
    }

    public Model_addNameProduct getTenSP() {
        return tenSP;
    }

    public void setTenSP(Model_addNameProduct tenSP) {
        this.tenSP = tenSP;
    }

    public long getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(long giaSP) {
        this.giaSP = giaSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getCode_sneaker() {
        return code_sneaker;
    }

    public void setCode_sneaker(String code_sneaker) {
        this.code_sneaker = code_sneaker;
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

    public Model_Color getMauSac() {
        return mauSac;
    }

    public void setMauSac(Model_Color mauSac) {
        this.mauSac = mauSac;
    }

    public Material getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(Material chatLieu) {
        this.chatLieu = chatLieu;
    }

    public SizeModel getKichCo() {
        return kichCo;
    }

    public void setKichCo(SizeModel kichCo) {
        this.kichCo = kichCo;
    }

    public Model_DeGiay getDeGiay() {
        return deGiay;
    }

    public void setDeGiay(Model_DeGiay deGiay) {
        this.deGiay = deGiay;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Model_SneakerDetail{" + "maSPCT=" + maSPCT + ", tenSP=" + tenSP + ", giaSP=" + giaSP + ", soLuong=" + soLuong + ", code_sneaker=" + code_sneaker + ", danhMuc=" + danhMuc + ", hang=" + hang + ", mauSac=" + mauSac + ", chatLieu=" + chatLieu + ", kichCo=" + kichCo + ", deGiay=" + deGiay + ", trangThai=" + trangThai + '}';
    }
 
}
