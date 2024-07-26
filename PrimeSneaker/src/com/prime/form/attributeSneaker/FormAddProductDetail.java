package com.prime.form.attributeSneaker;

import com.prime.main_model.Model_Color;
import com.prime.main_model.Model_SneakerDetail;
import com.prime.main_model.Model_addNameProduct;
import com.prime.main_model.SizeModel;
import com.prime.responsitory.ColorResponsitory;
import com.prime.responsitory.SizeResponsitory;
import com.prime.responsitory.SneakerDetailResponsitory;
import com.prime.responsitory.TeSPResponsitory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.glxn.qrgen.image.ImageType;

public class FormAddProductDetail extends javax.swing.JFrame {

    DefaultComboBoxModel dcboSize = new DefaultComboBoxModel();
    DefaultComboBoxModel dcboColor, dcboName = new DefaultComboBoxModel();
    private final ColorResponsitory colorRS = new ColorResponsitory();
    private final SizeResponsitory sizeRS = new SizeResponsitory();
    private final TeSPResponsitory nameProduct = new TeSPResponsitory();
    private SneakerDetailResponsitory snDetailRS = new SneakerDetailResponsitory();

    public FormAddProductDetail() {
        initComponents();
        setLocationRelativeTo(null);
        dcboColor = (DefaultComboBoxModel) cboColor.getModel();
        dcboSize = (DefaultComboBoxModel) cboSize.getModel();
        dcboName = (DefaultComboBoxModel) cboNameProduct.getModel();
        loadDataColor();
        loadDataSize();
        loadDataName();
    }

    private void loadDataSize() {
        dcboSize.removeAllElements();
        for (SizeModel size : sizeRS.getAll()) {
            dcboSize.addElement(size);
        }
    }

    private void loadDataColor() {
        dcboColor.removeAllElements();
        for (Model_Color color : colorRS.getALl()) {
            dcboColor.addElement(color);
        }
    }

    private void loadDataName() {
        dcboName.removeAllElements();
        for (Model_addNameProduct name : nameProduct.getAll()) {
            dcboName.addElement(name);
        }
    }

    private boolean validateForm() {
        if (txtPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá SP");
            txtPrice.requestFocus();
            return false;
        }
        if (txtQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá SP");
            txtQuantity.requestFocus();
            return false;
        }
        try {
            Double price = Double.valueOf(txtPrice.getText());
            Integer quantity = Integer.valueOf(txtQuantity.getText());
            if (price < 0 || quantity < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng và giá phải lớn hơn 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng và giá phải là số");
            return false;
        }
        String trangThai = null;
        if (rdoSell.isSelected()) {
            trangThai = "Đang bán";
        }
        if (rdoHethang.isSelected()) {
            trangThai = "Đã ngừng bán";
        }
        for (Model_SneakerDetail sn : snDetailRS.getALl()) {
            if (sn.getTenSP().getProduct_name().equals(cboNameProduct.getSelectedItem().toString())
                    && (sn.getKichCo().getSize_Number() == Double.valueOf(cboSize.getSelectedItem().toString()))
                    && sn.getMauSac().getColor_name().equals(cboColor.getSelectedItem().toString())
                    && (sn.getSoLuong() == Integer.valueOf(txtQuantity.getText()))
                    && (sn.getGiaSP() == Double.valueOf(txtPrice.getText()))
                    && sn.getCode_sneaker().equals(txtCodeSneaker.getText())
                    && sn.getTrangThai().equals(trangThai)) {
                JOptionPane.showMessageDialog(this, "Sản phẩm này đã tồn tại");
                return false;
            }
        }
        return true;
    }

    private Model_SneakerDetail getDataFrom() {
        Model_SneakerDetail sn = new Model_SneakerDetail();
        Model_addNameProduct name = nameProduct.getName(cboNameProduct.getSelectedItem().toString());
        System.out.println(name);
        Model_Color color = colorRS.getColor(cboColor.getSelectedItem().toString());
        SizeModel size = sizeRS.getSize(cboSize.getSelectedItem().toString());
        sn.setGiaSP(Double.valueOf(txtPrice.getText()));
        sn.setSoLuong(Integer.valueOf(txtQuantity.getText()));
        sn.setCode_sneaker(txtCodeSneaker.getText());
        sn.setTenSP(name);
        sn.setKichCo(size);
        sn.setMauSac(color);
        if (rdoSell.isSelected()) {
            sn.setTrangThai("Đang bán");
        }
        if (rdoHethang.isSelected()) {
            sn.setTrangThai("Đã ngừng bán");
        }
        return sn;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel28 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtIDProDuctDetail = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        cboColor = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        cboNameProduct = new javax.swing.JComboBox<>();
        rdoSell = new javax.swing.JRadioButton();
        rdoHethang = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        cboSize = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        txtCodeSneaker = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form add ProductDetail");

        jLabel28.setText("Mã SPCT");

        jLabel37.setText("Tên sản phẩm");

        jLabel38.setText("Giá");

        jLabel39.setText("Số lượng");

        jLabel40.setText("Trạng thái");

        jLabel51.setText("Kích cỡ");

        cboColor.setBackground(new java.awt.Color(39, 80, 150));
        cboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cboColor.setBorder(null);

        jLabel32.setText("Màu sắc");

        cboNameProduct.setBackground(new java.awt.Color(39, 80, 150));
        cboNameProduct.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cboNameProduct.setBorder(null);

        buttonGroup1.add(rdoSell);
        rdoSell.setSelected(true);
        rdoSell.setText("Còn hàng");

        buttonGroup1.add(rdoHethang);
        rdoHethang.setText("Hết hàng");

        jLabel1.setText("Thêm sản phẩm chi tiết");

        btnSave.setBackground(new java.awt.Color(39, 80, 150));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cboSize.setBackground(new java.awt.Color(39, 80, 150));
        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cboSize.setBorder(null);

        jLabel41.setText("Code ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(3, 3, 3)))
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDProDuctDetail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodeSneaker))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(rdoSell, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoHethang))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboColor, cboNameProduct, cboSize});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDProDuctDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel37)
                    .addComponent(cboNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel51)
                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodeSneaker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40)
                    .addComponent(rdoSell)
                    .addComponent(rdoHethang))
                .addGap(62, 62, 62)
                .addComponent(btnSave)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboColor, cboNameProduct, cboSize});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (validateForm()) {
            int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm sản phẩm này không");
            if (chon != JOptionPane.YES_OPTION) {
                return;
            }
            Model_SneakerDetail sn = getDataFrom();
            System.out.println(sn);
            try {
            ByteArrayOutputStream out = net.glxn.qrgen.QRCode.from(sn.getCode_sneaker()).to(ImageType.PNG).stream();      
            String path = "D:\\QRcode\\";
            
            FileOutputStream fout = new FileOutputStream(new File(path + (sn.getCode_sneaker() + ".png")));
            fout.write(out.toByteArray());
            fout.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
            if (snDetailRS.addSneakerDetail(sn) != null) {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
            }
        }
        System.exit(0);
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(FormAddProductDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAddProductDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAddProductDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAddProductDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAddProductDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboColor;
    private javax.swing.JComboBox<String> cboNameProduct;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JRadioButton rdoHethang;
    private javax.swing.JRadioButton rdoSell;
    private javax.swing.JTextField txtCodeSneaker;
    private javax.swing.JTextField txtIDProDuctDetail;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

}
