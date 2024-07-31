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
import com.prime.main_model.Material;
import com.prime.main_model.Model_Brand;
import com.prime.main_model.Model_Category;
import com.prime.main_model.Model_Color;
import com.prime.main_model.Model_DeGiay;
import com.prime.main_model.SizeModel;
import com.prime.responsitory.BrandResponsitory;
import com.prime.responsitory.CategoryResponsitory;
import com.prime.responsitory.ColorResponsitory;
import com.prime.responsitory.MaterialResponsitory;
import com.prime.responsitory.SizeResponsitory;
import com.prime.responsitory.SoleResponsitory;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Properties extends javax.swing.JPanel {

    private void loadDataBrand() {
        modelBrand.setRowCount(0);
        int x = 1;
        for (Model_Brand br : brs.getALl()) {
            modelBrand.addRow(new Object[]{x++, br.getBrand_id(), br.getBrand_name()});
        }
    }

    private void loadDataCate() {
        modelCate.setRowCount(0);
        int x = 1;
        for (Model_Category br : cateRS.getALl()) {
            modelCate.addRow(new Object[]{x++, br.getCategory_id(), br.getCategory_name()});
        }
    }

    private void loadDataMaterial() {
        modelMaterial.setRowCount(0);
        int x = 1;
        for (Material br : materRS.getAll()) {
            modelMaterial.addRow(new Object[]{x++, br.getMaMaterial(), br.getNameMaterial()});
        }
    }

    private void loadDataSole() {
        modelSole.setRowCount(0);
        int x = 1;
        for (Model_DeGiay br : soleRS.getAll()) {
            modelSole.addRow(new Object[]{x++, br.getMaDeGiay(), br.getTenDeGiay()});
        }
    }

    private void loadDataColor() {
        modelColor.setRowCount(0);
        int x = 1;
        for (Model_Color br : colorRS.getALl()) {
            modelColor.addRow(new Object[]{x++, br.getColor_id(), br.getColor_name()});
        }
    }

    private void loadDataSize() {
        modelSize.setRowCount(0);
        int x = 1;
        for (SizeModel br : sizeRS.getAll()) {
            modelSize.addRow(new Object[]{x++, br.getId_Size(), br.getSize_Number()});
        }
    }

    private Model_Brand readFormBr() {
        Model_Brand br = new Model_Brand();
        br.setBrand_name(txtBrandName.getText());
        return br;
    }

    private Model_Brand readFormBr1() {
        Model_Brand br = new Model_Brand();
        br.setBrand_name(txtBrandName.getText());
        br.setBrand_id(Integer.parseInt(txtBrandID.getText()));
        return br;
    }

    private Model_Category readForm() {
        Model_Category cate = new Model_Category();
        cate.setCategory_name(txtCategory.getText());
        return cate;
    }

    private Model_Category readForm1() {
        Model_Category cate = new Model_Category();
        cate.setCategory_name(txtCategory.getText());
        cate.setCategory_id(Integer.parseInt(txtIdCategory.getText()));
        return cate;
    }

    private Material readFormMa1() {
        Material br = new Material();
        br.setNameMaterial(txtMaterial.getText());
        br.setMaMaterial(Integer.parseInt(txtMaterialID.getText()));
        return br;
    }

    private Material readFormMa() {
        Material br = new Material();
        br.setNameMaterial(txtMaterial.getText());
        return br;
    }

    private Model_DeGiay readFormDe() {
        Model_DeGiay br = new Model_DeGiay();
        br.setTenDeGiay(txtSoleName.getText());
        return br;
    }

    private Model_DeGiay readFormDe1() {
        Model_DeGiay br = new Model_DeGiay();
        br.setTenDeGiay(txtSoleName.getText());
        br.setMaDeGiay(Integer.parseInt(txtSoleID.getText()));
        return br;
    }

    private Model_Color readFormCo() {
        Model_Color br = new Model_Color();
        br.setColor_name(txtColor.getText());
        return br;
    }

    public interface QRCallback {

        void getQRdata(String qrCode);
    }
    private final BrandResponsitory brs = new BrandResponsitory();
    private final CategoryResponsitory cateRS = new CategoryResponsitory();
    private final ColorResponsitory colorRS = new ColorResponsitory();
    private final MaterialResponsitory materRS = new MaterialResponsitory();
    private final SizeResponsitory sizeRS = new SizeResponsitory();
    private final SoleResponsitory soleRS = new SoleResponsitory();
    DefaultTableModel modelSize, modelColor, modelBrand, modelSole, modelMaterial, modelCate = new DefaultTableModel();

    public Properties() {
        initComponents();
        //        setOpaque(false);
        //        btnStopSell.setVisible(false);
        //        btnOnSell.setVisible(false);
        modelSize = (DefaultTableModel) tblSize.getModel();
        modelColor = (DefaultTableModel) tblColor.getModel();
        modelBrand = (DefaultTableModel) tblBrand.getModel();
        modelSole = (DefaultTableModel) tblSole.getModel();
        modelMaterial = (DefaultTableModel) tblMaterial.getModel();
        modelCate = (DefaultTableModel) tblCategory.getModel();
        loadDataBrand();
        loadDataCate();
        loadDataMaterial();
        loadDataSole();
        loadDataColor();
        loadDataSize();
    }

    private void showDataBrand(int index) {
        txtBrandID.setText(tblBrand.getValueAt(index, 1).toString());
        txtBrandName.setText(tblBrand.getValueAt(index, 2).toString());
        tblBrand.setRowSelectionInterval(index, index);
    }

    private void showDataCate(int index) {
        txtIdCategory.setText(tblCategory.getValueAt(index, 1).toString());
        txtCategory.setText(tblCategory.getValueAt(index, 2).toString());
        tblCategory.setRowSelectionInterval(index, index);
    }

    private void showDataColor(int index) {
        txtColorID.setText(tblColor.getValueAt(index, 1).toString());
        txtColor.setText(tblColor.getValueAt(index, 2).toString());
        tblColor.setRowSelectionInterval(index, index);
    }

    private void showDataMaterial(int index) {
        txtMaterialID.setText(tblMaterial.getValueAt(index, 1).toString());
        txtMaterial.setText(tblMaterial.getValueAt(index, 2).toString());
        tblMaterial.setRowSelectionInterval(index, index);
    }

    private void showDataSole(int index) {
        txtSoleID.setText(tblSole.getValueAt(index, 1).toString());
        txtSoleName.setText(tblSole.getValueAt(index, 2).toString());
        tblSole.setRowSelectionInterval(index, index);
    }

    private void showDataSize(int index) {
        txtSizeID.setText(tblSize.getValueAt(index, 1).toString());
        txtSize.setText(tblSize.getValueAt(index, 2).toString());
        tblSize.setRowSelectionInterval(index, index);
    }

    private Model_Color readFormCo1() {
        Model_Color br = new Model_Color();
        br.setColor_name(txtColor.getText());
        br.setColor_id(Integer.parseInt(txtColorID.getText()));
        return br;
    }

    private SizeModel readFormSi() {
        SizeModel br = new SizeModel();
        br.setSize_Number(Double.parseDouble(txtSize.getText()));
        return br;
    }

    private SizeModel readFormSi1() {
        SizeModel br = new SizeModel();
        br.setSize_Number(Double.parseDouble(txtSize.getText()));
        br.setId_Size(Integer.parseInt(txtSizeID.getText()));
        return br;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        tabbedPaneProduct = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtBrandID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtBrandName = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        btnBrandClear = new javax.swing.JButton();
        btnAddBrand = new javax.swing.JButton();
        btnUpdateBrand = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBrand = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtIdCategory = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        btnClearCate = new javax.swing.JButton();
        btnAddCate = new javax.swing.JButton();
        btnUpdateCate = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCategory = new javax.swing.JTable();
        tab3 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        txtMaterialID = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtMaterial = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        btnClearMaterial = new javax.swing.JButton();
        btnAddMaterial = new javax.swing.JButton();
        btnUpdateMaterial = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblMaterial = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtSoleID = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtSoleName = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        btnSoleClear = new javax.swing.JButton();
        btnSoleAdd = new javax.swing.JButton();
        btnSoleUpdate = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSole = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtColorID = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        btnColorClear = new javax.swing.JButton();
        btnColorAdd = new javax.swing.JButton();
        btnColorUpdate = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblColor = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtSizeID = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        btnSizeClear = new javax.swing.JButton();
        btnSizeAdd = new javax.swing.JButton();
        btnSizeUpdate = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1025, 700));

        tabbedPaneProduct.setBackground(new java.awt.Color(255, 255, 255));
        tabbedPaneProduct.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        tabbedPaneProduct.setAutoscrolls(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tab1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(185, 213, 246));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setText("Mã");

        txtBrandID.setEditable(false);
        txtBrandID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));
        txtBrandID.setSelectionColor(new java.awt.Color(39, 80, 150));

        jLabel17.setText("Tên hãng");

        txtBrandName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBrandID, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrandName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtBrandID, txtBrandName});

        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrandID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrandName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel13Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtBrandID, txtBrandName});

        jPanel14.setBackground(new java.awt.Color(185, 213, 246));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnBrandClear.setBackground(new java.awt.Color(39, 80, 150));
        btnBrandClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBrandClear.setForeground(new java.awt.Color(255, 255, 255));
        btnBrandClear.setText("Làm mới");
        btnBrandClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrandClearActionPerformed(evt);
            }
        });

        btnAddBrand.setBackground(new java.awt.Color(39, 80, 150));
        btnAddBrand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddBrand.setForeground(new java.awt.Color(255, 255, 255));
        btnAddBrand.setText("Thêm mới");
        btnAddBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBrandActionPerformed(evt);
            }
        });

        btnUpdateBrand.setBackground(new java.awt.Color(39, 80, 150));
        btnUpdateBrand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateBrand.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateBrand.setText("Sửa");
        btnUpdateBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBrandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBrandClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddBrand, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(btnUpdateBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddBrand, btnBrandClear, btnUpdateBrand});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnAddBrand)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBrandClear, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddBrand, btnBrandClear, btnUpdateBrand});

        tblBrand.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên hãng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBrand.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblBrand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBrandMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBrand);

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(tab1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 192, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
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
                .addGap(0, 57, Short.MAX_VALUE))
        );

        tabbedPaneProduct.addTab("Hãng", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(185, 213, 246));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setText("Mã");

        txtIdCategory.setEditable(false);
        txtIdCategory.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));
        txtIdCategory.setSelectionColor(new java.awt.Color(39, 80, 150));

        jLabel20.setText("Tên danh mục");

        txtCategory.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(txtIdCategory))
                .addGap(16, 16, 16))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(185, 213, 246));
        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnClearCate.setBackground(new java.awt.Color(39, 80, 150));
        btnClearCate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClearCate.setForeground(new java.awt.Color(255, 255, 255));
        btnClearCate.setText("Làm mới");
        btnClearCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCateActionPerformed(evt);
            }
        });

        btnAddCate.setBackground(new java.awt.Color(39, 80, 150));
        btnAddCate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddCate.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCate.setText("Thêm mới");
        btnAddCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCateActionPerformed(evt);
            }
        });

        btnUpdateCate.setBackground(new java.awt.Color(39, 80, 150));
        btnUpdateCate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateCate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateCate.setText("Sửa");
        btnUpdateCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClearCate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddCate, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(btnUpdateCate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnAddCate)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateCate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClearCate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel17Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddCate, btnClearCate, btnUpdateCate});

        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên danh mục"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoryMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblCategory);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 192, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
        );

        tabbedPaneProduct.addTab("Danh mục", jPanel1);

        tab3.setBackground(new java.awt.Color(255, 255, 255));
        tab3.setPreferredSize(new java.awt.Dimension(1015, 800));

        jPanel27.setBackground(new java.awt.Color(185, 213, 246));
        jPanel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel42.setText("Mã");

        txtMaterialID.setEditable(false);
        txtMaterialID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));
        txtMaterialID.setSelectionColor(new java.awt.Color(39, 80, 150));

        jLabel43.setText("Tên chất liệu");

        txtMaterial.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addGap(22, 22, 22)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaterialID, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel27Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMaterial, txtMaterialID});

        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaterialID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel28.setBackground(new java.awt.Color(185, 213, 246));
        jPanel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnClearMaterial.setBackground(new java.awt.Color(39, 80, 150));
        btnClearMaterial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClearMaterial.setForeground(new java.awt.Color(255, 255, 255));
        btnClearMaterial.setText("Làm mới");
        btnClearMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearMaterialActionPerformed(evt);
            }
        });

        btnAddMaterial.setBackground(new java.awt.Color(39, 80, 150));
        btnAddMaterial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddMaterial.setForeground(new java.awt.Color(255, 255, 255));
        btnAddMaterial.setText("Thêm mới");
        btnAddMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMaterialActionPerformed(evt);
            }
        });

        btnUpdateMaterial.setBackground(new java.awt.Color(39, 80, 150));
        btnUpdateMaterial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateMaterial.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateMaterial.setText("Sửa");
        btnUpdateMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMaterialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClearMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(btnUpdateMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddMaterial, btnClearMaterial, btnUpdateMaterial});

        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnAddMaterial)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClearMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel28Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddMaterial, btnClearMaterial, btnUpdateMaterial});

        tblMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên chất liệu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaterialMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblMaterial);

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addGroup(tab3Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 192, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        tabbedPaneProduct.addTab("Chất liệu", tab3);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel40.setText("Mã");

        txtSoleID.setEditable(false);
        txtSoleID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));
        txtSoleID.setSelectionColor(new java.awt.Color(39, 80, 150));

        jLabel41.setText("Tên đế");

        txtSoleName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoleID, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoleName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtSoleID, txtSoleName});

        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoleID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoleName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new java.awt.Color(185, 213, 246));
        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSoleClear.setBackground(new java.awt.Color(39, 80, 150));
        btnSoleClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSoleClear.setForeground(new java.awt.Color(255, 255, 255));
        btnSoleClear.setText("Làm mới");
        btnSoleClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoleClearActionPerformed(evt);
            }
        });

        btnSoleAdd.setBackground(new java.awt.Color(39, 80, 150));
        btnSoleAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSoleAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnSoleAdd.setText("Thêm mới");
        btnSoleAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoleAddActionPerformed(evt);
            }
        });

        btnSoleUpdate.setBackground(new java.awt.Color(39, 80, 150));
        btnSoleUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSoleUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnSoleUpdate.setText("Sửa");
        btnSoleUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoleUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSoleClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSoleAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(btnSoleUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel26Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSoleAdd, btnSoleClear, btnSoleUpdate});

        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnSoleAdd)
                .addGap(18, 18, 18)
                .addComponent(btnSoleUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSoleClear, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel26Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSoleAdd, btnSoleClear, btnSoleUpdate});

        tblSole.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên đế giày"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSole.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblSole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSoleMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblSole);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        tabbedPaneProduct.addTab("Đế giày", jPanel7);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jPanel23.setBackground(new java.awt.Color(185, 213, 246));
        jPanel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel38.setText("Mã");

        txtColorID.setEditable(false);
        txtColorID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));
        txtColorID.setSelectionColor(new java.awt.Color(39, 80, 150));

        jLabel39.setText("Tên màu");

        txtColor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtColorID, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel23Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtColor, txtColorID});

        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColorID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(185, 213, 246));
        jPanel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnColorClear.setBackground(new java.awt.Color(39, 80, 150));
        btnColorClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnColorClear.setForeground(new java.awt.Color(255, 255, 255));
        btnColorClear.setText("Làm mới");

        btnColorAdd.setBackground(new java.awt.Color(39, 80, 150));
        btnColorAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnColorAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnColorAdd.setText("Thêm mới");
        btnColorAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorAddActionPerformed(evt);
            }
        });

        btnColorUpdate.setBackground(new java.awt.Color(39, 80, 150));
        btnColorUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnColorUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnColorUpdate.setText("Sửa");
        btnColorUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnColorClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnColorAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(btnColorUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel24Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnColorAdd, btnColorClear, btnColorUpdate});

        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnColorAdd)
                .addGap(18, 18, 18)
                .addComponent(btnColorUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnColorClear, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel24Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnColorAdd, btnColorClear, btnColorUpdate});

        tblColor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên màu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblColor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblColorMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblColor);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 192, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        tabbedPaneProduct.addTab("Màu", jPanel16);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(185, 213, 246));
        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel28.setText("Mã");

        txtSizeID.setEditable(false);
        txtSizeID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));
        txtSizeID.setSelectionColor(new java.awt.Color(39, 80, 150));

        jLabel37.setText("Kích thước");

        txtSize.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(39, 80, 150)));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSizeID, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel21Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtSize, txtSizeID});

        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSizeID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(185, 213, 246));
        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSizeClear.setBackground(new java.awt.Color(39, 80, 150));
        btnSizeClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSizeClear.setForeground(new java.awt.Color(255, 255, 255));
        btnSizeClear.setText("Làm mới");

        btnSizeAdd.setBackground(new java.awt.Color(39, 80, 150));
        btnSizeAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSizeAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnSizeAdd.setText("Thêm mới");
        btnSizeAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSizeAddActionPerformed(evt);
            }
        });

        btnSizeUpdate.setBackground(new java.awt.Color(39, 80, 150));
        btnSizeUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSizeUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnSizeUpdate.setText("Sửa");
        btnSizeUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSizeUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSizeClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSizeAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(btnSizeUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel22Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnSizeAdd, btnSizeClear, btnSizeUpdate});

        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnSizeAdd)
                .addGap(18, 18, 18)
                .addComponent(btnSizeUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSizeClear, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel22Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnSizeAdd, btnSizeClear, btnSizeUpdate});

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Kích thước"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSize.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSize);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 192, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        tabbedPaneProduct.addTab("Kích thước", jPanel18);

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

        tabbedPaneProduct.getAccessibleContext().setAccessibleName("Hãng");
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBrandActionPerformed
        if (txtBrandName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thuộc tính");
            txtBrandName.requestFocus();
            return;
        }
        if (txtBrandName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Brand không được nhập số");
            txtBrandName.requestFocus();
            return;
        }
        ArrayList<Model_Brand> lst = brs.getALl();
        for (Model_Brand br : lst) {
            if (txtBrandName.getText().equals(br.getBrand_name())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Model_Brand br = readFormBr();
        if (brs.addBrand(br) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataBrand();

        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnAddBrandActionPerformed

    private void btnUpdateBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBrandActionPerformed
        int index = tblBrand.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng cần sửa");
            return;
        }
        if (txtBrandName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thuộc tính");
            txtBrandName.requestFocus();
            return;
        }
        if (txtBrandName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Brand không được nhập số");
            txtBrandName.requestFocus();
            return;
        }
        ArrayList<Model_Brand> lst = brs.getALl();
        for (Model_Brand br : lst) {
            if (txtBrandName.getText().equals(br.getBrand_name())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Model_Brand br = readFormBr1();
        if (brs.upDateBrand(br) != null) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            loadDataBrand();

        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnUpdateBrandActionPerformed

    private void btnBrandClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrandClearActionPerformed
        txtBrandID.setText("");
        txtBrandName.setText("");
    }//GEN-LAST:event_btnBrandClearActionPerformed

    private void btnAddCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCateActionPerformed
        if (txtCategory.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập loại giày");
            txtCategory.requestFocus();
            return;
        }
        if (txtCategory.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Loại giày không được nhập số");
            txtCategory.requestFocus();
            return;
        }
        ArrayList<Model_Category> lst = cateRS.getALl();
        for (Model_Category cate : lst) {
            if (txtCategory.getText().equals(cate.getCategory_name())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Model_Category cate = readForm();
        if (cateRS.addCategory(cate) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataCate();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnAddCateActionPerformed

    private void btnUpdateCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCateActionPerformed
        int index = tblCategory.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng cần sửa");
            return;
        }
        if (txtCategory.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập loại giày");
            txtCategory.requestFocus();
            return;
        }
        if (txtCategory.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Loại giày không được nhập số");
            txtCategory.requestFocus();
            return;
        }
        ArrayList<Model_Category> lst = cateRS.getALl();
        for (Model_Category cate : lst) {
            if (txtCategory.getText().equals(cate.getCategory_name())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Model_Category cate = readForm1();
        if (cateRS.upDateCategory(cate) != null) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            loadDataCate();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnUpdateCateActionPerformed

    private void btnClearCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCateActionPerformed
        txtCategory.setText("");
        txtIdCategory.setText("");
    }//GEN-LAST:event_btnClearCateActionPerformed

    private void btnAddMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMaterialActionPerformed
        if (txtMaterial.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thuộc tính");
            txtMaterial.requestFocus();
            return;
        }
        if (txtMaterial.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Material không được nhập số");
            txtMaterial.requestFocus();
            return;
        }
        ArrayList<Material> lst = materRS.getAll();
        for (Material co : lst) {
            if (txtMaterial.getText().equals(co.getNameMaterial())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Material co = readFormMa();
        if (materRS.addMaterial(co) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataMaterial();

        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnAddMaterialActionPerformed

    private void btnUpdateMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMaterialActionPerformed
        int index = tblMaterial.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng cần sửa");
            return;
        }
        if (txtMaterial.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thuộc tính");
            txtMaterial.requestFocus();
            return;
        }
        if (txtMaterial.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Material không được nhập số");
            txtMaterial.requestFocus();
            return;
        }
        ArrayList<Material> lst = materRS.getAll();
        for (Material co : lst) {
            if (txtMaterial.getText().equals(co.getNameMaterial())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Material co = readFormMa1();
        if (materRS.addMaterial(co) != null) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            loadDataMaterial();

        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnUpdateMaterialActionPerformed

    private void btnClearMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearMaterialActionPerformed
        txtMaterialID.setText("");
        txtMaterial.setText("");

    }//GEN-LAST:event_btnClearMaterialActionPerformed

    private void btnSoleAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoleAddActionPerformed
        if (txtSoleName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên Đế Giày");
            txtSoleName.requestFocus();
            return;
        }
        if (txtSoleName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Tên Đế giày không được nhập số");
            txtSoleName.requestFocus();
            return;
        }
        ArrayList<Model_DeGiay> lst = soleRS.getAll();
        for (Model_DeGiay co : lst) {
            if (txtSoleName.getText().equals(co.getTenDeGiay())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Model_DeGiay dg = readFormDe();
        if (soleRS.addSole(dg) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataSole();

        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnSoleAddActionPerformed

    private void btnSoleUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoleUpdateActionPerformed
        int index = tblSole.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng cần sửa");
            return;
        }
        if (txtSoleName.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên Đế Giày");
            txtSoleName.requestFocus();
            return;
        }
        if (txtSoleName.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Tên Đế giày không được nhập số");
            txtSoleName.requestFocus();
            return;
        }
        ArrayList<Model_DeGiay> lst = soleRS.getAll();
        for (Model_DeGiay co : lst) {
            if (txtSoleName.getText().equals(co.getTenDeGiay())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Model_DeGiay dg = readFormDe1();
        if (soleRS.updateSole(dg) != null) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            loadDataSole();

        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnSoleUpdateActionPerformed

    private void btnColorAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorAddActionPerformed
        if (txtColor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thuộc tính");
            txtColor.requestFocus();
            return;
        }
        if (txtColor.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Color không được nhập số");
            txtColor.requestFocus();
            return;
        }
        ArrayList<Model_Color> lst = colorRS.getALl();
        for (Model_Color co : lst) {
            if (txtColor.getText().equals(co.getColor_name())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Model_Color co = readFormCo();
        if (colorRS.addColor(co) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataColor();

        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnColorAddActionPerformed

    private void btnSoleClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoleClearActionPerformed
        txtSoleID.setText("");
        txtSoleName.setText("");

    }//GEN-LAST:event_btnSoleClearActionPerformed

    private void tblBrandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBrandMouseClicked
        int index = tblBrand.getSelectedRow();
        showDataBrand(index);
    }//GEN-LAST:event_tblBrandMouseClicked

    private void tblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoryMouseClicked
        int index = tblCategory.getSelectedRow();
        showDataCate(index);
    }//GEN-LAST:event_tblCategoryMouseClicked

    private void tblMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaterialMouseClicked
        int index = tblMaterial.getSelectedRow();
        showDataMaterial(index);
    }//GEN-LAST:event_tblMaterialMouseClicked

    private void tblSoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSoleMouseClicked
        int index = tblSole.getSelectedRow();
        showDataSole(index);
    }//GEN-LAST:event_tblSoleMouseClicked

    private void tblColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblColorMouseClicked
        int index = tblColor.getSelectedRow();
        showDataColor(index);
    }//GEN-LAST:event_tblColorMouseClicked

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        int index = tblSize.getSelectedRow();
        showDataSize(index);
    }//GEN-LAST:event_tblSizeMouseClicked

    private void btnColorUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorUpdateActionPerformed
        if (txtColorID.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng cần sửa");
            
            return;
        }
        if (txtColor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thuộc tính");
            txtColor.requestFocus();
            return;
        }
        if (txtColor.getText().trim().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Color không được nhập số");
            txtColor.requestFocus();
            return;
        }
        ArrayList<Model_Color> lst = colorRS.getALl();
        for (Model_Color co : lst) {
            if (txtColor.getText().equals(co.getColor_name())) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        Model_Color co = readFormCo1();
        if (colorRS.upDateColor(co) != null) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            loadDataColor();

        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnColorUpdateActionPerformed

    private void btnSizeUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSizeUpdateActionPerformed
        if (txtSizeID.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng cần sửa");
            return;
        }
        if (txtSize.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Size giày");
            txtSize.requestFocus();
            return;
        }
        try {
            double size_Number = Double.parseDouble(txtSize.getText());
            if (size_Number < 1 || size_Number > 50) {
                JOptionPane.showMessageDialog(this, "Size giày nằm trong khoảng 1 -50");
                txtSize.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Size giày phải là số");
            txtSize.requestFocus();
            return;
        }
        ArrayList<SizeModel> lst = sizeRS.getAll();
        for (SizeModel co : lst) {
            if (Double.parseDouble(txtSize.getText()) == co.getSize_Number()) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        SizeModel dg = readFormSi1();
        if (sizeRS.updateSize(dg) != null) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            loadDataSize();

        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnSizeUpdateActionPerformed

    private void btnSizeAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSizeAddActionPerformed
        if (txtSize.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Size giày");
            txtSize.requestFocus();
            return;
        }
        try {
            double size_Number = Double.parseDouble(txtSize.getText());
            if (size_Number < 1 || size_Number > 50) {
                JOptionPane.showMessageDialog(this, "Size giày nằm trong khoảng 1 -50");
                txtSize.requestFocus();
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Size giày phải là số");
            txtSize.requestFocus();
            return;
        }
        ArrayList<SizeModel> lst = sizeRS.getAll();
        for (SizeModel co : lst) {
            if (Double.parseDouble(txtSize.getText()) == co.getSize_Number()) {
                JOptionPane.showMessageDialog(this, "Thuộc tính này đã tồn tại");
                return;
            }
        }
        SizeModel dg = readFormSi();
        if (sizeRS.addSize(dg) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataSize();

        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btnSizeAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBrand;
    private javax.swing.JButton btnAddCate;
    private javax.swing.JButton btnAddMaterial;
    private javax.swing.JButton btnBrandClear;
    private javax.swing.JButton btnClearCate;
    private javax.swing.JButton btnClearMaterial;
    private javax.swing.JButton btnColorAdd;
    private javax.swing.JButton btnColorClear;
    private javax.swing.JButton btnColorUpdate;
    private javax.swing.JButton btnSizeAdd;
    private javax.swing.JButton btnSizeClear;
    private javax.swing.JButton btnSizeUpdate;
    private javax.swing.JButton btnSoleAdd;
    private javax.swing.JButton btnSoleClear;
    private javax.swing.JButton btnSoleUpdate;
    private javax.swing.JButton btnUpdateBrand;
    private javax.swing.JButton btnUpdateCate;
    private javax.swing.JButton btnUpdateMaterial;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab3;
    private javax.swing.JTabbedPane tabbedPaneProduct;
    private javax.swing.JTable tblBrand;
    private javax.swing.JTable tblCategory;
    private javax.swing.JTable tblColor;
    private javax.swing.JTable tblMaterial;
    private javax.swing.JTable tblSize;
    private javax.swing.JTable tblSole;
    private javax.swing.JTextField txtBrandID;
    private javax.swing.JTextField txtBrandName;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtColorID;
    private javax.swing.JTextField txtIdCategory;
    private javax.swing.JTextField txtMaterial;
    private javax.swing.JTextField txtMaterialID;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtSizeID;
    private javax.swing.JTextField txtSoleID;
    private javax.swing.JTextField txtSoleName;
    // End of variables declaration//GEN-END:variables
}
