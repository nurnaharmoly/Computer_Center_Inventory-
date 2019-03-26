
package com.coderbd.test;

import com.coderbd.domain.ProductCatagoryCls;
import com.coderbd.service.ProductCategoryServiceCls;

public class ProCategoryClsTest {
    public static void main(String[] args) {
        //ProductCategoryServiceCls.createTable();
        ProductCatagoryCls cat = new ProductCatagoryCls();
        cat.setName("Mouse");
        
        ProductCategoryServiceCls.insert(cat);
    }
}
