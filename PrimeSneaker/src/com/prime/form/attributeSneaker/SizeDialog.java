
package com.prime.form.attributeSneaker;

import com.prime.main_model.SizeModel;
import com.prime.responsitory.SizeResponsitory;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SizeDialog extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    int index;
    private final SizeResponsitory sizeRS = new SizeResponsitory();
    public SizeDialog() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tblSize.getModel();
        loadSizeToTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSizeId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();
        btnAddSize = new javax.swing.JButton();
        btnEditSize = new javax.swing.JButton();
        btnClearSize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Size Giày");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Size giày");

        jLabel1.setText("Mã size");

        txtSizeId.setEditable(false);
        txtSizeId.setEnabled(false);

        jLabel2.setText("Size");

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSize);

        btnAddSize.setText("Thêm");
        btnAddSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSizeActionPerformed(evt);
            }
        });

        btnEditSize.setText("Sửa");
        btnEditSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSizeActionPerformed(evt);
            }
        });

        btnClearSize.setText("Làm mới");
        btnClearSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSizeActionPerformed(evt);
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
                        .addComponent(txtSize))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSizeId, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddSize)
                        .addGap(67, 67, 67)
                        .addComponent(btnEditSize)
                        .addGap(63, 63, 63)
                        .addComponent(btnClearSize))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddSize, btnClearSize, btnEditSize});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSizeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSize)
                    .addComponent(btnEditSize)
                    .addComponent(btnClearSize))
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddSize, btnClearSize, btnEditSize});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSizeActionPerformed
        if (txtSize.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Size giày");
            txtSize.requestFocus();
            return;
        }
        try {
            double size_Number = Double.parseDouble(txtSize.getText());
            if (size_Number < 1 || size_Number > 50) {
                JOptionPane.showMessageDialog(this, "Size giày nằm trong khoảng 1 -50");
                txtSize.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Size giày phải là số");
            txtSize.requestFocus();
            return;
        }
        ArrayList<SizeModel> lst = sizeRS.getAll();
            for (SizeModel co : lst) {
                if (Double.parseDouble(txtSize.getText()) == co.getSize_Number()) {
                    JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                    return;
                }
            }
        SizeModel dg = readForm();
        if (sizeRS.addSize(dg) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadSizeToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnAddSizeActionPerformed

    private void btnEditSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSizeActionPerformed
        if (txtSizeId.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn size Giày cần sửa");
            return;
        }
        if (txtSize.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Size giày");
            txtSize.requestFocus();
            return;
        }
        try {
            double size_Number = Double.parseDouble(txtSize.getText());
            if (size_Number < 1 || size_Number > 50) {
                JOptionPane.showMessageDialog(this, "Size giày nằm trong khoảng 1 -50");
                txtSize.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Size giày phải là số");
            txtSize.requestFocus();
            return;
        }
        ArrayList<SizeModel> lst = sizeRS.getAll();
            for (SizeModel co : lst) {
                if (Double.parseDouble(txtSize.getText()) == co.getSize_Number()) {
                    JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                    return;
                }
            }
        SizeModel dg = readForm1();
        if (sizeRS.updateSize(dg) != null) {
            JOptionPane.showMessageDialog(this, "Update thành công");
            loadSizeToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Update thất bại");
        }
    }//GEN-LAST:event_btnEditSizeActionPerformed

    private void btnClearSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSizeActionPerformed
        txtSize.setText("");
        txtSizeId.setText("");
    }//GEN-LAST:event_btnClearSizeActionPerformed

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        index = tblSize.getSelectedRow();
        showDeTail(index);
    }//GEN-LAST:event_tblSizeMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SizeDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSize;
    private javax.swing.JButton btnClearSize;
    private javax.swing.JButton btnEditSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSize;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtSizeId;
    // End of variables declaration//GEN-END:variables
    private void loadSizeToTable() {
        model.setRowCount(0);
        ArrayList<SizeModel> lstDeGiay = sizeRS.getAll();
        for (SizeModel sm : lstDeGiay) {
            //System.out.println(dg);
            model.addRow(new Object[]{
                sm.getId_Size(),
                sm.getSize_Number()
            });
        }
    }

    private void showDeTail(int index) {
        txtSizeId.setText(tblSize.getValueAt(index, 0).toString());
        txtSize.setText(tblSize.getValueAt(index, 1).toString());
        tblSize.setRowSelectionInterval(index, index);
    }

    private SizeModel readForm() {
        SizeModel sm = new SizeModel();
        sm.setSize_Number(Double.parseDouble(txtSizeId.getText()));
        //sm.setId_Size(Integer.parseInt(txtSizeId.getText()));       
        return sm;
    }

    private SizeModel readForm1() {
        SizeModel sm = new SizeModel();
        sm.setSize_Number(Double.parseDouble(txtSizeId.getText()));
        sm.setId_Size(Integer.parseInt(txtSizeId.getText()));
        return sm;
    }
}
