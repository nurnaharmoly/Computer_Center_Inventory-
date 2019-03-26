
package com.coderbd.test;

import com.coderbd.domain.PurchaseCls;
import com.coderbd.domain.SalesCls;
import com.coderbd.domain.UserCls;
import com.coderbd.service.SalesServiceCls;
import java.util.Date;

public class SalesClsTest {
    public static void main(String[] args) {
        SalesServiceCls.createTable();
        /*PurchaseCls pc = new PurchaseCls();
        pc.setId(3);
        
        UserCls u = new UserCls();
        u.setId(2);
        
        SalesCls sc = new SalesCls("ASUS VivoBook S510U", "ASUSVivoBookS510U", 10, 60000, 600000, new Date(), pc, u);
        SalesServiceCls.insertForSales(sc);*/
    }
}
