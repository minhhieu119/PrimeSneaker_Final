/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.responsitory;

import com.prime.main_model.Model_Category;
import com.prime.untilities.ConnectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryResponsitory {

    public ArrayList<Model_Category> getALl() {
        ArrayList<Model_Category> lst = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            Statement stm = con.createStatement();
            String sql = "select category_id,category_name from Category";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Model_Category cate = new Model_Category();
                cate.setCategory_id(rs.getInt("category_id"));
                cate.setCategory_name(rs.getString("category_name"));
                lst.add(cate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ColorResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lst;
    }

    public Integer addCategory(Model_Category cate) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "insert into Category(category_name)\n"
                    + "values(?)";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, cate.getCategory_name());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColorResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public Integer upDateCategory(Model_Category cate) {
        Integer row = null;
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "update Category\n"
                    + "set category_name=? where category_id=?";
            PreparedStatement prsm = con.prepareStatement(sql);
            prsm.setString(1, cate.getCategory_name());
            prsm.setInt(2, cate.getCategory_id());
            row = prsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ColorResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }

    public ArrayList<Model_Category> searchCate(String key) {
        ArrayList<Model_Category> lstSearch = new ArrayList<>();
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select category_id,category_name from Category \n"
                    + "where category_name like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1, '%' + key + '%');
            
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                Model_Category cate = new Model_Category();
                cate.setCategory_id(rs.getInt("category_id"));
                cate.setCategory_name(rs.getString("category_name"));
                lstSearch.add(cate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lstSearch;
    }
    public Model_Category getCate(String key) {
        
        try {
            Connection con = ConnectionJDBC.getConnection();
            String sql = "select category_id,category_name from Category \n"
                    + "where category_name like ?";
            PreparedStatement prsm = con.prepareCall(sql);
            prsm.setObject(1,  key );
            Model_Category cate =null;
            ResultSet rs = prsm.executeQuery();
            while (rs.next()) {
                cate = new Model_Category();
                cate.setCategory_id(rs.getInt("category_id"));
                cate.setCategory_name(rs.getString("category_name"));
                return cate;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryResponsitory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
