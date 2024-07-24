package com.prime.main;

import com.prime.component.Header;
import com.prime.component.Menu;
import com.prime.event.EventMenuSelected;
import com.prime.event.EventShowPopupMenu;
import com.prime.form.Login;
import com.prime.form.ManageSneaker;
import com.prime.form.Statistic;
import com.prime.form.MainForm;
import com.prime.form.ManageCustomer;
import com.prime.form.ManageStaff;
import com.prime.form.OrderForm;
import com.prime.form.ManageOrder;
import com.prime.form.Properties;
import com.prime.form.Voucher;
import com.prime.main_model.SneakerDetail;
import com.prime.swing.MenuItem;
import com.prime.swing.PopupMenu;
import com.prime.swing.icon.GoogleMaterialDesignIcons;
import com.prime.swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;

    public Main() throws SQLException {
        initComponents();
        init();
    }

    private void init() throws SQLException {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                if (menuIndex == 0) {
                    try {
                        main.showForm(new OrderForm());
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (menuIndex == 1) {
                    main.showForm(new ManageOrder());
                }
                if (menuIndex == 2) {
                    main.showForm(new Voucher());
                }
                if (menuIndex == 3) {
                    main.showForm(new ManageSneaker());
                }
                if (menuIndex == 4) {
                    main.showForm(new Properties());
                }
                if (menuIndex == 5) {
                    main.showForm(new ManageStaff());
                }
                if (menuIndex == 6) {
                    main.showForm(new ManageCustomer());
                }
                if (menuIndex == 7) {
                    main.showForm(new Statistic());
                }
            }
        });
//        menu.addEventShowPopup(new EventShowPopupMenu() {
//            @Override
//            public void showPopup(Component com) {
//                MenuItem item = (MenuItem) com;
//                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
//                int x = Main.this.getX() + 52;
//                int y = Main.this.getY() + com.getY() + 500;
//                popup.setLocation(x, y);
//                popup.setVisible(true);
//            }
//        });
        menu.initMenuItem();
//        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
//        bg.add(header, "h 58!, wrap");
//        bg.add(main, "w 100%, h 100%");
        bg.add(menu, "w 62!, spany 2");    // Span Y 2cell
        bg.add(header, "h 58!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {

//            @Override
//            public void timingEvent(float fraction) {
//                double width;
//                if (menu.isShowMenu()) {
//                    width = 60 + (170 * (1f - fraction));
//                } else {
//                    width = 60 + (170 * fraction);
//                }
//                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
//                menu.revalidate();
//            }
//
//            @Override
//            public void end() {
//                menu.setShowMenu(!menu.isShowMenu());
//                menu.setEnableMenu(true);
//            }
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * fraction);
                } else {
                    width = 60 + (170 * (1f - fraction));
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new OrderForm());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý Bán Hàng Giày");

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1354, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
