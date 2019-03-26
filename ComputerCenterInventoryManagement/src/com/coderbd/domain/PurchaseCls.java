
package com.coderbd.domain;

import java.util.Date;

public class PurchaseCls {
    
    private int id;
    private String productName;
    private String productCode;
    private int qty;
    private double unitPrice;
    private double totalPrice;
    private Date purchaseDate;
    ProductCatagoryCls productCatagoryCls;
    UserCls userCls;

    public PurchaseCls() {
    }

    public PurchaseCls(String productName, String productCode, int qty, double unitPrice, double totalPrice, Date purchaseDate, ProductCatagoryCls productCatagoryCls, UserCls userCls) {
        this.productName = productName;
        this.productCode = productCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
        this.productCatagoryCls = productCatagoryCls;
        this.userCls = userCls;
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

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public ProductCatagoryCls getProductCatagoryCls() {
        return productCatagoryCls;
    }

    public void setProductCatagoryCls(ProductCatagoryCls productCatagoryCls) {
        this.productCatagoryCls = productCatagoryCls;
    }

    public UserCls getUserCls() {
        return userCls;
    }

    public void setUserCls(UserCls userCls) {
        this.userCls = userCls;
    }

    @Override
    public String toString() {
        return "PurchaseCls{" + "id=" + id + ", productName=" + productName + ", productCode=" + productCode + ", qty=" + qty + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", purchaseDate=" + purchaseDate + ", productCatagoryCls=" + productCatagoryCls + ", userCls=" + userCls + '}';
    }

    
    
    
    
}
