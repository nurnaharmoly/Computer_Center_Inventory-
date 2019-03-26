
package com.coderbd.test;

import com.coderbd.domain.ProductCatagoryCls;
import com.coderbd.domain.PurchaseCls;
import com.coderbd.domain.UserCls;
import com.coderbd.service.PurchaseServiceCls;
import java.util.Date;
import java.util.List;

public class PurchaseClsTest {
    public static void main(String[] args) {
        //PurchaseServiceCls.createTable();
        
       ProductCatagoryCls pro = new ProductCatagoryCls();
        pro.setId(3);
        
        UserCls uc = new UserCls();
        uc.setId(1);
        
        PurchaseCls pc = new PurchaseCls("Atech mouse", "Atech23m6", 10, 200, 2000 , new Date(), pro, uc);
        PurchaseServiceCls.insertMain(pc); 
      
       
        //List<PurchaseCls> list = PurchaseServiceCls.getProductList();
        //for (PurchaseCls p : list) {
           // System.out.println(p);  
        }
    }

