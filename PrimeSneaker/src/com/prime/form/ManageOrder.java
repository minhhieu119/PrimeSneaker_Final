package com.prime.form;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.prime.main_model.Bill;
import com.prime.main_model.BillDetail;
import com.prime.main_model.Order;
import com.prime.model.Admin;
import com.prime.services.BillService;
import com.prime.services.OrderService;
import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jdk.jfr.consumer.EventStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManageOrder extends javax.swing.JPanel {

    OrderService os = new OrderService();
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel modelSneakerDetail = new DefaultTableModel();
    BillService bs = new BillService();

    public ManageOrder() throws SQLException {
        initComponents();
        setOpaque(false);
        jdcStart.setDateFormatString("dd/MM/yyyy");
        jdcEnd.setDateFormatString("dd/MM/yyyy");
        model = (DefaultTableModel) tblManagerOder.getModel();

        loadDataToTableBill(bs.getAllBill());
    }

    private void loadDataToTableBill(List<Bill> list) {

        model.setRowCount(0);
        int i = 0;
        for (Bill bill : list) {
            i++;
            model.addRow(bill.toDataRow(i));
//            System.out.println(bill);
        }
    }

    private void fillToListOderDetail(List<BillDetail> list) {
        modelSneakerDetail = (DefaultTableModel) tblBillDetail.getModel();
        modelSneakerDetail.setRowCount(0);
        int stt = 1;
        for (BillDetail billDetail : list) {
            modelSneakerDetail.addRow(new Object[]{
                stt++,
                billDetail.getSneakerDetailCode(),
                billDetail.getProductName(),
                billDetail.getPrice(),
                billDetail.getQuantity()
            });
        }
    }

    private void search() {

        String hinhthucTT = null;
        if (cboPaymentMethod.getSelectedItem().equals("Tất cả")) {
            hinhthucTT = null;
        } else if (cboPaymentMethod.getSelectedItem().equals("Tiền mặt")) {
            hinhthucTT = "Tiền mặt";
        } else if (cboPaymentMethod.getSelectedItem().equals("Chuyển khoản")) {
            hinhthucTT = "Chuyển khoản";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "1900-01-01";
        Date ngayBatDau = jdcStart.getDate();
        Date ngayKetThuc = jdcEnd.getDate();
        String startStr = null;
        String endStr = null;
        if (ngayBatDau == null || ngayKetThuc == null) {
            try {
                ngayBatDau = sdf.parse(str);
                ngayKetThuc = new Date();
            } catch (Exception e) {
            }
        }
        startStr = sdf.format(ngayBatDau);
        endStr = sdf.format(ngayKetThuc);

        String text = txtSearchBill.getText().trim();

        if (text.isEmpty()) {
            text = null;
        }

        model.setRowCount(0);

//        System.out.println(trangThai);
//        System.out.println(hinhthucTT);
//        System.out.println(text);
        this.loadDataToTableBill(bs.timKiem(text, hinhthucTT, startStr, endStr));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearchBill = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboPaymentMethod = new javax.swing.JComboBox<>();
        btnXuatExcel = new javax.swing.JButton();
        jdcStart = new com.toedter.calendar.JDateChooser();
        jdcEnd = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnInHoaDon = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblManagerOder = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBillDetail = new javax.swing.JTable();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setText("Tìm kiếm");

        txtSearchBill.setToolTipText("");
        txtSearchBill.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));
        txtSearchBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchBillKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBillKeyReleased(evt);
            }
        });

        jLabel2.setText("Loại hóa đơn");

        cboPaymentMethod.setBackground(new java.awt.Color(39, 80, 150));
        cboPaymentMethod.setForeground(new java.awt.Color(255, 255, 255));
        cboPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tiền mặt", "Chuyển khoản" }));
        cboPaymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPaymentMethodActionPerformed(evt);
            }
        });

        btnXuatExcel.setBackground(new java.awt.Color(39, 80, 150));
        btnXuatExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatExcel.setText("Xuất excel");
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });

        jdcStart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        jdcStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcStartPropertyChange(evt);
            }
        });

        jdcEnd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 80, 150)));
        jdcEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcEndPropertyChange(evt);
            }
        });

        jLabel5.setText("Từ ngày");

        jLabel20.setText("Đến ngày");

        btnInHoaDon.setBackground(new java.awt.Color(39, 80, 150));
        btnInHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(39, 80, 150));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/prime/icon2/reload.png"))); // NOI18N
        btnReset.setBorder(null);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblManagerOder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MÃ HÓA ĐƠN", "MÃ NHÂN VIÊN", "MÃ VOUCHER", "TÊN KHÁCH HÀNG", "HÌNH THỨC TT", "TỔNG TIỀN", "NGÀY TẠO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblManagerOder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblManagerOder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblManagerOderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblManagerOder);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(txtSearchBill, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel20))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcStart, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(260, 260, 260))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInHoaDon)
                        .addGap(18, 18, 18)
                        .addComponent(btnXuatExcel)))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnInHoaDon, btnXuatExcel});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtSearchBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jdcStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcEnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXuatExcel)
                        .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnInHoaDon, btnReset, btnXuatExcel});

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tblBillDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MÃ SPCT", "TÊN SẢN PHẨM", "GIÁ", "SỐ LƯỢNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblBillDetail);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 147, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchBillKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBillKeyReleased
        search();
    }//GEN-LAST:event_txtSearchBillKeyReleased

    private void cboPaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPaymentMethodActionPerformed
        search();
    }//GEN-LAST:event_cboPaymentMethodActionPerformed

    private void tblManagerOderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblManagerOderMouseClicked
        int index = tblManagerOder.getSelectedRow();
        String id = String.valueOf(tblManagerOder.getValueAt(index, 1));
        int orderDetail = Integer.parseInt(id);

        try {
            fillToListOderDetail(bs.getOrderDetai(orderDetail));
        } catch (Exception e) {

        }

    }//GEN-LAST:event_tblManagerOderMouseClicked

    private void jdcStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcStartPropertyChange
        search();
    }//GEN-LAST:event_jdcStartPropertyChange

    private void jdcEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcEndPropertyChange
        search();
    }//GEN-LAST:event_jdcEndPropertyChange

    private void txtSearchBillKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBillKeyPressed
        search();
    }//GEN-LAST:event_txtSearchBillKeyPressed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Account");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblManagerOder.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblManagerOder.getColumnName(i));
                }
                for (int j = 0; j < tblManagerOder.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblManagerOder.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblManagerOder.getValueAt(j, k) != null) {
                            cell.setCellValue(tblManagerOder.getValueAt(j, k).toString());
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
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        if (Admin.isAdmin()) {
            if (tblManagerOder.getSelectedRow() != -1) {
                int orderId = (int) tblManagerOder.getValueAt(tblManagerOder.getSelectedRow(), 1);
                if (Desktop.isDesktopSupported()) {
                    try {
                        File pdfFile = new File("C:\\Users\\MSII\\Desktop\\PDF\\hoa_don" + orderId + ".pdf");

                        // Kiểm tra xem tệp có tồn tại và có thể đọc được không
                        if (pdfFile.exists() && pdfFile.canRead()) {
                            Desktop.getDesktop().open(pdfFile);
                        } else {
                            JOptionPane.showMessageDialog(this, "Hóa đơn chưa được in");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Desktop API không được hỗ trợ.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn hóa đơn", "Thông báo", 0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền in lại hóa đơn!", "Thông báo", 0);
        }


    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtSearchBill.setText("");
        cboPaymentMethod.setSelectedIndex(0);
        jdcStart.setDate(null);
        jdcEnd.setDate(null);
        modelSneakerDetail.setRowCount(0);
    }//GEN-LAST:event_btnResetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cboPaymentMethod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcEnd;
    private com.toedter.calendar.JDateChooser jdcStart;
    private javax.swing.JTable tblBillDetail;
    private javax.swing.JTable tblManagerOder;
    private javax.swing.JTextField txtSearchBill;
    // End of variables declaration//GEN-END:variables
}
