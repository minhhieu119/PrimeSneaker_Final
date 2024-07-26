/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.responsitory;

import com.prime.main_model.Model_Color;
import com.prime.untilities.ConnectionJDBC;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColorResponsitory {

    public ArrayList<Model_Color> getALl() {
        ArrayList<Model_Color> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            Statement stm = con.createStatement();
            String sql = "select color_id,color_name from Color";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Model_Color ml = new Model_Color();
                ml.setColor_id(rs.getInt("color_id"));
                ml.setColor_name(rs.getString("color_name"));
                lst.add(ml);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColorResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public Integer addColor(Model_Color col) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "insert into Color (color_name)\n"
                    + "values(?)";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, col.getColor_name());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColorResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer upDateColor(Model_Color col) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "update Color\n"
                    + "set color_name=? where color_id=?";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, col.getColor_name());
            prsm.setInt(2, col.getColor_id());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColorResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public ArrayList<Model_Color> search(String key) {
        ArrayList<Model_Color> lstSearch = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select color_id,color_name from Color \n"
                    + "where color_name like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, '%' + key + '%');
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_Color br = new Model_Color();
                br.setColor_id(rs.getInt("color_id"));
                br.setColor_name(rs.getString("color_name"));
                lstSearch.add(br);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstSearch;
    }
    public Model_Color getColor(String key) {
        
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select color_id,color_name from Color \n"
                    + "where color_name like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1,  key );
            Model_Color br =null;
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                 br = new Model_Color();
                br.setColor_id(rs.getInt("color_id"));
                br.setColor_name(rs.getString("color_name"));
                return br;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
