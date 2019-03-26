
package com.coderbd.service;

import com.coderbd.connection.MySqlJdbcConnection;
import com.coderbd.domain.ProductCatagoryCls;
import com.coderbd.domain.PurchaseCls;
import com.coderbd.domain.SummaryCls;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SummaryServiceCls {
    
    static Connection conn = MySqlJdbcConnection.getConnection();
    
    public static void createTable(){
     
        String sql = "create table summary(id int auto_increment primary key, productName varchar(50) not null, productCode varchar(30) not null, totalQty int(11) not null, soldQty int(11) not null, availableQty int(11) not null, lastUpdate date, product_id int(11)not null, foreign key (product_id) references purchase(id) ON DELETE RESTRICT ON UPDATE CASCADE)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Created Summary Table");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insert(SummaryCls sc){
    
        String sql = "insert into summary(productName, productCode, totalQty, soldQty, availableQty, lastUpdate, product_id) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sc.getProductName());
            ps.setString(2, sc.getProductCode());
            ps.setInt(3, sc.getTotalQty());
            ps.setInt(4, sc.getSoldQty());
            ps.setInt(5, sc.getAvailableQty());
            ps.setDate(6, new java.sql.Date(sc.getLastUpdate().getTime()));
            ps.setInt(7, sc.getPurchaseCls().getId());
            ps.execute();
            System.out.println("Data Insert into summary Table");
            
        } catch (SQLException ex) {
            Logger.getLogger(SummaryServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void update(SummaryCls sc){
    
        String sql = "update summary set totalQty =?, soldQty=?, availableQty =?, lastUpdate =? where productCode=?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sc.getTotalQty());
            ps.setInt(2, sc.getSoldQty());
            ps.setInt(3, sc.getAvailableQty());
            ps.setDate(4, new java.sql.Date(sc.getLastUpdate().getTime()));
            ps.setString(5, sc.getProductCode());
            ps.executeUpdate();
            System.out.println("Data Update in summary Table");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static SummaryCls getSummaryByProductCode(String productCode){
    
        SummaryCls sc = new SummaryCls();
        String sql = "select * from summary where productCode=?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productCode);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
            sc.setId(rs.getInt(1));
            sc.setProductName(rs.getString(2));
            sc.setProductCode(rs.getString(3));
            sc.setTotalQty(rs.getInt(4));
            sc.setSoldQty(rs.getInt(5));
            sc.setAvailableQty(rs.getInt(6));
            sc.setLastUpdate(rs.getDate(7));
                PurchaseCls p = new PurchaseCls();
                p.setId(rs.getInt(8));
            sc.setPurchaseCls(p);
            
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(SummaryServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
       return sc;
    }
    
    public static List<SummaryCls> getSummaryList(){
    List<SummaryCls> list = new ArrayList<>();
    
    String sql = "select s.productName, s.productCode, s.totalQty,s.soldQty, s.availableQty, c.name from summary s, purchase p, category c where s.product_id = p.id and p.cat_id = c.id";
    
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                SummaryCls sc = new SummaryCls();
                sc.setProductName(rs.getString(1));
                sc.setProductCode(rs.getString(2));
                sc.setTotalQty(rs.getInt(3));
                sc.setSoldQty(rs.getInt(4));
                sc.setAvailableQty(rs.getInt(5));
                ProductCatagoryCls pc = new ProductCatagoryCls();
                pc.setName(rs.getString("name"));
                PurchaseCls p = new PurchaseCls();
                p.setProductCatagoryCls(pc);
                sc.setPurchaseCls(p);
                list.add(sc);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SummaryServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
     return  list;
    }
    
}
