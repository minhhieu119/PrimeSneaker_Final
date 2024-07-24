package com.prime.form;

import com.prime.main_model.ModelCustomer;
import com.prime.services.CustomerService;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManageCustomer extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    CustomerService svc = new CustomerService();
    int index = -1;
    int confirm;

    public ManageCustomer() throws SQLException {
        initComponents();
        setOpaque(false);
        model = (DefaultTableModel) tblListCustomer.getModel();
        ArrayList<ModelCustomer> list = svc.getAllCustomer();
        fillToTable(list);
        if (tblListCustomer.getRowCount() > 0) {
            index = 0;
            showDetail(list);
        }

        txtCustomerId.setEditable(false);
        txtCustomerId.setBackground(Color.lightGray);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtCustomerId = new javax.swing.JTextField();
        txtCustomerName = new javax.swing.JTextField();
        txtCustomerPhone = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        btnAddCustomer = new javax.swing.JButton();
        btnUpdateCustomer = new javax.swing.JButton();
        btnClearCustomer = new javax.swing.JButton();
        txtDob = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblListCustomer = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblPageDelete = new javax.swing.JLabel();
        btnNextDeleted = new javax.swing.JButton();
        btnPrevDeleted = new javax.swing.JButton();
        btnLastDeleted = new javax.swing.JButton();
        btnFirstDeleted = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrderHistory = new javax.swing.JTable();
        btnFirst2 = new javax.swing.JButton();
        btnPrev2 = new javax.swing.JButton();
        lblPage2 = new javax.swing.JLabel();
        btnLast2 = new javax.swing.JButton();
        btnNext2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtCustomerId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        txtCustomerName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        txtCustomerPhone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        buttonGroup1.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Nam");

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Nữ");

        jLabel1.setText("Mã khách hàng");

        jLabel2.setText("Tên khách hàng");

        jLabel7.setText("Giới tính");

        jLabel8.setText("Số điện thoại");

        jLabel9.setText("Địa chỉ");

        jLabel11.setText("Ngày sinh");

        jScrollPane2.setBackground(new java.awt.Color(39, 80, 150));

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        jScrollPane2.setViewportView(txtAddress);

        jPanel17.setBackground(new java.awt.Color(185, 213, 246));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAddCustomer.setBackground(new java.awt.Color(39, 80, 150));
        btnAddCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCustomer.setText("Thêm khách hàng");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        btnUpdateCustomer.setBackground(new java.awt.Color(39, 80, 150));
        btnUpdateCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCustomer.setText("Sửa khách hàng");
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });

        btnClearCustomer.setBackground(new java.awt.Color(39, 80, 150));
        btnClearCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnClearCustomer.setText("Reset");
        btnClearCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddCustomer)
                    .addComponent(btnUpdateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddCustomer, btnClearCustomer, btnUpdateCustomer});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAddCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClearCustomer)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                            .addComponent(txtDob)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(rdoMale)
                        .addGap(85, 85, 85)
                        .addComponent(rdoFemale))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, txtCustomerId, txtCustomerName, txtCustomerPhone});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rdoMale, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(rdoFemale))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCustomerId, txtCustomerName, txtCustomerPhone});

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblListCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng", "SDT", "Giới tính", "Địa chỉ", "Ngày sinh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListCustomerMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblListCustomer);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblPageDelete.setText("Page");

        btnNextDeleted.setBackground(new java.awt.Color(39, 80, 150));
        btnNextDeleted.setForeground(new java.awt.Color(255, 255, 255));
        btnNextDeleted.setText(">>");

        btnPrevDeleted.setBackground(new java.awt.Color(39, 80, 150));
        btnPrevDeleted.setForeground(new java.awt.Color(255, 255, 255));
        btnPrevDeleted.setText("<<");

        btnLastDeleted.setBackground(new java.awt.Color(39, 80, 150));
        btnLastDeleted.setForeground(new java.awt.Color(255, 255, 255));
        btnLastDeleted.setText(">|");

        btnFirstDeleted.setBackground(new java.awt.Color(39, 80, 150));
        btnFirstDeleted.setForeground(new java.awt.Color(255, 255, 255));
        btnFirstDeleted.setText("|<");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFirstDeleted)
                .addGap(15, 15, 15)
                .addComponent(btnPrevDeleted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPageDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNextDeleted)
                .addGap(10, 10, 10)
                .addComponent(btnLastDeleted)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFirstDeleted, btnLastDeleted, btnNextDeleted, btnPrevDeleted});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirstDeleted)
                    .addComponent(btnPrevDeleted)
                    .addComponent(lblPageDelete)
                    .addComponent(btnNextDeleted)
                    .addComponent(btnLastDeleted))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Danh sách khách hàng", jPanel9);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblOrderHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng", "Mã hoá đơn", "Ngày giao dịch", "Tổng tiền", "Phương thức thanh toán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrderHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblOrderHistoryMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tblOrderHistory);

        btnFirst2.setBackground(new java.awt.Color(39, 80, 150));
        btnFirst2.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst2.setText("|<");

        btnPrev2.setBackground(new java.awt.Color(39, 80, 150));
        btnPrev2.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev2.setText("<<");

        lblPage2.setText("Page");

        btnLast2.setBackground(new java.awt.Color(39, 80, 150));
        btnLast2.setForeground(new java.awt.Color(255, 255, 255));
        btnLast2.setText(">|");

        btnNext2.setBackground(new java.awt.Color(39, 80, 150));
        btnNext2.setForeground(new java.awt.Color(255, 255, 255));
        btnNext2.setText(">>");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(329, 329, 329)
                .addComponent(btnFirst2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrev2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPage2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNext2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLast2)
                .addContainerGap(348, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFirst2, btnLast2, btnNext2, btnPrev2});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst2)
                    .addComponent(btnPrev2)
                    .addComponent(lblPage2)
                    .addComponent(btnNext2)
                    .addComponent(btnLast2))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Lịch sử giao dịch", jPanel8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrderHistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderHistoryMousePressed

    }//GEN-LAST:event_tblOrderHistoryMousePressed

    private void tblListCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListCustomerMouseClicked
        // TODO add your handling code here:
        index = tblListCustomer.getSelectedRow();
        try {
            showDetail(svc.getAllCustomer());
        } catch (SQLException ex) {
            Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblListCustomerMouseClicked

    private void btnClearCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCustomerActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnClearCustomerActionPerformed

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed
        // TODO add your handling code here:
        checkNull();
        if (!checkPhone()) {
            showMess("Số điện thoại không đúng định dạng");
            txtCustomerPhone.requestFocus();
            return;
        }
        if (!checkDate()) {
            showMess("Ngày sinh không đúng định dạng");
            txtDob.requestFocus();
            return;
        }
        try {
            ModelCustomer cus = readForm();
            System.out.println(cus.getCustomerID());
            System.out.println(txtCustomerId.getText());
            if (checkExistID()) {
                confirm = JOptionPane.showConfirmDialog(this, "Xác nhận sửa khách hàng?");
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
                if (svc.updateCustomer(cus)) {
                    ArrayList<ModelCustomer> list = svc.getAllCustomer();
                    fillToTable(list);
                    showMess("Cập nhật thông tin khách hàng thành công");
                    index = 0;
                    showDetail(list);
                }
            } else {
                showMess("Không tồn tại mã khách hàng này");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
     
        checkNull();
        if (!checkPhone()) {
            showMess("Số điện thoại không đúng định dạng");
            txtCustomerPhone.requestFocus();
            return;
        }
        if (!checkDate()) {
            showMess("Ngày sinh không đúng định dạng");
            txtDob.requestFocus();
            return;
        }
        
        try {
            if (checkExistName() && checkExistPhone()) {
                showMess("Đã tồn tại khách hàng và số ĐT này");
                txtCustomerName.requestFocus();
                return;
            }
        try {
            ModelCustomer cus = readForm();
            confirm = JOptionPane.showConfirmDialog(this, "Xác nhận thêm khách hàng?");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            if (svc.addCustomer(cus)) {
                ArrayList<ModelCustomer> list = svc.getAllCustomer();
                fillToTable(list);
                showMess("Thêm khách hàng thành công");
                index = 0;
                showDetail(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        } catch (SQLException ex) {
            Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnClearCustomer;
    private javax.swing.JButton btnFirst2;
    private javax.swing.JButton btnFirstDeleted;
    private javax.swing.JButton btnLast2;
    private javax.swing.JButton btnLastDeleted;
    private javax.swing.JButton btnNext2;
    private javax.swing.JButton btnNextDeleted;
    private javax.swing.JButton btnPrev2;
    private javax.swing.JButton btnPrevDeleted;
    private javax.swing.JButton btnUpdateCustomer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel lblPage2;
    private javax.swing.JLabel lblPageDelete;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTable tblListCustomer;
    private javax.swing.JTable tblOrderHistory;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtCustomerId;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerPhone;
    private javax.swing.JTextField txtDob;
    // End of variables declaration//GEN-END:variables

    private void fillToTable(ArrayList<ModelCustomer> list) {
        model.setRowCount(0);
        int i = 1;
        for (ModelCustomer customer : list) {
            model.addRow(new Object[]{
                i++,
                customer.getCustomerID(),
                customer.getCustomerName(),
                customer.getPhoneNumber(),
                customer.isGender() ? "Nam" : "Nữ",
                customer.getAddress(),
                customer.getDob()
            });
        }
    }

    private void showDetail(ArrayList<ModelCustomer> list) {
        ModelCustomer customer = list.get(index);
        txtCustomerId.setText(customer.getCustomerID() + "");
        txtCustomerName.setText(customer.getCustomerName());
        txtCustomerPhone.setText(customer.getPhoneNumber());
        rdoMale.setSelected(customer.isGender());
        rdoFemale.setSelected(!customer.isGender());
        txtAddress.setText(customer.getAddress());
        txtDob.setText(customer.getDob() + "");
        tblListCustomer.setRowSelectionInterval(index, index);
    }

    private void clearForm() {
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerPhone.setText("");
        txtAddress.setText("");
        txtDob.setText("");
        rdoMale.setSelected(true);
    }

    private void checkNull() {
        if (txtCustomerName.getText().trim().equals("")) {
            showMess("Không bỏ trống tên khách hàng");
            txtCustomerName.requestFocus();
            return;
        }
        if (txtCustomerPhone.getText().trim().equals("")) {
            showMess("Không bỏ trống số ĐT");
            txtCustomerPhone.requestFocus();
            return;
        }
    }

    private boolean checkPhone() {
        String phonePattern = "^(\\+84|0)(3[2-9]|5[689]|7[06-9]|8[1-689]|9[0-46-9])[0-9]{7}$";
        return validateString(txtCustomerPhone.getText(), phonePattern);
    }

    private void showMess(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private boolean checkDate() {
        String datePattern = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
        return validateString(txtDob.getText(), datePattern);
    }

    private boolean validateString(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    private boolean checkExistName() throws SQLException {
        ArrayList<ModelCustomer> list = svc.getAllCustomer();
        for (int i = 0; i < list.size(); i++) {
            if (txtCustomerName.getText().trim().equalsIgnoreCase(list.get(i).getCustomerName().trim())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkExistPhone() throws SQLException {
        ArrayList<ModelCustomer> list = svc.getAllCustomer();
        for (int i = 0; i < list.size(); i++) {
            if (txtCustomerPhone.getText().trim().equals(list.get(i).getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    private ModelCustomer readForm() throws ParseException {
        ModelCustomer cus = new ModelCustomer();
        cus.setCustomerID(Integer.valueOf(txtCustomerId.getText()));
        cus.setCustomerName(txtCustomerName.getText());
        cus.setPhoneNumber(txtCustomerPhone.getText());
        cus.setGender(rdoMale.isSelected());
        cus.setAddress(txtAddress.getText());
        String string = txtDob.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(string);
        cus.setDob(date);
        return cus;
    }

    private boolean checkExistID() throws SQLException {
        ArrayList<ModelCustomer> list = svc.getAllCustomer();
        for (int i = 0; i < list.size(); i++) {
            if (Integer.valueOf(txtCustomerId.getText()).equals(list.get(i).getCustomerID())) {
                return true;
            }
        }
        return false;
    }
}
