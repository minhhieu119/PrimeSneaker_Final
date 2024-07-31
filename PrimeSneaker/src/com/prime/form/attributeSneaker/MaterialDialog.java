package com.prime.form.attributeSneaker;

import com.prime.form.ManageSneaker;
import com.prime.main_model.Material;
import com.prime.responsitory.MaterialResponsitory;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MaterialDialog extends javax.swing.JDialog {

    DefaultTableModel model = new DefaultTableModel();
    int index;
    private final MaterialResponsitory mrs = new MaterialResponsitory();
    ManageSneaker sneaker = new ManageSneaker();

    public MaterialDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tblMaterial.getModel();
        loadMaterialToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaterialId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaterialName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaterial = new javax.swing.JTable();
        btnAddMaterial = new javax.swing.JButton();
        btnEditMaterial = new javax.swing.JButton();
        btnClearMaterial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chất liệu giày");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Chất liệu giày");

        jLabel1.setText("Mã chất liệu");

        txtMaterialId.setEditable(false);
        txtMaterialId.setEnabled(false);

        jLabel2.setText("Tên chất liệu");

        tblMaterial.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaterialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMaterial);

        btnAddMaterial.setText("Thêm");
        btnAddMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMaterialActionPerformed(evt);
            }
        });

        btnEditMaterial.setText("Sửa");
        btnEditMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditMaterialActionPerformed(evt);
            }
        });

        btnClearMaterial.setText("Làm mới");
        btnClearMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearMaterialActionPerformed(evt);
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
                        .addComponent(txtMaterialName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaterialId, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddMaterial)
                        .addGap(67, 67, 67)
                        .addComponent(btnEditMaterial)
                        .addGap(63, 63, 63)
                        .addComponent(btnClearMaterial))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddMaterial, btnClearMaterial, btnEditMaterial});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaterialId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMaterial)
                    .addComponent(btnEditMaterial)
                    .addComponent(btnClearMaterial))
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddMaterial, btnClearMaterial, btnEditMaterial});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMaterialActionPerformed
        if (txtMaterialName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên Chất liệu");
            txtMaterialName.requestFocus();
            return;
        }
        if (txtMaterialName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Danh mục không được nhập số");
            txtMaterialName.requestFocus();
            return;
        }
        ArrayList<Material> lst = mrs.getAll();
        for (Material co : lst) {
            if (txtMaterialName.getText().trim().equals(co.getNameMaterial())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Material m = readForm();
        if (mrs.addMaterial(m) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadMaterialToTable();
            sneaker.loadDataMaterial();
            this.dispose();
        } else
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
    }//GEN-LAST:event_btnAddMaterialActionPerformed

    private void btnEditMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditMaterialActionPerformed
        if (txtMaterialId.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Material cần sửa");
            return;
        }
        if (txtMaterialName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên Chất liệu");
            txtMaterialName.requestFocus();
            return;
        }
        if (txtMaterialName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Danh mục không được nhập số");
            txtMaterialName.requestFocus();
            return;
        }
        ArrayList<Material> lst = mrs.getAll();
        for (Material co : lst) {
            if (txtMaterialName.getText().equals(co.getNameMaterial())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Material m = readForm1();
        if (mrs.updateMaterial(m) != null) {
            JOptionPane.showMessageDialog(this, "Update thành công");
            loadMaterialToTable();
        } else
            JOptionPane.showMessageDialog(this, "Update thất bại");
    }//GEN-LAST:event_btnEditMaterialActionPerformed

    private void btnClearMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearMaterialActionPerformed
        txtMaterialId.setText("");
        txtMaterialName.setText("");
    }//GEN-LAST:event_btnClearMaterialActionPerformed

    private void tblMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaterialMouseClicked
        index = tblMaterial.getSelectedRow();
        showDetail(index);
    }//GEN-LAST:event_tblMaterialMouseClicked

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
            java.util.logging.Logger.getLogger(MaterialDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaterialDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaterialDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaterialDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                MaterialDialog dialog = new MaterialDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAddMaterial;
    private javax.swing.JButton btnClearMaterial;
    private javax.swing.JButton btnEditMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMaterial;
    private javax.swing.JTextField txtMaterialId;
    private javax.swing.JTextField txtMaterialName;
    // End of variables declaration//GEN-END:variables
    private void loadMaterialToTable() {
        model.setRowCount(0);
        ArrayList<Material> lst = mrs.getAll();
        for (Material m : lst) {
            model.addRow(new Object[]{
                m.getMaMaterial(),
                m.getNameMaterial()
            });
        }
    }

    private void showDetail(int index) {
        txtMaterialId.setText(tblMaterial.getValueAt(index, 0).toString());
        txtMaterialName.setText(tblMaterial.getValueAt(index, 1).toString());
        tblMaterial.setRowSelectionInterval(index, index);
    }

    private Material readForm() {
        Material m = new Material();
        m.setNameMaterial(txtMaterialName.getText().trim());
        return m;
    }

    private Material readForm1() {
        Material m = new Material();
        m.setNameMaterial(txtMaterialName.getText().trim());
        m.setMaMaterial(Integer.parseInt(txtMaterialId.getText()));
        return m;
    }
}
