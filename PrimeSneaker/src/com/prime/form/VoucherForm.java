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
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import jdk.jfr.consumer.EventStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VoucherForm extends javax.swing.JPanel {

    DefaultTableModel model = new DefaultTableModel();
    VoucherService vrs = new VoucherService();
    int index;

    public VoucherForm() {
        initComponents();
        setOpaque(false);
        jdcStartDate.setDateFormatString("dd/MM/yyyy");
        jdcEndDate.setDateFormatString("dd/MM/yyyy");
        txtSearchStartDate.setDateFormatString("dd/MM/yyyy");
        txtSearchEndDate.setDateFormatString("dd/MM/yyyy");
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

    private void loadDataToTableVoucher2(List<VoucherAq> list) {
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
        jdcStartDate.setDate(dateStart);
        jdcEndDate.setDate(dateEnd);
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
        voucher.setStartDate(jdcStartDate.getDate());
        voucher.setEndDate(jdcEndDate.getDate());
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
        float giamToiThieuFloat;
        String giaTriGiam = txtGiaTriGiam.getText();
        int soLuong = spfQuantity.getValue();
        String donToiThieu = txtMinOder.getText();
        long donToiThieuLong;
        String giamToiDa = txtMaxMoney.getText();
        float giamToiDaFloat;
        Date ngayBatDau = jdcStartDate.getDate();
        Date ngayKetThuc = jdcEndDate.getDate();
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
                    giamToiThieuFloat = (Float.parseFloat(txtGiaTriGiam.getText()) / 100) * Float.parseFloat(txtMinOder.getText());
                    if (giamToiDaFloat < giamToiThieuFloat || giamToiDaFloat > Float.parseFloat(txtMinOder.getText())) {
                        txtMaxMoney.setText("1");
                        mess("Giá trị % giảm phải lớn hơn " + giamToiThieuFloat + " và nhỏ hơn " + Float.parseFloat(txtMinOder.getText()));
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
            jdcStartDate.requestFocus();
            return true;
        }
        if (ngayKetThuc == null) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được để trống ");
            jdcEndDate.requestFocus();
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
//            if (dateStart.before(tomorrow)) {
//                JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được trước ngày hôm nay !");
//                jdcStartDate.requestFocus();
//                return true;
//            } else 
            if (dateEnd.before(dateStart)) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc phải cùng hoặc sau ngày bắt đầu");
                jdcEndDate.requestFocus();
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu hoặc ngày kết thúc sai định dạng !");
            return true;
        }

        return false;

    }

    private void search() throws SQLException {
        String status;
        String startDate;
        String endDate;
        String key = txtSearchVoucher.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        String end = "2100-12-30";
        Date ngayBatDau = txtSearchStartDate.getDate();
        Date ngayKetThuc = txtSearchEndDate.getDate();
        if (ngayBatDau == null || ngayKetThuc == null) {
            try {
                ngayBatDau = sdf.parse(str);
                ngayKetThuc = sdf.parse(end);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        startDate = sdf.format(ngayBatDau);
        endDate = sdf.format(ngayKetThuc);

        if (key.isEmpty()) {
            key = null;
        }

//        System.out.println(key);
//        System.out.println(status);
//        System.out.println(startDate);
//        System.out.println(endDate);
        model.setRowCount(0);
        loadDataToTableVoucher2(vrs.timKiem(key, startDate, endDate));
        
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
        jLabel23 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnUpdateVoucher = new javax.swing.JButton();
        btnAddVoucher = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtVoucherId = new javax.swing.JTextField();
        txtMinOder = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtVoucherName = new javax.swing.JTextField();
        txtMaxMoney = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdoPercent = new javax.swing.JRadioButton();
        rdoMoney = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtGiaTriGiam = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        spfQuantity = new com.toedter.components.JSpinField();
        jdcStartDate = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jdcEndDate = new com.toedter.calendar.JDateChooser();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý voucher"));

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
        txtSearchStartDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtSearchStartDatePropertyChange(evt);
            }
        });

        jLabel21.setText("Từ");

        jLabel22.setText("Đến ");

        txtSearchEndDate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(39, 80, 150), 1, true));
        txtSearchEndDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtSearchEndDatePropertyChange(evt);
            }
        });

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
        cboSearchStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSearchStatusActionPerformed(evt);
            }
        });

        txtSearchVoucher.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        txtSearchVoucher.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 80, 150)));
        txtSearchVoucher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchVoucherKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchVoucherKeyReleased(evt);
            }
        });

        jLabel23.setText("Tìm kiếm");

        btnReset.setBackground(new java.awt.Color(39, 80, 150));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/prime/icon2/reload.png"))); // NOI18N
        btnReset.setBorder(null);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearchStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(134, 134, 134)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtSearchVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cboSearchStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(185, 213, 246));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
        btnClearForm.setText("Làm mới");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        btnExcel.setBackground(new java.awt.Color(39, 80, 150));
        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setText("Xuất Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdateVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(btnClearForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnAddVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClearForm, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddVoucher, btnClearForm, btnUpdateVoucher});

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel17.setText("Mã voucher");

        txtVoucherId.setEditable(false);
        txtVoucherId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        txtMinOder.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        jLabel18.setText("Đơn tối thiểu");

        jLabel15.setText("Tên voucher");

        txtVoucherName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        txtMaxMoney.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));
        txtMaxMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxMoneyActionPerformed(evt);
            }
        });

        jLabel19.setText("Giảm tối đa");

        jLabel10.setText("Loại voucher");

        buttonGroup2.add(rdoPercent);
        rdoPercent.setSelected(true);
        rdoPercent.setText("%");

        buttonGroup2.add(rdoMoney);
        rdoMoney.setText("Tiền");

        jLabel16.setText("Giá trị giảm");

        txtGiaTriGiam.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        jLabel12.setText("Số lượng");

        spfQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        spfQuantity.setMinimum(0);

        jdcStartDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel14.setText("Ngày kết thúc");

        jLabel9.setText("Ngày bắt đầu");

        jdcEndDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(spfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtGiaTriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtVoucherId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(rdoMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtVoucherName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMaxMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMinOder, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(179, 179, 179))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel12, jLabel14, jLabel15, jLabel17, jLabel18, jLabel19, jLabel9});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtGiaTriGiam, txtMaxMoney, txtMinOder, txtVoucherId, txtVoucherName});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMinOder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaxMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtVoucherId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtVoucherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdoPercent)
                    .addComponent(rdoMoney))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaTriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spfQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12))
                .addGap(24, 24, 24))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel12, jLabel14, jLabel15, jLabel17, jLabel18, jLabel19, jLabel9});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {spfQuantity, txtGiaTriGiam, txtMaxMoney, txtMinOder, txtVoucherId, txtVoucherName});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jdcEndDate, jdcStartDate});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jdcStartDate.setDate(null);
        jdcEndDate.setDate(null);
        tblVoucher.clearSelection();
    }

    private void tblVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoucherMouseClicked
        showDetai();
    }//GEN-LAST:event_tblVoucherMouseClicked

    private void btnAddVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVoucherActionPerformed
        AddVoucher addVou = new AddVoucher();
        addVou.setVisible(true);
        addVou.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadDataToTableVoucher(vrs.findAll());
            }

        });

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
//        System.out.println(getForm());
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

            int quantity = spfQuantity.getValue();
            if (quantity < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                return;
            }

            if (vrs.updateVoucher(voucher) > 0) {
                clearForm();
                loadDataToTableVoucher2(vrs.findAll());
                mess("Cập nhật voucher thành công");
            } else {
                mess("Cập nhật voucher thất bại!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi cập nhật!");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateVoucherMouseClicked

    private void txtMaxMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxMoneyActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Account");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblVoucher.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblVoucher.getColumnName(i));
                }
                for (int j = 0; j < tblVoucher.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblVoucher.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblVoucher.getValueAt(j, k) != null) {
                            cell.setCellValue(tblVoucher.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                EventStream.openFile(saveFile.toPath());
                JOptionPane.showMessageDialog(this, "Xuất file thành công!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void txtSearchVoucherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchVoucherKeyPressed
        try {
            search();
        } catch (SQLException ex) {
            Logger.getLogger(VoucherForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchVoucherKeyPressed

    private void txtSearchVoucherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchVoucherKeyReleased
        try {
            search();
//            cboSearchStatus.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(VoucherForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchVoucherKeyReleased

    private void cboSearchStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSearchStatusActionPerformed
        txtSearchVoucher.setText("");
        txtSearchStartDate.setDate(null);
        txtSearchEndDate.setDate(null);
        String sql = "";
        try {
            if (cboSearchStatus.getSelectedIndex() == 0) {
                sql = """
                  SELECT voucher_code, voucher_name, voucher_type, voucher_value, min_order_value, max_discount, [start_date], end_date, quantity
                  FROM dbo.Voucher
                  """;
                model.setRowCount(0);
                loadDataToTableVoucher2(vrs.timKiemStatus(sql));
            } else if (cboSearchStatus.getSelectedIndex() == 1) {
                sql = """
                  SELECT voucher_code, voucher_name, voucher_type, voucher_value, min_order_value, max_discount, [start_date], end_date, quantity
                  FROM dbo.Voucher
                  WHERE start_date > GETDATE() and quantity > 0
                  """;
                model.setRowCount(0);
                loadDataToTableVoucher2(vrs.timKiemStatus(sql));
            } else if (cboSearchStatus.getSelectedIndex() == 2) {
                sql = """
                  SELECT voucher_code, voucher_name, voucher_type, voucher_value, min_order_value, max_discount, [start_date], end_date, quantity
                  FROM dbo.Voucher
                  WHERE GETDATE() BETWEEN start_date AND end_date and quantity > 0
                  """;
                model.setRowCount(0);
                loadDataToTableVoucher2(vrs.timKiemStatus(sql));
            } else {
                sql = """
                  SELECT voucher_code, voucher_name, voucher_type, voucher_value, min_order_value, max_discount, [start_date], end_date, quantity
                  FROM dbo.Voucher
                  WHERE end_date < GETDATE() or quantity = 0
                  """;
                model.setRowCount(0);
                loadDataToTableVoucher2(vrs.timKiemStatus(sql));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cboSearchStatusActionPerformed

    private void txtSearchStartDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtSearchStartDatePropertyChange
        try {
            search();
        } catch (SQLException ex) {
            Logger.getLogger(VoucherForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchStartDatePropertyChange

    private void txtSearchEndDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtSearchEndDatePropertyChange
        try {
            search();
        } catch (SQLException ex) {
            Logger.getLogger(VoucherForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchEndDatePropertyChange

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtSearchVoucher.setText("");
        txtSearchStartDate.setDate(null);
        txtSearchEndDate.setDate(null);
        cboSearchStatus.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddVoucher;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnReset;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcEndDate;
    private com.toedter.calendar.JDateChooser jdcStartDate;
    private javax.swing.JRadioButton rdoMoney;
    private javax.swing.JRadioButton rdoPercent;
    private com.toedter.components.JSpinField spfQuantity;
    private javax.swing.JTable tblVoucher;
    private javax.swing.JTextField txtGiaTriGiam;
    private javax.swing.JTextField txtMaxMoney;
    private javax.swing.JTextField txtMinOder;
    private com.toedter.calendar.JDateChooser txtSearchEndDate;
    private com.toedter.calendar.JDateChooser txtSearchStartDate;
    private javax.swing.JTextField txtSearchVoucher;
    private javax.swing.JTextField txtVoucherId;
    private javax.swing.JTextField txtVoucherName;
    // End of variables declaration//GEN-END:variables
}
