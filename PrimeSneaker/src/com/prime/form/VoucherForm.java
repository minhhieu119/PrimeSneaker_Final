package com.prime.form;

import com.prime.main_model.VoucherAq;
import com.prime.services.VoucherService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.prime.form.attributeSneaker.AddVoucher;
import com.prime.form.attributeSneaker.UpdateVoucher;

public class VoucherForm extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    VoucherService vrs = new VoucherService();
    int index;

    public VoucherForm() {
        initComponents();
        setOpaque(false);
        model = (DefaultTableModel) tblVoucher.getModel();
        loadDataToTableVoucher(vrs.findAll());
//        vrs.AutoUpdateStatus();x1x

    }

    private void loadDataToTableVoucher(List<VoucherAq> list) {
        model.setRowCount(0);
        int stt = 1;
        for (VoucherAq voucherAq : list) {
            model.addRow(new Object[]{
                stt++,
                voucherAq.getVoucherCode(),
                voucherAq.getVoucherName(),
                voucherAq.isVoucherType() ? "Tiền mặt" : "%",
                voucherAq.getVoucherValue(),
                voucherAq.getMinOrderValue(),
                voucherAq.getMaxDiscount(),
                voucherAq.getStartDate(),
                voucherAq.getEndDate(),
                voucherAq.getQuantity(),
                voucherAq.getTrangThaiByDate()
            });
//            System.out.println(voucherAq);
        }

    }

    private void showDetai() {
        index = tblVoucher.getSelectedRow();
        txtVoucherId.setText(tblVoucher.getValueAt(index, 1).toString());
        txtVoucherName.setText(tblVoucher.getValueAt(index, 2).toString());
        rdoPercent.setSelected(tblVoucher.getValueAt(index, 3).toString().equalsIgnoreCase("%") ? true : false);
        rdoMoney.setSelected(tblVoucher.getValueAt(index, 3).toString().equalsIgnoreCase("Tiền mặt") ? true : false);
        txtGiaTriGiam.setText(tblVoucher.getValueAt(index, 4).toString());
        txtMinOder.setText(tblVoucher.getValueAt(index, 5).toString());
        txtMaxMoney.setText(tblVoucher.getValueAt(index, 6).toString());
        Object valueDateStart = tblVoucher.getValueAt(index, 7);
        Object valueDateEnd = tblVoucher.getValueAt(index, 8);
        Date dateStart = null;
        Date dateEnd = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateStart = dateFormat.parse(valueDateStart.toString());
            dateEnd = dateFormat.parse(valueDateEnd.toString());
        } catch (Exception e) {
        }
        txtStartDate.setDate(dateStart);
        txtEndDate.setDate(dateEnd);
        spfQuantity.setValue(Integer.parseInt(tblVoucher.getValueAt(index, 9).toString()));
    }

    private VoucherAq getForm() {
        VoucherAq voucher = new VoucherAq();
        voucher.setVoucherCode(txtVoucherId.getText());
        voucher.setVoucherName(txtVoucherName.getText());
        voucher.setVoucherType(rdoMoney.isSelected() ? true : false);
        voucher.setVoucherValue(Integer.parseInt(txtGiaTriGiam.getText()));
        voucher.setQuantity(spfQuantity.getValue());
        voucher.setMaxDiscount(Float.parseFloat(txtMaxMoney.getText()));
        voucher.setMinOrderValue(Long.parseLong(txtMinOder.getText()));
        voucher.setStartDate(txtStartDate.getDate());
        voucher.setEndDate(txtEndDate.getDate());
//        System.out.println(voucher.toString());
        return voucher;

    }

    private boolean checkTrungMaVoucher(String maVC) {
        for (int i = 0; i < tblVoucher.getRowCount(); i++) {
            if (tblVoucher.getValueAt(i, 1).toString().equalsIgnoreCase(maVC)) {
                return true;
            }
        }
        return false;
    }

    private void mess(String mess) {
        JOptionPane.showMessageDialog(this, mess);
    }

    private boolean checkForm() {

        String maVoucher = txtVoucherId.getText();
        maVoucher = maVoucher.replaceAll("\\s+", "").trim();
        String regexVoucher = "^[a-zA-Z0-9]{1,20}$";
        String tenVoucher = txtVoucherName.getText();
        int giaTriGiamInt;
        String loaiVC = rdoPercent.isSelected() ? "%" : "Tiền";

        String giaTriGiam = txtGiaTriGiam.getText();
        int soLuong = spfQuantity.getValue();
        String donToiThieu = txtMinOder.getText();
        long donToiThieuLong;
        String giamToiDa = txtMaxMoney.getText();
        float giamToiDaFloat;
        Date ngayBatDau = txtStartDate.getDate();
        Date ngayKetThuc = txtEndDate.getDate();
        // maVoucher
        if (maVoucher.trim().isEmpty()) {
            mess("Mã voucher không được để trống");
            txtVoucherId.requestFocus();
            return true;
        }
        if (!maVoucher.matches(regexVoucher)) {
            mess("Mã voucher không được quá 20 ký tự và khống chứa các ký tự đặc biệt");
            txtVoucherId.requestFocus();
            return true;
        }

        // TenVoucher
        if (tenVoucher.trim().isEmpty()) {
            mess("Tên voucher không được để trống");
            txtVoucherName.requestFocus();
            return true;
        }
        if (tenVoucher.length() > 100) {
            mess("Tên voucher không được quá 100 ký tự");
            txtVoucherName.requestFocus();
            return true;
        }

        // Đơn tối thiếu
        if (donToiThieu.isEmpty()) {
            mess("Điều kiện hoá đơn không được để trống");
            txtMinOder.requestFocus();
            return true;
        }
        try {
            donToiThieuLong = Long.parseLong(donToiThieu);
            if (donToiThieuLong < 500000) {
                mess("Điều kiện hoá đơn phải lớn hơn 500000!");
                txtGiaTriGiam.requestFocus();
                return true;
            }
        } catch (Exception e) {
            mess("Điều kiện hoá đơn phải là số!");
            txtGiaTriGiam.requestFocus();
            return true;
        }

        // Giảm tối đa
        // Giá trị giảm tương ứng
        if (giaTriGiam.isEmpty()) {
            mess("Giá trị giảm không được để trống");
            txtGiaTriGiam.requestFocus();
            return true;
        }
        try {
            giaTriGiamInt = Integer.parseInt(giaTriGiam);
            if (giaTriGiamInt <= 0) {
                mess("Giá trị voucher phải lớn hơn 0!");
                txtGiaTriGiam.requestFocus();
                return true;
            }
        } catch (Exception e) {
            mess("Giá trị giảm phải là số!");
            txtGiaTriGiam.requestFocus();
            return true;
        }
        if (loaiVC.equals("%")) {
            if (giaTriGiamInt < 1 || giaTriGiamInt > 60) {
                txtGiaTriGiam.setText("1");
                mess("Giá trị % giảm phải từ 1-60%");
                txtGiaTriGiam.requestFocus();
                return true;
            }
        }
        if (loaiVC.equals("Tiền")) {
            if (giaTriGiamInt < 10000 || giaTriGiamInt > 5000000) {
                mess("Giá trị tiền giảm phải từ 10000-5000000 ");
                txtGiaTriGiam.requestFocus();
                return true;
            }
        }

        if (giamToiDa.isEmpty()) {
            mess("Điều kiện giá trị giảm tối đa của hoá đơn không được để trống");
            txtMaxMoney.requestFocus();
            return true;
        }

        try {
            giamToiDaFloat = Float.parseFloat(giamToiDa);
            if (giamToiDaFloat <= 0) {
                mess("Điều kiện giá trị giảm tối đa của hoá đơn phải lớn hơn 0!");
                txtGiaTriGiam.requestFocus();
                return true;
            } else {
                if (loaiVC.equals("%")) {
                    if (giamToiDaFloat < 1 || giamToiDaFloat > 60) {
                        txtMaxMoney.setText("1");
                        mess("Giá trị % giảm phải từ 1-60%");
                        txtMaxMoney.requestFocus();
                        return true;
                    }
                }
                if (loaiVC.equals("Tiền")) {
                    if (giamToiDaFloat < 10000 || giamToiDaFloat > 5000000) {
                        mess("Giá trị tiền giảm phải từ 10000-5000000 ");
                        txtMaxMoney.requestFocus();
                        return true;
                    }
                }
            }

        } catch (Exception e) {
            mess("Điều kiện giá trị giảm tối đa của hoá đơn phải là số!");
            txtGiaTriGiam.requestFocus();
            return true;

        }

        if (loaiVC.equals("Tiền")) {
            if (giamToiDaFloat != Float.parseFloat(txtGiaTriGiam.getText())) {
                mess("Giá trị tiền giảm tối đa phải bằng:  " + giaTriGiamInt);
                return true;
            }
        }

        try {
            if (soLuong <= 0) {
                mess("Số lượng phải lớn hơn 0");
                spfQuantity.requestFocus();
                return true;
            }
        } catch (Exception e) {
            mess("Vui lòng nhập số lượng là số nguyên dương");
            spfQuantity.requestFocus();
            return true;
        }

        // Ngày bắt đầu, ngày kết thúc
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date dateStart = null;
        Date dateEnd = null;

        if (ngayBatDau == null) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được để trống ");
            txtStartDate.requestFocus();
            return true;
        }
        if (ngayKetThuc == null) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được để trống ");
            txtEndDate.requestFocus();
            return true;
        }
        try {
            String dateStartStr = formatDate.format(ngayBatDau);
            dateStart = formatDate.parse(dateStartStr);
            String dateEndStr = formatDate.format(ngayKetThuc);
            dateEnd = formatDate.parse(dateEndStr);
            Date today = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(today);
            calendar.add(Calendar.DATE, -1);
            Date tomorrow = calendar.getTime();
//            System.out.println(tomorrow.toString());
            if (dateStart.before(tomorrow)) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được trước ngày hôm nay !");
                txtStartDate.requestFocus();
                return true;
            } else if (dateEnd.before(dateStart)) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc phải cùng hoặc sau ngày bắt đầu");
                txtEndDate.requestFocus();
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu hoặc ngày kết thúc sai định dạng !");
            return true;
        }

        return false;

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVoucher = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        txtSearchStartDate = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtSearchEndDate = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        cboSearchStatus = new javax.swing.JComboBox<>();
        txtSearchVoucher = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnUpdateVoucher = new javax.swing.JButton();
        btnAddVoucher = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        spfQuantity = new com.toedter.components.JSpinField();
        txtMinOder = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtVoucherId = new javax.swing.JTextField();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        txtVoucherName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtGiaTriGiam = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtMaxMoney = new javax.swing.JTextField();
        rdoPercent = new javax.swing.JRadioButton();
        rdoMoney = new javax.swing.JRadioButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách Voucher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tblVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã voucher", "Tên voucher", "Loại Voucher", "Giá trị giảm", "Đơn tối thiểu", "Giảm tối đa", "Ngày bắt đầu", "Ngày kết thúc", "Số lượng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVoucher.setRowHeight(35);
        tblVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoucherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVoucher);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày"));

        txtSearchStartDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel21.setText("Từ");

        jLabel22.setText("Đến ");

        txtSearchEndDate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(39, 80, 150), 1, true));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtSearchEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearchEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(txtSearchStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel20.setText("Trạng thái");

        cboSearchStatus.setBackground(new java.awt.Color(39, 80, 150));
        cboSearchStatus.setForeground(new java.awt.Color(255, 255, 255));
        cboSearchStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Sắp áp dụng", "Đang áp dụng", "Hết hạn" }));

        txtSearchVoucher.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtSearchVoucher.setForeground(new java.awt.Color(204, 204, 204));
        txtSearchVoucher.setText("Tên Voucher - Mã Voucher");
        txtSearchVoucher.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 80, 150)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(cboSearchStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 333, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cboSearchStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel14.setText("Ngày kết thúc");

        jLabel17.setText("Mã voucher");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        btnUpdateVoucher.setBackground(new java.awt.Color(39, 80, 150));
        btnUpdateVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateVoucher.setText("Cập nhật");
        btnUpdateVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateVoucherMouseClicked(evt);
            }
        });

        btnAddVoucher.setBackground(new java.awt.Color(39, 80, 150));
        btnAddVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnAddVoucher.setText("Thêm");
        btnAddVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVoucherActionPerformed(evt);
            }
        });

        btnClearForm.setBackground(new java.awt.Color(39, 80, 150));
        btnClearForm.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClearForm.setForeground(new java.awt.Color(255, 255, 255));
        btnClearForm.setText("Clear");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClearForm)
                    .addComponent(btnUpdateVoucher)
                    .addComponent(btnAddVoucher))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddVoucher, btnClearForm, btnUpdateVoucher});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnAddVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnUpdateVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddVoucher, btnClearForm, btnUpdateVoucher});

        jLabel9.setText("Ngày bắt đầu");

        txtStartDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel18.setText("Đơn tối thiểu");

        jLabel15.setText("Tên voucher");

        spfQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        txtMinOder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel10.setText("Loại voucher");

        txtVoucherId.setEditable(false);
        txtVoucherId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        txtEndDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        txtVoucherName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel12.setText("Số lượng");

        jLabel16.setText("Giá trị giảm");

        txtGiaTriGiam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel19.setText("Giảm tối đa");

        txtMaxMoney.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        buttonGroup2.add(rdoPercent);
        rdoPercent.setSelected(true);
        rdoPercent.setText("%");

        buttonGroup2.add(rdoMoney);
        rdoMoney.setText("Tiền");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(29, 29, 29)
                                .addComponent(txtVoucherId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel15))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVoucherName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdoPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(rdoMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaTriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMaxMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMinOder, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(104, 104, 104)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel12, jLabel14, jLabel15, jLabel17, jLabel18, jLabel19, jLabel9});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtVoucherId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtVoucherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(rdoPercent)
                                    .addComponent(rdoMoney))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtGiaTriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtMinOder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(txtMaxMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(spfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel12, jLabel14, jLabel15, jLabel17, jLabel18, jLabel19, jLabel9});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void clearForm() {
        txtVoucherId.setText("");
        txtVoucherName.setText("");
        rdoPercent.setSelected(true);
        txtGiaTriGiam.setText("");
        spfQuantity.setValue(0);
        txtMinOder.setText("");
        txtMaxMoney.setText("");
        txtStartDate.setDate(null);
        txtEndDate.setDate(null);
        tblVoucher.clearSelection();
    }

    private void tblVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMouseClicked
        showDetai();
    }//GEN-LAST:event_tblVoucherMouseClicked

    private void btnAddVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVoucherActionPerformed
        new AddVoucher().setVisible(true);
        loadDataToTableVoucher(vrs.findAll());
//        try {
//            if (checkForm()) {
//                return;
//            }
//            if (checkTrungMaVoucher(txtVoucherId.getText())) {
//
//                JOptionPane.showMessageDialog(this, "Mã voucher đã tồn tại!");
//                txtVoucherId.requestFocus();
//                return;
//            }
//            VoucherAq voucher = getForm();
////            System.out.println(voucher.toString());
//            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm voucher không?");
//            if (hoi != JOptionPane.YES_OPTION) {
//                return;
//            }
//
//            if (vrs.addVoucher(voucher) != null) {
//                clearForm();
//                loadDataToTableVoucher(vrs.findAll());
//                mess("Thêm voucher thành công");
//            } else {
//                mess("Thêm voucher thất bại!");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Lỗi thêm");
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnAddVoucherActionPerformed

    private void btnUpdateVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateVoucherMouseClicked
            
        try {
            
            index = tblVoucher.getSelectedRow();
            if (index < 0) {
                mess("Hãy chọn dòng trong bảng để cập nhật");
                return;
            }
            
            if (checkForm()) {
                return;
            }
            
//            if (checkTrungMaVoucher(txtVoucherId.getText())) {
//
//                JOptionPane.showMessageDialog(this, "Mã voucher đã tồn tại!");
//                txtVoucherId.requestFocus();
//                return;
//            }
            VoucherAq voucher = getForm();
//            System.out.println(voucher.toString());
            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật voucher: " + voucher.getVoucherCode() + " không?");
            if (hoi != JOptionPane.YES_OPTION) {
                return;
            }

            if (vrs.updateVoucher(voucher) != null) {
                clearForm();
                loadDataToTableVoucher(vrs.findAll());
                mess("Cập nhật voucher thành công");
            } else {
                mess("Cập nhật voucher thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi cập nhật!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateVoucherMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVoucher;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnUpdateVoucher;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboSearchStatus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoMoney;
    private javax.swing.JRadioButton rdoPercent;
    private com.toedter.components.JSpinField spfQuantity;
    private javax.swing.JTable tblVoucher;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JTextField txtGiaTriGiam;
    private javax.swing.JTextField txtMaxMoney;
    private javax.swing.JTextField txtMinOder;
    private com.toedter.calendar.JDateChooser txtSearchEndDate;
    private com.toedter.calendar.JDateChooser txtSearchStartDate;
    private javax.swing.JTextField txtSearchVoucher;
    private com.toedter.calendar.JDateChooser txtStartDate;
    private javax.swing.JTextField txtVoucherId;
    private javax.swing.JTextField txtVoucherName;
    // End of variables declaration//GEN-END:variables
}
