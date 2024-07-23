package com.prime.form;

import com.prime.form.attribute.ViewQr;
import com.prime.form.attributeSneaker.CartQuantityJDialog;
import com.prime.main_model.Order;
import com.prime.main_model.SneakerCart;
import com.prime.main_model.SneakerDetail;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import com.prime.main_model.Voucher;
import com.prime.model.CartQuantity;
import com.prime.services.OrderService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.prime.model.CartQuantity;

public class OrderForm extends javax.swing.JPanel {

    OrderService os = new OrderService();
    DefaultTableModel modelSneaker = new DefaultTableModel();
    DefaultTableModel modelCart = new DefaultTableModel();
    DefaultTableModel modelInvoice = new DefaultTableModel();
    int invoiceId;
    int cartIndex;
    int indexOrder;
    int indexSneaker;

    public OrderForm() throws SQLException {
        initComponents();
        setOpaque(false);
        addVoucher();
        fillToListInvoice(os.getOrder());
        if (tblInvoice.getRowCount() > 0) {
            tblInvoice.setRowSelectionInterval(0, 0);
            invoiceId = (int) tblInvoice.getValueAt(tblInvoice.getSelectedRow(), 1);
        }
        fillToListCart(os.getToCart(invoiceId));
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
                sc.getSize()

            });
//System.out.println(sd);
        }
    }

    public Integer getQuantity(int quantity) {
        return quantity;
    }

    private void showDetail() throws SQLException {
        Order o = os.getOneOrder(invoiceId);
        indexOrder = tblInvoice.getSelectedRow();
        if (o.getOrderId() == 0) {
//            System.out.println(tblInvoice.getValueAt(indexOrder, 1));
            txtInvoiceId.setText(tblInvoice.getValueAt(indexOrder, 1) + "");
//            txtStaffId.setText(o.getUserId() + "");
            txtStaffId.setText("NV004 - Trần Ánh Quỳnh");
            txtStartDateCreated.setText(tblInvoice.getValueAt(indexOrder, 5) + "");
            txtOrderCost.setText(o.getTotalCost() + "");
            if (o.getVoucherName() == null) {
                cboVoucher.setSelectedIndex(0);
            } else {
                cboVoucher.setSelectedItem(o.getVoucherName());
            }
            if (o.getPaymentMethod() == null) {
                cboPaymentMethod.setSelectedIndex(0);
            } else {
                cboPaymentMethod.setSelectedItem(o.getPaymentMethod());
            }
            voucherProcess();
        } else {
            txtInvoiceId.setText(o.getOrderId() + "");
            txtStaffId.setText(o.getUserId() + "");
            txtStartDateCreated.setText(o.getCreated_at() + "");
            txtOrderCost.setText(o.getTotalCost() + "");
            if (o.getVoucherName() == null) {
                cboVoucher.setSelectedIndex(0);
            } else {
                cboVoucher.setSelectedItem(o.getVoucherName());
            }
            if (o.getPaymentMethod() == null) {
                cboPaymentMethod.setSelectedIndex(0);
            } else {
                cboPaymentMethod.setSelectedItem(o.getPaymentMethod());
            }
            voucherProcess();
        }

    }

    private void clearForm() {
        txtInvoiceId.setText("");
        txtStaffId.setText("");
        cboVoucher.setSelectedIndex(0);
        txtStartDateCreated.setText("");
        txtOrderCost.setText("");
        txtDiscoutCost.setText("");
        txtTotalCost.setText("");
        cboPaymentMethod.setSelectedIndex(0);
        txtMoneyCash.setText("");
        txtMoneyTransfer.setText("");
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

    private void voucherProcess() throws SQLException {
        Voucher v = os.getOneVoucher((String) cboVoucher.getSelectedItem());
        long orderCost = Long.parseLong(txtOrderCost.getText());
        float discountRate = v.getDiscountRate();
        long discountAmount = v.getDiscountAmount();
        long minOrderValue = v.getMinOrderValue();
        if (cboVoucher.getSelectedIndex() == 0) {
            txtDiscoutCost.setText("0");
            txtTotalCost.setText((orderCost - (Float.parseFloat(txtDiscoutCost.getText()))) + "");
        } else {
            if (discountRate == 0) {
                if (orderCost >= minOrderValue) {
                    txtDiscoutCost.setText(discountAmount + "");
                    txtTotalCost.setText((orderCost - (Float.parseFloat(txtDiscoutCost.getText()))) + "");
                } else {
                    txtDiscoutCost.setText("0");
                    txtTotalCost.setText((orderCost - (Float.parseFloat(txtDiscoutCost.getText()))) + "");
                }
            } else {
                if (orderCost >= minOrderValue) {
                    txtDiscoutCost.setText((orderCost * discountRate) + "");
                    txtTotalCost.setText((orderCost - (Float.parseFloat(txtDiscoutCost.getText()))) + "");
                } else {
                    txtDiscoutCost.setText("0");
                    txtTotalCost.setText((orderCost - (Float.parseFloat(txtDiscoutCost.getText()))) + "");
                }
            }
        }
    }

    private int checkProductQuantity() {
        int count = 0;
        String index = "";
//        System.out.println(tblInvoice.getRowCount());
        for (int i = 0; i < tblInvoice.getRowCount(); i++) {
            if (tblInvoice.getValueAt(i, 3).equals(0)) {
                count++;
            }
        }
//        System.out.println(count);
        return count;
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
        btnPay = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtDiscoutCost = new javax.swing.JTextField();
        txtTotalCost = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnDeleteOrder = new javax.swing.JButton();
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
        btnScanQR = new javax.swing.JButton();
        btnDeleteMuch = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1058, 770));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HĐ", "Mã NV", "Số lượng SP", "Trạng thái", "Ngày tạo", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
                "STT", "Mã HĐ", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Hãng", "Màu sắc", "Kích cỡ", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
            tblCart.getColumnModel().getColumn(9).setPreferredWidth(15);
        }

        jPanel2.setBackground(new java.awt.Color(185, 213, 246));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDeleteCart.setBackground(new java.awt.Color(39, 80, 150));
        btnDeleteCart.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnDeleteCart.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteCart.setText("Xóa");
        btnDeleteCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCartActionPerformed(evt);
            }
        });

        txtCartQuantityUpdate.setBackground(new java.awt.Color(39, 80, 150));
        txtCartQuantityUpdate.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
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
                    .addComponent(txtCartQuantityUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCart, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtCartQuantityUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(btnDeleteCart, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

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

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
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

        jLabel17.setText("Tên nhân viên");

        txtStaffId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel18.setText("Giảm giá:");

        cboVoucher.setBackground(new java.awt.Color(39, 80, 150));
        cboVoucher.setForeground(new java.awt.Color(255, 255, 255));
        cboVoucher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không áp dụng" }));
        cboVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVoucherActionPerformed(evt);
            }
        });

        jLabel19.setText("Ngày tạo:");

        txtStartDateCreated.setEditable(false);
        txtStartDateCreated.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel20.setText("Tiền HĐ");

        txtOrderCost.setEditable(false);
        txtOrderCost.setText("0");
        txtOrderCost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel21.setText("Hình thức TT:");

        cboPaymentMethod.setBackground(new java.awt.Color(39, 80, 150));
        cboPaymentMethod.setForeground(new java.awt.Color(255, 255, 255));
        cboPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản" }));
        cboPaymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPaymentMethodActionPerformed(evt);
            }
        });

        jLabel22.setText("TIền mặt:");

        txtMoneyCash.setEditable(false);
        txtMoneyCash.setText("0");
        txtMoneyCash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel24.setText("Tiền CK:");

        txtMoneyTransfer.setText("0");
        txtMoneyTransfer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        btnPay.setBackground(new java.awt.Color(39, 80, 150));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("Thanh toán");

        jLabel26.setText("Tiền giảm");

        txtDiscoutCost.setBackground(new java.awt.Color(242, 242, 242));
        txtDiscoutCost.setText("0");
        txtDiscoutCost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        txtTotalCost.setBackground(new java.awt.Color(242, 242, 242));
        txtTotalCost.setText("0");
        txtTotalCost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel1.setText("Tiền TT");

        btnDeleteOrder.setBackground(new java.awt.Color(39, 80, 150));
        btnDeleteOrder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteOrder.setText("Huỷ hoá đơn");
        btnDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnDeleteOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPay))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMoneyTransfer, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMoneyCash, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboPaymentMethod, 0, 142, Short.MAX_VALUE)))
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
                                    .addComponent(txtOrderCost)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDiscoutCost, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotalCost, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel24});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDeleteOrder, btnPay});

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboPaymentMethod, cboVoucher, txtDiscoutCost, txtInvoiceId, txtMoneyCash, txtMoneyTransfer, txtOrderCost, txtStaffId, txtStartDateCreated, txtTotalCost});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDeleteOrder, btnPay});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22, jLabel24});

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
        btnAddInvoice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        btnScanQR.setBackground(new java.awt.Color(39, 80, 150));
        btnScanQR.setForeground(new java.awt.Color(255, 255, 255));
        btnScanQR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/prime/icon/z4947982062204_cc726bd2d83818a4619a57822d9df5f0.gif"))); // NOI18N
        btnScanQR.setBorder(null);
        btnScanQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanQRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchProdDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSlider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbnGia, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(btnScanQR)
                .addGap(15, 15, 15))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnGia, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSearchProdDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sliderPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))))
                    .addComponent(btnScanQR, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDeleteMuch.setBackground(new java.awt.Color(39, 80, 150));
        btnDeleteMuch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteMuch.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteMuch.setText("Huỷ hoá đơn");
        btnDeleteMuch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMuchActionPerformed(evt);
            }
        });

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
                        .addComponent(btnDeleteMuch)
                        .addGap(9, 9, 9))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddInvoice, btnDeleteMuch});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnDeleteMuch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
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

        try {
//            System.out.println(checkProductQuantity());
            if (checkProductQuantity() < 3) {
                if (os.addInvoice() > 0) {
                    fillToListInvoice(os.getOrder());
                    tblInvoice.setRowSelectionInterval(0, 0);
                    fillToListCart(os.getToCart((int) tblInvoice.getValueAt(tblInvoice.getSelectedRow(), 1)));
                    showDetail();
                    invoiceId = (int) tblInvoice.getValueAt(0, 1);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không được tạo quá 3 hóa đơn trống");
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
        String id = String.valueOf(tblInvoice.getValueAt(index, 1));
        invoiceId = Integer.parseInt(id);
//        System.out.println(invoiceId);
        try {
            showDetail();
            fillToListCart(os.getToCart(invoiceId));
        } catch (SQLException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_tblInvoiceMouseClicked

    private void tblSneakerDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSneakerDetailMouseClicked
        try {
            int id = tblInvoice.getSelectedRow();
            boolean vali = false;
            if (evt.getClickCount() == 2) {
                if (invoiceId == -1) {
                    JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn", "Thông báo", 1);
                    return;
                } else {
                    indexSneaker = tblSneakerDetail.getSelectedRow();
                    String sneakerCode = (String) tblSneakerDetail.getValueAt(indexSneaker, 1);

                    for (int i = 0; i < tblCart.getRowCount(); i++) {
                        if (tblCart.getValueAt(i, 2).equals(sneakerCode)) {
                            vali = true;
                            break;
                        }
                    }
                    if (!vali) {
                        os.addToCart(os.getSneakerDetail(sneakerCode), invoiceId, 1);
                        fillToListInvoice(os.getOrder());
                        tblInvoice.setRowSelectionInterval(id, id);
                        fillToListCart(os.getToCart(invoiceId));
                        os.updateQuantityAddSneaker(sneakerCode, 1);
                        fillToListSneakerDetail(os.getAllSneakerDetail());
                        showDetail();
                    } else {
                        JOptionPane.showMessageDialog(this, "Bạn đã thêm loại này", "Thông báo", 1);
                    }

                }

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblSneakerDetailMouseClicked

    private void btnDeleteCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCartActionPerformed

        try {
            cartIndex = tblCart.getSelectedRow();
            int id = tblInvoice.getSelectedRow();
            int sdId;
            int orderId;
            boolean active = false;
            int index = tblInvoice.getSelectedRow();
            if (cartIndex != -1) {

                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa khỏi giỏ hàng không?", "Thông báo", 2);

                if (confirm != 0) {
                    return;
                }
                for (int i = 0; i < tblCart.getRowCount(); i++) {
                    if (tblCart.getValueAt(i, 9) != null) {
                        sdId = os.getIdSneaker((String) tblCart.getValueAt(i, 2));
                        orderId = (int) tblCart.getValueAt(i, 1);
                        os.deleteOrderDetail(orderId, sdId);
                        os.updateQuantityDeleteSneaker((String) tblCart.getValueAt(i, 2), 1);
                        active = true;
                    }
                }
                if (!active) {

//                    System.out.println(tblCart.getValueAt(cartIndex, 2));
                    sdId = os.getIdSneaker((String) tblCart.getValueAt(cartIndex, 2));
                    orderId = (int) tblCart.getValueAt(cartIndex, 1);
                    if (os.deleteOrderDetail(orderId, sdId) != null || os.deleteOrderDetail(invoiceId, sdId) != 0) {
                        os.updateQuantityDeleteSneaker((String) tblCart.getValueAt(cartIndex, 2), 1);
                        fillToListSneakerDetail(os.getAllSneakerDetail());
                        fillToListInvoice(os.getOrder());
                        tblInvoice.setRowSelectionInterval(id, id);
                        fillToListCart(os.getToCart(invoiceId));
//                        if (os.updateQuantityDeleteSneaker((String) tblCart.getValueAt(cartIndex, 2), 1) != 0) {
//                            System.out.println("ok");
//                        }
//                        System.out.println(tblCart.getValueAt(tblCart.getSelectedRow(), 2));

                        showDetail();
                        JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", 1);
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa không thành công", "Thông báo", 1);
                    }
                } else {
                    fillToListSneakerDetail(os.getAllSneakerDetail());
                    fillToListInvoice(os.getOrder());
                    tblInvoice.setRowSelectionInterval(index, index);
                    fillToListCart(os.getToCart((int) tblInvoice.getValueAt(index, 1)));
                    invoiceId = (int) tblInvoice.getValueAt(index, 1);
                    showDetail();
                    JOptionPane.showMessageDialog(this, "Xóa thành công các hóa đơn chi tiết", "Thông báo", 1);
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
        indexOrder = tblInvoice.getSelectedRow();
        try {
            if (indexOrder != -1) {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy hóa đơn không ?", "Thông báo", 1);
                if (confirm != 0) {
                    return;
                }

                if (os.updateOrder((int) tblInvoice.getValueAt(indexOrder, 1)) != null || os.updateOrder((int) tblInvoice.getValueAt(indexOrder, 1)) != 0) {

                    for (int i = 0; i < tblCart.getRowCount(); i++) {
                        String code = (String) tblCart.getValueAt(i, 2);
                        os.updateQuantityDeleteSneaker(code, (int) tblCart.getValueAt(i, 4));
                    }
                    fillToListSneakerDetail(os.getAllSneakerDetail());
                    fillToListInvoice(os.getOrder());
                    tblInvoice.setRowSelectionInterval(0, 0);
                    JOptionPane.showMessageDialog(this, "Hủy hóa đơn thành công", "Thông báo", 1);
                    fillToListCart(os.getToCart((int) tblInvoice.getValueAt(0, 1)));
                    invoiceId = (int) tblInvoice.getValueAt(0, 1);
                    showDetail();
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

    private void cboPaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPaymentMethodActionPerformed
        if (cboPaymentMethod.getSelectedIndex() == 0) {

            txtMoneyCash.setText("");
            txtMoneyCash.setEditable(true);
            txtMoneyTransfer.setText("0");
            txtMoneyTransfer.setEditable(false);

        } else {
            txtMoneyCash.setEditable(false);
            txtMoneyCash.setText("0");
            txtMoneyTransfer.setText(txtTotalCost.getText());
        }
    }//GEN-LAST:event_cboPaymentMethodActionPerformed

    private void cboVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVoucherActionPerformed
        try {
            voucherProcess();
        } catch (SQLException ex) {
            Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboVoucherActionPerformed

    private void txtCartQuantityUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCartQuantityUpdateActionPerformed
        if (tblCart.getSelectedRow() != -1) {
            invoiceId = (int) tblCart.getValueAt(tblCart.getSelectedRow(), 1);
            indexSneaker = tblCart.getSelectedRow();
            String sneakerCode = (String) tblSneakerDetail.getValueAt(indexSneaker, 1);
            int sdId = 0;
            try {
                sdId = os.getIdSneaker(sneakerCode);
                System.out.println(os.updateOrderDetailQuantity(3, invoiceId, sdId));
            } catch (SQLException ex) {
                Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//            CartQuantityJDialog c = new CartQuantityJDialog(null, true);
//            c.setVisible(true);
//            c.addWindowListener(new WindowAdapter() {
//                @Override
//                public void windowClosed(WindowEvent e) {
//                    try {
//                        invoiceId = (int) tblCart.getValueAt(tblCart.getSelectedRow(), 1);
//                        indexSneaker = tblCart.getSelectedRow();
//                        String sneakerCode = (String) tblSneakerDetail.getValueAt(indexSneaker, 1);
//                        int sdId = os.getIdSneaker(sneakerCode);
//                        System.out.println(invoiceId);
//                        System.out.println(sdId);
//                        System.out.println(CartQuantity.getQuantity());
////                        if (os.updateOrderDetailQuantity(CartQuantity.getQuantity(), invoiceId, sdId) != null || os.updateOrderDetailQuantity(CartQuantity.getQuantity(), invoiceId, sdId) != 0) {
////                            fillToListInvoice(os.getOrder());
////                            fillToListCart(os.getToCart(invoiceId));
////                        }
////                        os.updateOrderDetailQuantity(CartQuantity.getQuantity(), invoiceId, sdId);
//                        System.out.println(os.updateOrderDetailQuantity(CartQuantity.getQuantity(), invoiceId, sdId));
//                        fillToListInvoice(os.getOrder());
//                        fillToListCart(os.getToCart(invoiceId));
//                    } catch (SQLException ex) {
//                        Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            });
//            JOptionPane.showMessageDialog(this, "Sửa số lượng thành công", "Thông báo", 1);

        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm trong giỏ", "Thông báo", 1);
        }
    }//GEN-LAST:event_txtCartQuantityUpdateActionPerformed

    private void btnDeleteMuchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMuchActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn hủy các hóa đơn này không?", "Thông báo", 1);
        boolean active = false;
        if (confirm != 0) {
            return;
        }
        try {
            for (int i = 0; i < tblInvoice.getRowCount(); i++) {
                if (tblInvoice.getValueAt(i, 6) != null) {
                    int orderId = Integer.parseInt(tblInvoice.getValueAt(i, 1) + "");
                    os.updateOrder(orderId);
                    for (int j = 0; j < tblCart.getRowCount(); j++) {
                        String code = (String) tblCart.getValueAt(j, 2);
                        os.updateQuantityDeleteSneaker(code, (int) tblCart.getValueAt(j, 4));
                    }
                    active = true;
                }

            }
            if (active) {
                JOptionPane.showMessageDialog(this, "Hủy thành công", "Thông báo", 1);
                fillToListSneakerDetail(os.getAllSneakerDetail());
                fillToListInvoice(os.getOrder());
                if (tblInvoice.getRowCount() > 0) {
                    tblInvoice.setRowSelectionInterval(0, 0);
                    fillToListCart(os.getToCart((int) tblInvoice.getValueAt(0, 1)));
                } else {
                    fillToListCart(new ArrayList<>());
                }
                invoiceId = (int) tblInvoice.getValueAt(0, 1);
                showDetail();
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn để xóa", "Thông báo", 1);
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnDeleteMuchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddInvoice;
    private javax.swing.JButton btnDeleteCart;
    private javax.swing.JButton btnDeleteMuch;
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
