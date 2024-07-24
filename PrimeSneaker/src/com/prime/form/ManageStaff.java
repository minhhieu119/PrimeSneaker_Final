package com.prime.form;

import com.prime.constant.Role;
import com.prime.main_model.ModelUser;
import com.prime.services.UserService;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ManageStaff extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    UserService svc = new UserService();
    int index;

    public ManageStaff() throws SQLException {
        initComponents();
        setOpaque(false);
        model = (DefaultTableModel) tblStaff.getModel();
        ArrayList<ModelUser> listUser = svc.getAllUsers();
        fillToTable(listUser);
        if (tblStaff.getRowCount() > 0) {
            index = 0;
            showDetail(listUser);
        }
        addPlaceHolder(txtSearchStaff, "Mã NV - Tên NV - SĐT - CCCD - Địa chỉ");
        
        index = tblStaff.getSelectedRow();
        if (index >= 0) {
            txtStaffId.setEditable(false);
            txtStaffId.setBackground(Color.lightGray);
            txtUserAccount.setEditable(false);
            txtUserAccount.setBackground(Color.lightGray);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtStaffId = new javax.swing.JTextField();
        txtStaffName = new javax.swing.JTextField();
        txtStaffPhone = new javax.swing.JTextField();
        rdoStaff = new javax.swing.JRadioButton();
        rdoAdmin = new javax.swing.JRadioButton();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        btnAddNewStaff = new javax.swing.JButton();
        btnUpdateStaff = new javax.swing.JButton();
        btnBlockAccount = new javax.swing.JButton();
        btnScanCitizenQR = new javax.swing.JButton();
        btnExportExcel = new javax.swing.JButton();
        btnClearStaff = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtUserAccount = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPsw = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtIDCardNumber = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtDob = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        cboStatusForm = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtSearchStaff = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();
        cboGenderFilter = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cboRoleFilter = new javax.swing.JComboBox<>();
        cboStatusFilter = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtStaffId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        txtStaffName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        txtStaffPhone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        buttonGroup2.add(rdoStaff);
        rdoStaff.setSelected(true);
        rdoStaff.setText("Nhân viên");

        buttonGroup2.add(rdoAdmin);
        rdoAdmin.setText("Quản lý");

        buttonGroup1.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Nam");

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Nữ");

        jLabel1.setText("Mã nhân viên");

        jLabel2.setText("Tên nhân viên");

        jLabel6.setText("Vai trò");

        jLabel7.setText("Giới tính");

        jLabel8.setText("Số điện thoại");

        jPanel17.setBackground(new java.awt.Color(185, 213, 246));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAddNewStaff.setBackground(new java.awt.Color(39, 80, 150));
        btnAddNewStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewStaff.setText("Thêm Nhân viên");
        btnAddNewStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewStaffActionPerformed(evt);
            }
        });

        btnUpdateStaff.setBackground(new java.awt.Color(39, 80, 150));
        btnUpdateStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateStaff.setText("Sửa thông tin NV");
        btnUpdateStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStaffActionPerformed(evt);
            }
        });

        btnBlockAccount.setBackground(new java.awt.Color(39, 80, 150));
        btnBlockAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnBlockAccount.setText("Khoá Nhân Viên");
        btnBlockAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlockAccountActionPerformed(evt);
            }
        });

        btnScanCitizenQR.setBackground(new java.awt.Color(39, 80, 150));
        btnScanCitizenQR.setForeground(new java.awt.Color(255, 255, 255));
        btnScanCitizenQR.setText("Quét CCCD");

        btnExportExcel.setBackground(new java.awt.Color(39, 80, 150));
        btnExportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExportExcel.setText("Xuất Excel");

        btnClearStaff.setBackground(new java.awt.Color(39, 80, 150));
        btnClearStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnClearStaff.setText("Reset");
        btnClearStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearStaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnAddNewStaff)
                .addGap(43, 43, 43)
                .addComponent(btnUpdateStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addComponent(btnBlockAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(btnClearStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(btnScanCitizenQR)
                .addGap(39, 39, 39)
                .addComponent(btnExportExcel)
                .addGap(27, 27, 27))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddNewStaff, btnBlockAccount, btnClearStaff, btnExportExcel, btnScanCitizenQR, btnUpdateStaff});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateStaff)
                    .addComponent(btnBlockAccount)
                    .addComponent(btnClearStaff)
                    .addComponent(btnScanCitizenQR)
                    .addComponent(btnExportExcel)
                    .addComponent(btnAddNewStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddNewStaff, btnBlockAccount, btnClearStaff, btnExportExcel, btnScanCitizenQR, btnUpdateStaff});

        jLabel17.setText("Tài khoản");

        txtUserAccount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel18.setText("Mật khẩu");

        txtPsw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel19.setText("Địa chỉ");

        jLabel20.setText("Email");

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel21.setText("CCCD");

        txtIDCardNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel22.setText("Ngày sinh");

        jLabel23.setText("Trạng thái");

        txtDob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        jScrollPane3.setViewportView(txtAddress);

        cboStatusForm.setBackground(new java.awt.Color(39, 80, 150));
        cboStatusForm.setForeground(new java.awt.Color(255, 255, 255));
        cboStatusForm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm việc", "Đã nghỉ việc" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStaffName, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                    .addComponent(txtStaffPhone)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoMale)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoFemale))
                                    .addComponent(txtUserAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addComponent(txtPsw)
                                    .addComponent(txtStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(rdoStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoAdmin))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                        .addComponent(txtEmail)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(21, 21, 21)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDob)
                                        .addComponent(cboStatusForm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(txtIDCardNumber))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane3, txtDob, txtEmail, txtIDCardNumber, txtPsw, txtStaffId, txtStaffName, txtStaffPhone, txtUserAccount});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(txtStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStaffPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoMale)
                            .addComponent(rdoFemale))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoStaff)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoAdmin)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboStatusForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)))
                .addGap(8, 8, 8)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboStatusForm, txtDob, txtEmail, txtIDCardNumber, txtPsw, txtStaffId, txtStaffName, txtStaffPhone, txtUserAccount});

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(39, 80, 150)));

        txtSearchStaff.setForeground(new java.awt.Color(153, 153, 153));
        txtSearchStaff.setText("Mã NV - Tên NV - SĐT - CCCD - Địa chỉ");
        txtSearchStaff.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 80, 150)));
        txtSearchStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchStaffActionPerformed(evt);
            }
        });
        txtSearchStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchStaffKeyReleased(evt);
            }
        });

        jLabel3.setText("Tìm kiếm :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        tblStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã NV", "Tên NV", "Số điện thoại", "Giới tính", "Tài khoản", "Mật khẩu", "Vai trò", "Địa chỉ", "Email", "Số CCCD", "Ngày sinh", "Trạng thái", "Hành động"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStaff);

        cboGenderFilter.setBackground(new java.awt.Color(39, 80, 150));
        cboGenderFilter.setForeground(new java.awt.Color(255, 255, 255));
        cboGenderFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jLabel4.setText("Giới tính: ");

        jLabel13.setText("Vai trò: ");

        cboRoleFilter.setBackground(new java.awt.Color(39, 80, 150));
        cboRoleFilter.setForeground(new java.awt.Color(255, 255, 255));
        cboRoleFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân Viên" }));

        cboStatusFilter.setBackground(new java.awt.Color(39, 80, 150));
        cboStatusFilter.setForeground(new java.awt.Color(255, 255, 255));
        cboStatusFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm", "Nghỉ việc" }));

        jLabel16.setText("Trạng thái");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cboGenderFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(108, 108, 108)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboRoleFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(cboStatusFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(139, 139, 139))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(4, 4, 4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboGenderFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboRoleFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboStatusFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearStaffActionPerformed
        // TODO add your handling code here:
        clearForm();
        txtStaffId.setEditable(true);
        txtStaffId.setBackground(Color.white);
        txtUserAccount.setEditable(true);
        txtUserAccount.setBackground(Color.white);
    }//GEN-LAST:event_btnClearStaffActionPerformed

    private void btnAddNewStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewStaffActionPerformed
        // TODO add your handling code here:
        checkNull();
        if (!checkEmail()) {
            showMess("Email không đúng định dạng");
            txtEmail.requestFocus();
            return;
        }
        if (!checkDate()) {
            showMess("Ngày sinh không đúng định dạng yyyy-MM-dd");
            txtDob.requestFocus();
            return;
        }
        if (!checkPhone()) {
            showMess("Số điện thoại không đúng định dạng");
            txtStaffPhone.requestFocus();
            return;
        }
        if (!checkIDNumber()) {
            showMess("Số CCCD gồm 12 chữ số");
            txtStaffPhone.requestFocus();
            return;
        }
        try {
            if (checkExistID()) {
                showMess("Đã tồn tại mã Nhân viên này");
                txtStaffId.requestFocus();
                return;
            }
            if (checkExistAccount()) {
                showMess("Đã tồn tại tên tài khoản này");
                txtUserAccount.requestFocus();
                return;
            }
            if (checkExistIDNumber()) {
                showMess("Đã tồn tại số căn cước công dân này");
                txtIDCardNumber.requestFocus();
                return;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ModelUser user = readForm();
            try {
                int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận thêm tài khoản?");
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
                if (svc.addUser(user)) {
                    fillToTable(svc.getAllUsers());
                    showMess("Thêm Nhân viên thành công");
                }
            } catch (SQLException ex) {
                showMess("Thêm lỗi");
            }
        } catch (ParseException ex) {
            Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddNewStaffActionPerformed

    private void btnUpdateStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStaffActionPerformed
        // TODO add your handling code here:
        index = tblStaff.getSelectedRow();
        if (index < 0) {
            showMess("Bạn chưa chọn nhân viên trong bảng");
            return;
        }
        
        checkNull();
        //check định dạng
        if (!checkEmail()) {
            showMess("Email không đúng định dạng");
            txtEmail.requestFocus();
            return;
        }
        if (!checkDate()) {
            showMess("Ngày sinh không đúng định dạng yyyy-MM-dd");
            txtDob.requestFocus();
            return;
        }
        if (!checkPhone()) {
            showMess("Số điện thoại không đúng định dạng");
            txtStaffPhone.requestFocus();
            return;
        }
        if (!checkIDNumber()) {
            showMess("Số CCCD gồm 12 chữ số");
            txtStaffPhone.requestFocus();
            return;
        }
        //check tồn tại
//        try {
//
//            if (checkExistAccount()) {
//                showMess("Đã tồn tại tên tài khoản này");
//                txtUserAccount.requestFocus();
//                return;
//            }
//            if (checkExistIDNumber()) {
//                showMess("Đã tồn tại số căn cước công dân này");
//                txtIDCardNumber.requestFocus();
//                return;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //sửa
        try {
            ModelUser user = readForm();
            if (checkExistAccount() && checkExistID()) {
                int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận cập nhật tài khoản này?");
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
                if (svc.updateUser(user)) {
                    ArrayList<ModelUser> listUser = svc.getAllUsers();
                    fillToTable(listUser);
                    showMess("Sửa thông tin Nhân viên thành công");
                    index = 0;
                    showDetail(listUser);
                }
            }
        } catch (Exception e) {
            showMess("Lỗi sửa");
        }
    }//GEN-LAST:event_btnUpdateStaffActionPerformed

    private void txtSearchStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchStaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchStaffActionPerformed

    private void tblStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStaffMouseClicked
        // TODO add your handling code here:
        index = tblStaff.getSelectedRow();
//        System.out.println(index);

        if (index >= 0) {
            txtStaffId.setEditable(false);
            txtStaffId.setBackground(Color.lightGray);
            txtUserAccount.setEditable(false);
            txtUserAccount.setBackground(Color.lightGray);
        }
        
        try {
            showDetail(svc.getAllUsers());
        } catch (SQLException ex) {
            Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblStaffMouseClicked

    private void btnBlockAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlockAccountActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn khóa tài khoản này?");
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        try {
          ModelUser user = readForm();
            if (svc.updateUserStatus(user)) {
                showMess("Khóa tài khoản thành công");
                fillToTable(svc.getAllUsers());
                index = 0;
                showDetail(svc.getAllUsers());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnBlockAccountActionPerformed

    private void txtSearchStaffKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStaffKeyReleased
        // TODO add your handling code here:
        try {
            ArrayList<ModelUser> listUser = svc.getUsersByKey(txtSearchStaff.getText());
            fillToTable(listUser);
            if (tblStaff.getRowCount() > 0) {
                index = 0;
                showDetail(listUser);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchStaffKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewStaff;
    private javax.swing.JButton btnBlockAccount;
    private javax.swing.JButton btnClearStaff;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnScanCitizenQR;
    private javax.swing.JButton btnUpdateStaff;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboGenderFilter;
    private javax.swing.JComboBox<String> cboRoleFilter;
    private javax.swing.JComboBox<String> cboStatusFilter;
    private javax.swing.JComboBox<String> cboStatusForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoAdmin;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JRadioButton rdoStaff;
    private javax.swing.JTable tblStaff;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtDob;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIDCardNumber;
    private javax.swing.JTextField txtPsw;
    private javax.swing.JTextField txtSearchStaff;
    private javax.swing.JTextField txtStaffId;
    private javax.swing.JTextField txtStaffName;
    private javax.swing.JTextField txtStaffPhone;
    private javax.swing.JTextField txtUserAccount;
    // End of variables declaration//GEN-END:variables

    private void fillToTable(ArrayList<ModelUser> list) throws SQLException {
        model.setRowCount(0);
        int i = 1;
        for (ModelUser user : list) {
            model.addRow(new Object[]{
                i++,
                user.getUserCode(),
                user.getStaffName(),
                user.getPhone(),
                user.isGender() ? "Nam" : "Nữ",
                user.getAccountName(),
                user.getPsw(),
                user.getRole(),
                user.getAddress(),
                user.getEmail(),
                user.getIdCardNumber(),
                user.getDob(),
                user.getStatus()
            });
        }
    }

    private void showDetail(ArrayList<ModelUser> list) throws SQLException {
        ModelUser user = list.get(index);
        txtStaffId.setText(user.getUserCode());
        txtStaffName.setText(user.getStaffName());
        txtStaffPhone.setText(user.getPhone());
        rdoMale.setSelected(user.isGender());
        rdoFemale.setSelected(!user.isGender());
        if (user.getRole().contains("Quản lý")) {
            rdoAdmin.setSelected(true);
        } else {
            rdoStaff.setSelected(true);
        }
        txtUserAccount.setText(user.getAccountName());
        txtPsw.setText(user.getPsw());
        txtAddress.setText(user.getAddress());
        txtEmail.setText(user.getEmail());
        txtIDCardNumber.setText(user.getIdCardNumber());
        txtDob.setText(user.getDob() + "");
        cboStatusForm.setSelectedItem(user.getStatus());

//        System.out.println(user);
        tblStaff.setRowSelectionInterval(index, index);
    }

    private void addPlaceHolder(JTextField tf, String placeHolder) {
        tf.setText(placeHolder);
        tf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tf.getText().equals(placeHolder)) {
                    txtSearchStaff.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tf.getText().isEmpty()) {
                    tf.setText(placeHolder);
                    try {
                        fillToTable(svc.getAllUsers());
                    } catch (SQLException ex) {
                        Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (tblStaff.getRowCount() > 0) {
                        index = 0;
                        try {
                            showDetail(svc.getAllUsers());
                        } catch (SQLException ex) {
                            Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        });
    }

    private void clearForm() {
        txtStaffId.setText("");
        txtStaffName.setText("");
        txtUserAccount.setText("");
        txtPsw.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtIDCardNumber.setText("");
        txtDob.setText("");
        txtStaffPhone.setText("");
        tblStaff.clearSelection();
    }

    private void checkNull() {
        if (txtStaffId.getText().trim().equals("")) {
            showMess("Mã Nhân viên không được để trống");
            txtStaffId.requestFocus();
            return;
        }
        if (txtStaffName.getText().trim().equals("")) {
            showMess("Tên Nhân viên không được để trống");
            txtStaffName.requestFocus();
            return;
        }
        if (txtStaffPhone.getText().trim().equals("")) {
            showMess("Số điện thoại không được để trống");
            txtStaffPhone.requestFocus();
            return;
        }
        if (txtUserAccount.getText().trim().equals("")) {
            showMess("Tên tài khoản không được để trống");
            txtUserAccount.requestFocus();
            return;
        }
        if (txtPsw.getText().trim().equals("")) {
            showMess("Mật khẩu không được để trống");
            txtPsw.requestFocus();
            return;
        }
        if (txtAddress.getText().trim().equals("")) {
            showMess("Địa chỉ không được để trống");
            txtAddress.requestFocus();
            return;
        }
        if (txtIDCardNumber.getText().trim().equals("")) {
            showMess("CCCD không được để trống");
            txtIDCardNumber.requestFocus();
            return;
        }
        if (txtDob.getText().trim().equals("")) {
            showMess("Ngày sinh không được để trống");
            txtDob.requestFocus();
            return;
        }
    }

    private void showMess(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private boolean checkEmail() {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return validateString(txtEmail.getText(), emailPattern);
    }

    private boolean checkDate() {
        String datePattern = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
        return validateString(txtDob.getText(), datePattern);
    }

    private boolean checkPhone() {
        String phonePattern = "^(\\+84|0)(3[2-9]|5[689]|7[06-9]|8[1-689]|9[0-46-9])[0-9]{7}$";
        return validateString(txtStaffPhone.getText(), phonePattern);
    }

    private boolean checkIDNumber() {
        String idPattern = "^(\\d{12})$";
        return validateString(txtStaffId.getText(), idPattern);
    }

    private boolean validateString(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
    
    private ModelUser readForm() throws ParseException {
        ModelUser user = new ModelUser();
        user.setUserCode(txtStaffId.getText());
        user.setStaffName(txtStaffName.getText());
        user.setPhone(txtStaffPhone.getText());
        user.setGender(rdoMale.isSelected() ? true : false);
        user.setAccountName(txtUserAccount.getText());
        user.setPsw(txtPsw.getText());
        user.setRoleId(rdoAdmin.isSelected() ? Role.ADMIN : Role.STAFF);
        user.setAddress(txtAddress.getText());
        user.setEmail(txtEmail.getText());
        user.setIdCardNumber(txtIDCardNumber.getText());
        String string = txtDob.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(string);
        user.setDob(date);
        user.setStatus((String) cboStatusForm.getSelectedItem());
        return user;
    }

    private boolean checkExistIDNumber() throws SQLException {
        ArrayList<ModelUser> list = svc.getAllUsers();
        for (ModelUser user : list) {
            if (txtIDCardNumber.getText().trim().equals(user.getIdCardNumber())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkExistAccount() throws SQLException {
        ArrayList<ModelUser> list = svc.getAllUsers();
        for (ModelUser user : list) {
            if (txtUserAccount.getText().trim().equals(user.getAccountName())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistID() throws SQLException {
        ArrayList<ModelUser> list = svc.getAllUsers();
        for (ModelUser user : list) {
            if (txtStaffId.getText().trim().equals(user.getUserCode())) {
                return true;
            }
        }
        return false;
    }

    
}
