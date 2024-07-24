/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.responsitory;

import com.prime.main_model.Model_Brand;
import com.prime.untilities.ConnectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrandResponsitory {

    public ArrayList<Model_Brand> getALl() {
        ArrayList<Model_Brand> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            Statement stm = con.createStatement();
            String sql = "select brand_id,brand_name from Brand";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Model_Brand br = new Model_Brand();
                br.setBrand_id(rs.getInt("brand_id"));
                br.setBrand_name(rs.getString("brand_name"));
                lst.add(br);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColorResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public Integer addBrand(Model_Brand br) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "insert into Brand(brand_name)\n"
                    + "values(?)";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, br.getBrand_name());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColorResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer upDateBrand(Model_Brand br) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "update Brand\n"
                    + "set brand_name=? where brand_id=?";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, br.getBrand_name());
            prsm.setInt(2, br.getBrand_id());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColorResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public ArrayList<Model_Brand> search(String key) {
        ArrayList<Model_Brand> lstSearch = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select brand_id,brand_name from Brand \n"
                    + "where brand_name like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, '%' + key + '%');          
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_Brand br = new Model_Brand();
                br.setBrand_id(rs.getInt("brand_id"));
                br.setBrand_name(rs.getString("brand_name"));
                lstSearch.add(br);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstSearch;
    }
    public Model_Brand getBr(String key) {
        
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select brand_id,brand_name from Brand \n"
                    + "where brand_name like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1,key); 
            Model_Brand br = null;
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                 br = new Model_Brand();
                br.setBrand_id(rs.getInt("brand_id"));
                br.setBrand_name(rs.getString("brand_name"));  
                return br;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
