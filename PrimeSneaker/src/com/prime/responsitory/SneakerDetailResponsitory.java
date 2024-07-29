/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.responsitory;

import com.prime.main_model.Material;
import com.prime.main_model.Model_Brand;
import com.prime.main_model.Model_Category;
import com.prime.main_model.Model_Color;
import com.prime.main_model.Model_DeGiay;
import com.prime.main_model.Model_SneakerDetail;
import com.prime.main_model.Model_addNameProduct;
import com.prime.main_model.SizeModel;
import com.prime.untilities.ConnectionJDBC;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SneakerDetailResponsitory {

    public ArrayList<Model_SneakerDetail> getALl() {
        ArrayList<Model_SneakerDetail> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            Statement stm = con.createStatement();
            String sql = "select SneakerDetail.sneaker_detail_id,sneaker_detail_code,sneaker_name,price,quantity,category_name,brand_name,color_name,material_name,size_number,sole_name,SneakerDetail.[status] "
                    + "from Sneaker right join SneakerDetail on Sneaker.sneaker_id= SneakerDetail.sneaker_id\n"
                    + "                                     left join Category on Sneaker.category_id = Category.category_id\n"
                    + "						left join Brand on Sneaker.brand_id = Brand.brand_id\n"
                    + "						left join Sole on Sneaker.sole_id = Sole.sole_id\n"
                    + "						left join Material on Sneaker.material_id = Material.material_id\n"
                    + "						left join Size on SneakerDetail.size_id = Size.size_id\n"
                    + "						left join Color on SneakerDetail.color_id = Color.color_id\n";

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Model_SneakerDetail sd = new Model_SneakerDetail();
                Model_addNameProduct sn = new Model_addNameProduct();
                Model_Category cate = new Model_Category();
                Model_Brand br = new Model_Brand();
                Model_Color co = new Model_Color();
                Material m = new Material();
                SizeModel si = new SizeModel();
                Model_DeGiay de = new Model_DeGiay();
                sd.setMaSPCT(rs.getInt("sneaker_detail_id"));
                sd.setCode_sneaker(rs.getString("sneaker_detail_code"));
                sn.setProduct_name(rs.getString("sneaker_name"));
                sd.setTenSP(sn);
                sd.setGiaSP(rs.getLong("price"));
                sd.setSoLuong(rs.getInt("quantity"));
                cate.setCategory_name(rs.getString("category_name"));
                sd.setDanhMuc(cate);
                br.setBrand_name(rs.getString("brand_name"));
                sd.setHang(br);
                co.setColor_name(rs.getString("color_name"));
                sd.setMauSac(co);
                m.setNameMaterial(rs.getString("material_name"));
                sd.setChatLieu(m);
                si.setSize_Number(rs.getDouble("size_number"));
                sd.setKichCo(si);
                de.setTenDeGiay(rs.getString("sole_name"));
                sd.setDeGiay(de);
                sd.setTrangThai(rs.getString("status"));
                lst.add(sd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SneakerDetailResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    public Integer addSneakerDetail(Model_SneakerDetail md) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "insert into SneakerDetail(sneaker_id,sneaker_detail_code,size_id,color_id,price,quantity,[status])\n"
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setObject(1, md.getTenSP().getProduct_id());
            prsm.setObject(2, md.getCode_sneaker());
            prsm.setObject(3, md.getKichCo().getId_Size());
            prsm.setObject(4, md.getMauSac().getColor_id());
            prsm.setObject(5, md.getGiaSP());
            prsm.setObject(6, md.getSoLuong());
            prsm.setObject(7, md.getTrangThai());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SneakerDetailResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public ArrayList<Model_SneakerDetail> getSneakerByGia(double gia) {
        ArrayList<Model_SneakerDetail> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();

            String sql = "select SneakerDetail.sneaker_detail_id,sneaker_detail_code,sneaker_name,price,quantity,category_name,brand_name,color_name,material_name,size_number,sole_name,SneakerDetail.[status] "
                    + "from Sneaker right join SneakerDetail on Sneaker.sneaker_id= SneakerDetail.sneaker_id\n"
                    + "                                     left join Category on Sneaker.category_id = Category.category_id\n"
                    + "						left join Brand on Sneaker.brand_id = Brand.brand_id\n"
                    + "						left join Sole on Sneaker.sole_id = Sole.sole_id\n"
                    + "						left join Material on Sneaker.material_id = Material.material_id\n"
                    + "						left join Size on SneakerDetail.size_id = Size.size_id\n"
                    + "						left join Color on SneakerDetail.color_id = Color.color_id\n"
                    + "                                             where price <= ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, gia);
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_SneakerDetail sd = new Model_SneakerDetail();
                Model_addNameProduct sn = new Model_addNameProduct();
                Model_Category cate = new Model_Category();
                Model_Brand br = new Model_Brand();
                Model_Color co = new Model_Color();
                Material m = new Material();
                SizeModel si = new SizeModel();
                Model_DeGiay de = new Model_DeGiay();
                sd.setMaSPCT(rs.getInt("sneaker_detail_id"));
                sd.setCode_sneaker(rs.getString("sneaker_detail_code"));
                sn.setProduct_name(rs.getString("sneaker_name"));
                sd.setTenSP(sn);
                sd.setGiaSP(rs.getLong("price"));
                sd.setSoLuong(rs.getInt("quantity"));
                cate.setCategory_name(rs.getString("category_name"));
                sd.setDanhMuc(cate);
                br.setBrand_name(rs.getString("brand_name"));
                sd.setHang(br);
                co.setColor_name(rs.getString("color_name"));
                sd.setMauSac(co);
                m.setNameMaterial(rs.getString("material_name"));
                sd.setChatLieu(m);
                si.setSize_Number(rs.getDouble("size_number"));
                sd.setKichCo(si);
                de.setTenDeGiay(rs.getString("sole_name"));
                sd.setDeGiay(de);
                sd.setTrangThai(rs.getString("status"));
                lst.add(sd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SneakerDetailResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    public ArrayList<Model_SneakerDetail> getSneakerByID(String id) {
        ArrayList<Model_SneakerDetail> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();

            String sql = "select SneakerDetail.sneaker_detail_id,sneaker_detail_code,sneaker_name,price,quantity,category_name,brand_name,color_name,material_name,size_number,sole_name,SneakerDetail.[status] from Sneaker right join SneakerDetail on Sneaker.sneaker_id= SneakerDetail.sneaker_id\n"
                    + "                                     left join Category on Sneaker.category_id = Category.category_id\n"
                    + "						left join Brand on Sneaker.brand_id = Brand.brand_id\n"
                    + "						left join Sole on Sneaker.sole_id = Sole.sole_id\n"
                    + "						left join Material on Sneaker.material_id = Material.material_id\n"
                    + "						left join Size on SneakerDetail.size_id = Size.size_id\n"
                    + "						left join Color on SneakerDetail.color_id = Color.color_id\n"
                    + "                                             where Sneaker.sneaker_id like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, id);
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_SneakerDetail sd = new Model_SneakerDetail();
                Model_addNameProduct sn = new Model_addNameProduct();
                Model_Category cate = new Model_Category();
                Model_Brand br = new Model_Brand();
                Model_Color co = new Model_Color();
                Material m = new Material();
                SizeModel si = new SizeModel();
                Model_DeGiay de = new Model_DeGiay();
                sd.setMaSPCT(rs.getInt("sneaker_detail_id"));
                sd.setCode_sneaker(rs.getString("sneaker_detail_code"));
                sn.setProduct_name(rs.getString("sneaker_name"));
                sd.setTenSP(sn);
                sd.setGiaSP(rs.getLong("price"));
                sd.setSoLuong(rs.getInt("quantity"));
                cate.setCategory_name(rs.getString("category_name"));
                sd.setDanhMuc(cate);
                br.setBrand_name(rs.getString("brand_name"));
                sd.setHang(br);
                co.setColor_name(rs.getString("color_name"));
                sd.setMauSac(co);
                m.setNameMaterial(rs.getString("material_name"));
                sd.setChatLieu(m);
                si.setSize_Number(rs.getDouble("size_number"));
                sd.setKichCo(si);
                de.setTenDeGiay(rs.getString("sole_name"));
                sd.setDeGiay(de);
                sd.setTrangThai(rs.getString("status"));
                lst.add(sd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SneakerDetailResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    public Integer updateStatus(int id) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "update Sneaker \n"
                    + "set status = N'Đã ngừng bán'"
                    + "where sneaker_id =? ";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setObject(1, id);
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SneakerDetailResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer updateStatusOnSell(int id) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "update Sneaker \n"
                    + "set status = N'Đang bán'"
                    + "where sneaker_id =? ";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setObject(1, id);
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SneakerDetailResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public ArrayList<Model_SneakerDetail> foundSneakerDetailByText(String key) {
        ArrayList<Model_SneakerDetail> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();

            String sql = "select SneakerDetail.sneaker_detail_id,sneaker_detail_code,sneaker_name,price,quantity,category_name,brand_name,color_name,material_name,size_number,sole_name,SneakerDetail.[status] from Sneaker right join SneakerDetail on Sneaker.sneaker_id= SneakerDetail.sneaker_id\n"
                    + "                         left join Category on Sneaker.category_id = Category.category_id\n"
                    + "           				left join Brand on Sneaker.brand_id = Brand.brand_id\n"
                    + "                		left join Sole on Sneaker.sole_id = Sole.sole_id\n"
                    + "                		left join Material on Sneaker.material_id = Material.material_id\n"
                    + "           				left join Size on SneakerDetail.size_id = Size.size_id\n"
                    + "          				left join Color on SneakerDetail.color_id = Color.color_id\n"
                    + "                       where(SneakerDetail.sneaker_detail_id like ? or sneaker_detail_code like ? or sneaker_name like ? or  brand_name like ? or category_name like ? \n"
                    + "					 or  material_name like ? or quantity like ? or price like ? or size_number like ? or color_name like ? ) \n";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, '%' + key + '%');
            prsm.setObject(2, '%' + key + '%');
            prsm.setObject(3, '%' + key + '%');
            prsm.setObject(4, '%' + key + '%');
            prsm.setObject(5, '%' + key + '%');
            prsm.setObject(6, '%' + key + '%');
            prsm.setObject(7, '%' + key + '%');
            prsm.setObject(8, '%' + key + '%');
            prsm.setObject(9, '%' + key + '%');
            prsm.setObject(10, '%' + key + '%');
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_SneakerDetail sd = new Model_SneakerDetail();
                Model_addNameProduct sn = new Model_addNameProduct();
                Model_Category cate = new Model_Category();
                Model_Brand br = new Model_Brand();
                Model_Color co = new Model_Color();
                Material m = new Material();
                SizeModel si = new SizeModel();
                Model_DeGiay de = new Model_DeGiay();
                sd.setMaSPCT(rs.getInt("sneaker_detail_id"));
                sd.setCode_sneaker(rs.getString("sneaker_detail_code"));
                sn.setProduct_name(rs.getString("sneaker_name"));
                sd.setTenSP(sn);
                sd.setGiaSP(rs.getLong("price"));
                sd.setSoLuong(rs.getInt("quantity"));
                cate.setCategory_name(rs.getString("category_name"));
                sd.setDanhMuc(cate);
                br.setBrand_name(rs.getString("brand_name"));
                sd.setHang(br);
                co.setColor_name(rs.getString("color_name"));
                sd.setMauSac(co);
                m.setNameMaterial(rs.getString("material_name"));
                sd.setChatLieu(m);
                si.setSize_Number(rs.getDouble("size_number"));
                sd.setKichCo(si);
                de.setTenDeGiay(rs.getString("sole_name"));
                sd.setDeGiay(de);
                sd.setTrangThai(rs.getString("status"));
                lst.add(sd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SneakerDetailResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }

    public Integer updateSneakerDetail(Model_SneakerDetail md) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
//            String sql = "update SneakerDetail \n"
//                    + "	set size_id=?,color_id=?,price=?,quantity=?,[status]=?\n"
//                    + " where sneaker_detail_id = ?";

            String sql = """
                  update SneakerDetail
                  set size_id=?,color_id=?,price=?,quantity=?,[status]= ?
                  where sneaker_detail_code = ?
                  """;
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setObject(1, md.getKichCo().getId_Size());
            prsm.setObject(2, md.getMauSac().getColor_id());
            prsm.setObject(3, md.getGiaSP());
            prsm.setObject(4, md.getSoLuong());
            prsm.setObject(5, md.getTrangThai());
            prsm.setObject(6, md.getCode_sneaker());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SneakerDetailResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
}
