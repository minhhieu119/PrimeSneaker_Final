/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.model;

import com.prime.main_model.ModelUser;

/**
 *
 * @author MSII
 */
public class Admin {
    public static ModelUser user = null;
    
    public static void clear (){
        Admin.user = null;
    }
    
    public static boolean isLogin (){
        return Admin.user != null;
    }
    
    public static boolean isAdmin (){
        return Admin.isLogin() && user.getRoleId() == 1;
    }
}
