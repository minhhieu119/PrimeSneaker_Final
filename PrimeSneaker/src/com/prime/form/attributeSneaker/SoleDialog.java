
package com.prime.form.attributeSneaker;

import com.prime.main_model.Model_DeGiay;
import com.prime.responsitory.SoleResponsitory;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SoleDialog extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    int index;
    private final SoleResponsitory soleRS = new SoleResponsitory();
    public SoleDialog() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tblSole.getModel();
        loadDeGiayToTable();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSoleId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSoleName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSole = new javax.swing.JTable();
        btnAddSole = new javax.swing.JButton();
        btnEditSole = new javax.swing.JButton();
        btnClearSole = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đế giày");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Đế giày");

        jLabel1.setText("Mã đế giày");

        txtSoleId.setEditable(false);
        txtSoleId.setEnabled(false);

        jLabel2.setText("Tên đế");

        tblSole.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSoleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSole);

        btnAddSole.setText("Thêm");
        btnAddSole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSoleActionPerformed(evt);
            }
        });

        btnEditSole.setText("Sửa");
        btnEditSole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSoleActionPerformed(evt);
            }
        });

        btnClearSole.setText("Làm mới");
        btnClearSole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSoleActionPerformed(evt);
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
                        .addComponent(txtSoleName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoleId, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddSole)
                        .addGap(67, 67, 67)
                        .addComponent(btnEditSole)
                        .addGap(63, 63, 63)
                        .addComponent(btnClearSole))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddSole, btnClearSole, btnEditSole});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoleId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSole)
                    .addComponent(btnEditSole)
                    .addComponent(btnClearSole))
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddSole, btnClearSole, btnEditSole});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSoleActionPerformed
        if (txtSoleName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên Đế Giày");
            txtSoleName.requestFocus();
            return;
        }
        if (txtSoleName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Tên Đế giày không được nhập số");
            txtSoleName.requestFocus();
            return;
        }
        ArrayList<Model_DeGiay> lst = soleRS.getAll();
            for (Model_DeGiay co : lst) {
                if (txtSoleName.getText().equals(co.getTenDeGiay())) {
                    JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                    return;
                }
            }
        Model_DeGiay dg = readForm();
        if (soleRS.addSole(dg) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDeGiayToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnAddSoleActionPerformed

    private void btnEditSoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSoleActionPerformed
        if (txtSoleId.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Đế giày cần sửa");
            return;
        }
        if (txtSoleName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Đế Giày");
            txtSoleName.requestFocus();
            return;
        }
        if (txtSoleName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Tên Đế giày không được nhập số");
            txtSoleName.requestFocus();
            return;
        }
        ArrayList<Model_DeGiay> lst = soleRS.getAll();
            for (Model_DeGiay co : lst) {
                if (txtSoleName.getText().equals(co.getTenDeGiay())) {
                    JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                    return;
                }
            }
        Model_DeGiay dg = readForm1();
        if (soleRS.updateSole(dg) != null) {
            loadDeGiayToTable();
            JOptionPane.showMessageDialog(this, "Cập nhật đế giày thành công thành công");
        } else
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
    }//GEN-LAST:event_btnEditSoleActionPerformed

    private void btnClearSoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSoleActionPerformed
        txtSoleId.setText("");
        txtSoleName.setText("");
    }//GEN-LAST:event_btnClearSoleActionPerformed

    private void tblSoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSoleMouseClicked
        index = tblSole.getSelectedRow();
        showDeTail(index);
    }//GEN-LAST:event_tblSoleMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SoleDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSole;
    private javax.swing.JButton btnClearSole;
    private javax.swing.JButton btnEditSole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSole;
    private javax.swing.JTextField txtSoleId;
    private javax.swing.JTextField txtSoleName;
    // End of variables declaration//GEN-END:variables
    private void loadDeGiayToTable() {
        model.setRowCount(0);
        ArrayList<Model_DeGiay> lstDeGiay = soleRS.getAll();
        for (Model_DeGiay dg : lstDeGiay) {
           // System.out.println(dg);
            model.addRow(new Object[]{
                dg.getMaDeGiay(),
                dg.getTenDeGiay()
            });
        }
    }

    private void showDeTail(int index) {
        txtSoleId.setText(tblSole.getValueAt(index, 0).toString());
        txtSoleName.setText(tblSole.getValueAt(index, 1).toString());
        tblSole.setRowSelectionInterval(index, index);
    }

    private Model_DeGiay readForm() {
        Model_DeGiay dg = new Model_DeGiay();
        dg.setTenDeGiay(txtSoleName.getText());
        //dg.setMaDeGiay(Integer.parseInt(txtSoleId.getText()));
        return dg;
    }

    private Model_DeGiay readForm1() {
        Model_DeGiay dg = new Model_DeGiay();
        dg.setTenDeGiay(txtSoleName.getText());
        dg.setMaDeGiay(Integer.parseInt(txtSoleId.getText()));
        return dg;
    }
}
