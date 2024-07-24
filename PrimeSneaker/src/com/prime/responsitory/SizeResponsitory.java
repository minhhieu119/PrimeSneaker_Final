/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.responsitory;

import com.prime.main_model.SizeModel;
import com.prime.untilities.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SizeResponsitory {

    public ArrayList<SizeModel> getAll() {
        ArrayList<SizeModel> lstSize = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select size_id,size_number from Size";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SizeModel si = new SizeModel();
                si.setId_Size(rs.getInt("size_id"));
                si.setSize_Number(rs.getDouble("size_number"));
                lstSize.add(si);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoleResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstSize;
    }

    public Integer addSize(SizeModel si) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "insert into Size(size_number)\n"
                    + "values(?)";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setDouble(1, si.getSize_Number());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SoleResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return row;
    }

    public Integer updateSize(SizeModel si) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "update Size\n"
                    + "set size_number=?\n"
                    + "where size_id=?";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setDouble(1, si.getSize_Number());
            prsm.setInt(2, si.getId_Size());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SoleResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public ArrayList<SizeModel> search(String key) {
        ArrayList<SizeModel> lstSearch = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select size_id,size_number from Size \n"
                    + "where size_number = ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1,  key );
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                SizeModel br = new SizeModel();
                br.setId_Size(rs.getInt("size_id"));
                br.setSize_Number(rs.getDouble("size_number"));
                lstSearch.add(br);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstSearch;
    }
    public SizeModel getSize(String key) {
        
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select size_id,size_number from Size \n"
                    + "where size_number = ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1,  key );
            SizeModel br=null;
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                 br = new SizeModel();
                br.setId_Size(rs.getInt("size_id"));
                br.setSize_Number(rs.getDouble("size_number"));
                return br;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
