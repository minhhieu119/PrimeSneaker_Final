/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.responsitory;

import com.prime.main_model.Model_DeGiay;
import com.prime.untilities.ConnectionJDBC;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SoleResponsitory {

    public ArrayList<Model_DeGiay> getAll() {
        ArrayList<Model_DeGiay> lstDeGiay = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select sole_id,sole_name from Sole";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Model_DeGiay de = new Model_DeGiay();
                de.setMaDeGiay(rs.getInt("sole_id"));
                de.setTenDeGiay(rs.getString("sole_name"));
                lstDeGiay.add(de);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoleResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstDeGiay;
    }

    public Integer addSole(Model_DeGiay dg) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "insert into Sole(sole_name)\n"
                    + "values(?)";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, dg.getTenDeGiay());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SoleResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return row;
    }

    public Integer updateSole(Model_DeGiay dg) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "update Sole\n"
                    + "set sole_name = ?\n"
                    + "where sole_id = ?";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, dg.getTenDeGiay());
            prsm.setInt(2, dg.getMaDeGiay());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SoleResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public ArrayList<Model_DeGiay> search(String key) {
        ArrayList<Model_DeGiay> lstSearch = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select sole_id,sole_name from Sole \n"
                    + "where sole_name like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, '%' + key + '%');
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_DeGiay br = new Model_DeGiay();
                br.setMaDeGiay(rs.getInt("sole_id"));
                br.setTenDeGiay(rs.getString("sole_name"));
                lstSearch.add(br);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstSearch;
    }

    public Model_DeGiay getSole(String key) {

        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select sole_id,sole_name from Sole \n"
                    + "where sole_name like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, key);
            Model_DeGiay br = null;
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                br = new Model_DeGiay();
                br.setMaDeGiay(rs.getInt("sole_id"));
                br.setTenDeGiay(rs.getString("sole_name"));
                return br;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
