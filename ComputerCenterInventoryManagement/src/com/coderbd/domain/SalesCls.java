
package com.coderbd.domain;

import java.util.Date;

public class SalesCls {
    
    private int id;
    private String productName;
    private String productCode;
    private int qty;
    private double unitPrice;
    private double totalPrice;
    private Date salesDate;
    PurchaseCls purchaseCls;
    UserCls userCls;

    public SalesCls() {
    }

    public SalesCls(String productName, String productCode, int qty, double unitPrice, double totalPrice, Date salesDate, PurchaseCls purchaseCls, UserCls userCls) {
        this.productName = productName;
        this.productCode = productCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.salesDate = salesDate;
        this.purchaseCls = purchaseCls;
        this.userCls = userCls;
    }

    public SalesCls(String productCode, int qty, double unitPrice, double totalPrice, Date salesDate) {
        this.productCode = productCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.salesDate = salesDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public PurchaseCls getPurchaseCls() {
        return purchaseCls;
    }

    public void setPurchaseCls(PurchaseCls purchaseCls) {
        this.purchaseCls = purchaseCls;
    }

    public UserCls getUserCls() {
        return userCls;
    }

    public void setUserCls(UserCls userCls) {
        this.userCls = userCls;
    }

    @Override
    public String toString() {
        return "SalesCls{" + "id=" + id + ", productName=" + productName + ", productCode=" + productCode + ", qty=" + qty + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", salesDate=" + salesDate + ", purchaseCls=" + purchaseCls + ", userCls=" + userCls + '}';
    }

    
    
}
