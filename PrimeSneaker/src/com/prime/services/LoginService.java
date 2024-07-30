/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.services;

import com.prime.main_model.ModelUser;
import com.prime.main_model.User;
import com.prime.untilities.ConnectionJDBC;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    ArrayList<User> listUser = new ArrayList<>();
    
    public ArrayList<User> getAllUser (){
        String sql = """
                     select r.role_id, u.account_name, u.[password], r.role_name
                     from [User] u join [Role] r on u.role_id = r.role_id
                     """;
        try {
            Connection c = ConnectionJDBC.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setRole_id(rs.getInt("role_id"));
                user.setAccount_name(rs.getString("account_name"));
                user.setPassword(rs.getString("password"));
                user.setRole_name(rs.getString("role_name"));
                listUser.add(user);
            }
            return listUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }
    
    public ModelUser getOneUser (String accountName) throws SQLException{
        ModelUser mu = new ModelUser();
        String sql = """
                     select user_code, role_id, full_name, gender, date_of_birth,phone_number, [address], email, id_card_number, account_name, [password], [status]
                     from [User] where account_name like ?
                     """;
        Connection connect = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            connect = ConnectionJDBC.getConnection();
            ps = connect.prepareStatement(sql);
            ps.setString(1, accountName);
            result = ps.executeQuery();
            if (result.next()) {
                mu.setUserCode(result.getString("user_code"));
                mu.setRoleId(result.getInt("role_id"));
                mu.setStaffName(result.getString("full_name"));
                mu.setGender(result.getBoolean("gender"));
                mu.setDob(result.getDate("date_of_birth"));
                mu.setPhone(result.getString("phone_number"));
                mu.setAddress(result.getString("address"));
                mu.setEmail(result.getString("email"));
                mu.setIdCardNumber(result.getString("id_card_number"));
                mu.setAccountName(result.getString("account_name"));
                mu.setPsw(result.getString("password"));
                mu.setStatus(result.getString("status"));
            }
            return mu;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            result.close();
            ps.close();
            connect.close();
        }
        return mu;
    }
}
