
package com.coderbd.service;

import com.coderbd.connection.MySqlJdbcConnection;
import com.coderbd.domain.ProductCatagoryCls;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductCategoryServiceCls {
   static Connection conn = MySqlJdbcConnection.getConnection();
   
   public static void createTable(){
   
       String sql = "create table category(id int auto_increment primary key, name varchar(30) not null)";
       
       try {
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.execute();
           System.out.println("Created Category Table");
       } catch (SQLException ex) {
           Logger.getLogger(ProductCategoryServiceCls.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   public static void insert(ProductCatagoryCls cat){
    
       String sql = "insert into category(name) values(?)";
   
       try {
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, cat.getName());
           ps.execute();
           System.out.println("Data Insert into catagory Table");
       } catch (SQLException ex) {
           Logger.getLogger(ProductCategoryServiceCls.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   public static List<ProductCatagoryCls> getCatList(){
    List<ProductCatagoryCls> list = new ArrayList<>();
    
    String sql = "select * from category";
    
       try {
           PreparedStatement ps = conn.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {               
               ProductCatagoryCls pc = new ProductCatagoryCls();
               pc.setId(rs.getInt(1));
               pc.setName(rs.getString(2));
               list.add(pc);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(ProductCategoryServiceCls.class.getName()).log(Level.SEVERE, null, ex);
       }
   return list;
   }
   
}
