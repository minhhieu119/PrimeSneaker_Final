/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.prime.form.attributeSneaker;

import com.prime.main_model.ModelCustomer;
import com.prime.model.Customer;
import com.prime.services.OrderService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.apache.xmlbeans.impl.store.Cur;

/**
 *
 * @author MSII
 */
public class CustomerJDialog extends javax.swing.JDialog {

    OrderService os = new OrderService();
//    String fullname;
//    String phoneNumber;
//    boolean gender;
//    String address;

    public CustomerJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    private boolean checkPhone() {
        String regex = "^(\\+84|0)(3[2-9]|5[689]|7[06-9]|8[1-689]|9[0-46-9])[0-9]{7}$";
        Pattern pat = Pattern.compile(regex);
        Matcher matcher = pat.matcher(txtCustomerPhone.getText());
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    private boolean doubleCheck(String p) {
        for (ModelCustomer mc : os.getAllPhoneNumber()) {
            if (mc.getPhoneNumber().equalsIgnoreCase(p)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        txtCustomerPhone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAddCustomer = new javax.swing.JButton();
        rdoCustomerMale = new javax.swing.JRadioButton();
        rdoCustomerFemale = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCustomerAddress = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Thiết lập khách hàng mới");

        jLabel2.setText("Họ và tên");

        txtCustomerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        txtCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerNameActionPerformed(evt);
            }
        });

        txtCustomerPhone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel3.setText("SĐT");

        jLabel4.setText("Giới tính");

        jLabel5.setText("Địa chỉ");

        btnAddCustomer.setBackground(new java.awt.Color(39, 80, 150));
        btnAddCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCustomer.setText("Thêm");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoCustomerMale);
        rdoCustomerMale.setSelected(true);
        rdoCustomerMale.setText("Nam");

        buttonGroup1.add(rdoCustomerFemale);
        rdoCustomerFemale.setText("Nữ");

        txtCustomerAddress.setColumns(20);
        txtCustomerAddress.setRows(5);
        txtCustomerAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        jScrollPane1.setViewportView(txtCustomerAddress);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rdoCustomerMale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoCustomerFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCustomerName, txtCustomerPhone});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdoCustomerMale)
                    .addComponent(rdoCustomerFemale))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCustomerName, txtCustomerPhone});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
       ModelCustomer mc = new ModelCustomer();
       mc.setCustomerName(txtCustomerName.getText());
       mc.setPhoneNumber(txtCustomerPhone.getText());
       mc.setGender(rdoCustomerMale.isSelected() ? true : false);
       mc.setAddress(txtCustomerAddress.getText());

        if (txtCustomerName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên", "Thông báo", 2);
            return;
        }
        if (txtCustomerPhone.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống số điện thoại", "Thông báo", 2);
            return;
        }
        
        if (!checkPhone()) {
            JOptionPane.showMessageDialog(this, "Sai định dạng số điện thoại", "Thông báo", 2);
            return;
        }

        if (doubleCheck(txtCustomerPhone.getText())) {
            JOptionPane.showMessageDialog(this, "Đã tồn tại số điện thoại mời nhập lại");
            txtCustomerPhone.setText("");
            return;
        }
        System.out.println(mc);

        try {
            if (os.addCustomer(mc) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", 1);
                Customer c = new Customer();
                c.setCustomerName(txtCustomerName.getText());
                c.setPhoneNumber(txtCustomerPhone.getText());
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại", "Thông báo", 1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi thêm", "Thông báo", 1);
        }
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void txtCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomerJDialog dialog = new CustomerJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoCustomerFemale;
    private javax.swing.JRadioButton rdoCustomerMale;
    private javax.swing.JTextArea txtCustomerAddress;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerPhone;
    // End of variables declaration//GEN-END:variables
}
