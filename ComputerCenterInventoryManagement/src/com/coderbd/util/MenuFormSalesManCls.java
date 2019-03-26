package com.coderbd.util;

import com.coderbd.view.DashBoardddd;
import com.coderbd.view.LoginJF;
import com.coderbd.view.SalesClsView1;
import com.coderbd.view.SalesClsForSalesManView11;
import com.coderbd.view.UserDashBoardddd;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuFormSalesManCls {

    public static JMenuBar commonMenuForSalesMan(JFrame f) {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem dashboard = new JMenuItem("Dashboard");
        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 f.setVisible(false);
                new UserDashBoardddd().setVisible(true);
            }
        });
        
        
        JMenuItem sales = new JMenuItem("Sales");
        sales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 f.setVisible(false);
                new SalesClsForSalesManView11().setVisible(true);
            }
        });
        JMenuItem summary = new JMenuItem("Summary");
        summary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 f.setVisible(false);
                new DashBoardddd().setVisible(true);
            }
        });
       
        JMenuItem signOut = new JMenuItem("Sign Out");
        signOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new LoginJF().setVisible(true);
            }
        });
        file.add(dashboard);
        file.addSeparator();      
        file.add(sales);
        file.addSeparator();
        file.add(summary);
        file.addSeparator();       
        file.add(signOut);

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                System.exit(0);
            }
        });
        menuBar.add(file);
        menuBar.add(exit);      
        f.setJMenuBar(menuBar);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return menuBar;
    }
}
