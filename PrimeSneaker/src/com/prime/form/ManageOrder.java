package com.prime.form;

import com.prime.main_model.Bill;
import com.prime.main_model.BillDetail;
import com.prime.services.BillService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ManageOrder extends javax.swing.JPanel {
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel modelSneakerDetail = new DefaultTableModel();
    BillService bs = new BillService();
    public ManageOrder() {
        initComponents();
        setOpaque(false);
        model = (DefaultTableModel) tblManagerOder.getModel();
        
        loadDataToTableBill(bs.getAllBill());
    }
    
    private void loadDataToTableBill(List<Bill> list) {

        model.setRowCount(0);
        int i = 0;
        for (Bill bill : list) {
            i++;
            model.addRow(bill.toDataRow(i));
        }
    }
    
    private void fillToListOderDetail(List<BillDetail> list){
        modelSneakerDetail = (DefaultTableModel) tblBillDetail.getModel();
        modelSneakerDetail.setRowCount(0);
        int stt = 1;
        for (BillDetail billDetail : list) {
            modelSneakerDetail.addRow(new Object[]{
                stt++,
                billDetail.getProductName(),
                billDetail.getPrice(),
                billDetail.getQuantity()
            });
        }
    }

    private void search() {

        String hinhthucTT = null;
        if (cboPaymentMethod.getSelectedItem().equals("Tất cả")) {
            hinhthucTT = null;
        } else if (cboPaymentMethod.getSelectedItem().equals("Tiền mặt")) {
            hinhthucTT = "Tiền mặt";
        } else if (cboPaymentMethod.getSelectedItem().equals("Chuyển khoản")) {
            hinhthucTT = "Chuyển khoản";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date ngayBatDau = jdcStart.getDate();
        Date ngayKetThuc = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (ngayBatDau == null || ngayKetThuc == null) {
            try {
                ngayBatDau = sdf.parse(str);
                ngayKetThuc = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(ngayBatDau);
        endStr = sdf.format(ngayKetThuc);

        String text = txtSearchBill.getText().trim();
        
        if(text.isEmpty()){
            text = null;
        }
        
        model.setRowCount(0);

//        System.out.println(trangThai);
        System.out.println(hinhthucTT);
        System.out.println(text);
        this.loadDataToTableBill(bs.timKiem(text, hinhthucTT, startStr, endStr));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearchBill = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboPaymentMethod = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblManagerOder = new javax.swing.JTable();
        btnXuatExcel = new javax.swing.JButton();
        jdcStart = new com.toedter.calendar.JDateChooser();
        jdcEnd = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnInHoaDon = new javax.swing.JButton();
        btnQR1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBillDetail = new javax.swing.JTable();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setText("Tìm kiếm");

        txtSearchBill.setToolTipText("");
        txtSearchBill.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 80, 150)));
        txtSearchBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBillKeyReleased(evt);
            }
        });

        jLabel2.setText("Loại hóa đơn");

        cboPaymentMethod.setBackground(new java.awt.Color(39, 80, 150));
        cboPaymentMethod.setForeground(new java.awt.Color(255, 255, 255));
        cboPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tiền mặt", "Chuyển khoản" }));
        cboPaymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPaymentMethodActionPerformed(evt);
            }
        });

        tblManagerOder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MÃ HÓA ĐƠN", "MÃ NHÂN VIÊN", "TÊN KHÁCH HÀNG", "HÌNH THỨC TT", "TỔNG TIỀN", "NGÀY TẠO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblManagerOder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblManagerOder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblManagerOderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblManagerOder);

        btnXuatExcel.setBackground(new java.awt.Color(39, 80, 150));
        btnXuatExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatExcel.setText("Xuất excel");

        jdcStart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        jdcStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcStartPropertyChange(evt);
            }
        });

        jdcEnd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        jdcEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcEndPropertyChange(evt);
            }
        });

        jLabel5.setText("Từ ngày");

        jLabel20.setText("Đến ngày");

        btnInHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        btnInHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnInHoaDon.setText("In hóa đơn");

        btnQR1.setBackground(new java.awt.Color(39, 80, 150));
        btnQR1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQR1.setForeground(new java.awt.Color(255, 255, 255));
        btnQR1.setText("Quét QR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(txtSearchBill, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel20))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcStart, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(260, 260, 260))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInHoaDon)
                        .addGap(18, 18, 18)
                        .addComponent(btnQR1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXuatExcel)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnInHoaDon, btnQR1, btnXuatExcel});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtSearchBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(jdcStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cboPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(13, 13, 13)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatExcel)
                    .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQR1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnInHoaDon, btnQR1, btnXuatExcel});

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tblBillDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "TÊN SẢN PHẨM", "GIÁ", "SỐ LƯỢNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblBillDetail);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchBillKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBillKeyReleased
        search();
    }//GEN-LAST:event_txtSearchBillKeyReleased

    private void cboPaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPaymentMethodActionPerformed
        search();
    }//GEN-LAST:event_cboPaymentMethodActionPerformed

    private void tblManagerOderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblManagerOderMouseClicked
        int index = tblManagerOder.getSelectedRow();
        String id = String.valueOf(tblManagerOder.getValueAt(index, 1));
        int orderDetail = Integer.parseInt(id);
        
        try {
            fillToListOderDetail(bs.getOrderDetai(orderDetail));
        } catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_tblManagerOderMouseClicked

    private void jdcStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcStartPropertyChange
        search();
    }//GEN-LAST:event_jdcStartPropertyChange

    private void jdcEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcEndPropertyChange
        search();
    }//GEN-LAST:event_jdcEndPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnQR1;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cboPaymentMethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcEnd;
    private com.toedter.calendar.JDateChooser jdcStart;
    private javax.swing.JTable tblBillDetail;
    private javax.swing.JTable tblManagerOder;
    private javax.swing.JTextField txtSearchBill;
    // End of variables declaration//GEN-END:variables
}
