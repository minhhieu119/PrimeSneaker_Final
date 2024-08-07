package com.prime.form;

import com.prime.main_model.ModelCustomer;
import com.prime.main_model.Order;
import com.prime.services.CustomerService;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManageCustomer extends javax.swing.JPanel {

    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    CustomerService svc = new CustomerService();
    int index = -1;
    int confirm;
    int pageIndex;

    public ManageCustomer() throws SQLException {
        initComponents();
        setOpaque(false);
        jdcDOB.setDateFormatString("dd/MM/yyyy");
        model1 = (DefaultTableModel) tblListCustomer.getModel();
        ArrayList<ModelCustomer> list = svc.getAllCustomer();

        lblPage.setText("1");
        btnPrev.setEnabled(false);
        pageIndex = Integer.valueOf(lblPage.getText());
        ArrayList<ModelCustomer> listPaging = svc.getAllCustomerPaging(pageIndex, 9);
        fillToTable(listPaging);
        if (tblListCustomer.getRowCount() > 0) {
            index = 0;
            showDetail(list);
        }
        txtCustomerId.setEditable(false);
        txtCustomerId.setBackground(Color.lightGray);

        model2 = (DefaultTableModel) tblOrderHistory.getModel();
        ArrayList<Order> listOrder = svc.getOrderHistory();
        fillToOrderHistoryTbl();

        addPlaceHolder(txtSearchCustomer, "Tìm theo SĐT");
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
        btnAddNewStaff = new javax.swing.JButton();
        btnUpdateStaff = new javax.swing.JButton();
        btnClearStaff = new javax.swing.JButton();
        btnExportToExcel = new javax.swing.JButton();
        jdcDOB = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblListCustomer = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtSearchCustomer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrderHistory = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        txtCustomerId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        txtCustomerName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        txtCustomerPhone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

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

        btnAddNewStaff.setBackground(new java.awt.Color(39, 80, 150));
        btnAddNewStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewStaff.setText("Thêm khách hàng");
        btnAddNewStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        btnUpdateStaff.setBackground(new java.awt.Color(39, 80, 150));
        btnUpdateStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateStaff.setText("Sửa khách hàng");
        btnUpdateStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });

        btnClearStaff.setBackground(new java.awt.Color(39, 80, 150));
        btnClearStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnClearStaff.setText("Làm mới");
        btnClearStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCustomerActionPerformed(evt);
            }
        });

        btnExportToExcel.setBackground(new java.awt.Color(39, 80, 150));
        btnExportToExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExportToExcel.setText("Xuất Excel");
        btnExportToExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportToExcelbtnClearCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddNewStaff)
                    .addComponent(btnUpdateStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportToExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddNewStaff, btnClearStaff, btnUpdateStaff});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAddNewStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnUpdateStaff)
                .addGap(18, 18, 18)
                .addComponent(btnClearStaff)
                .addGap(18, 18, 18)
                .addComponent(btnExportToExcel)
                .addGap(22, 22, 22))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddNewStaff, btnClearStaff, btnExportToExcel, btnUpdateStaff});

        jdcDOB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

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
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                            .addComponent(jdcDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane2, txtCustomerId, txtCustomerName, txtCustomerPhone});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCustomerId)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoFemale)
                            .addComponent(rdoMale))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcDOB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txtSearchCustomer.setForeground(new java.awt.Color(153, 153, 153));
        txtSearchCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 80, 150)));
        txtSearchCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchCustomerKeyReleased(evt);
            }
        });

        jLabel3.setText("Tìm kiếm :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearchCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        lblPage.setText("Page");

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrev)
                .addGap(18, 18, 18)
                .addComponent(lblPage)
                .addGap(18, 18, 18)
                .addComponent(btnNext)
                .addGap(404, 404, 404))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(lblPage)
                    .addComponent(btnNext))
                .addGap(16, 16, 16))
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrderHistoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderHistoryMousePressed

    }//GEN-LAST:event_tblOrderHistoryMousePressed

    private void tblListCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListCustomerMouseClicked
        // TODO add your handling code here:
//        index = tblListCustomer.getSelectedRow();
//        try {
//            showDetail(svc.getAllCustomerPaging(pageIndex, 9));
//        } catch (SQLException ex) {
//            Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
//        }
          showDetailSearch();
    }//GEN-LAST:event_tblListCustomerMouseClicked

    private void btnClearCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCustomerActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnClearCustomerActionPerformed

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed
        // TODO add your handling code here:
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

        if (jdcDOB.getDate() != null) {
            if (!checkAge()) {
                showMess("Độ tuổi không hợp lệ");
                jdcDOB.requestFocus();
                return;
            }
        } else {
            showMess("Cần nhập ngày sinh và nhập đúng định dạng dd/MM/yyyy");
            jdcDOB.requestFocus();
            return;
        }

        if (!checkPhone()) {
            showMess("Số điện thoại không đúng định dạng");
            txtCustomerPhone.requestFocus();
            return;
        }
        try {
            ModelCustomer cus = readFormToUpdate();
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

//        checkNull();
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

        if (jdcDOB.getDate() != null) {
            if (!checkAge()) {
                showMess("Độ tuổi không hợp lệ");
                jdcDOB.requestFocus();
                return;
            }
        } else {
            showMess("Cần nhập ngày sinh và nhập đúng định dạng dd/MM/yyyy");
            jdcDOB.requestFocus();
            return;
        }

        if (!checkPhone()) {
            showMess("Số điện thoại không đúng định dạng");
            txtCustomerPhone.requestFocus();
            return;
        }

        try {
            if (checkExistName() && checkExistPhone()) {
                showMess("Đã tồn tại khách hàng và số ĐT này");
                txtCustomerName.requestFocus();
                return;
            }

            confirm = JOptionPane.showConfirmDialog(this, "Xác nhận thêm khách hàng?");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            ModelCustomer cus = readForm();
            if (txtCustomerId.getText().trim().isEmpty()) {
                if (svc.addCustomer(cus)) {
                    ArrayList<ModelCustomer> list = svc.getAllCustomer();
                    fillToTable(list);
                    showMess("Thêm khách hàng thành công");
                    index = tblListCustomer.getRowCount() - 1;
                    showDetail(list);
                }
                return;
            } else {
                if (checkExistID()) {
                    showMess("Đã tồn tại mã khách hàng này, không thể thêm mới");
                    txtCustomerId.requestFocus();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void txtSearchCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchCustomerKeyReleased
        // TODO add your handling code here:
        try {
            ArrayList<ModelCustomer> listCustomer = svc.CustomerByPhone(txtSearchCustomer.getText());
            fillToTable(listCustomer);
            if (tblListCustomer.getRowCount() > 0) {
                index = 0;
                showDetail(listCustomer);
            }
//            showDetailSearch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtSearchCustomerKeyReleased

    private void btnExportToExcelbtnClearCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportToExcelbtnClearCustomerActionPerformed
        // TODO add your handling code here:
        FileOutputStream output = null;
        BufferedOutputStream buffer = null;
        XSSFWorkbook excelExporter = null;

        JFileChooser excelFileChooser = new JFileChooser("Desktop");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelExporter = new XSSFWorkbook();
                XSSFSheet sheet = excelExporter.createSheet("Sheet table");
                for (int i = 0; i < model1.getRowCount(); i++) {
                    XSSFRow excelRow = sheet.createRow(i);
                    for (int j = 0; j < model1.getColumnCount() - 1; j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(model1.getValueAt(i, j).toString());
//                            System.out.println(model.getValueAt(i, j));
                    }
                }
                output = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                buffer = new BufferedOutputStream(output);
                excelExporter.write(buffer);
                showMess("Xuất file thành công!");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (buffer != null) {
                        buffer.close();
                    }
                    if (output != null) {
                        output.close();
                    }
                    if (excelExporter != null) {
                        excelExporter.close();
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnExportToExcelbtnClearCustomerActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        pageIndex = Integer.valueOf(lblPage.getText()) - 1;
        try {
            fillToTable(svc.getAllCustomerPaging(pageIndex, 9));
            lblPage.setText(pageIndex + "");
            if (pageIndex > 1) {
                btnPrev.setEnabled(true);
            } else {
                btnPrev.setEnabled(false);
            }

            if (tblListCustomer.getRowCount() < 9) {
                btnNext.setEnabled(false);
            } else {
                btnNext.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        pageIndex = Integer.valueOf(lblPage.getText()) + 1;
        try {
            fillToTable(svc.getAllCustomerPaging(pageIndex, 9));
            lblPage.setText(pageIndex + "");
            if (pageIndex > 1) {
                btnPrev.setEnabled(true);
            } else {
                btnPrev.setEnabled(false);
            }

            if (tblListCustomer.getRowCount() < 9) {
                btnNext.setEnabled(false);
            } else {
                btnNext.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewStaff;
    private javax.swing.JButton btnClearStaff;
    private javax.swing.JButton btnExportToExcel;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnUpdateStaff;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane4;
    private com.toedter.calendar.JDateChooser jdcDOB;
    private javax.swing.JLabel lblPage;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTable tblListCustomer;
    private javax.swing.JTable tblOrderHistory;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtCustomerId;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerPhone;
    private javax.swing.JTextField txtSearchCustomer;
    // End of variables declaration//GEN-END:variables

    private void fillToTable(ArrayList<ModelCustomer> list) {
        model1.setRowCount(0);
        int i = 1;
        for (ModelCustomer customer : list) {
            model1.addRow(new Object[]{
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
        jdcDOB.setDate(customer.getDob());
        tblListCustomer.setRowSelectionInterval(index, index);
    }

    private void clearForm() {

        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerPhone.setText("");
        txtAddress.setText("");
        jdcDOB.setDate(null);
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

//    private boolean checkDate() {
//        String datePattern = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";
//        return validateString(txtDob.getText(), datePattern);
//    }
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
//        cus.setCustomerID(Integer.valueOf(txtCustomerId.getText()));
        cus.setCustomerName(txtCustomerName.getText());
        cus.setPhoneNumber(txtCustomerPhone.getText());
        cus.setGender(rdoMale.isSelected());
        cus.setAddress(txtAddress.getText());
//        Date string = jdcDOB.getDate();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse(string);
        cus.setDob(jdcDOB.getDate());
        return cus;
    }

    private ModelCustomer readFormToUpdate() throws ParseException {
        ModelCustomer cus = new ModelCustomer();
        cus.setCustomerID(Integer.valueOf(txtCustomerId.getText()));
        cus.setCustomerName(txtCustomerName.getText());
        cus.setPhoneNumber(txtCustomerPhone.getText());
        cus.setGender(rdoMale.isSelected());
        cus.setAddress(txtAddress.getText());
//        String string = txtDob.getText();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse(string);
        cus.setDob(jdcDOB.getDate());
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

    private void fillToOrderHistoryTbl() throws SQLException {
        model2.setRowCount(0);
        int i = 1;
        for (Order order : svc.getOrderHistory()) {
            model2.addRow(new Object[]{
                i++,
                order.getCustomerId(),
                order.getCustomerName(),
                order.getOrderId(),
                order.getUpdate_at(),
                order.getTotalCost(),
                order.getPaymentMethod()
            });
        }
    }

    private boolean checkAge() {
        Date date = jdcDOB.getDate();
        if (LocalDate.now().getYear() - (date.getYear() + 1900) <= 0) {
            return false;
        }
        return true;
    }

    private void addPlaceHolder(JTextField tf, String placeHolder) {
        tf.setText(placeHolder);
        tf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tf.getText().equals(placeHolder)) {
                    txtSearchCustomer.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tf.getText().isEmpty()) {
                    tf.setText(placeHolder);
                    try {
                        fillToTable(svc.getAllCustomer());
                    } catch (SQLException ex) {
                        Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (tblListCustomer.getRowCount() > 0) {
                        index = 0;
                        try {
                            showDetail(svc.getAllCustomer());
                        } catch (SQLException ex) {
                            Logger.getLogger(ManageStaff.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        });
    }

    private void showDetailSearch() {
        index = tblListCustomer.getSelectedRow();
        txtCustomerId.setText(tblListCustomer.getValueAt(index, 1).toString());
        txtCustomerName.setText(tblListCustomer.getValueAt(index, 2).toString());
        txtCustomerPhone.setText(tblListCustomer.getValueAt(index, 3).toString());
        rdoMale.setSelected(tblListCustomer.getValueAt(index, 4).toString().equals("Nam") ? true : false);
        rdoMale.setSelected(tblListCustomer.getValueAt(index, 4).toString().equals("Nữ") ? true : false);
        txtAddress.setText(tblListCustomer.getValueAt(index, 5).toString());
        jdcDOB.setDate((Date) tblListCustomer.getValueAt(index, 6));
        tblListCustomer.setRowSelectionInterval(index, index);
    }
}
