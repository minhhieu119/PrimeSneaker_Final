package com.prime.form;

public class ManageOrder extends javax.swing.JPanel {

    public ManageOrder() {
        initComponents();
        setOpaque(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
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

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(1058, 700));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(1058, 700));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1058, 700));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setText("Tìm kiếm");

        txtTimKiem.setText("Mã hóa đơn - Mã nhân viên - Tên khách hàng");
        txtTimKiem.setToolTipText("");
        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 80, 150)));
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel2.setText("Loại hóa đơn");

        jLabel3.setText("Trạng thái");

        cboTrangThai.setBackground(new java.awt.Color(39, 80, 150));
        cboTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã thanh toán", "Chờ thanh toán", "Đã hủy" }));
        cboTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangThaiActionPerformed(evt);
            }
        });

        cboLoaiHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        cboLoaiHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        cboLoaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Bán tại quầy", "Khách đặt hàng" }));
        cboLoaiHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiHoaDonActionPerformed(evt);
            }
        });

        btnNextAllHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        btnNextAllHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNextAllHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnNextAllHoaDon.setText(">>");
        btnNextAllHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextAllHoaDonActionPerformed(evt);
            }
        });

        lblTrangHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTrangHoaDon.setText("1");

        btnPreAllHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        btnPreAllHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPreAllHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnPreAllHoaDon.setText("<<");
        btnPreAllHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreAllHoaDonActionPerformed(evt);
            }
        });

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
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        btnXemChiTiet.setBackground(new java.awt.Color(39, 80, 150));
        btnXemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXemChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        btnPreHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        btnPreHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPreHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnPreHoaDon.setText("<");
        btnPreHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreHoaDonActionPerformed(evt);
            }
        });

        btnNextHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        btnNextHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNextHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnNextHoaDon.setText(">");
        btnNextHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextHoaDonActionPerformed(evt);
            }
        });

        btnXuatExcel.setBackground(new java.awt.Color(51, 153, 0));
        btnXuatExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatExcel.setText("Xuất excel");
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });

        jdcStart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        jdcStart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdcStartKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jdcStartKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdcStartKeyTyped(evt);
            }
        });

        jdcEnd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        jdcEnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdcEndKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jdcEndKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdcEndKeyTyped(evt);
            }
        });

        jLabel5.setText("Từ ngày");

        jLabel20.setText("Đến ngày");

        btnInHoaDon.setBackground(new java.awt.Color(0, 153, 255));
        btnInHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        btnQR1.setBackground(new java.awt.Color(39, 80, 150));
        btnQR1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQR1.setForeground(new java.awt.Color(255, 255, 255));
        btnQR1.setText("Quét QR");
        btnQR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQR1ActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
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

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnInHoaDon, btnQR1, btnXemChiTiet, btnXuatExcel});

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
        btnPreAllHDCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreAllHDCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
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
                .addGap(344, 344, 344))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Hóa đơn", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        if (txtTimKiem.getText().equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            txtTimKiem.setText(null);
            txtTimKiem.requestFocus();
            removePlacehoder(txtTimKiem);
        }
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        if (txtTimKiem.getText().length() == 0) {
            addPlacehoder(txtTimKiem);
            txtTimKiem.setText("Mã hóa đơn - Mã nhân viên - Tên khách hàng");
        }
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            this.fillTableHoaDon(billService.fillHoaDon(1));
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            if (trangHD > soTrangHoaDon) {
                trangHD = soTrangHoaDon;
            }
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            if (trangHD > soTrangHoaDon) {
                trangHD = soTrangHoaDon;
            }
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cboTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangThaiActionPerformed
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            this.fillTableHoaDon(billService.fillHoaDon(1));
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            if (trangHD > soTrangHoaDon) {
                trangHD = soTrangHoaDon;
            }
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            if (trangHD > soTrangHoaDon) {
                trangHD = soTrangHoaDon;
            }
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        }
    }//GEN-LAST:event_cboTrangThaiActionPerformed

    private void cboLoaiHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiHoaDonActionPerformed
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            this.fillTableHoaDon(billService.fillHoaDon(1));
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            if (trangHD > soTrangHoaDon) {
                trangHD = soTrangHoaDon;
            }
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            if (trangHD > soTrangHoaDon) {
                trangHD = soTrangHoaDon;
            }
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        }
    }//GEN-LAST:event_cboLoaiHoaDonActionPerformed

    private void btnNextAllHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextAllHoaDonActionPerformed
        // TODO add your handling code here:
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        }
        if (trangHD < soTrangHoaDon) {
            trangHD = soTrangHoaDon;
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
            lblTrangHoaDon.setText(trangHD + "/" + soTrangHoaDon);
        }
    }//GEN-LAST:event_btnNextAllHoaDonActionPerformed

    private void btnPreAllHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreAllHoaDonActionPerformed
        // TODO add your handling code here:
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        }
        if (trangHD > 1) {
            trangHD = 1;
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
            lblTrangHoaDon.setText(trangHD + "/" + soTrangHoaDon);
        }
    }//GEN-LAST:event_btnPreAllHoaDonActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        index = tblHoaDon.getSelectedRow();
        int idHoaDon = Integer.parseInt(tblHoaDon.getValueAt(index, 1).toString());
        soTrangHDCT = billService.fillHoaDonChiTiet(idHoaDon, soTrangHDCT).size();
        countTrang();
        fillTableHoaDonChiTiet(billService.fillHoaDonChiTiet(idHoaDon, soTrangHDCT));
        soTrangLichSu = billService.fillLichSu(idHoaDon, soTrangLichSu).size();
        countTrang();
        fillTableLichSu(billService.fillLichSu(idHoaDon, soTrangLichSu));
        if (evt.getClickCount() == 2) {
            index = tblHoaDon.getSelectedRow();
            int id = Integer.parseInt(tblHoaDon.getValueAt(index, 1).toString());
            ModelBill modelBill = billService.selectHoaDonById(id);
            new HoaDon(null, true).showData(modelBill.getId(), modelBill.getTenNhanVien(),
                modelBill.getTenKhachHang(), modelBill.getMaVoucher(), modelBill.getTrangThai(),
                modelBill.getDiaChi(), modelBill.getTenNguoiNhan(), modelBill.getSoDienThoai(),
                modelBill.getLoaiHoaDon(), modelBill.getTienShip(),
                modelBill.getTongTien(), modelBill.getTienMat(),
                modelBill.getTienChuyenKhoan(), modelBill.getNgayTao());
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        // TODO add your handling code here:
        index = tblHoaDon.getSelectedRow();
        int id = Integer.parseInt(tblHoaDon.getValueAt(index, 1).toString());
        ModelBill modelBill = billService.selectHoaDonById(id);
        new HoaDon(null, true).showData(modelBill.getId(), modelBill.getTenNhanVien(),
            modelBill.getTenKhachHang(), modelBill.getMaVoucher(), modelBill.getTrangThai(),
            modelBill.getDiaChi(), modelBill.getTenNguoiNhan(), modelBill.getSoDienThoai(),
            modelBill.getLoaiHoaDon(), modelBill.getTienShip(),
            modelBill.getTongTien(), modelBill.getTienMat(),
            modelBill.getTienChuyenKhoan(), modelBill.getNgayTao());
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnPreHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreHoaDonActionPerformed
        // TODO add your handling code here:
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        }

        if (trangHD > 1) {
            trangHD--;
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
            lblTrangHoaDon.setText(trangHD + "/" + soTrangHoaDon);
        }
    }//GEN-LAST:event_btnPreHoaDonActionPerformed

    private void btnNextHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextHoaDonActionPerformed
        // TODO add your handling code here:
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
        }
        if (trangHD < soTrangHoaDon) {
            trangHD++;
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
            lblTrangHoaDon.setText(trangHD + "/" + soTrangHoaDon);
        }
    }//GEN-LAST:event_btnNextHoaDonActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Account");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblHoaDon.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblHoaDon.getColumnName(i));
                }
                for (int j = 0; j < tblHoaDon.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblHoaDon.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblHoaDon.getValueAt(j, k) != null) {
                            cell.setCellValue(tblHoaDon.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                EventStream.openFile(saveFile.toPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void jdcStartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcStartKeyPressed
        // TODO add your handling code here:
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            this.fillTableHoaDon(billService.fillHoaDon(1));
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        }
    }//GEN-LAST:event_jdcStartKeyPressed

    private void jdcStartKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcStartKeyReleased
        // TODO add your handling code here:
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            this.fillTableHoaDon(billService.fillHoaDon(1));
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        }
    }//GEN-LAST:event_jdcStartKeyReleased

    private void jdcStartKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcStartKeyTyped
        // TODO add your handling code here:
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            this.fillTableHoaDon(billService.fillHoaDon(1));
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        }
    }//GEN-LAST:event_jdcStartKeyTyped

    private void jdcEndKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcEndKeyPressed
        // TODO add your handling code here:
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            this.fillTableHoaDon(billService.fillHoaDon(1));
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        }
    }//GEN-LAST:event_jdcEndKeyPressed

    private void jdcEndKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcEndKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jdcEndKeyReleased

    private void jdcEndKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcEndKeyTyped
        // TODO add your handling code here:
        String trangThai = null;
        if (cboTrangThai.getSelectedItem().equals("Tất cả")) {
            trangThai = "";
        } else if (cboTrangThai.getSelectedItem().equals("Đã thanh toán")) {
            trangThai = "Đã thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Chờ thanh toán")) {
            trangThai = "Chờ thanh toán";
        } else if (cboTrangThai.getSelectedItem().equals("Đã hủy")) {
            trangThai = "Đã hủy";
        }
        String loaiHoaDon = null;
        if (cboLoaiHoaDon.getSelectedItem().equals("Tất cả")) {
            loaiHoaDon = "";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Bán tại quầy")) {
            loaiHoaDon = "Bán tại quầy";
        } else if (cboLoaiHoaDon.getSelectedItem().equals("Khách đặt hàng")) {
            loaiHoaDon = "Khách đặt hàng";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date start = jdcStart.getDate();
        Date end = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (start == null || end == null) {
            try {
                start = sdf.parse(str);
                end = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(start);
        endStr = sdf.format(end);
        String text = txtTimKiem.getText().trim();
        dtm = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtm.setRowCount(0);
        if (text.isEmpty()) {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            this.fillTableHoaDon(billService.fillHoaDon(1));
        } else if (text.equals("Mã hóa đơn - Mã nhân viên - Tên khách hàng")) {
            text = "";
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        } else {
            soTrangHoaDon = billService.countHoaDon(text, loaiHoaDon, trangThai, startStr, endStr).size();
            this.countTrang();
            fillTableHoaDon(billService.timKiem(trangHD, text, loaiHoaDon, trangThai, startStr, endStr));
        }
    }//GEN-LAST:event_jdcEndKeyTyped

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        // TODO add your handling code here:
        index = tblHoaDon.getSelectedRow();
        int id = Integer.parseInt(tblHoaDon.getValueAt(index, 1).toString());
        ModelBill modelBill = billService.selectHoaDonById(id);
        byte[] qrCodeBytes = createQrCodeFromText("     " + String.valueOf(id) + "    ");
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn file để lưu");
            fileChooser.setCurrentDirectory(new File("D:\\PDF_HOADON"));
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                PdfWriter writer = new PdfWriter(new FileOutputStream(filePath));
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);
                Paragraph paragraph = new Paragraph();
                paragraph.add("Mã hóa đơn:                    " + modelBill.getId() + "\n");
                paragraph.add("Mã nhân viên:                " + modelBill.getTenNhanVien() + "\n");
                paragraph.add("Tên khách hàng:             " + modelBill.getTenKhachHang() + "\n");
                paragraph.add("Tên người nhận:             " + modelBill.getTenNguoiNhan() + "\n");
                paragraph.add("Số điện thoại:                 " + modelBill.getSoDienThoai() + "\n");
                paragraph.add("Địa chỉ:                           " + modelBill.getDiaChi() + "\n");
                String tongTien = "Tổng tiền:                       " + String.valueOf(String.format("%,.0f", modelBill.getTongTien()));
                String tienMat = "Tiền mặt:                        " + String.valueOf(String.format("%,.0f", modelBill.getTienMat()));
                String tienChuyenKhoan = "Tiền chuyển khoản:       " + String.valueOf(String.format("%,.0f", modelBill.getTienChuyenKhoan()));
                paragraph.add("Tiền ship:                       " + String.format("%,.0f", modelBill.getTienShip()) + "\n");
                paragraph.add(tongTien + "\n");
                paragraph.add(tienMat + "\n");
                paragraph.add(tienChuyenKhoan + "\n");
                paragraph.add("Loại hóa đơn:                 " + modelBill.getLoaiHoaDon() + "\n");
                paragraph.add("Mã voucher:                   " + modelBill.getMaVoucher() + "\n");
                paragraph.add("Trạng thái:                     " + modelBill.getTrangThai() + "\n");
                paragraph.add("Ngày tạo:                       " + modelBill.getNgayTao());
                paragraph.setFont(PdfFontFactory.createFont("D:\\Library\\arial-unicode-ms.ttf",
                    PdfEncodings.IDENTITY_H, EmbeddingStrategy.PREFER_EMBEDDED));
            ImageData data = ImageDataFactory.create(qrCodeBytes);
            Image img = new Image(data);
            document.setLeftMargin(170);
            document.add(paragraph);
            document.add(img);
            document.close();
            JOptionPane.showMessageDialog(this, "Tạo file hóa đơn thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Tạo file hóa đơn thất bại");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void btnPreAllHDCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreAllHDCTActionPerformed
        // TODO add your handling code here:
        if (trangHD > 1) {
            trangHD = 1;
            index = tblHoaDon.getSelectedRow();
            int idHoaDon = Integer.parseInt(tblHoaDon.getValueAt(index, 1).toString());
            fillTableHoaDonChiTiet(billService.fillHoaDonChiTiet(idHoaDon, soTrangHDCT));
            lblTrangHoaDon.setText(trangHD + "/" + soTrangHDCT);
        }
    }//GEN-LAST:event_btnPreAllHDCTActionPerformed

    private void btnQR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQR1ActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcEnd;
    private com.toedter.calendar.JDateChooser jdcStart;
    private javax.swing.JLabel lblTrangHDCT;
    private javax.swing.JLabel lblTrangHoaDon;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
