/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.responsitory;

import com.prime.main_model.Material;
import com.prime.main_model.Model_Brand;
import com.prime.main_model.Model_Category;
import com.prime.main_model.Model_DeGiay;
import com.prime.main_model.Model_Sneaker;
import com.prime.main_model.Model_addNameProduct;
import com.prime.untilities.ConnectionJDBC;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SneakerResponsitory {

    public ArrayList<Model_Sneaker> getAll() {
        ArrayList<Model_Sneaker> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select distinct Sneaker.sneaker_id,sneaker_name,brand_name,category_name,material_name,sole_name,sum(quantity) as quantity,Sneaker.[status] \n"
                    + "					from Sneaker left join SneakerDetail on Sneaker.sneaker_id = SneakerDetail.sneaker_id\n"
                    + "                              		left join Category on Sneaker.category_id = Category.category_id\n"
                    + "						left join Brand on Sneaker.brand_id = Brand.brand_id\n"
                    + "                    			left join Sole on Sneaker.sole_id = Sole.sole_id\n"
                    + "                    			left join Material on Sneaker.material_id = Material.material_id				\n"
                    + "               			group by Sneaker.sneaker_id,sneaker_name,category_name,Sneaker.[status],material_name,sole_name,brand_name ";
            PreparedStatement prsm = con.prepareCall(sql);
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_Sneaker sn = new Model_Sneaker();
                sn.setId_Sneaker(rs.getInt("sneaker_id"));
                Model_addNameProduct addName = new Model_addNameProduct();
                addName.setProduct_name(rs.getString("sneaker_name"));
                sn.setTen_SP(addName);
                Model_Brand br = new Model_Brand();
                br.setBrand_name(rs.getString("brand_name"));
                sn.setHang(br);
                Model_Category cate = new Model_Category();
                cate.setCategory_name(rs.getString("category_name"));
                sn.setDanhMuc(cate);
                Material ma = new Material();
                ma.setNameMaterial(rs.getString("material_name"));
                sn.setChatLieu(ma);
                Model_DeGiay sole = new Model_DeGiay();
                sole.setTenDeGiay(rs.getString("sole_name"));
                sn.setDeGiay(sole);
                sn.setSoLuong(rs.getInt("quantity"));
                sn.setTrangThai(rs.getString("status"));
                lst.add(sn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SneakerResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public ArrayList<Model_Sneaker> getAllSPOnSell() {
        ArrayList<Model_Sneaker> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select distinct Sneaker.sneaker_id,sneaker_name,brand_name,category_name,material_name,sole_name,sum(quantity) as quantity,Sneaker.[status] \n"
                    + "										from Sneaker left join SneakerDetail on Sneaker.sneaker_id = SneakerDetail.sneaker_id\n"
                    + "                              				 left join Category on Sneaker.category_id = Category.category_id\n"
                    + "											 left join Brand on Sneaker.brand_id = Brand.brand_id\n"
                    + "                    						left join Sole on Sneaker.sole_id = Sole.sole_id\n"
                    + "                    						left join Material on Sneaker.material_id = Material.material_id \n"
                    + "											where Sneaker.[status] like N'Đang bán' 		\n"
                    + "               					 group by Sneaker.sneaker_id,sneaker_name,category_name,Sneaker.[status],material_name,sole_name,brand_name";
            PreparedStatement prsm = con.prepareCall(sql);
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_Sneaker sn = new Model_Sneaker();
                sn.setId_Sneaker(rs.getInt("sneaker_id"));
                Model_addNameProduct addName = new Model_addNameProduct();
                addName.setProduct_name(rs.getString("sneaker_name"));
                sn.setTen_SP(addName);
                Model_Brand br = new Model_Brand();
                br.setBrand_name(rs.getString("brand_name"));
                sn.setHang(br);
                Model_Category cate = new Model_Category();
                cate.setCategory_name(rs.getString("category_name"));
                sn.setDanhMuc(cate);
                Material ma = new Material();
                ma.setNameMaterial(rs.getString("material_name"));
                sn.setChatLieu(ma);
                Model_DeGiay sole = new Model_DeGiay();
                sole.setTenDeGiay(rs.getString("sole_name"));
                sn.setDeGiay(sole);
                sn.setSoLuong(rs.getInt("quantity"));
                sn.setTrangThai(rs.getString("status"));
                lst.add(sn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SneakerResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public ArrayList<Model_Sneaker> getAllSPStopSell() {
        ArrayList<Model_Sneaker> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select distinct Sneaker.sneaker_id,sneaker_name,brand_name,category_name,material_name,sole_name,sum(quantity) as quantity,Sneaker.[status] \n"
                    + "										from Sneaker left join SneakerDetail on Sneaker.sneaker_id = SneakerDetail.sneaker_id\n"
                    + "                              				 left join Category on Sneaker.category_id = Category.category_id\n"
                    + "											 left join Brand on Sneaker.brand_id = Brand.brand_id\n"
                    + "                    						left join Sole on Sneaker.sole_id = Sole.sole_id\n"
                    + "                    						left join Material on Sneaker.material_id = Material.material_id \n"
                    + "											where Sneaker.[status] like N'Ngừng bán' 				\n"
                    + "               					 group by Sneaker.sneaker_id,sneaker_name,category_name,Sneaker.[status],material_name,sole_name,brand_name";
            PreparedStatement prsm = con.prepareCall(sql);
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_Sneaker sn = new Model_Sneaker();
                sn.setId_Sneaker(rs.getInt("sneaker_id"));
                Model_addNameProduct addName = new Model_addNameProduct();
                addName.setProduct_name(rs.getString("sneaker_name"));
                sn.setTen_SP(addName);
                Model_Brand br = new Model_Brand();
                br.setBrand_name(rs.getString("brand_name"));
                sn.setHang(br);
                Model_Category cate = new Model_Category();
                cate.setCategory_name(rs.getString("category_name"));
                sn.setDanhMuc(cate);
                Material ma = new Material();
                ma.setNameMaterial(rs.getString("material_name"));
                sn.setChatLieu(ma);
                Model_DeGiay sole = new Model_DeGiay();
                sole.setTenDeGiay(rs.getString("sole_name"));
                sn.setDeGiay(sole);
                sn.setSoLuong(rs.getInt("quantity"));
                sn.setTrangThai(rs.getString("status"));
                lst.add(sn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SneakerResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public Integer upDateSneaker(Model_Sneaker sn) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "update Sneaker\n"
                    + "	set sneaker_name = ?, brand_id=?, category_id= ?, sole_id=?,material_id=?, [status] = ?\n"
                    + "	where sneaker_id= ? ";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, sn.getTen_SP().getProduct_name());
            prsm.setObject(2, sn.getHang().getBrand_id());
            prsm.setObject(3, sn.getDanhMuc().getCategory_id());
            prsm.setObject(4, sn.getDeGiay().getMaDeGiay());
            prsm.setObject(5, sn.getChatLieu().getMaMaterial());
            prsm.setObject(6, sn.getTrangThai());
            prsm.setObject(7, sn.getId_Sneaker());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SneakerResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public ArrayList<Model_Sneaker> foundByText(String key) {
        ArrayList<Model_Sneaker> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select distinct Sneaker.sneaker_id,sneaker_name,brand_name,category_name,material_name,sole_name,sum(quantity) as quantity,Sneaker.[status] \n"
                    + "             							from Sneaker left join SneakerDetail on Sneaker.sneaker_id = SneakerDetail.sneaker_id\n"
                    + "                                      				 left join Category on Sneaker.category_id = Category.category_id\n"
                    + "           							left join Brand on Sneaker.brand_id = Brand.brand_id\n"
                    + "                            					left join Sole on Sneaker.sole_id = Sole.sole_id\n"
                    + "                           					left join Material on Sneaker.material_id = Material.material_id \n"
                    + "        								where (Sneaker.sneaker_id like ? or sneaker_name like ? or  brand_name like ? or category_name like ? or material_name like ? or sole_name like ?) or quantity like ?	\n"
                    + "                         					 group by Sneaker.sneaker_id,sneaker_name,category_name,Sneaker.[status],material_name,sole_name,brand_name"
                    + "                                                                      having sum(quantity) like ?";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setObject(1, '%' + key + '%');
            prsm.setObject(2, '%' + key + '%');
            prsm.setObject(3, '%' + key + '%');
            prsm.setObject(4, '%' + key + '%');
            prsm.setObject(5, '%' + key + '%');
            prsm.setObject(6, '%' + key + '%');
            prsm.setObject(7, '%' + key + '%');
            prsm.setObject(8, '%' + key + '%');
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_Sneaker sn = new Model_Sneaker();
                sn.setId_Sneaker(rs.getInt("sneaker_id"));
                Model_addNameProduct addName = new Model_addNameProduct();
                addName.setProduct_name(rs.getString("sneaker_name"));
                sn.setTen_SP(addName);
                Model_Brand br = new Model_Brand();
                br.setBrand_name(rs.getString("brand_name"));
                sn.setHang(br);
                Model_Category cate = new Model_Category();
                cate.setCategory_name(rs.getString("category_name"));
                sn.setDanhMuc(cate);
                Material ma = new Material();
                ma.setNameMaterial(rs.getString("material_name"));
                sn.setChatLieu(ma);
                Model_DeGiay sole = new Model_DeGiay();
                sole.setTenDeGiay(rs.getString("sole_name"));
                sn.setDeGiay(sole);
                sn.setSoLuong(rs.getInt("quantity"));
                sn.setTrangThai(rs.getString("status"));
                lst.add(sn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SneakerResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public Integer addSneaker(Model_Sneaker sn) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "insert into Sneaker(sneaker_name,brand_id,category_id,sole_id,material_id,[status])\n"
                    + "values (?,?,?,?,?,?)";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setObject(1, sn.getTen_SP().getProduct_name());
            prsm.setObject(2, sn.getHang().getBrand_id());
            prsm.setObject(3, sn.getDanhMuc().getCategory_id());
            prsm.setObject(4, sn.getDeGiay().getMaDeGiay());
            prsm.setObject(5, sn.getChatLieu().getMaMaterial());
            prsm.setObject(6, sn.getTrangThai());
            row = prsm.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(SneakerResponsitory.class.getName()).log(Level.SEVERE, null, e);
        }
        return row;
    }

}
