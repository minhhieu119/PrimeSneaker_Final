package com.prime.form.attributeSneaker;

import com.prime.form.ManageSneaker;
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

public class FormAddProductDetail extends javax.swing.JDialog {

    DefaultComboBoxModel dcboSize = new DefaultComboBoxModel();
    DefaultComboBoxModel dcboColor, dcboName = new DefaultComboBoxModel();
    private final ColorResponsitory colorRS = new ColorResponsitory();
    private final SizeResponsitory sizeRS = new SizeResponsitory();
    private final TeSPResponsitory nameProduct = new TeSPResponsitory();
    private SneakerDetailResponsitory snDetailRS = new SneakerDetailResponsitory();
    ManageSneaker sneaker = new ManageSneaker();

    public FormAddProductDetail(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        dcboColor = (DefaultComboBoxModel) cboColor.getModel();
        dcboSize = (DefaultComboBoxModel) cboSize.getModel();
        dcboName = (DefaultComboBoxModel) cboNameProduct.getModel();
        loadDataColor();
        loadDataSize();
        loadDataName();
        if (rdoHethang.isSelected()) {
            txtQuantity.setText("0");
            txtQuantity.setEditable(false);
        }
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
        if (txtCodeSneaker.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập code Sản Phẩm");
            txtCodeSneaker.requestFocus();
            return false;
        }
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
        
        for (Model_SneakerDetail sn : snDetailRS.getALl()) {
            if (sn.getCode_sneaker().equals(txtCodeSneaker.getText())) {
                JOptionPane.showMessageDialog(this, "Code_Sneaker đã tồn tại");
                return false;
            }
        }
        try {
            Double price = Double.valueOf(txtPrice.getText());
            Integer quantity = Integer.valueOf(txtQuantity.getText());
            if (price < 100000 || quantity < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng và giá phải lớn hơn hoặc bằng 0 và giá lớn hơn hoặc = 100000");
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng và giá phải là số");
            return false;
        }
        String trangThai = null;
        if (rdoSell.isSelected()) {
            trangThai = "Còn hàng";
        }
        if (rdoHethang.isSelected()) {
            trangThai = "Hết hàng";
        }
        for (Model_SneakerDetail sn : snDetailRS.getALl()) {
            if (sn.getTenSP().getProduct_name().equals(cboNameProduct.getSelectedItem().toString())
                    && (sn.getKichCo().getSize_Number() == Double.valueOf(cboSize.getSelectedItem().toString()))
                    && sn.getMauSac().getColor_name().equals(cboColor.getSelectedItem().toString())     
                    && sn.getCode_sneaker().equals(txtCodeSneaker.getText())) {
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
        sn.setGiaSP( Long.valueOf(txtPrice.getText()));
        sn.setSoLuong(Integer.valueOf(txtQuantity.getText()));
        sn.setCode_sneaker(txtCodeSneaker.getText());
        sn.setTenSP(name);
        sn.setKichCo(size);
        sn.setMauSac(color);
        if (rdoSell.isSelected()) {
            sn.setTrangThai("Còn hàng");
        }
        if (rdoHethang.isSelected()) {
            sn.setTrangThai("Hết hàng");
        }
        return sn;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
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
        rdoSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSellActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHethang);
        rdoHethang.setText("Hết hàng");
        rdoHethang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHethangActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
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
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel41)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCodeSneaker))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdoSell, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoHethang)))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel51)
                    .addComponent(jLabel37)
                    .addComponent(jLabel32))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(284, 284, 284))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboColor, cboNameProduct, cboSize});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(cboNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(txtCodeSneaker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(rdoSell)
                    .addComponent(rdoHethang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(33, 33, 33))
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
                String path = "C:\\Users\\MSII\\Desktop\\QRcode\\";

                FileOutputStream fout = new FileOutputStream(new File(path + (sn.getCode_sneaker() + ".png")));
                fout.write(out.toByteArray());
                fout.flush();
            } catch (Exception e) {
                System.out.println(e);
            }
            if (snDetailRS.addSneakerDetail(sn) != null) {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                sneaker.loadSneakerDetailToTable(snDetailRS.getALl());
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
            }
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void rdoHethangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHethangActionPerformed
        if (rdoHethang.isSelected()) {
            txtQuantity.setText("0");
            txtQuantity.setEditable(false);
        } 
    }//GEN-LAST:event_rdoHethangActionPerformed

    private void rdoSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSellActionPerformed
        txtQuantity.setEditable(true);
    }//GEN-LAST:event_rdoSellActionPerformed

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
                FormAddProductDetail dialog = new FormAddProductDetail(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
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
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

}
