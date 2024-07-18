package com.prime.form;

import com.prime.form.attribute.ViewQr;
import com.prime.form.attributeSneaker.CartQuantity;
import com.prime.main_model.Order;
import com.prime.main_model.SneakerCart;
import com.prime.main_model.SneakerDetail;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import com.prime.main_model.Voucher;
import com.prime.services.OrderService;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class OrderForm extends javax.swing.JPanel {

    OrderService os = new OrderService();
    DefaultTableModel modelSneaker = new DefaultTableModel();
    DefaultTableModel modelCart = new DefaultTableModel();
    DefaultTableModel modelInvoice = new DefaultTableModel();
    int invoiceId = 0;
    int cartIndex = 0;
    int index;

    public OrderForm() throws SQLException {
        initComponents();
        setOpaque(false);
        addVoucher();
        fillToListInvoice(os.getOrder());
        fillToListSneakerDetail(os.getAllSneakerDetail());

    }

    private void addVoucher() throws SQLException {
        for (Voucher vou : os.getVoucher()) {
            cboVoucher.addItem(vou.getVoucherName());
        }
    }

    private void fillToListSneakerDetail(List<SneakerDetail> list) throws SQLException {
        modelSneaker = (DefaultTableModel) tblSneakerDetail.getModel();
        modelSneaker.setRowCount(0);
        int index = 0;
        for (SneakerDetail sd : list) {
            modelSneaker.addRow(new Object[]{
                index += 1,
                sd.getSneakerCode(),
                sd.getSneakerName(),
                sd.getPrice(),
                sd.getQuantity(),
                sd.getBrand(),
                sd.getCategory(),
                sd.getMaterial(),
                sd.getSole(),
                sd.getColor(),
                sd.getSize()
            });
//System.out.println(sd);
        }
    }

    private void fillToListInvoice(List<Order> list) throws SQLException {
        modelInvoice = (DefaultTableModel) tblInvoice.getModel();
        modelInvoice.setRowCount(0);
        int stt = 0;
        for (Order o : list) {
            modelInvoice.addRow(new Object[]{
                stt += 1,
                o.getOrderId(),
                o.getUserId(),
                o.getQuantity(),
                o.getStatus(),
                o.getCreated_at()
            });
//System.out.println(sd);
        }
    }

    private void fillToListCart(List<SneakerCart> list) throws SQLException {
        modelCart = (DefaultTableModel) tblCart.getModel();
        modelCart.setRowCount(0);
        int stt = 0;
        int quantity = 0;
        for (SneakerCart sc : list) {
            modelCart.addRow(new Object[]{
                stt += 1,
                sc.getOrder_id(),
                sc.getSneakerCode(),
                sc.getSneakerName(),
                sc.getQuantity(),
                sc.getQuantity() * sc.getPrice(),
                sc.getBrand(),
                sc.getColor(),
                sc.getSize(),
                "Action"
            });
//System.out.println(sd);
        }
    }

    public Integer getQuantity(int quantity) {
        return quantity;
    }

    private void showDetail() {
        txtInvoiceId.setText((String) tblInvoice.getValueAt(index, 1));
        txtStaffId.setText((String) tblInvoice.getValueAt(index, 2));
        cboVoucher.setSelectedItem(ABORT);
        txtStaffId.setText((String) tblInvoice.getValueAt(index, 2));
        txtStaffId.setText((String) tblInvoice.getValueAt(index, 2));
        txtStaffId.setText((String) tblInvoice.getValueAt(index, 2));
        txtStaffId.setText((String) tblInvoice.getValueAt(index, 2));
        txtStaffId.setText((String) tblInvoice.getValueAt(index, 2));
        txtStaffId.setText((String) tblInvoice.getValueAt(index, 2));
        txtStaffId.setText((String) tblInvoice.getValueAt(index, 2));
    }

    private SneakerDetail getSneakerToCart() {
        SneakerDetail sd = new SneakerDetail();
        int index = tblSneakerDetail.getSelectedRow();
        sd.setSneakerCode((String) tblSneakerDetail.getValueAt(index, 1));
        sd.setSneakerName((String) tblSneakerDetail.getValueAt(index, 2));
        sd.setPrice((long) tblSneakerDetail.getValueAt(index, 3));
        sd.setQuantity((int) tblSneakerDetail.getValueAt(index, 4));
        sd.setBrand((String) tblSneakerDetail.getValueAt(index, 5));
        sd.setCategory((String) tblSneakerDetail.getValueAt(index, 6));
        sd.setMaterial((String) tblSneakerDetail.getValueAt(index, 7));
        sd.setSole((String) tblSneakerDetail.getValueAt(index, 8));
        sd.setColor((String) tblSneakerDetail.getValueAt(index, 9));
        sd.setSize((float) tblSneakerDetail.getValueAt(index, 10));
        return sd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblInvoice = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnDeleteCart = new javax.swing.JButton();
        txtCartQuantityUpdate = new javax.swing.JButton();
        btnScanQR = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtNameCustomer = new javax.swing.JTextField();
        btnListCustomer = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtInvoiceId = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtStaffId = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cboVoucher = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        txtStartDateCreated = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtOrderCost = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cboPaymentMethod = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txtMoneyCash = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtMoneyTransfer = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtChange = new javax.swing.JTextField();
        btnPay = new javax.swing.JButton();
        btnDeleteOrder = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtDiscoutCost = new javax.swing.JTextField();
        txtTotalCost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAddInvoice = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblSlider = new javax.swing.JLabel();
        sliderPrice = new javax.swing.JSlider();
        txtSearchProdDetail = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSneakerDetail = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lbnGia = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1058, 770));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1formMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Mã NV", "Số lượng SP", "Trạng thái", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInvoiceMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblInvoice);
        if (tblInvoice.getColumnModel().getColumnCount() > 0) {
            tblInvoice.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HĐ", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Hãng", "Màu sắc", "Kích cỡ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCartMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCart);
        if (tblCart.getColumnModel().getColumnCount() > 0) {
            tblCart.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblCart.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblCart.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblCart.getColumnModel().getColumn(4).setPreferredWidth(20);
            tblCart.getColumnModel().getColumn(8).setPreferredWidth(20);
        }

        jPanel2.setBackground(new java.awt.Color(185, 213, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDeleteCart.setBackground(new java.awt.Color(39, 80, 150));
        btnDeleteCart.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnDeleteCart.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCart.setText("Xóa");
        btnDeleteCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCartActionPerformed(evt);
            }
        });

        txtCartQuantityUpdate.setBackground(new java.awt.Color(39, 80, 150));
        txtCartQuantityUpdate.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        txtCartQuantityUpdate.setForeground(new java.awt.Color(255, 255, 255));
        txtCartQuantityUpdate.setText("Sửa");
        txtCartQuantityUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCartQuantityUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCartQuantityUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCart, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDeleteCart, txtCartQuantityUpdate});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtCartQuantityUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteCart, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDeleteCart, txtCartQuantityUpdate});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnScanQR.setBackground(new java.awt.Color(39, 80, 150));
        btnScanQR.setForeground(new java.awt.Color(255, 255, 255));
        btnScanQR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/prime/icon/z4947982062204_cc726bd2d83818a4619a57822d9df5f0.gif"))); // NOI18N
        btnScanQR.setText("Quét Mã SP");
        btnScanQR.setBorder(null);
        btnScanQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanQRActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });
        txtPhoneNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneNumberKeyReleased(evt);
            }
        });

        jLabel36.setText("SDT:");

        jLabel37.setText("Tên KH:");

        txtNameCustomer.setEditable(false);
        txtNameCustomer.setText("Khách lẻ");
        txtNameCustomer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        btnListCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnListCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnListCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/prime/icon/listCustomer.png"))); // NOI18N
        btnListCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnListCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("Mã hóa đơn:");

        txtInvoiceId.setEditable(false);
        txtInvoiceId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel17.setText("Mã NV:");

        txtStaffId.setEditable(false);
        txtStaffId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel18.setText("Giảm giá:");

        cboVoucher.setBackground(new java.awt.Color(39, 80, 150));
        cboVoucher.setForeground(new java.awt.Color(255, 255, 255));
        cboVoucher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không áp dụng" }));

        jLabel19.setText("Ngày tạo:");

        txtStartDateCreated.setEditable(false);
        txtStartDateCreated.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel20.setText("Tiền HĐ");

        txtOrderCost.setEditable(false);
        txtOrderCost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel21.setText("Hình thức TT:");

        cboPaymentMethod.setBackground(new java.awt.Color(39, 80, 150));
        cboPaymentMethod.setForeground(new java.awt.Color(255, 255, 255));
        cboPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Cả hai" }));

        jLabel22.setText("TIền mặt:");

        txtMoneyCash.setBackground(new java.awt.Color(242, 242, 242));
        txtMoneyCash.setText("0");
        txtMoneyCash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel24.setText("Tiền CK:");

        txtMoneyTransfer.setEditable(false);
        txtMoneyTransfer.setText("0");
        txtMoneyTransfer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel25.setText("Tiền trả lại:");

        txtChange.setEditable(false);
        txtChange.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        btnPay.setBackground(new java.awt.Color(39, 80, 150));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("Thanh toán");

        btnDeleteOrder.setBackground(new java.awt.Color(39, 80, 150));
        btnDeleteOrder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteOrder.setText("Huỷ hoá đơn");
        btnDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrderActionPerformed(evt);
            }
        });

        jLabel26.setText("Tiền giảm");

        txtDiscoutCost.setBackground(new java.awt.Color(242, 242, 242));
        txtDiscoutCost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        txtTotalCost.setBackground(new java.awt.Color(242, 242, 242));
        txtTotalCost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel1.setText("Tiền TT");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMoneyTransfer, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMoneyCash, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboPaymentMethod, 0, 142, Short.MAX_VALUE)
                            .addComponent(txtChange)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDiscoutCost, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(txtTotalCost)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnDeleteOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(btnPay))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtStartDateCreated, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboVoucher, javax.swing.GroupLayout.Alignment.LEADING, 0, 142, Short.MAX_VALUE)
                            .addComponent(txtStaffId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtInvoiceId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrderCost))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDeleteOrder, btnPay});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel24, jLabel25});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInvoiceId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStartDateCreated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrderCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiscoutCost))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMoneyCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMoneyTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboPaymentMethod, cboVoucher, txtChange, txtDiscoutCost, txtInvoiceId, txtMoneyCash, txtMoneyTransfer, txtOrderCost, txtStaffId, txtStartDateCreated, txtTotalCost});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDeleteOrder, btnPay});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel24, jLabel25});

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        btnAddInvoice.setBackground(new java.awt.Color(39, 80, 150));
        btnAddInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnAddInvoice.setText("Tạo hoá đơn");
        btnAddInvoice.setBorder(null);
        btnAddInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInvoiceActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm chi tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel23.setText("Search :");

        lblSlider.setText("Tìm theo giá:");

        sliderPrice.setBackground(new java.awt.Color(39, 80, 150));
        sliderPrice.setMaximum(6000000);
        sliderPrice.setMinimum(100000);
        sliderPrice.setToolTipText("100");
        sliderPrice.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderPriceStateChanged(evt);
            }
        });

        txtSearchProdDetail.setForeground(new java.awt.Color(153, 153, 153));
        txtSearchProdDetail.setText("Tìm kiếm theo mã, tên, trạng thái ,số lượng, thuộc tính sản phẩm");
        txtSearchProdDetail.setToolTipText("");
        txtSearchProdDetail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 80, 150)));
        txtSearchProdDetail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchProdDetailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchProdDetailFocusLost(evt);
            }
        });
        txtSearchProdDetail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchProdDetailKeyReleased(evt);
            }
        });

        tblSneakerDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng tồn", "Hãng", "Danh mục", "Chất liệu", "Đế giày", "Màu sắc", "Kích cỡ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSneakerDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSneakerDetailMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSneakerDetail);
        if (tblSneakerDetail.getColumnModel().getColumnCount() > 0) {
            tblSneakerDetail.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblSneakerDetail.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblSneakerDetail.getColumnModel().getColumn(4).setPreferredWidth(20);
            tblSneakerDetail.getColumnModel().getColumn(5).setPreferredWidth(40);
            tblSneakerDetail.getColumnModel().getColumn(9).setPreferredWidth(50);
            tblSneakerDetail.getColumnModel().getColumn(10).setPreferredWidth(20);
        }

        jLabel2.setText("Giá: ");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchProdDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(lblSlider)
                .addGap(18, 18, 18)
                .addComponent(sliderPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbnGia, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnGia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearchProdDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sliderPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAddInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnScanQR, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnScanQR, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Hóa đơn chờ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnScanQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScanQRActionPerformed
        // TODO add your handling code here:
        if (tblInvoice.getSelectedRow() != -1) {
            ViewQr view = new ViewQr(null, true);
            view.setVisible(true);
            view.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    int index = tblInvoice.getSelectedRow();
                    int maHD = Integer.parseInt(tblInvoice.getValueAt(index, 1).toString());
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để thêm sản phẩm");
            return;
        }
    }//GEN-LAST:event_btnScanQRActionPerformed

    private void jPanel1formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1formMouseClicked
        // TODO add your handling code here:

        //        fillTableHoaDon(banHang.fillHoaDon());
        //        fillTableGioHang(banHang.getAllHDCT(WIDTH));
    }//GEN-LAST:event_jPanel1formMouseClicked

    private void txtSearchProdDetailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchProdDetailFocusGained
        if (txtSearchProdDetail.getText().equals("Tìm kiếm theo mã, tên, trạng thái ,số lượng, thuộc tính sản phẩm")) {
            txtSearchProdDetail.setText("");
            setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchProdDetailFocusGained

    private void txtSearchProdDetailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchProdDetailFocusLost
        if (txtSearchProdDetail.getText().equals("")) {
            txtSearchProdDetail.setText("Tìm kiếm theo mã, tên, trạng thái ,số lượng, thuộc tính sản phẩm");
            setForeground(new Color(39, 80, 150));
        }
    }//GEN-LAST:event_txtSearchProdDetailFocusLost

    private void btnAddInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInvoiceActionPerformed
        int stt = 0;
        try {
            if (os.addInvoice() > 0) {
                fillToListInvoice(os.getOrder());
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAddInvoiceActionPerformed

    private void txtSearchProdDetailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchProdDetailKeyReleased
        String key = txtSearchProdDetail.getText().trim();
        try {
            if (key.isBlank()) {
                fillToListSneakerDetail(os.getAllSneakerDetail());
            } else {
//                System.out.println(key);
                fillToListSneakerDetail(os.searchSD(key));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtSearchProdDetailKeyReleased

    private void sliderPriceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderPriceStateChanged
        int price = sliderPrice.getValue();
        try {
            lbnGia.setText("" + price);
            fillToListSneakerDetail(os.searchPrice(price));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_sliderPriceStateChanged

    private void tblInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInvoiceMouseClicked
        int index = tblInvoice.getSelectedRow();
        invoiceId = (int) tblInvoice.getValueAt(index, 1);
        try {
//            System.out.println(invoiceId);
            fillToListCart(os.getToCart(invoiceId));
        } catch (SQLException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_tblInvoiceMouseClicked

    private void txtCartQuantityUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCartQuantityUpdateActionPerformed
        if (tblCart.getSelectedRow() != -1) {
            new CartQuantity().setVisible(true);
            System.out.println(getQuantity(SOMEBITS));
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm trong giỏ", "Thông báo", 1);
        }

    }//GEN-LAST:event_txtCartQuantityUpdateActionPerformed

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    private void btnListCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListCustomerActionPerformed

    private void tblSneakerDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSneakerDetailMouseClicked
        try {

            if (evt.getClickCount() == 2) {
                if (invoiceId == 0) {
                    JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn", "Thông báo", 1);
                    return;
                }
                index = tblSneakerDetail.getSelectedRow();
                os.addToCart(os.getSneakerDetail((String) tblSneakerDetail.getValueAt(index, 1)), invoiceId);
                fillToListCart(os.getToCart(invoiceId));
                fillToListInvoice(os.getOrder());
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblSneakerDetailMouseClicked

    private void btnDeleteCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCartActionPerformed

        try {
            int sdId;
            int orderId;

            if (tblCart.getSelectedRow() != -1) {
//                cartIndex = tblCart.getSelectedRow();
//                sdId = os.getIdSneakerDetail((String) tblCart.getValueAt(cartIndex, 1)).getSneakerId();
//                if (os.deleteOrderDetail(invoiceId, sdId) != null || os.deleteOrderDetail(invoiceId, sdId) != 0) {
//                    fillToListCart(os.getToCart(invoiceId));
//                    fillToListInvoice(os.getOrder());
//                    JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", 1);
//                } else {
//                    JOptionPane.showMessageDialog(this, "Xóa không thành công", "Thông báo", 1);
//                }
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Thông báo", 2);

                if (confirm != 0) {
                    return;
                }
                index = tblCart.getSelectedRow();
                sdId = os.getIdSneaker((String) tblCart.getValueAt(index, 2));
                orderId = (int) tblCart.getValueAt(index, 1);
                if (os.deleteOrderDetail(orderId, sdId) != null || os.deleteOrderDetail(invoiceId, sdId) != 0) {
                    fillToListCart(os.getToCart(orderId));
                    fillToListInvoice(os.getOrder());
                    JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa không thành công", "Thông báo", 1);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm cần xóa", "Thông báo", 1);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDeleteCartActionPerformed

    private void tblCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCartMouseClicked

    }//GEN-LAST:event_tblCartMouseClicked

    private void btnDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrderActionPerformed
        index = tblInvoice.getSelectedRow();
        try {
            if (index != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy hóa đơn không ?", "Thông báo", 1);
                if (confirm != 0) {
                    return;
                }

                if (os.updateOrder((int) tblInvoice.getValueAt(index, 1)) != null || os.updateOrder((int) tblInvoice.getValueAt(index, 1)) != 0) {
                    fillToListInvoice(os.getOrder());
                    JOptionPane.showMessageDialog(this, "Hủy hóa đơn thành công", "Thông báo", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Không hủy được hóa đơn", "Thông báo", 1);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn cần hủy", "Thông báo", 1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi hủy hóa đơn", "Thông báo", 2);
        }


    }//GEN-LAST:event_btnDeleteOrderActionPerformed

    private void txtPhoneNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneNumberKeyReleased
        String name;
        try {
            if (txtPhoneNumber.getText().isBlank()) {
                txtNameCustomer.setText("Khách lẻ");
            } else {
                name = os.getCustomerName(txtPhoneNumber.getText());
                txtNameCustomer.setText(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txtPhoneNumberKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddInvoice;
    private javax.swing.JButton btnDeleteCart;
    private javax.swing.JButton btnDeleteOrder;
    private javax.swing.JButton btnListCustomer;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnScanQR;
    private javax.swing.JComboBox<String> cboPaymentMethod;
    private javax.swing.JComboBox<String> cboVoucher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblSlider;
    private javax.swing.JLabel lbnGia;
    private javax.swing.JSlider sliderPrice;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblInvoice;
    private javax.swing.JTable tblSneakerDetail;
    private javax.swing.JButton txtCartQuantityUpdate;
    private javax.swing.JTextField txtChange;
    private javax.swing.JTextField txtDiscoutCost;
    private javax.swing.JTextField txtInvoiceId;
    private javax.swing.JTextField txtMoneyCash;
    private javax.swing.JTextField txtMoneyTransfer;
    private javax.swing.JTextField txtNameCustomer;
    private javax.swing.JTextField txtOrderCost;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSearchProdDetail;
    private javax.swing.JTextField txtStaffId;
    private javax.swing.JTextField txtStartDateCreated;
    private javax.swing.JTextField txtTotalCost;
    // End of variables declaration//GEN-END:variables
}
