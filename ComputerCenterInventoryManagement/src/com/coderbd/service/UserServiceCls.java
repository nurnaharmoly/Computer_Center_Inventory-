package com.coderbd.service;

import com.coderbd.connection.MySqlJdbcConnection;
import com.coderbd.domain.UserCls;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceCls {

    static Connection conn = MySqlJdbcConnection.getConnection();

    public static void createTable() {
        String sql = "create table user(id int auto_increment primary key, userName varchar(30) not null, passWord varchar(30) not null, userType varchar(30) not null, firstName varchar(30), lastName varchar(30), email varchar(30) not null, mobile varchar(30) not null, regiDate Date, status bit)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Table Created");
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insert(UserCls userCls) {

        String sql = "insert into user(userName, passWord, userType, firstName, lastName, email, mobile, regiDate, status) values(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userCls.getUserName());
            ps.setString(2, userCls.getPassWord());
            ps.setString(3, userCls.getUserType());
            ps.setString(4, userCls.getFirstName());
            ps.setString(5, userCls.getLastName());
            ps.setString(6, userCls.getEmail());
            ps.setString(7, userCls.getMobile());
            ps.setDate(8, new java.sql.Date(userCls.getRegiDate().getTime()));
            ps.setBoolean(9, userCls.isStatus());
            ps.executeUpdate();
            System.out.println("Data Inserted");

        } catch (SQLException ex) {
            Logger.getLogger(UserServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public static UserCls getUserByuserName(String userName, String passWord, boolean status){
      UserCls userCls = new  UserCls();
      String sql = "select * from user where userName=? and  passWord=? and status=?";
      
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            ps.setBoolean(3, status);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
             userCls.setId(rs.getInt(1));
             userCls.setUserName(rs.getString(2));
             userCls.setPassWord(rs.getString(3));
             userCls.setUserType(rs.getString(4));
             userCls.setFirstName(rs.getString(5));
             userCls.setLastName(rs.getString(6));
             userCls.setEmail(rs.getString(7));
             userCls.setMobile(rs.getString(8));
             userCls.setRegiDate(rs.getDate(9));
             userCls.setStatus(rs.getBoolean(10));
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
     return userCls;
     }
     
     public static List<UserCls> getUserList() {
        List<UserCls> list = new ArrayList<>();

        String sql = "select * from user";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserCls user = new UserCls();
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassWord(rs.getString(3));
                user.setUserType(rs.getString(4));
                user.setFirstName(rs.getString(5));
                user.setLastName(rs.getString(6));
                user.setEmail(rs.getString(7));
                user.setMobile(rs.getString(8));
                user.setRegiDate(rs.getDate(9));
                user.setStatus(rs.getBoolean(10));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

   
}
