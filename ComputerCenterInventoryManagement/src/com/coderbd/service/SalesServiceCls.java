
package com.coderbd.service;

import com.coderbd.connection.MySqlJdbcConnection;
import com.coderbd.domain.ProductCatagoryCls;
import com.coderbd.domain.PurchaseCls;
import com.coderbd.domain.SalesCls;
import com.coderbd.domain.SummaryCls;
import com.coderbd.domain.UserCls;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalesServiceCls {
    
    static Connection conn = MySqlJdbcConnection.getConnection();
    
    
    public static void createTable(){
     
        String sql = "Create table sales(id int auto_increment primary key, productName varchar(30) not null, productCode varchar(30) not null, qty int(11) not null, unitPrice double not null, totalPrice double not null, salesDate date not null, Product_id int(11) not null, foreign key(Product_id) references purchase(id), user_id int(11) not null, foreign key (user_id) references user(id)ON DELETE RESTRICT ON UPDATE CASCADE)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Created sales Table");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insert(SalesCls sc){
     
        String sql = "insert into sales(productName, productCode, qty, unitPrice, totalPrice, salesDate, product_id, user_id) values(?,?,?,?,?,?,?,?)";
          
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sc.getProductName());
            ps.setString(2, sc.getProductCode());
            ps.setInt(3, sc.getQty());
            ps.setDouble(4, sc.getUnitPrice());
            ps.setDouble(5, sc.getTotalPrice());
            ps.setDate(6, new java.sql.Date(sc.getSalesDate().getTime()));
            ps.setInt(7, sc.getPurchaseCls().getId());
            ps.setInt(8, sc.getUserCls().getId());
            ps.executeUpdate();
            System.out.println("Data Insert into Sales Table");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void insertForSales(SalesCls sc){
     if (sc != null){
         SummaryCls smc = SummaryServiceCls.getSummaryByProductCode(sc.getProductCode());
         
         if(smc.getAvailableQty() >= sc.getQty()){
             insert(sc);
         int soldQty = smc.getSoldQty()+sc.getQty();
         int avilQty = smc.getAvailableQty()- sc.getQty();
         smc.setSoldQty(soldQty);
         smc.setAvailableQty(avilQty);
         smc.setLastUpdate(new Date());
         
         SummaryServiceCls.update(smc);
         }else{
             System.out.println("You do not have sufficient Product");
         }
       }
    }
    
    
    public static List<SalesCls> getSalesList(){
         List<SalesCls> list = new ArrayList<>();
         
         String sql = "select s.productName,s.productCode, s.qty, s.unitPrice, s.totalPrice, s.salesdate, c.name from sales s, purchase p, category c where s.product_id=p.id and p.cat_id=c.id";
         
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
               SalesCls sc = new SalesCls();
               sc.setProductName(rs.getString(1));
               sc.setProductCode(rs.getString(2));
               sc.setQty(rs.getInt(3));
               sc.setUnitPrice(rs.getDouble(4));
               sc.setTotalPrice(rs.getDouble(5));
               sc.setSalesDate(rs.getDate(6));
               ProductCatagoryCls pcc = new ProductCatagoryCls();
               pcc.setName(rs.getString(7));
               PurchaseCls pc = new PurchaseCls();
               pc.setProductCatagoryCls(pcc);
               sc.setPurchaseCls(pc);
               
               list.add(sc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
