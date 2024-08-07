package com.prime.form;

import com.prime.form.attributeSneaker.BrandDialog;
import com.prime.form.attributeSneaker.CategoryDialog;
import com.prime.form.attributeSneaker.ColorDialog;
import com.prime.form.attributeSneaker.InfoProductDialog;
import com.prime.form.attributeSneaker.MaterialDialog;
import com.prime.form.attributeSneaker.ProductDialog;
import com.prime.form.attributeSneaker.SizeDialog;
import com.prime.form.attributeSneaker.SoleDialog;
import com.prime.form.attribute.ViewQr;
import com.prime.form.attributeSneaker.FormAddProductDetail;
import com.prime.main_model.Material;
import com.prime.main_model.Model_Brand;
import com.prime.main_model.Model_Category;
import com.prime.main_model.Model_Color;
import com.prime.main_model.Model_DeGiay;
import com.prime.main_model.Model_Sneaker;
import com.prime.main_model.Model_SneakerDetail;
import com.prime.main_model.Model_addNameProduct;
import com.prime.main_model.SizeModel;
import com.prime.main_model.SneakerDetail;
import com.prime.responsitory.BrandResponsitory;
import com.prime.responsitory.CategoryResponsitory;
import com.prime.responsitory.ColorResponsitory;
import com.prime.responsitory.MaterialResponsitory;
import com.prime.responsitory.SizeResponsitory;
import com.prime.responsitory.SneakerDetailResponsitory;
import com.prime.responsitory.SneakerResponsitory;
import com.prime.responsitory.SoleResponsitory;
import com.prime.responsitory.TeSPResponsitory;
import com.prime.services.OrderService;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ColorModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.jfr.consumer.EventStream;
import net.glxn.qrgen.image.ImageType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ManageSneaker extends javax.swing.JPanel {

//    public interface QRCallback {
//
//        void getQRdata(String qrCode);
//    }
    private final BrandResponsitory brs = new BrandResponsitory();
    private final CategoryResponsitory cateRS = new CategoryResponsitory();
    private final ColorResponsitory colorRS = new ColorResponsitory();
    private final MaterialResponsitory materRS = new MaterialResponsitory();
    private final SizeResponsitory sizeRS = new SizeResponsitory();
    private final SoleResponsitory soleRS = new SoleResponsitory();
    private final TeSPResponsitory trs = new TeSPResponsitory();
    private final SneakerDetailResponsitory sdetailRS = new SneakerDetailResponsitory();
    private final SneakerResponsitory sneakerRS = new SneakerResponsitory();
    private final OrderService os = new OrderService();
    DefaultComboBoxModel dcboBrand = new DefaultComboBoxModel();
    DefaultComboBoxModel dcboCate = new DefaultComboBoxModel();
    DefaultComboBoxModel dcboMaterial = new DefaultComboBoxModel();
    DefaultComboBoxModel dcboSole = new DefaultComboBoxModel();
    DefaultComboBoxModel dcboSize = new DefaultComboBoxModel();
    DefaultComboBoxModel dcboColor = new DefaultComboBoxModel();
    DefaultTableModel modelDetail = new DefaultTableModel();
    DefaultTableModel modelSneaker = new DefaultTableModel();
    private int index;

    public ManageSneaker() {
        initComponents();
        setOpaque(false);
        btnStopSell.setVisible(false);
        btnOnSell.setVisible(false);
        dcboBrand = (DefaultComboBoxModel) cboBrand.getModel();
        dcboCate = (DefaultComboBoxModel) cboCategory.getModel();
        dcboMaterial = (DefaultComboBoxModel) cboMaterial.getModel();
        dcboSole = (DefaultComboBoxModel) cboSole.getModel();
        dcboColor = (DefaultComboBoxModel) cboColor.getModel();
        dcboSize = (DefaultComboBoxModel) cboSize.getModel();
        modelDetail = (DefaultTableModel) tblProductDetail.getModel();
        modelSneaker = (DefaultTableModel) tblProducts.getModel();
        loadDataBrand();
        loadDataCate();
        loadDataMaterial();
        loadDataSole();
        loadDataColor();
        loadDataSize();
        loadSneakerDetailToTable(sdetailRS.getALl());
        loadSneakerToTable(sneakerRS.getAll());
        txtProductId.setEditable(false);
        txtProdDetail.setEditable(false);

    }

    public void loadSneakerDetailToTable(ArrayList<Model_SneakerDetail> lst) {
        modelDetail.setRowCount(0);
        int x = 1;
        for (Model_SneakerDetail msd : lst) {
            modelDetail.addRow(new Object[]{
                x++,
                msd.getCode_sneaker(),
                msd.getTenSP().getProduct_name(),
                msd.getGiaSP(),
                msd.getSoLuong(),
                msd.getDanhMuc().getCategory_name(),
                msd.getHang().getBrand_name(),
                msd.getMauSac().getColor_name(),
                msd.getChatLieu().getNameMaterial(),
                msd.getKichCo().getSize_Number(),
                msd.getDeGiay().getTenDeGiay(),
                msd.getTrangThai()
            });
        }
    }

    private void loadSneakerToTable(ArrayList<Model_Sneaker> sn) {
        modelSneaker.setRowCount(0);
        int y = 1;
        for (Model_Sneaker ms : sn) {
            modelSneaker.addRow(new Object[]{
                y++,
                ms.getId_Sneaker(),
                ms.getTen_SP().getProduct_name(),
                ms.getHang().getBrand_name(),
                ms.getDanhMuc().getCategory_name(),
                ms.getChatLieu().getNameMaterial(),
                ms.getDeGiay().getTenDeGiay(),
                ms.getSoLuong(),
                ms.getTrangThai()
            });
        }
    }

    private void fillToListSneakerDetail(List<SneakerDetail> list) throws SQLException {
        modelSneaker = (DefaultTableModel) tblProductDetail.getModel();
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
        }
    }

    private void setSelectedIndex(JComboBox cbo, String value) {
        for (int i = 0; i < cbo.getItemCount(); i++) {
            if (cbo.getItemAt(i).toString().equals(value)) {
                cbo.setSelectedIndex(i);
                return;
            }
        }
    }

    private void showProductDetail(int index) {
        txtProdDetail.setText(tblProductDetail.getValueAt(index, 1).toString());
        lbnProductName.setText(tblProductDetail.getValueAt(index, 2).toString());
        txtPrice.setText(tblProductDetail.getValueAt(index, 3).toString());
        txtQuantity.setText(tblProductDetail.getValueAt(index, 4).toString());
        lbnCategory.setText(tblProductDetail.getValueAt(index, 5).toString());
        lbnBrand.setText(tblProductDetail.getValueAt(index, 6).toString());
        String color = tblProductDetail.getValueAt(index, 7).toString();
        setSelectedIndex(cboColor, color);
        lbnMaterial.setText(tblProductDetail.getValueAt(index, 8).toString());
        String size = tblProductDetail.getValueAt(index, 9).toString();
        setSelectedIndex(cboSize, size);
        lbnSole.setText(tblProductDetail.getValueAt(index, 10).toString());
        rdoStock.setSelected(tblProductDetail.getValueAt(index, 11).toString().equals("Còn hàng") ? true : false);
        rdoSoldOut.setSelected(tblProductDetail.getValueAt(index, 11).toString().equals("Hết hàng") ? true : false);
        tblProductDetail.setRowSelectionInterval(index, index);
    }

    private void showDataProduct(int index) {

        txtProductId.setText(tblProducts.getValueAt(index, 1).toString());
        txtProductName.setText(tblProducts.getValueAt(index, 2).toString());
        String brand = tblProducts.getValueAt(index, 3).toString();
        setSelectedIndex(cboBrand, brand);
        String cate = tblProducts.getValueAt(index, 4).toString();
        setSelectedIndex(cboCategory, cate);
        String material = tblProducts.getValueAt(index, 5).toString();
        setSelectedIndex(cboMaterial, material);
        String sole = tblProducts.getValueAt(index, 6).toString();
        setSelectedIndex(cboSole, sole);
        rdoSell.setSelected(tblProducts.getValueAt(index, 8).toString().equals("Đang bán") ? true : false);
        rdoEndSell.setSelected(tblProducts.getValueAt(index, 8).toString().equals("Ngừng bán") ? true : false);
        tblProducts.setRowSelectionInterval(index, index);
    }

    private boolean validateFormDetail() {

        if (txtQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Số lượng");
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
        if (rdoStock.isSelected()) {
            trangThai = "Còn hàng";
        }
        if (rdoSoldOut.isSelected()) {
            trangThai = "Hết hàng";
        }
        for (Model_SneakerDetail sn : sdetailRS.getALl()) {
            if (sn.getTenSP().getProduct_name().equals(lbnProductName.getText())
                    && (sn.getKichCo().getSize_Number() == Double.valueOf(cboSize.getSelectedItem().toString()))
                    && sn.getMauSac().getColor_name().equals(cboColor.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(this, "Sản phẩm này đã tồn tại");
                return false;
            }
        }
        return true;
    }

    private boolean validateFormUpdateDetail() {

        if (txtQuantity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Số lượng");
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
        if (rdoStock.isSelected()) {
            trangThai = "Còn hàng";
        }
        if (rdoSoldOut.isSelected()) {
            trangThai = "Hết hàng";
        }
        return true;
    }

    public void loadDataBrand() {
        cboBrand.removeAllItems();
        for (Model_Brand br : brs.getALl()) {
            dcboBrand.addElement(br);
        }
    }

    public void loadDataCate() {
        cboCategory.removeAllItems();
        for (Model_Category cate : cateRS.getALl()) {
            dcboCate.addElement(cate);
        }
    }

    public void loadDataMaterial() {
        cboMaterial.removeAllItems();
        for (Material ma : materRS.getAll()) {
            dcboMaterial.addElement(ma);
        }
    }

    public void loadDataSole() {
        cboSole.removeAllItems();
        for (Model_DeGiay sole : soleRS.getAll()) {
            dcboSole.addElement(sole);
        }
    }

    public void loadDataSize() {
        cboSize.removeAllItems();
        for (SizeModel size : sizeRS.getAll()) {
            dcboSize.addElement(size);
        }
    }

    public void loadDataColor() {
        cboColor.removeAllItems();
        for (Model_Color color : colorRS.getALl()) {
            dcboColor.addElement(color);
        }
    }

    private boolean validateForm() {
        if (txtProductName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên SP");
            return false;
        }
        if (txtProductName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Tên không được bắt đầu bằng số");
            txtProductName.requestFocus();
            return false;
        }
        for (Model_Sneaker sn : sneakerRS.getAll()) {
            if (sn.getTen_SP().getProduct_name().toLowerCase().equals(txtProductName.getText().toString().toLowerCase()) && sn.getChatLieu().getNameMaterial().toLowerCase().equals(cboMaterial.getSelectedItem().toString().toLowerCase())
                    && sn.getDanhMuc().getCategory_name().toLowerCase().equals(cboCategory.getSelectedItem().toString().toLowerCase()) && sn.getHang().getBrand_name().toLowerCase().equals(cboBrand.getSelectedItem().toString().toLowerCase())) {
                JOptionPane.showMessageDialog(this, "Sản phẩm này đã tồn tại");
                return false;
            }
        }
        return true;
    }

    private Model_Sneaker readForm() {
        Model_addNameProduct tenSP = new Model_addNameProduct();
        tenSP.setProduct_name(txtProductName.getText());
        Model_Brand br = brs.getBr(cboBrand.getSelectedItem().toString());
        Model_Category cate = cateRS.getCate(cboCategory.getSelectedItem().toString());
        Model_DeGiay sole = soleRS.getSole(cboSole.getSelectedItem().toString());
        Material ms = materRS.getMaterial(cboMaterial.getSelectedItem().toString());
        String trangThai = null;
        if (rdoSell.isSelected()) {
            trangThai = "Đang bán";
        }
        if (rdoEndSell.isSelected()) {
            trangThai = "Ngừng bán";
        }
        Model_Sneaker sn = new Model_Sneaker();
        sn.setChatLieu(ms);
        sn.setDanhMuc(cate);
        sn.setDeGiay(sole);
        sn.setHang(br);
        sn.setTen_SP(tenSP);
        sn.setTrangThai(trangThai);
        return sn;
    }

    private Model_Sneaker getFormUPdate() {
        Model_addNameProduct tenSP = new Model_addNameProduct();
        tenSP.setProduct_name(txtProductName.getText());
        Model_Brand br = brs.getBr(cboBrand.getSelectedItem().toString());
        Model_Category cate = cateRS.getCate(cboCategory.getSelectedItem().toString());
        Model_DeGiay sole = soleRS.getSole(cboSole.getSelectedItem().toString());
        Material ms = materRS.getMaterial(cboMaterial.getSelectedItem().toString());
        String trangThai = null;
        if (rdoSell.isSelected()) {
            trangThai = "Đang bán";
        }
        if (rdoEndSell.isSelected()) {
            trangThai = "Ngừng bán";
        }
        Model_Sneaker sn = new Model_Sneaker();
        sn.setChatLieu(ms);
        sn.setDanhMuc(cate);
        sn.setDeGiay(sole);
        sn.setHang(br);
        sn.setTen_SP(tenSP);
        sn.setId_Sneaker(Integer.valueOf(txtProductId.getText()));
        sn.setTrangThai(trangThai);
        return sn;
    }

//    private Model_SneakerDetail getFormDetailProduct() {
//        Model_SneakerDetail sn = new Model_SneakerDetail();
//        sn.setMaSPCT(Integer.parseInt(txtProdDetail.getText()));
//        sn.setCode_sneaker(txtProdDetail.getText());
//        Model_Color color = colorRS.getColor(cboColor.getSelectedItem().toString());
//        SizeModel size = sizeRS.getSize(cboSize.getSelectedItem().toString());
//        sn.setGiaSP((long) Float.parseFloat(txtPrice.getText()));
//        sn.setSoLuong(Integer.valueOf(txtQuantity.getText()));
//        sn.setKichCo(size);
//        sn.setMauSac(color);
//        if (rdoStock.isSelected()) {
//            sn.setTrangThai("Còn hàng");
//        }
//        if (rdoSoldOut.isSelected()) {
//            sn.setTrangThai("Hết hàng");
//        }
//        return sn;
//    }
    
    private Model_SneakerDetail getFormDetailProduct() {
        Model_SneakerDetail sn = new Model_SneakerDetail();
        sn.setCode_sneaker(txtProdDetail.getText());
        Model_Color color = colorRS.getColor(cboColor.getSelectedItem().toString());
        SizeModel size = sizeRS.getSize(cboSize.getSelectedItem().toString());
        sn.setGiaSP((long)Float.parseFloat(txtPrice.getText()));
        sn.setSoLuong(Integer.valueOf(txtQuantity.getText()));
        sn.setKichCo(size);
        sn.setMauSac(color);
        if (rdoStock.isSelected()) {
            sn.setTrangThai("Còn hàng");
        }
        if (rdoSoldOut.isSelected()) {
            sn.setTrangThai("Hết hàng");
        }
        return sn;
    }

    private void search() {
        String key = null;
        if (txtSearchProduct.getText().trim().isEmpty() || txtSearchProduct.getText().equalsIgnoreCase("Tìm kiếm theo mã sản phẩm, tên sản phẩm, thuộc tính")) {
            key = null;
        } else {
            key = txtSearchProduct.getText();
        }

        String status = null;
        if (rdoAllProduct.isSelected()) {
            status = null;
        } else if (rdoOnSell.isSelected()) {
            status = "Đang bán";
        } else {
            status = "Ngừng bán";
        }
        modelSneaker.setRowCount(0);
        loadSneakerToTable(sneakerRS.foundByText(key, status));
    }

    public void searchSneakerDetail() throws SQLException {
        String key = txtSearchProdDetail.getText().trim();
        if (key.isEmpty() || key.equalsIgnoreCase("Tìm kiếm theo mã, tên, trạng thái , thuộc tính sản phẩm")) {
            key = null;
        }
        long price;
        if (sliderPrice.getValue() == 100000) {
            price = Long.MAX_VALUE;
        } else {
            price = (long) sliderPrice.getValue();
            lbnPrice.setText(price + "");
        }
        modelDetail.setRowCount(0);
        fillToListSneakerDetail(os.searchSD(key, price));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        tabbedPaneProduct = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rdoAllProduct = new javax.swing.JRadioButton();
        rdoOnSell = new javax.swing.JRadioButton();
        rdoStopSell = new javax.swing.JRadioButton();
        btnStopSell = new javax.swing.JButton();
        btnOnSell = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtSearchProduct = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtProductId = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        cboCategory = new javax.swing.JComboBox<>();
        btnAddProdCategory1 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        cboBrand = new javax.swing.JComboBox<>();
        btnAddProdBrand1 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        cboMaterial = new javax.swing.JComboBox<>();
        btnAddProdMaterial1 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        cboSole = new javax.swing.JComboBox<>();
        btnAddProdSole1 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        rdoSell = new javax.swing.JRadioButton();
        rdoEndSell = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        btnProductClear = new javax.swing.JButton();
        btnProductAdd = new javax.swing.JButton();
        btnEditProduct = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtProdDetail = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cboColor = new javax.swing.JComboBox<>();
        txtPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        cboSize = new javax.swing.JComboBox<>();
        btnAddProdColor = new javax.swing.JButton();
        btnAddProdSize = new javax.swing.JButton();
        rdoStock = new javax.swing.JRadioButton();
        rdoSoldOut = new javax.swing.JRadioButton();
        lbnProductName = new javax.swing.JLabel();
        lbnCategory = new javax.swing.JLabel();
        lbnSole = new javax.swing.JLabel();
        lbnBrand = new javax.swing.JLabel();
        lbnMaterial = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProductDetail = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        sliderPrice = new javax.swing.JSlider();
        txtSearchProdDetail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbnPrice = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        btnAddNewProd2 = new javax.swing.JButton();
        btnUpdateProd2 = new javax.swing.JButton();
        btnDownloadQR2 = new javax.swing.JButton();
        btnRefresh2 = new javax.swing.JButton();
        btnExportToExcel2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1025, 700));

        tabbedPaneProduct.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPaneProduct.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý sản phẩm Giày", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        tabbedPaneProduct.setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tab1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Hãng", "Danh mục", "Chất liệu", "Đế giày", "Số lượng", "Trạng thái", "Hành động"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProducts);

        jLabel15.setText("Trạng thái :");

        jPanel3.setBackground(new java.awt.Color(185, 213, 246));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(39, 80, 150)));

        buttonGroup1.add(rdoAllProduct);
        rdoAllProduct.setSelected(true);
        rdoAllProduct.setText("Tất cả");
        rdoAllProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllProductActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoOnSell);
        rdoOnSell.setText("Đang bán");
        rdoOnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoOnSellActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoStopSell);
        rdoStopSell.setText("Ngừng bán");
        rdoStopSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoStopSellActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(rdoAllProduct)
                .addGap(46, 46, 46)
                .addComponent(rdoOnSell)
                .addGap(36, 36, 36)
                .addComponent(rdoStopSell)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoAllProduct)
                    .addComponent(rdoOnSell)
                    .addComponent(rdoStopSell))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnStopSell.setBackground(new java.awt.Color(39, 80, 150));
        btnStopSell.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnStopSell.setForeground(new java.awt.Color(255, 255, 255));
        btnStopSell.setText("Ngừng bán");
        btnStopSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopSellActionPerformed(evt);
            }
        });

        btnOnSell.setBackground(new java.awt.Color(39, 80, 150));
        btnOnSell.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOnSell.setForeground(new java.awt.Color(255, 255, 255));
        btnOnSell.setText("Đang bán");
        btnOnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnSellActionPerformed(evt);
            }
        });

        jLabel28.setText("Tìm kiếm:");

        txtSearchProduct.setForeground(new java.awt.Color(153, 153, 153));
        txtSearchProduct.setText("Tìm kiếm theo mã sản phẩm, tên sản phẩm, thuộc tính");
        txtSearchProduct.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 80, 150)));
        txtSearchProduct.setSelectionColor(new java.awt.Color(39, 80, 150));
        txtSearchProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchProductFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchProductFocusLost(evt);
            }
        });
        txtSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchProductActionPerformed(evt);
            }
        });
        txtSearchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchProductKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(172, 172, 172)
                            .addComponent(btnStopSell)
                            .addGap(81, 81, 81)
                            .addComponent(btnOnSell)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(43, 43, 43)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(323, 501, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStopSell, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOnSell, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setText("Mã sản phẩm");

        txtProductId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));
        txtProductId.setSelectionColor(new java.awt.Color(39, 80, 150));

        jLabel17.setText("Tên sản phẩm");

        txtProductName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        jLabel37.setText("Danh mục");

        cboCategory.setBackground(new java.awt.Color(39, 80, 150));
        cboCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cboCategory.setBorder(null);

        btnAddProdCategory1.setBackground(new java.awt.Color(39, 80, 150));
        btnAddProdCategory1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProdCategory1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProdCategory1.setText("+");
        btnAddProdCategory1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdCategory1ActionPerformed(evt);
            }
        });

        jLabel38.setText("Hãng");

        cboBrand.setBackground(new java.awt.Color(39, 80, 150));
        cboBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cboBrand.setBorder(null);

        btnAddProdBrand1.setBackground(new java.awt.Color(39, 80, 150));
        btnAddProdBrand1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProdBrand1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProdBrand1.setText("+");
        btnAddProdBrand1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdBrand1ActionPerformed(evt);
            }
        });

        jLabel39.setText("Chất liệu");

        cboMaterial.setBackground(new java.awt.Color(39, 80, 150));
        cboMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cboMaterial.setBorder(null);
        cboMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaterialActionPerformed(evt);
            }
        });

        btnAddProdMaterial1.setBackground(new java.awt.Color(39, 80, 150));
        btnAddProdMaterial1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProdMaterial1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProdMaterial1.setText("+");
        btnAddProdMaterial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdMaterial1ActionPerformed(evt);
            }
        });

        jLabel40.setText("Đế giày");

        cboSole.setBackground(new java.awt.Color(39, 80, 150));
        cboSole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cboSole.setBorder(null);

        btnAddProdSole1.setBackground(new java.awt.Color(39, 80, 150));
        btnAddProdSole1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProdSole1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProdSole1.setText("+");
        btnAddProdSole1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdSole1ActionPerformed(evt);
            }
        });

        jLabel41.setText("Trạng thái");

        buttonGroup3.add(rdoSell);
        rdoSell.setSelected(true);
        rdoSell.setText("Đang bán");

        buttonGroup3.add(rdoEndSell);
        rdoEndSell.setText("Ngừng bán");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel39))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(rdoSell)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoEndSell))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(cboMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddProdMaterial1))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtProductId)
                            .addComponent(cboBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddProdBrand1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel17)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboSole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCategory, javax.swing.GroupLayout.Alignment.TRAILING, 0, 222, Short.MAX_VALUE)
                    .addComponent(txtProductName, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddProdSole1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddProdCategory1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboBrand, cboCategory, cboMaterial, cboSole, txtProductId, txtProductName});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(cboBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddProdBrand1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddProdCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddProdSole1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboSole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel40))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel39)
                                .addComponent(cboMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAddProdMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoSell)
                        .addComponent(rdoEndSell)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboBrand, cboCategory, cboMaterial, cboSole, txtProductId, txtProductName});

        jPanel14.setBackground(new java.awt.Color(185, 213, 246));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnProductClear.setBackground(new java.awt.Color(39, 80, 150));
        btnProductClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProductClear.setForeground(new java.awt.Color(255, 255, 255));
        btnProductClear.setText("Làm mới");
        btnProductClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductClearActionPerformed(evt);
            }
        });

        btnProductAdd.setBackground(new java.awt.Color(39, 80, 150));
        btnProductAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProductAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnProductAdd.setText("Thêm mới sản phẩm");
        btnProductAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductAddActionPerformed(evt);
            }
        });

        btnEditProduct.setBackground(new java.awt.Color(39, 80, 150));
        btnEditProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnEditProduct.setText("Sửa");
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProductAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProductClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditProduct, btnProductAdd, btnProductClear});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnProductAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEditProduct, btnProductAdd, btnProductClear});

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 394, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );

        tabbedPaneProduct.addTab("Sản phẩm", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết sản phẩm"));

        jLabel25.setText("Mã SPCT");

        txtProdDetail.setEditable(false);
        txtProdDetail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel26.setText("Tên sản phẩm");

        jLabel27.setText("Giá");

        jLabel29.setText("Số lượng");

        jLabel30.setText("Danh mục");

        jLabel31.setText("Hãng");

        jLabel32.setText("Màu sắc");

        jLabel33.setText("Chất liệu");

        jLabel34.setText("Kích cỡ");

        jLabel35.setText("Trạng thái");

        jLabel36.setText("Đế giày");

        cboColor.setBackground(new java.awt.Color(39, 80, 150));
        cboColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cboColor.setBorder(null);

        txtPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        cboSize.setBackground(new java.awt.Color(39, 80, 150));
        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cboSize.setBorder(null);

        btnAddProdColor.setBackground(new java.awt.Color(39, 80, 150));
        btnAddProdColor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProdColor.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProdColor.setText("+");
        btnAddProdColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdColorActionPerformed(evt);
            }
        });

        btnAddProdSize.setBackground(new java.awt.Color(39, 80, 150));
        btnAddProdSize.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddProdSize.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProdSize.setText("+");
        btnAddProdSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdSizeActionPerformed(evt);
            }
        });

        buttonGroup4.add(rdoStock);
        rdoStock.setSelected(true);
        rdoStock.setText("Còn hàng");
        rdoStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoStockActionPerformed(evt);
            }
        });

        buttonGroup4.add(rdoSoldOut);
        rdoSoldOut.setText("Hết hàng");
        rdoSoldOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSoldOutActionPerformed(evt);
            }
        });

        lbnCategory.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPrice))
                                    .addComponent(cboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel33)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbnBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtProdDetail)
                                            .addComponent(lbnMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddProdColor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel30))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbnProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtQuantity)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(cboSize, 0, 166, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddProdSize))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(lbnSole, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoSoldOut)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboColor, cboSize, lbnBrand, lbnCategory, lbnMaterial, lbnProductName, lbnSole, txtPrice, txtProdDetail, txtQuantity});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(txtProdDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(lbnMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel33))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbnSole, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddProdColor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddProdSize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(rdoStock)
                    .addComponent(rdoSoldOut))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel25, jLabel26, jLabel27, jLabel29, jLabel30, jLabel31, jLabel32, jLabel33, jLabel34, jLabel35, jLabel36});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboColor, cboSize, lbnBrand, lbnCategory, lbnMaterial, lbnProductName, lbnSole, txtPrice, txtProdDetail, txtQuantity});

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm chi tiết", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel23.setText("Tìm kiếm");

        tblProductDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm ", "Giá", "Số lượng", "Danh mục", "Hãng", "Màu sắc", "Chất liệu", "Kích cỡ", "Đế giày", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductDetail.setRowHeight(30);
        tblProductDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductDetailMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblProductDetail);

        jLabel2.setText("Tìm theo giá:");

        sliderPrice.setBackground(new java.awt.Color(39, 80, 150));
        sliderPrice.setMaximum(4000000);
        sliderPrice.setMinimum(100000);
        sliderPrice.setToolTipText("100");
        sliderPrice.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderPriceStateChanged(evt);
            }
        });

        txtSearchProdDetail.setForeground(new java.awt.Color(153, 153, 153));
        txtSearchProdDetail.setText("Tìm kiếm theo mã, tên, trạng thái , thuộc tính sản phẩm");
        txtSearchProdDetail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(39, 80, 150)));
        txtSearchProdDetail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchProdDetailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchProdDetailFocusLost(evt);
            }
        });
        txtSearchProdDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchProdDetailActionPerformed(evt);
            }
        });
        txtSearchProdDetail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchProdDetailKeyReleased(evt);
            }
        });

        jLabel1.setText("Giá:");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchProdDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sliderPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearchProdDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sliderPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(lbnPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel17.setBackground(new java.awt.Color(185, 213, 246));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAddNewProd2.setBackground(new java.awt.Color(39, 80, 150));
        btnAddNewProd2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddNewProd2.setForeground(new java.awt.Color(255, 255, 255));
        btnAddNewProd2.setText("Thêm mới");
        btnAddNewProd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewProd2ActionPerformed(evt);
            }
        });

        btnUpdateProd2.setBackground(new java.awt.Color(39, 80, 150));
        btnUpdateProd2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateProd2.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateProd2.setText("Sửa");
        btnUpdateProd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProd2ActionPerformed(evt);
            }
        });

        btnDownloadQR2.setBackground(new java.awt.Color(39, 80, 150));
        btnDownloadQR2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDownloadQR2.setForeground(new java.awt.Color(255, 255, 255));
        btnDownloadQR2.setText("Dowload QR");
        btnDownloadQR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadQR2ActionPerformed(evt);
            }
        });

        btnRefresh2.setBackground(new java.awt.Color(39, 80, 150));
        btnRefresh2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh2.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh2.setText("Làm mới");
        btnRefresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresh2ActionPerformed(evt);
            }
        });

        btnExportToExcel2.setBackground(new java.awt.Color(39, 80, 150));
        btnExportToExcel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExportToExcel2.setForeground(new java.awt.Color(255, 255, 255));
        btnExportToExcel2.setText("Xuất Excel");
        btnExportToExcel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportToExcel2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefresh2)
                    .addComponent(btnDownloadQR2)
                    .addComponent(btnExportToExcel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddNewProd2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateProd2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddNewProd2, btnDownloadQR2, btnExportToExcel2, btnRefresh2, btnUpdateProd2});

        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnAddNewProd2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnUpdateProd2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDownloadQR2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportToExcel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddNewProd2, btnDownloadQR2, btnExportToExcel2, btnRefresh2, btnUpdateProd2});

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        tabbedPaneProduct.addTab("Sản phẩm chi tiết", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneProduct)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tabbedPaneProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProdColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdColorActionPerformed
        new ColorDialog(null, true).setVisible(true);
        loadDataColor();
    }//GEN-LAST:event_btnAddProdColorActionPerformed

    private void btnAddProdSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdSizeActionPerformed
        new SizeDialog(null, true).setVisible(true);
        loadDataSize();
    }//GEN-LAST:event_btnAddProdSizeActionPerformed

    private void txtSearchProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchProductFocusGained
        if (txtSearchProduct.getText().equals("Tìm kiếm theo mã sản phẩm, tên sản phẩm, thuộc tính")) {
            txtSearchProduct.setText("");
            setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchProductFocusGained

    private void txtSearchProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchProductFocusLost
        if (txtSearchProduct.getText().equals("")) {
            txtSearchProduct.setText("Tìm kiếm theo mã sản phẩm, tên sản phẩm, thuộc tính");
            setForeground(new Color(39, 80, 150));
        }
    }//GEN-LAST:event_txtSearchProductFocusLost

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked

        int index = tblProducts.getSelectedRow();
        showDataProduct(index);
        if (evt.getClickCount() == 2) {
            tabbedPaneProduct.setSelectedIndex(1);
            loadSneakerDetailToTable(sdetailRS.getSneakerByID(tblProducts.getValueAt(index, 1).toString()));
        }

    }//GEN-LAST:event_tblProductsMouseClicked

    private void rdoAllProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllProductActionPerformed
        if (rdoAllProduct.isSelected()) {
            btnStopSell.setVisible(false);
            btnOnSell.setVisible(false);
//            loadSneakerToTable(sneakerRS.getAll());
            search();
        }

    }//GEN-LAST:event_rdoAllProductActionPerformed

    private void rdoOnSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoOnSellActionPerformed
        if (rdoOnSell.isSelected()) {
            btnStopSell.setVisible(true);
            btnOnSell.setVisible(false);
//            loadSneakerToTable(sneakerRS.getAllSPOnSell());
            search();
        }

    }//GEN-LAST:event_rdoOnSellActionPerformed

    private void rdoStopSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoStopSellActionPerformed
        if (rdoStopSell.isSelected()) {
            btnStopSell.setVisible(false);
            btnOnSell.setVisible(true);
//            loadSneakerToTable(sneakerRS.getAllSPStopSell());
            search();
        }

    }//GEN-LAST:event_rdoStopSellActionPerformed

    private void tblProductDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductDetailMouseClicked
        int index = tblProductDetail.getSelectedRow();
        showProductDetail(index);
    }//GEN-LAST:event_tblProductDetailMouseClicked

    private void txtSearchProdDetailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchProdDetailFocusGained
        if (txtSearchProdDetail.getText().equals("Tìm kiếm theo mã, tên, trạng thái , thuộc tính sản phẩm")) {
            txtSearchProdDetail.setText("");
            setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSearchProdDetailFocusGained

    private void txtSearchProdDetailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchProdDetailFocusLost
        if (txtSearchProduct.getText().equals("")) {
            txtSearchProduct.setText("Tìm kiếm theo mã, tên, trạng thái , thuộc tính sản phẩm");
            setForeground(new Color(53, 153, 153));
        }
    }//GEN-LAST:event_txtSearchProdDetailFocusLost

    private void btnOnSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnSellActionPerformed
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng sản phẩm để ngừng bán");
            return;
        }
        List<Integer> isSelected = new ArrayList<>();
        for (int i = tblProducts.getRowCount() - 1; i >= 0; i--) {
            Boolean isChecked = (Boolean) tblProducts.getValueAt(i, 9);
            if (isChecked != null && isChecked) {
                int id = (int) tblProducts.getValueAt(i, 1);
                isSelected.add(id);
            }
        }
        if (!isSelected.isEmpty() && JOptionPane.showConfirmDialog(this, "Bạn có muốn khôi phục sản phẩm này không ?") == 0) {
            boolean stopsell = false;
            for (Integer id : isSelected) {
                if (sdetailRS.updateStatusOnSell(id) != null) {
                    stopsell = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Chuyển đang bán thất bại");
                }
            }
            if (stopsell) {
                JOptionPane.showMessageDialog(this, "Chuyển đang bán thành công");
            }
            loadSneakerToTable(sneakerRS.getAllSPStopSell());
        }
    }//GEN-LAST:event_btnOnSellActionPerformed

    private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductActionPerformed

        if (txtProductId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng cần sửa");
            return;
        }
        if (validateForm()) {
            Model_Sneaker sn = getFormUPdate();
            int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật sản phẩm này không?");
            if (chon != JOptionPane.YES_OPTION) {
                return;
            }
            if (sneakerRS.upDateSneaker(sn) != null) {
                JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công");
                loadSneakerToTable(sneakerRS.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thất bại");
            }

        }
    }//GEN-LAST:event_btnEditProductActionPerformed

    private void btnAddProdCategory1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdCategory1ActionPerformed
        new CategoryDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnAddProdCategory1ActionPerformed

    private void btnAddProdBrand1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdBrand1ActionPerformed
        new BrandDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnAddProdBrand1ActionPerformed

    private void cboMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMaterialActionPerformed

    private void btnAddProdMaterial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdMaterial1ActionPerformed
        new MaterialDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnAddProdMaterial1ActionPerformed

    private void btnAddProdSole1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdSole1ActionPerformed
        new SoleDialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnAddProdSole1ActionPerformed

    private void rdoStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoStockActionPerformed

    private void rdoSoldOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSoldOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoSoldOutActionPerformed

    private void sliderPriceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderPriceStateChanged
        try {
            //        lbnPrice.setText(sliderPrice.getValue() + "");
//        loadSneakerDetailToTable(sdetailRS.getSneakerByGia(Double.parseDouble(sliderPrice.getValue() + "")));
            searchSneakerDetail();
        } catch (SQLException ex) {
            Logger.getLogger(ManageSneaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sliderPriceStateChanged

    private void btnAddNewProd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewProd2ActionPerformed
        new FormAddProductDetail(null, true).setVisible(true);
        loadSneakerDetailToTable(sdetailRS.getALl());
        index = sdetailRS.getALl().size() - 1;
        showProductDetail(index);
    }//GEN-LAST:event_btnAddNewProd2ActionPerformed

    private void btnRefresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresh2ActionPerformed
        txtProdDetail.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        lbnProductName.setText("");
        lbnMaterial.setText("");
        cboColor.setSelectedIndex(0);
        lbnProductName.setText("");
        lbnBrand.setText("");
        lbnSole.setText("");
        lbnCategory.setText("");
        cboSize.setSelectedIndex(0);
        sliderPrice.setValue(100000);
        txtSearchProdDetail.setText("Tìm kiếm theo mã, tên, trạng thái , thuộc tính sản phẩm");
        sliderPrice.setValue(100000);
        lbnPrice.setText("");
        loadSneakerDetailToTable(sdetailRS.getALl());
    }//GEN-LAST:event_btnRefresh2ActionPerformed

    private void btnStopSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopSellActionPerformed
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng sản phẩm để ngừng bán");
            return;
        }
        List<Integer> isSelected = new ArrayList<>();
        for (int i = tblProducts.getRowCount() - 1; i >= 0; i--) {
            Boolean isChecked = (Boolean) tblProducts.getValueAt(i, 9);
            if (isChecked != null && isChecked) {
                int id = (int) tblProducts.getValueAt(i, 1);
//                System.out.println(id);
                isSelected.add(id);
            }
        }
        if (!isSelected.isEmpty() && JOptionPane.showConfirmDialog(this, "Bạn có muốn ngừng bán sản phẩm này không ?") == 0) {
            boolean stopsell = false;
            for (Integer id : isSelected) {
                if (sdetailRS.updateStatus(id) != null) {
                    stopsell = true;
                } else {
                    JOptionPane.showMessageDialog(this, "Chuyển ngừng bán thất bại");
                }
            }
            if (stopsell) {
                JOptionPane.showMessageDialog(this, "Chuyển ngừng bán thành công");
            }
            loadSneakerToTable(sneakerRS.getAllSPOnSell());
        }
    }//GEN-LAST:event_btnStopSellActionPerformed

    private void btnProductClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductClearActionPerformed
        rdoAllProduct.setSelected(true);
        txtProductId.setText("");
        txtProductName.setText("");
        rdoSell.setSelected(true);
        cboBrand.setSelectedIndex(0);
        cboCategory.setSelectedIndex(0);
        cboMaterial.setSelectedIndex(0);
        cboSole.setSelectedIndex(0);
        loadSneakerToTable(sneakerRS.getAll());
    }//GEN-LAST:event_btnProductClearActionPerformed

    private void txtSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchProductActionPerformed

    }//GEN-LAST:event_txtSearchProductActionPerformed

    private void txtSearchProdDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchProdDetailActionPerformed

    }//GEN-LAST:event_txtSearchProdDetailActionPerformed

    private void btnProductAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductAddActionPerformed
        if (validateForm()) {
            Model_Sneaker sn = readForm();
//            System.out.println(sn);
            int chon = JOptionPane.showConfirmDialog(this, "Bạn có thêm mới sản phẩm này không?");
            if (chon != JOptionPane.YES_OPTION) {
                return;
            }
            if (sneakerRS.addSneaker(sn) != null) {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công");
                loadSneakerToTable(sneakerRS.getAll());
                int index = sneakerRS.getAll().size() - 1;
                showDataProduct(index);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại");
                return;
            }
        }
    }//GEN-LAST:event_btnProductAddActionPerformed

    private void btnUpdateProd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProd2ActionPerformed
        if (txtProdDetail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 sản phẩm cần sửa");
            return;
        }
        if (validateFormUpdateDetail()) {
            Model_SneakerDetail sn = getFormDetailProduct();
//            System.out.println(sn);
            if (sdetailRS.updateSneakerDetail(sn) > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công");
                loadSneakerDetailToTable(sdetailRS.getALl());
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thất bại");
            }

        }
    }//GEN-LAST:event_btnUpdateProd2ActionPerformed

    private void txtSearchProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchProductKeyReleased
//        if (txtSearchProduct.getText().isBlank()) {
//            loadSneakerToTable(sneakerRS.getAll());
//        } else {
//            loadSneakerToTable(sneakerRS.foundByText(txtSearchProduct.getText().trim()));
//        }
        search();
    }//GEN-LAST:event_txtSearchProductKeyReleased

    private void txtSearchProdDetailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchProdDetailKeyReleased
        try {
            //        if (txtSearchProdDetail.getText().isBlank()) {
//            loadSneakerDetailToTable(sdetailRS.getALl());
//        } else {
//            loadSneakerDetailToTable(sdetailRS.foundSneakerDetailByText(txtSearchProdDetail.getText().trim()));
//        }
            searchSneakerDetail();
        } catch (SQLException ex) {
            Logger.getLogger(ManageSneaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchProdDetailKeyReleased

    private void btnExportToExcel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportToExcel2ActionPerformed
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Account");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblProductDetail.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblProductDetail.getColumnName(i));
                }
                for (int j = 0; j < tblProductDetail.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblProductDetail.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblProductDetail.getValueAt(j, k) != null) {
                            cell.setCellValue(tblProductDetail.getValueAt(j, k).toString());
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
    }//GEN-LAST:event_btnExportToExcel2ActionPerformed

    private void btnDownloadQR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadQR2ActionPerformed
        int index = tblProductDetail.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng sản phẩm để dowload QR");
            return;
        }
        String code = tblProductDetail.getValueAt(index, 1).toString();
        try {
            ByteArrayOutputStream out = net.glxn.qrgen.QRCode.from(code).to(ImageType.PNG).stream();
            // String path = "D:\\QRcode\\";
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu mã QR");
            fileChooser.setSelectedFile(new File(code + ".png"));// đặt tên file mặc định là code 
            int userSelecttion = fileChooser.showSaveDialog(this);
            if (userSelecttion == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (FileOutputStream fout = new FileOutputStream(file)) {
                    fout.write(out.toByteArray());
                    fout.flush();
                    JOptionPane.showMessageDialog(this, "Dowload QR thành công");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi lưu file: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Người dùng đã hủy lưu QR");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi tạo mã QR");
        }
    }//GEN-LAST:event_btnDownloadQR2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewProd2;
    private javax.swing.JButton btnAddProdBrand1;
    private javax.swing.JButton btnAddProdCategory1;
    private javax.swing.JButton btnAddProdColor;
    private javax.swing.JButton btnAddProdMaterial1;
    private javax.swing.JButton btnAddProdSize;
    private javax.swing.JButton btnAddProdSole1;
    private javax.swing.JButton btnDownloadQR2;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JButton btnExportToExcel2;
    private javax.swing.JButton btnOnSell;
    private javax.swing.JButton btnProductAdd;
    private javax.swing.JButton btnProductClear;
    private javax.swing.JButton btnRefresh2;
    private javax.swing.JButton btnStopSell;
    private javax.swing.JButton btnUpdateProd2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cboBrand;
    private javax.swing.JComboBox<String> cboCategory;
    private javax.swing.JComboBox<String> cboColor;
    private javax.swing.JComboBox<String> cboMaterial;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JComboBox<String> cboSole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbnBrand;
    private javax.swing.JLabel lbnCategory;
    private javax.swing.JLabel lbnMaterial;
    private javax.swing.JLabel lbnPrice;
    private javax.swing.JLabel lbnProductName;
    private javax.swing.JLabel lbnSole;
    private javax.swing.JRadioButton rdoAllProduct;
    private javax.swing.JRadioButton rdoEndSell;
    private javax.swing.JRadioButton rdoOnSell;
    private javax.swing.JRadioButton rdoSell;
    private javax.swing.JRadioButton rdoSoldOut;
    private javax.swing.JRadioButton rdoStock;
    private javax.swing.JRadioButton rdoStopSell;
    private javax.swing.JSlider sliderPrice;
    private javax.swing.JPanel tab1;
    private javax.swing.JTabbedPane tabbedPaneProduct;
    private javax.swing.JTable tblProductDetail;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProdDetail;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearchProdDetail;
    private javax.swing.JTextField txtSearchProduct;
    // End of variables declaration//GEN-END:variables
}
