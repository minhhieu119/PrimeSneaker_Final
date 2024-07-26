/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.responsitory;

import com.prime.main_model.Material;
import com.prime.untilities.ConnectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaterialResponsitory {

    public ArrayList<Material> getAll() {
        ArrayList<Material> lstMaterial = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select material_id,material_name from Material";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Material ma = new Material();
                ma.setMaMaterial(rs.getInt("material_id"));
                ma.setNameMaterial(rs.getString("material_name"));
                lstMaterial.add(ma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoleResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstMaterial;
    }

    public Integer addMaterial(Material ma) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "insert into Material(material_name)\n"
                    + "values(?)";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, ma.getNameMaterial());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SoleResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return row;
    }

    public Integer updateMaterial(Material ma) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "update Material\n"
                    + "set material_name= ?\n"
                    + "where material_id=?";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, ma.getNameMaterial());
            prsm.setInt(2, ma.getMaMaterial());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SoleResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public ArrayList<Material> search(String key) {
        ArrayList<Material> lstSearch = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select material_id,material_name from Material \n"
                    + "where material_name like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, '%' + key + '%');
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Material br = new Material();
                br.setMaMaterial(rs.getInt("material_id"));
                br.setNameMaterial(rs.getString("material_name"));
                lstSearch.add(br);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstSearch;
    }
    public Material getMaterial(String key) {
        
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select material_id,material_name from Material \n"
                    + "where material_name like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, key );
            Material br =null;
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                 br = new Material();
                br.setMaMaterial(rs.getInt("material_id"));
                br.setNameMaterial(rs.getString("material_name"));
                return br;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
