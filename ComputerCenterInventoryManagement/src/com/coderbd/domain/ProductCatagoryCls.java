
package com.coderbd.domain;
public class ProductCatagoryCls {
    private int id;
    private String name;

    public ProductCatagoryCls() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductCatagoryCls{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
