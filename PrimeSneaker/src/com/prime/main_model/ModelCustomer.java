
package com.prime.main_model;

import java.util.Date;


public class ModelCustomer {
    private int customerID;
    private String customerName;
    private boolean gender;
    private Date dob;
    private String address;
    private String phoneNumber;

    public ModelCustomer() {
    }

    public ModelCustomer(String customerName, boolean gender, String address, String phoneNumber) {
        this.customerName = customerName;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    

    public ModelCustomer(int customerID, String customerName, boolean gender, Date dob, String address, String phoneNumber) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ModelCustomer{" + "customerID=" + customerID + ", customerName=" + customerName + ", gender=" + gender + ", dob=" + dob + ", address=" + address + ", phoneNumber=" + phoneNumber + '}';
    }
    
}