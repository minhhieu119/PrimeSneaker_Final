/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.prime.form.attributeSneaker;

import com.prime.main_model.VoucherAq;
import com.prime.services.VoucherService;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class AddVoucher extends javax.swing.JFrame {

    VoucherService ser = new VoucherService();

    /**
     * Creates new form AddVoucher
     */
    public AddVoucher() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void mess(String mess) {
        JOptionPane.showMessageDialog(this, mess);
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
        float giamToiThieuFloat;
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
                txtMaxMoney.requestFocus();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel17 = new javax.swing.JLabel();
        txtVoucherId = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtVoucherName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rdoPercent = new javax.swing.JRadioButton();
        rdoMoney = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtGiaTriGiam = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        spfQuantity = new com.toedter.components.JSpinField();
        jLabel18 = new javax.swing.JLabel();
        txtMinOder = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtMaxMoney = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel17.setText("Mã voucher");

        txtVoucherId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel15.setText("Tên voucher");

        txtVoucherName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel10.setText("Loại voucher");

        buttonGroup1.add(rdoPercent);
        rdoPercent.setSelected(true);
        rdoPercent.setText("%");

        buttonGroup1.add(rdoMoney);
        rdoMoney.setText("Tiền");

        jLabel16.setText("Giá trị giảm");

        txtGiaTriGiam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel12.setText("Số lượng");

        spfQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel18.setText("Đơn tối thiểu");

        txtMinOder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel19.setText("Giảm tối đa");

        txtMaxMoney.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel9.setText("Ngày bắt đầu");

        txtStartDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel14.setText("Ngày kết thúc");

        txtEndDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THÊM VOUCHER");

        jButton1.setText("Lưu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Huỷ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(29, 29, 29)
                                .addComponent(txtVoucherId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtGiaTriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(29, 29, 29)
                                            .addComponent(rdoPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(35, 35, 35)
                                            .addComponent(rdoMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addComponent(txtVoucherName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(1, 1, 1)
                                .addComponent(spfQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(8, 8, 8)
                                .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(8, 8, 8))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(8, 8, 8)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMinOder, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaxMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2))
                                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVoucherId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtVoucherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(rdoPercent)
                            .addComponent(rdoMoney))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtGiaTriGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtMinOder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtMaxMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(spfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (checkForm()) {
                return;
            }
            String maVoucher = txtVoucherId.getText().trim().replaceAll("\\s+", "");
            boolean maVoucherTonTai = false;
            for (VoucherAq voucherAq : ser.findAll()) {
                if (voucherAq.getVoucherCode().trim().equalsIgnoreCase(maVoucher)) {
                    maVoucherTonTai = true;
                    break;
                }
            }
            String tenVoucher = txtVoucherName.getText().trim().replaceAll("\\s+", "");
            boolean check = false;
            for (VoucherAq voucherAq : ser.findAll()) {
                if (voucherAq.getVoucherName().trim().equalsIgnoreCase(tenVoucher)) {
                    check = true;
                    break;
                }
            }
            if (check) {
                mess("Tên voucher đã tồn tại");
                txtVoucherName.requestFocus();
                return;
            }
            if (maVoucherTonTai) {
                mess("Mã voucher này đã tồn tại");
                txtVoucherId.requestFocus();
            } else {
                VoucherAq voucher = getForm();
//            System.out.println(voucher.toString());
                int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm voucher không?");
                if (hoi != JOptionPane.YES_OPTION) {
                    return;
                }

                if (ser.addVoucher(voucher) != null) {

                    mess("Thêm voucher thành công");
                    this.dispose();
                } else {
                    mess("Thêm voucher thất bại!");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi thêm");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddVoucher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rdoMoney;
    private javax.swing.JRadioButton rdoPercent;
    private com.toedter.components.JSpinField spfQuantity;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private javax.swing.JTextField txtGiaTriGiam;
    private javax.swing.JTextField txtMaxMoney;
    private javax.swing.JTextField txtMinOder;
    private com.toedter.calendar.JDateChooser txtStartDate;
    private javax.swing.JTextField txtVoucherId;
    private javax.swing.JTextField txtVoucherName;
    // End of variables declaration//GEN-END:variables
}
