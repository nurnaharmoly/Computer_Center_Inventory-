
package com.coderbd.test;

import com.coderbd.domain.UserCls;
import com.coderbd.service.UserServiceCls;
import java.util.Date;

public class UserTest {
    public static void main(String[] args) {
        //UserServiceCls.createTable();
       UserCls uc = new UserCls("Roni", "456", "Salesman", "Mr", "Roni", "roni@gmail.com", "01814526954", new Date(), true);
        UserServiceCls.insert(uc);

          //UserCls uc = UserServiceCls.getUserByuserName("moly", "123", true);
          //System.out.println(uc);


        
    }
}
