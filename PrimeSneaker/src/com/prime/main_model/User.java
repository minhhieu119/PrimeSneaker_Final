/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.main_model;

/**
 *
 * @author MSII
 */
public class User {
    private int role_id;
    private String account_name;
    private String password;
    private String role_name;

    public User() {
    }

    public User(int role_id, String account_name, String password, String role_name) {
        this.role_id = role_id;
        this.account_name = account_name;
        this.password = password;
        this.role_name = role_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "User{" + "role_id=" + role_id + ", account_name=" + account_name + ", password=" + password + ", role_name=" + role_name + '}';
    }
    
    
}
