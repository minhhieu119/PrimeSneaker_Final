/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.services;


import com.prime.main_model.ModelUser;
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
public class UserService {

    Connection connect = null;
    PreparedStatement ps = null;
    ResultSet result = null;

    public ArrayList<ModelUser> getAllUsers() throws SQLException {
        ArrayList<ModelUser> listUser = new ArrayList<>();
        String query = "SELECT user_code, role_id, full_name, gender, date_of_birth, phone_number, "
                + "address, email, id_card_number, account_name, password, status\n"
                + " FROM [User]";
        try {
            connect = ConnectionJDBC.getConnection();
            ps = connect.prepareStatement(query);
            result = ps.executeQuery();
            while (result.next()) {
                ModelUser user = new ModelUser();
                user.setUserCode(result.getString("user_code"));
                user.setRoleId(result.getInt("role_id"));
//                user.setUserQR(result.getString("user_code"));
                user.setStaffName(result.getString("full_name"));
                user.setGender(result.getBoolean("gender"));
                user.setDob(result.getDate("date_of_birth"));
                user.setPhone(result.getString("phone_number"));
                user.setAccountName(result.getString("account_name"));
                user.setAddress(result.getString("address"));
                user.setEmail(result.getString("email"));
                user.setIdCardNumber(result.getString("id_card_number"));
                user.setStatus(result.getString("status"));
                user.setPsw(result.getString("password"));
                listUser.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            result.close();
            ps.close();
            connect.close();
        }
        return listUser;
    }

    public boolean addUser(ModelUser user) throws SQLException {
        Integer row = null;
        String query = "insert into [User](user_code,role_id, full_name, gender, date_of_birth, phone_number, address, email, id_card_number, account_name, password, status)\n"
                + " values(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connect = ConnectionJDBC.getConnection();
            ps = connect.prepareStatement(query);
            ps.setString(1, user.getUserCode());
            ps.setInt(2, user.getRoleId());
            ps.setString(3, user.getStaffName());
            ps.setBoolean(4, user.isGender());
            ps.setDate(5, new java.sql.Date(user.getDob().getTime()));
            ps.setString(6, user.getPhone());
            ps.setString(7, user.getAddress());
            ps.setString(8, user.getEmail());
            ps.setString(9, user.getIdCardNumber());
            ps.setString(10, user.getAccountName());
            ps.setString(11, user.getPsw());
            ps.setString(12, user.getStatus());
            row = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            connect.close();
        }
        return false;
    }

    public boolean updateUser(ModelUser user) throws SQLException {
        Integer row = null;
        String query = "UPDATE [User]\n"
                + "SET role_id = ?, full_name = ?, "
                + "gender = ?, date_of_birth = ?, "
                + "phone_number = ?, address = ?, "
                + "email = ?, id_card_number = ?, "
                + "account_name = ?, password = ?, "
                + "status = ?\n"
                + "WHERE user_code = ?";
        try {
            connect = ConnectionJDBC.getConnection();
            ps = connect.prepareStatement(query);
            ps.setInt(1, user.getRoleId());
            ps.setString(2, user.getStaffName());
            ps.setBoolean(3, user.isGender());
            ps.setDate(4, new java.sql.Date(user.getDob().getTime()));
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getIdCardNumber());
            ps.setString(9, user.getAccountName());
            ps.setString(10, user.getPsw());
            ps.setString(11, user.getStatus());
            ps.setString(12, user.getUserCode());
            row = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            connect.close();
        }
        return false;
    }

    public boolean updateUserStatus(ModelUser user) throws SQLException {
        Integer row = null;
        String query = "UPDATE [User]\n"
                + "SET status = N'Đã nghỉ việc'"
                + "WHERE user_code = ?";
        try {
            connect = ConnectionJDBC.getConnection();
            ps = connect.prepareStatement(query);
            ps.setString(1, user.getUserCode());
            row = ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            ps.close();
            connect.close();
        }
    }

    public ArrayList<ModelUser> getUsersByKey(String key) throws SQLException {
        ArrayList<ModelUser> resulList = new ArrayList<>();
        String query = "SELECT user_code, role_id, full_name, gender, date_of_birth, phone_number, "
                + "address, email, id_card_number, account_name, password, status\n"
                + " FROM [User]\n"
                + "WHERE user_code LIKE ?"
                + " OR full_name LIKE ?"
                + " OR date_of_birth LIKE ?"
                + " OR phone_number LIKE ?"
                + " OR address LIKE ?"
                + " OR email LIKE ?"
                + " OR id_card_number LIKE ?"
                + " OR account_name LIKE ?"
                + " OR password LIKE ?";
        try {
            connect = ConnectionJDBC.getConnection();
            ps = connect.prepareStatement(query);
            for (int i = 1; i < 10; i++) {
                ps.setString(i, "%" + key + "%");  
            }
            result = ps.executeQuery();
            while (result.next()) {                
                ModelUser user = new ModelUser();
                user.setUserCode(result.getString("user_code"));
                user.setRoleId(result.getInt("role_id"));
//                user.setUserQR(result.getString("user_code"));
                user.setStaffName(result.getString("full_name"));
                user.setGender(result.getBoolean("gender"));
                user.setDob(result.getDate("date_of_birth"));
                user.setPhone(result.getString("phone_number"));
                user.setAccountName(result.getString("account_name"));
                user.setAddress(result.getString("address"));
                user.setEmail(result.getString("email"));
                user.setIdCardNumber(result.getString("id_card_number"));
                user.setStatus(result.getString("status"));
                user.setPsw(result.getString("password"));
                resulList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            result.close();
            ps.close();
            connect.close();
        }
        return resulList;
    }
    
    
}
