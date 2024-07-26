/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.responsitory;

import com.prime.main_model.Model_addNameProduct;
import com.prime.untilities.ConnectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tt
 */
public class TeSPResponsitory {

    public Integer addTenSP(String tenSP) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sqsl = "insert into Sneaker(sneaker_name)\n"
                    + "values(?)";
            PreparedStatement prsm = con.prepareStatement(sqsl);
            prsm.setObject(1, tenSP);
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeSPResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer updateTenSP(Model_addNameProduct m) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sqsl = "update Sneaker\n"
                    + "set sneaker_name=? where sneaker_id=?";
            PreparedStatement prsm = con.prepareStatement(sqsl);
            prsm.setObject(1, m.getProduct_name());
            prsm.setObject(2, m.getProduct_id());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TeSPResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public ArrayList<Model_addNameProduct> getAll() {
        ArrayList<Model_addNameProduct> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select  distinct sneaker_id, sneaker_name from Sneaker ";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Model_addNameProduct name = new Model_addNameProduct();
                name.setProduct_id(rs.getInt("sneaker_id"));
                name.setProduct_name(rs.getString("sneaker_name"));
                lst.add(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeSPResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }
    public Model_addNameProduct getName(String key) {
        
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select  distinct sneaker_id, sneaker_name from Sneaker  where sneaker_name like ?";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setObject(1,key);
            Model_addNameProduct name =null;
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                 name = new Model_addNameProduct();
                name.setProduct_id(rs.getInt("sneaker_id"));
                name.setProduct_name(rs.getString("sneaker_name"));
                return name;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeSPResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
