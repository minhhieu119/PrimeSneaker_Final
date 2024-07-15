/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.services;

import com.prime.main_model.User;
import com.prime.untilities.ConnectionJDBC;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
