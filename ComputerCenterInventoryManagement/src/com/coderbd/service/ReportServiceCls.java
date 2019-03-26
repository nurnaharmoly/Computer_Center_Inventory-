/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.service;

import com.coderbd.connection.MySqlJdbcConnection;
import com.coderbd.domain.AdminDashBordCls;
import com.coderbd.domain.ProductCatagoryCls;
import com.coderbd.domain.PurchaseCls;
import com.coderbd.domain.SalesCls;
import com.coderbd.domain.UserCls;
import com.coderbd.service.ProductCategoryServiceCls;
import com.coderbd.service.PurchaseServiceCls;
import com.coderbd.util.DateFormatingCls;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ReportServiceCls {
    static Connection conn = MySqlJdbcConnection.getConnection();

//////////////////////////user Report//////////////////////////
    public static List<UserCls> getUserListByStatus(boolean status) {
        List<UserCls> list = new ArrayList<>();

        String sql = "select * from user where status=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, status);
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
            Logger.getLogger(ReportServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<UserCls> getUserListByUserType(String userType) {
        List<UserCls> list = new ArrayList<>();

        String sql = "select * from user where userType=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userType);
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
            Logger.getLogger(ReportServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<UserCls> getUserListByUserTypeAndStatus(String userType, boolean status) {
        List<UserCls> list = new ArrayList<>();

        String sql = "select * from user where userType=? and status=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userType);
            ps.setBoolean(2, status);
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
            Logger.getLogger(ReportServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    ////////////////Purchase Report///////////////////////

    public static List<PurchaseCls> getProductListBycategory(int categoryId) {
        List<PurchaseCls> list = new ArrayList<>();

        String sql = "select * from purchase p, category c where p.cat_id=c.id and cat_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PurchaseCls purchase = new PurchaseCls();
                purchase.setId(rs.getInt(1));
                purchase.setProductName(rs.getString(2));
                purchase.setProductCode(rs.getString(3));
                purchase.setQty(rs.getInt(4));
                purchase.setUnitPrice(rs.getDouble(5));
                purchase.setTotalPrice(rs.getDouble(6));
                purchase.setPurchaseDate(rs.getDate(7));
                ProductCatagoryCls pc = new ProductCatagoryCls();
                pc.setId(rs.getInt(8));
                pc.setName(rs.getString("name"));
                purchase.setProductCatagoryCls(pc);

                list.add(purchase);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<PurchaseCls> getProductListByDateRange(Date startdate, Date endDate) {
        List<PurchaseCls> list = new ArrayList<>();

        String sql = "select * from purchase p, category c where p.cat_id=c.id and purchasedate between ? and ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(startdate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PurchaseCls purchase = new PurchaseCls();
                purchase.setId(rs.getInt(1));
                purchase.setProductName(rs.getString(2));
                purchase.setProductCode(rs.getString(3));
                purchase.setQty(rs.getInt(4));
                purchase.setUnitPrice(rs.getDouble(5));
                purchase.setTotalPrice(rs.getDouble(6));
                purchase.setPurchaseDate(rs.getDate(7));
                ProductCatagoryCls pc = new ProductCatagoryCls();
                pc.setId(rs.getInt(8));
                pc.setName(rs.getString("name"));
                purchase.setProductCatagoryCls(pc);

                list.add(purchase);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static Double getPurchaseAmountByDateRange(Date startdate, Date endDate) {
        Double totalPurchaseAmount = 0.0;
        String sql = " select totalPrice from purchase where purchasedate between ? and ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(startdate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                totalPurchaseAmount += rs.getDouble(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPurchaseAmount;
    }

    public static Double getTotalPurchaseAmount() {
        Double totalPurchaseAmount = 0.0;
        String sql = " select totalPrice from purchase";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                totalPurchaseAmount += rs.getDouble(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPurchaseAmount;
    }

    public static int getTotalPurchaseItems() {
        int totalPurchaseItems = 0;
        String sql = " select qty from purchase";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                totalPurchaseItems += rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPurchaseItems;
    }

    public static int getTotalPurchaseItemsByToday(Date today) {
        int totalPurchaseItems = 0;
        String sql = " select qty from purchase where purchaseDate=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(today.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                totalPurchaseItems += rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalPurchaseItems;
    }

    ////////////////////////Sales Report////////////////////////////////////
    public static List<SalesCls> getSalesByUser(int userID) {
        List<SalesCls> list = new ArrayList<>();

        String sql = "select s.productName,s.productCode, s.qty, s.unitPrice, s.totalPrice, s.salesdate, c.name from sales s, purchase p, category c where s.product_id=p.id and p.cat_id=c.id and s.user_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SalesCls sales = new SalesCls();
                sales.setProductName(rs.getString(1));
                sales.setProductCode(rs.getString(2));
                sales.setQty(rs.getInt(3));
                sales.setUnitPrice(rs.getDouble(4));
                sales.setTotalPrice(rs.getDouble(5));
                sales.setSalesDate(rs.getDate(6));
                ProductCatagoryCls pc = new ProductCatagoryCls();
                pc.setName(rs.getString(7));
                PurchaseCls p = new PurchaseCls();
                p.setProductCatagoryCls(pc);
                sales.setPurchaseCls(p);
                list.add(sales);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<SalesCls> getSalesByUserAndDateRange(int userID, Date startdate, Date endDate) {
        List<SalesCls> list = new ArrayList<>();

        String sql = "select s.productName,s.productCode, s.qty, s.unitPrice, s.totalPrice, s.salesdate, c.name from sales s, purchase p, category c where s.product_id=p.id and p.cat_id=c.id and s.user_id=? and s.salesdate between ? and ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setDate(2, new java.sql.Date(startdate.getTime()));
            ps.setDate(3, new java.sql.Date(endDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SalesCls sales = new SalesCls();
                sales.setProductName(rs.getString(1));
                sales.setProductCode(rs.getString(2));
                sales.setQty(rs.getInt(3));
                sales.setUnitPrice(rs.getDouble(4));
                sales.setTotalPrice(rs.getDouble(5));
                sales.setSalesDate(rs.getDate(6));
                ProductCatagoryCls pc = new ProductCatagoryCls();
                pc.setName(rs.getString(7));
                PurchaseCls p = new PurchaseCls();
                p.setProductCatagoryCls(pc);
                sales.setPurchaseCls(p);
                list.add(sales);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<SalesCls> getSalesByDateRange(Date startdate, Date endDate) {
        List<SalesCls> list = new ArrayList<>();

        String sql = "select s.productName,s.productCode, s.qty, s.unitPrice, s.totalPrice, s.salesdate, c.name from sales s, purchase p, category c where s.product_id=p.id and p.cat_id=c.id and s.salesdate between ? and ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(startdate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SalesCls sales = new SalesCls();
                sales.setProductName(rs.getString(1));
                sales.setProductCode(rs.getString(2));
                sales.setQty(rs.getInt(3));
                sales.setUnitPrice(rs.getDouble(4));
                sales.setTotalPrice(rs.getDouble(5));
                sales.setSalesDate(rs.getDate(6));
                ProductCatagoryCls pc = new ProductCatagoryCls();
                pc.setName(rs.getString(7));
                PurchaseCls p = new PurchaseCls();
                p.setProductCatagoryCls(pc);
                sales.setPurchaseCls(p);
                list.add(sales);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static List<SalesCls> getSalesByToday(Date today) {
        List<SalesCls> list = new ArrayList<>();
        String sql = "select s.productName,s.productCode, s.qty, s.unitPrice, s.totalPrice, s.salesdate, c.name from sales s, purchase p, category c where s.product_id=p.id and p.cat_id=c.id and s.salesdate=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(today.getTime()));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SalesCls sales = new SalesCls();
                sales.setProductName(rs.getString(1));
                sales.setProductCode(rs.getString(2));
                sales.setQty(rs.getInt(3));
                sales.setUnitPrice(rs.getDouble(4));
                sales.setTotalPrice(rs.getDouble(5));
                sales.setSalesDate(rs.getDate(6));
                ProductCatagoryCls pc = new ProductCatagoryCls();
                pc.setName(rs.getString(7));
                PurchaseCls p = new PurchaseCls();
                p.setProductCatagoryCls(pc);
                sales.setPurchaseCls(p);
                list.add(sales);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static Double getSalesAmountByToday(Date today) {
        Double amount = 0.0;
        String sql = "select sum(totalPrice) from sales where salesdate=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(today.getTime()));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                amount = rs.getDouble(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }

    public static double getSalesTotalAmount() {
        double amount = 0.0;
        String sql = "select totalPrice from sales";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                amount += rs.getDouble(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }

    public static int getSalesTotalItems() {
        int amount = 0;
        String sql = "select qty from sales";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                amount += rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }

    public static int getSoldTodayItems(Date today) {
        int item = 0;
        String sql = "select sum(qty) from sales where salesdate=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(today.getTime()));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                item = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    public static Double getSalesAmountByDateRange(Date sDate, Date eDate) {
        Double amount = 0.0;
        String sql = "select totalPrice from sales where salesdate between ? and ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(sDate.getTime()));
            ps.setDate(2, new java.sql.Date(eDate.getTime()));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                amount += rs.getDouble(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseServiceCls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }

    public static AdminDashBordCls getDashboardDetails() {
        AdminDashBordCls adb = new AdminDashBordCls();

        adb.setTodaysPurchaseAmount(getPurchaseAmountByDateRange(DateFormatingCls.getDateFromString(DateFormatingCls.getStringFromDate(new Date())), DateFormatingCls.getDateFromString(DateFormatingCls.getStringFromDate(new Date()))));

        adb.setEntirePurchaseAmount(getTotalPurchaseAmount());

        adb.setCurrentMonthPurchaseAmount(getPurchaseAmountByDateRange(DateFormatingCls.getFirstDateOfCurrentMonth(), DateFormatingCls.getDateFromString(DateFormatingCls.getStringFromDate(new Date()))));
        adb.setTotalItems(getTotalPurchaseItems());
        adb.setTodaysPurchaseItem(getTotalPurchaseItemsByToday(DateFormatingCls.getDateFromString(DateFormatingCls.getStringFromDate(new Date()))));
        ///////////sales part

        adb.setTodaysSalesAmount(getSalesAmountByToday(DateFormatingCls.getDateFromString(DateFormatingCls.getStringFromDate(new Date()))));
        adb.setCurrentMonthSalesAmount(getSalesAmountByDateRange(DateFormatingCls.getFirstDateOfCurrentMonth(), DateFormatingCls.getDateFromString(DateFormatingCls.getStringFromDate(new Date()))));

        adb.setEntireSalesAmount(getSalesTotalAmount());
        adb.setTotalSoldItems(getSalesTotalItems());
        adb.setTodaysSoldItems(getSoldTodayItems(DateFormatingCls.getDateFromString(DateFormatingCls.getStringFromDate(new Date()))));

        return adb;
    }

    
}
