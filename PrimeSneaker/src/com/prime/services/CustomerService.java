/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.services;
import com.prime.main_model.ModelCustomer;
import com.prime.untilities.ConnectionJDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author haove
 */
public class CustomerService {
    Connection connect = null;
    PreparedStatement ps = null;
    ResultSet result = null;
    
    public ArrayList<ModelCustomer> getAllCustomer() throws SQLException{
        ArrayList<ModelCustomer> list = new ArrayList<>();
        String query = "SELECT customer_id, full_name, gender, date_of_birth, address, phone_number FROM Customer";
        try {
            connect = ConnectionJDBC.getConnection();
            ps = connect.prepareStatement(query);
            result = ps.executeQuery();
            while (result.next()) {                
                ModelCustomer customer = new ModelCustomer();
                customer.setCustomerID(result.getInt("customer_id"));
                customer.setCustomerName(result.getString("full_name"));
                customer.setPhoneNumber(result.getString("phone_number"));
                customer.setGender(result.getBoolean("gender"));
                customer.setAddress(result.getString("address"));
                customer.setDob(result.getDate("date_of_birth"));
                list.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            result.close();
            ps.close();
            connect.close();
        }
        return list;
    }
    
    public boolean addCustomer(ModelCustomer customer) throws SQLException{
        Integer row = null;
        String query = "INSERT INTO Customer(full_name, phone_number, gender, address, date_of_birth)\n"
                + "VALUES(?,?,?,?,?)";
        try {
            connect = ConnectionJDBC.getConnection();
            ps = connect.prepareStatement(query);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getPhoneNumber());
            ps.setBoolean(3, customer.isGender());
            ps.setString(4, customer.getAddress());
            ps.setDate(5, new java.sql.Date(customer.getDob().getTime()));
            row = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            result.close();
            ps.close();
            connect.close();
        }
        return false;
    }
    
    public boolean updateCustomer(ModelCustomer customer) throws SQLException{
        Integer row = null;
        String query = "UPDATE Customer\n"
                + "SET full_name = ?, gender = ?, date_of_birth = ?, address = ?, phone_number = ?\n"
                + "WHERE customer_id = ?";
        try {
            connect = ConnectionJDBC.getConnection();
            ps = connect.prepareStatement(query);
            ps.setString(1, customer.getCustomerName());
            ps.setBoolean(2, customer.isGender());
            ps.setDate(3,  new java.sql.Date(customer.getDob().getTime()));
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getPhoneNumber());
            ps.setInt(6, customer.getCustomerID());
            row = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ps.close();
            connect.close();
        }
        return false;
    }
}
