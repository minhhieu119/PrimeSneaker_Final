
package com.prime.main_model;

import java.time.LocalDate;
import java.util.Date;


public class ModelUser {
    private String userCode;
    private int user_id;
    private int roleId;
//    private String role;
    private String staffName;
    private boolean gender;
    private Date dob;
    private String phone;
    private String address;
    private String email;
    private String idCardNumber;
    private String accountName;
    private String psw;
    private String status;

    public ModelUser() {
    }

    public ModelUser(String userCode, int roleId, String staffName, boolean gender, Date dob, String phone, String address, String email, String idCardNumber, String accountName, String psw, String status) {
        this.userCode = userCode;
        this.roleId = roleId;
        this.staffName = staffName;
        this.gender = gender;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.idCardNumber = idCardNumber;
        this.accountName = accountName;
        this.psw = psw;
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ModelUser{" + "userCode=" + userCode + ", roleId=" + roleId + ", staffName=" + staffName + ", gender=" + gender + ", dob=" + dob + ", phone=" + phone + ", address=" + address + ", email=" + email + ", idCardNumber=" + idCardNumber + ", accountName=" + accountName + ", psw=" + psw + ", status=" + status + '}';
    }

    
    
}
