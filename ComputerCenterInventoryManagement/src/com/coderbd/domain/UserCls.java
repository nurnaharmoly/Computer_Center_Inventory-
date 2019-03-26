package com.coderbd.domain;

import java.util.Date;

public class UserCls {

    private int id;
    private String userName;
    private String passWord;
    private String userType;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date regiDate;
    private boolean status;

    public UserCls() {
    }

    public UserCls(String userName, String passWord, String userType, String firstName, String lastName, String email, String mobile, Date regiDate, boolean status) {
        this.userName = userName;
        this.passWord = passWord;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.regiDate = regiDate;
        this.status = status;
    }



    public UserCls(String userName, String passWord, boolean status) {
        this.userName = userName;
        this.passWord = passWord;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserCls{" + "id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", userType=" + userType + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobile=" + mobile + ", regiDate=" + regiDate + ", status=" + status + '}';
    }
    
    
}
