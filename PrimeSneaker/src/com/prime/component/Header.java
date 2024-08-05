package com.prime.component;

import com.prime.form.Login;
import com.prime.model.Admin;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
        lbUserName.setText(Admin.user.getStaffName());
        System.out.println(Admin.user.getStaffName());
        lbRole.setText(Admin.user.getRoleId() == 1 ? "Quản lý" : "Nhân viên");
    }

    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }
    
    public static void closeAllFrames() {
        for (Window window : Window.getWindows()) {
            if (window instanceof JFrame) {
                ((JFrame) window).dispose();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new com.prime.swing.Button();
        pic = new com.prime.swing.ImageAvatar();
        pic1 = new com.prime.swing.ImageAvatar();
        lbUserName = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        pic2 = new com.prime.swing.ImageAvatar();
        pic3 = new com.prime.swing.ImageAvatar();

        setBackground(new java.awt.Color(39, 80, 150));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/prime/icon/menu.png"))); // NOI18N
        cmdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMenuActionPerformed(evt);
            }
        });

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/prime/icon2/login_img.png"))); // NOI18N

        pic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/prime/icon2/login_img.png"))); // NOI18N
        pic.add(pic1);
        pic1.setBounds(0, 0, 0, 0);

        lbUserName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(255, 255, 255));
        lbUserName.setText("Ánh Quỳnh");

        lbRole.setForeground(new java.awt.Color(246, 243, 243));
        lbRole.setText("Admin");

        pic2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/prime/icon2/logout.png"))); // NOI18N
        pic2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pic2MouseClicked(evt);
            }
        });

        pic3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/prime/icon2/login_img.png"))); // NOI18N
        pic2.add(pic3);
        pic3.setBounds(0, 0, 0, 0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 422, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbRole, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(12, 12, 12)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pic2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbRole)
                        .addGap(6, 6, 6))
                    .addComponent(pic2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdMenuActionPerformed

    private void pic2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pic2MouseClicked
//        System.out.println("exit");
        closeAllFrames();
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_pic2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.prime.swing.Button cmdMenu;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUserName;
    private com.prime.swing.ImageAvatar pic;
    private com.prime.swing.ImageAvatar pic1;
    private com.prime.swing.ImageAvatar pic2;
    private com.prime.swing.ImageAvatar pic3;
    // End of variables declaration//GEN-END:variables
}
