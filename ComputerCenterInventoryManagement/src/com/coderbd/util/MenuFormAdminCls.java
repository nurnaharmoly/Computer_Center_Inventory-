
package com.coderbd.util;

import com.coderbd.view.DashBoardddd;
import com.coderbd.view.LoginJF;
import com.coderbd.view.PurchaseClsView;
import com.coderbd.view.PurchaseReportClsView;
import com.coderbd.view.SalesClsView1;
import com.coderbd.view.SalesReportClsView;
import com.coderbd.view.SignUpClsView;
import com.coderbd.view.UserReportClsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuFormAdminCls {
     public static JMenuBar commonMenuForAdmin(JFrame f) {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem dashboard = new JMenuItem("Dashboard");
        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new DashBoardddd().setVisible(true);
            }
        });
        JMenuItem pCategory = new JMenuItem("category");
        pCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new DashBoardddd().setVisible(true);
            }
        });
        JMenuItem purchase = new JMenuItem("Purchase");
        purchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new PurchaseClsView().setVisible(true);
            }
        });
        JMenuItem sales = new JMenuItem("Sales");
        sales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new SalesClsView1().setVisible(true);
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
        JMenuItem user = new JMenuItem("User");
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new SignUpClsView().setVisible(true);
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
        file.add(pCategory);
        file.addSeparator();
        file.add(purchase);
        file.addSeparator();
        file.add(sales);
        file.addSeparator();
        file.add(summary);
        file.addSeparator();
        file.add(user);
        file.addSeparator();
        file.add(signOut);
        JMenu report = new JMenu("Report");
        JMenuItem purchaseReport = new JMenuItem("Purchase");
        purchaseReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new PurchaseReportClsView().setVisible(true);
            }
        });
        JMenuItem saleReport = new JMenuItem("Sales");
        saleReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new SalesReportClsView().setVisible(true);
            }
        });
        JMenuItem userReport = new JMenuItem("User");
        userReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new UserReportClsView().setVisible(true);
            }
        });

        report.add(purchaseReport);
        report.add(saleReport);
        report.add(userReport);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                System.exit(0);
            }
        });

        menuBar.add(file);
        menuBar.add(report);
        menuBar.add(exit);
        f.setJMenuBar(menuBar);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return menuBar;
    }
}
