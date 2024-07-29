
package com.prime.form.attributeSneaker;

import com.prime.form.ManageSneaker;
import com.prime.main_model.Model_Brand;
import com.prime.responsitory.BrandResponsitory;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class BrandDialog extends javax.swing.JDialog {

    DefaultTableModel model = new DefaultTableModel();
    int index;
    ManageSneaker sneaker = new ManageSneaker();
    private final BrandResponsitory brs = new BrandResponsitory();
    public BrandDialog(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tblBrand.getModel();
        loadBrandToTable(brs.getALl());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBrandId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBrandName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBrand = new javax.swing.JTable();
        btnAddBrand = new javax.swing.JButton();
        btnEditBrand = new javax.swing.JButton();
        btnClearBrand = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hãng giày");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Hãng giày");

        jLabel1.setText("Mã hãng giày");

        txtBrandId.setEditable(false);
        txtBrandId.setEnabled(false);

        jLabel2.setText("Tên hãng");

        tblBrand.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thuộc tính", "Tên thuộc tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBrandMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBrand);

        btnAddBrand.setText("Thêm");
        btnAddBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBrandActionPerformed(evt);
            }
        });

        btnEditBrand.setText("Sửa");
        btnEditBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBrandActionPerformed(evt);
            }
        });

        btnClearBrand.setText("Làm mới");
        btnClearBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearBrandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBrandName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBrandId, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddBrand)
                        .addGap(67, 67, 67)
                        .addComponent(btnEditBrand)
                        .addGap(63, 63, 63)
                        .addComponent(btnClearBrand))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddBrand, btnClearBrand, btnEditBrand});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrandId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrandName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBrand)
                    .addComponent(btnEditBrand)
                    .addComponent(btnClearBrand))
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddBrand, btnClearBrand, btnEditBrand});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBrandActionPerformed
        if (txtBrandName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập hãng Giày");
            txtBrandName.requestFocus();
            return;
        }
        if (txtBrandName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Hãng giày không được nhập số");
            txtBrandName.requestFocus();
            return;
        }
        ArrayList<Model_Brand> lst = brs.getALl();
            for (Model_Brand br : lst) {
                if (txtBrandName.getText().trim().toLowerCase().equals(br.getBrand_name().toLowerCase())) {
                    JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                    return;
                }
            }
        Model_Brand br = readForm();
        if (brs.addBrand(br) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadBrandToTable(brs.getALl());
            sneaker.loadDataBrand();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnAddBrandActionPerformed

    private void btnEditBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBrandActionPerformed
        if (txtBrandId.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Brand cần sửa");
            return;
        }
        if (txtBrandName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Hãng Giày");
            txtBrandName.requestFocus();
            return;
        }
        if (txtBrandName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Hãng giày không được nhập số");
            txtBrandName.requestFocus();
            return;
        }
        ArrayList<Model_Brand> lst = brs.getALl();
            for (Model_Brand br : lst) {
                if (txtBrandName.getText().equals(br.getBrand_name())) {
                    JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                    return;
                }
            }
        Model_Brand br = readForm1();
        if (brs.upDateBrand(br) != null) {
            JOptionPane.showMessageDialog(this, "Update thành công");
            loadBrandToTable(brs.getALl());
        } else
            JOptionPane.showMessageDialog(this, "Update thất bại");
    }//GEN-LAST:event_btnEditBrandActionPerformed

    private void btnClearBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearBrandActionPerformed
         txtBrandId.setText("");
        txtBrandName.setText("");
    }//GEN-LAST:event_btnClearBrandActionPerformed

    private void tblBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBrandMouseClicked
        index =tblBrand.getSelectedRow();
        showDetail(index);
    }//GEN-LAST:event_tblBrandMouseClicked

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
            java.util.logging.Logger.getLogger(BrandDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrandDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrandDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrandDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BrandDialog dialog = new BrandDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAddBrand;
    private javax.swing.JButton btnClearBrand;
    private javax.swing.JButton btnEditBrand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBrand;
    private javax.swing.JTextField txtBrandId;
    private javax.swing.JTextField txtBrandName;
    // End of variables declaration//GEN-END:variables
    private void loadBrandToTable(ArrayList<Model_Brand> lst) {
        model.setRowCount(0);       
        for (Model_Brand br : lst) {
            model.addRow(new Object[]{
                br.getBrand_id(),
                br.getBrand_name()
            });
        }
    }

    private Model_Brand readForm() {
        Model_Brand br = new Model_Brand();
        br.setBrand_name(txtBrandName.getText().trim());
        return br;
    }

    private Model_Brand readForm1() {
        Model_Brand br = new Model_Brand();
        br.setBrand_name(txtBrandName.getText());
        br.setBrand_id(Integer.parseInt(txtBrandId.getText()));
        return br;
    }

    private void showDetail(int index) {
        txtBrandId.setText(tblBrand.getValueAt(index,0).toString());
        txtBrandName.setText(tblBrand.getValueAt(index, 1).toString());
        tblBrand.setRowSelectionInterval(index, index);
    }
}
