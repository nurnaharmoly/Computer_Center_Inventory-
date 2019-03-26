
package com.coderbd.service;

import com.coderbd.connection.MySqlJdbcConnection;
import com.coderbd.domain.ProductCatagoryCls;
import com.coderbd.domain.PurchaseCls;
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

public class PurchaseServiceCls {
    
    static Connection conn = MySqlJdbcConnection.getConnection();
    
    
    public static void createTable(){
     
        String sql = "Create table purchase(id int auto_increment primary key, productName varchar(30) not null, productCode varchar(30) not null, qty int(11) not null, unitPrice double not null, totalPrice double not null, purchaseDate date not null, cat_id int(11) not null, foreign key(cat_id) references category(id), user_id int(11) not null, foreign key (user_id) references user(id)ON DELETE RESTRICT ON UPDATE CASCADE)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Created Purchase Table");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insert(PurchaseCls pur){
     
        String sql = "insert into purchase(productName, productCode, qty, unitPrice, totalPrice, purchaseDate, cat_id, user_id) values(?,?,?,?,?,?,?,?)";
          
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pur.getProductName());
            ps.setString(2, pur.getProductCode());
            ps.setInt(3, pur.getQty());
            ps.setDouble(4, pur.getUnitPrice());
            ps.setDouble(5, pur.getTotalPrice());
            ps.setDate(6, new java.sql.Date(pur.getPurchaseDate().getTime()));
            ps.setInt(7, pur.getProductCatagoryCls().getId());
            ps.setInt(8, pur.getUserCls().getId());
            ps.executeUpdate();
            System.out.println("Data Insert into purchase Table");
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static PurchaseCls getPurchaseByProductCode(String productCode){
    PurchaseCls pur = new PurchaseCls();
        String sql = "select * from purchase where productCode=?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productCode);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                pur.setId(rs.getInt(1));
                pur.setProductName(rs.getString(2));
                pur.setProductCode(rs.getString(3));
                pur.setQty(rs.getInt(4));
                pur.setUnitPrice(rs.getDouble(5));
                pur.setTotalPrice(rs.getDouble(6));
                pur.setPurchaseDate(rs.getDate(7));
                ProductCatagoryCls pc = new ProductCatagoryCls();
                pc.setId(rs.getInt(8));
                pur.setProductCatagoryCls(pc);
                UserCls u = new UserCls();
                u.setId(rs.getInt(9));
                pur.setUserCls(u);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
       return pur;
    }
    
    public static void insertMain(PurchaseCls pc){
     if (pc != null){
         insert(pc);
         PurchaseCls p = getPurchaseByProductCode(pc.getProductCode());
         
         try {
             SummaryCls sc = SummaryServiceCls.getSummaryByProductCode(pc.getProductCode());
         if(pc.getProductCode().equalsIgnoreCase(sc.getProductCode())){
         int totalQty = sc.getTotalQty()+pc.getQty();
         int avilQty = sc.getAvailableQty()+pc.getQty();
         sc.setTotalQty(totalQty);
         sc.setAvailableQty(avilQty);
         sc.setLastUpdate(new Date());
         } 
            SummaryServiceCls.update(sc);
            
         } catch (NullPointerException e) {
             
             SummaryCls sc2 = new SummaryCls(pc.getProductName(), pc.getProductCode(), pc.getQty(), 0, pc.getQty(), new Date(), p);
             SummaryServiceCls.insert(sc2);
         }
      }
    }
    
    
    public static PurchaseCls getProductDetails(String productCode){
    
        PurchaseCls pc = new PurchaseCls();
        String sql = "select * from purchase p, category c where p.productCode=? and p.cat_id = c.id limit 1";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pc.setId(rs.getInt(1));
                pc.setProductName(rs.getString(2));
                pc.setProductCode(rs.getString(3));
                pc.setQty(rs.getInt(4));
                pc.setUnitPrice(rs.getDouble(5));
                pc.setTotalPrice(rs.getDouble(6));
                pc.setPurchaseDate(rs.getDate(7));
                ProductCatagoryCls pcc = new ProductCatagoryCls();
                pcc.setId(rs.getInt(8));
                pcc.setName(rs.getString("name"));
                pc.setProductCatagoryCls(pcc);
                UserCls uc = new UserCls();
                uc.setId(rs.getInt(9));
                pc.setUserCls(uc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pc;
    }
    
    
    public static List<PurchaseCls> getProductList(){
         List<PurchaseCls> list = new ArrayList<>();
         
         String sql = "select p.productName, p.productCode, p.qty, p.unitPrice, p.totalPrice, p.purchaseDate, c.name from purchase p, category c where p.cat_id = c.id";
         
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
               PurchaseCls pc = new PurchaseCls();
              
               pc.setProductName(rs.getString(1));
               pc.setProductCode(rs.getString(2));
               pc.setQty(rs.getInt(3));
               pc.setUnitPrice(rs.getDouble(4));
               pc.setTotalPrice(rs.getDouble(5));
               pc.setPurchaseDate(rs.getDate(6));
               ProductCatagoryCls pcc = new ProductCatagoryCls();
              
               pcc.setName(rs.getString("name"));
               pc.setProductCatagoryCls(pcc);
               UserCls uc = new UserCls();
               
               list.add(pc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
