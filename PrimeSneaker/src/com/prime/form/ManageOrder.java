package com.prime.form;

public class ManageOrder extends javax.swing.JPanel {

    public ManageOrder() {
        initComponents();
        setOpaque(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        cboLoaiHoaDon = new javax.swing.JComboBox<>();
        btnNextAllHoaDon = new javax.swing.JButton();
        lblTrangHoaDon = new javax.swing.JLabel();
        btnPreAllHoaDon = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnXemChiTiet = new javax.swing.JButton();
        btnPreHoaDon = new javax.swing.JButton();
        btnNextHoaDon = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        jdcStart = new com.toedter.calendar.JDateChooser();
        jdcEnd = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnInHoaDon = new javax.swing.JButton();
        btnQR1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        lblTrangHDCT = new javax.swing.JLabel();
        btnNextHDCT = new javax.swing.JButton();
        btnPreHDCT = new javax.swing.JButton();
        btnNextAllHDCT = new javax.swing.JButton();
        btnPreAllHDCT = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setText("Tìm kiếm");

        txtTimKiem.setText("Mã hóa đơn - Mã nhân viên - Tên khách hàng");
        txtTimKiem.setToolTipText("");
        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 80, 150)));

        jLabel2.setText("Loại hóa đơn");

        jLabel3.setText("Trạng thái");

        cboTrangThai.setBackground(new java.awt.Color(39, 80, 150));
        cboTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã thanh toán", "Chờ thanh toán", "Đã hủy" }));

        cboLoaiHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        cboLoaiHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        cboLoaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Bán tại quầy", "Khách đặt hàng" }));

        btnNextAllHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        btnNextAllHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNextAllHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnNextAllHoaDon.setText(">>");

        lblTrangHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrangHoaDon.setText("1");

        btnPreAllHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        btnPreAllHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPreAllHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnPreAllHoaDon.setText("<<");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MÃ HÓA ĐƠN", "MÃ NHÂN VIÊN", "TÊN KHÁCH HÀNG", "HÌNH THỨC TT", "TỔNG TIỀN", "NGÀY TẠO", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(tblHoaDon);

        btnXemChiTiet.setBackground(new java.awt.Color(39, 80, 150));
        btnXemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXemChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnXemChiTiet.setText("Xem chi tiết");

        btnPreHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        btnPreHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPreHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnPreHoaDon.setText("<");

        btnNextHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        btnNextHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNextHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnNextHoaDon.setText(">");

        btnXuatExcel.setBackground(new java.awt.Color(39, 80, 150));
        btnXuatExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatExcel.setText("Xuất excel");

        jdcStart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jdcEnd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

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
                        .addComponent(btnPreAllHoaDon)
                        .addGap(18, 18, 18)
                        .addComponent(btnPreHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTrangHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNextHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNextAllHoaDon)
                        .addGap(129, 129, 129)
                        .addComponent(btnQR1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInHoaDon)
                        .addGap(18, 18, 18)
                        .addComponent(btnXuatExcel)
                        .addGap(18, 18, 18)
                        .addComponent(btnXemChiTiet))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cboLoaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdcEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jdcStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(222, 222, 222)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(jdcStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(cboLoaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNextAllHoaDon)
                            .addComponent(lblTrangHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPreAllHoaDon)
                            .addComponent(btnXemChiTiet)
                            .addComponent(btnPreHoaDon)
                            .addComponent(btnNextHoaDon)
                            .addComponent(btnXuatExcel)
                            .addComponent(btnQR1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblHoaDonChiTiet);

        lblTrangHDCT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrangHDCT.setText("1");

        btnNextHDCT.setBackground(new java.awt.Color(39, 80, 150));
        btnNextHDCT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNextHDCT.setForeground(new java.awt.Color(255, 255, 255));
        btnNextHDCT.setText(">");

        btnPreHDCT.setBackground(new java.awt.Color(39, 80, 150));
        btnPreHDCT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPreHDCT.setForeground(new java.awt.Color(255, 255, 255));
        btnPreHDCT.setText("<");

        btnNextAllHDCT.setBackground(new java.awt.Color(39, 80, 150));
        btnNextAllHDCT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNextAllHDCT.setForeground(new java.awt.Color(255, 255, 255));
        btnNextAllHDCT.setText(">>");

        btnPreAllHDCT.setBackground(new java.awt.Color(39, 80, 150));
        btnPreAllHDCT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPreAllHDCT.setForeground(new java.awt.Color(255, 255, 255));
        btnPreAllHDCT.setText("<<");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPreAllHDCT)
                .addGap(18, 18, 18)
                .addComponent(btnPreHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTrangHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNextHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNextAllHDCT)
                .addGap(351, 351, 351))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextAllHDCT)
                    .addComponent(lblTrangHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreAllHDCT)
                    .addComponent(btnPreHDCT)
                    .addComponent(btnNextHDCT))
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addGap(0, 95, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnNextAllHDCT;
    private javax.swing.JButton btnNextAllHoaDon;
    private javax.swing.JButton btnNextHDCT;
    private javax.swing.JButton btnNextHoaDon;
    private javax.swing.JButton btnPreAllHDCT;
    private javax.swing.JButton btnPreAllHoaDon;
    private javax.swing.JButton btnPreHDCT;
    private javax.swing.JButton btnPreHoaDon;
    private javax.swing.JButton btnQR1;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cboLoaiHoaDon;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcEnd;
    private com.toedter.calendar.JDateChooser jdcStart;
    private javax.swing.JLabel lblTrangHDCT;
    private javax.swing.JLabel lblTrangHoaDon;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
