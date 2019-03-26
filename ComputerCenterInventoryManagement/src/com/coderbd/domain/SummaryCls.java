
package com.coderbd.domain;

import java.util.Date;

public class SummaryCls {
    
    private int id;
    private String productName;
    private String productCode;
    private int totalQty;
    private int soldQty;
    private int availableQty;
    private Date lastUpdate;
    PurchaseCls purchaseCls;

    public SummaryCls() {
    }

    public SummaryCls(String productCode, int totalQty, int soldQty, int availableQty, Date lastUpdate) {
        this.productCode = productCode;
        this.totalQty = totalQty;
        this.soldQty = soldQty;
        this.availableQty = availableQty;
        this.lastUpdate = lastUpdate;
    }

    public SummaryCls(String productName, String productCode, int totalQty, int soldQty, int availableQty, Date lastUpdate, PurchaseCls purchaseCls) {
        this.productName = productName;
        this.productCode = productCode;
        this.totalQty = totalQty;
        this.soldQty = soldQty;
        this.availableQty = availableQty;
        this.lastUpdate = lastUpdate;
        this.purchaseCls = purchaseCls;
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

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public PurchaseCls getPurchaseCls() {
        return purchaseCls;
    }

    public void setPurchaseCls(PurchaseCls purchaseCls) {
        this.purchaseCls = purchaseCls;
    }

    @Override
    public String toString() {
        return "SummaryCls{" + "id=" + id + ", productName=" + productName + ", productCode=" + productCode + ", totalQty=" + totalQty + ", soldQty=" + soldQty + ", availableQty=" + availableQty + ", lastUpdate=" + lastUpdate + ", purchaseCls=" + purchaseCls + '}';
    }
    
    
    
}
