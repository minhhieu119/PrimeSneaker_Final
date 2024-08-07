package com.prime.form;

import com.prime.dialog.Message;
import com.prime.main.Main;
import com.prime.model.ModelCard;
import com.prime.services.StatisticService;
import com.prime.swing.icon.GoogleMaterialDesignIcons;
import com.prime.swing.icon.IconFontSwing;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import jdk.jfr.consumer.EventStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Statistic extends javax.swing.JPanel {

    int index;
    StatisticService ss = new StatisticService();
    DefaultTableModel modelStatisticWeek = new DefaultTableModel();
    DefaultTableModel modelStatisticTable = new DefaultTableModel();

    public Statistic() throws SQLException {
        initComponents();
        setOpaque(false);
        jdcStart.setDateFormatString("dd/MM/yyyy");
        jdcEnd.setDateFormatString("dd/MM/yyyy");
        fillToWeekTable(ss.getStatisticOneWeek());
        initData();
        showChart(pnlChart);
        disableOption();
    }

    private void fillToWeekTable(List<com.prime.main_model.Statistic> list) throws SQLException {
        index = 0;
        modelStatisticWeek = (DefaultTableModel) tblDoanhThuTuan.getModel();
        modelStatisticWeek.setRowCount(0);
        for (com.prime.main_model.Statistic s : list) {
            modelStatisticWeek.addRow(new Object[]{
                index += 1,
                s.getCreatedAt(),
                s.getTotalCost()
            });
        }
    }

    private void fillToStatisticYear(List<com.prime.main_model.Statistic> list) throws SQLException {
        index = 0;
        modelStatisticTable = (DefaultTableModel) tblStatistic.getModel();
        modelStatisticTable.setRowCount(0);
        for (com.prime.main_model.Statistic s : list) {
            modelStatisticTable.addRow(new Object[]{
                index += 1,
                s.getMonth(),
                s.getQuantity(),
                s.getTotalCost()
            });
        }
    }

    private void fillToStatisticMonth(List<com.prime.main_model.Statistic> list) throws SQLException {
        index = 0;
        modelStatisticTable = (DefaultTableModel) tblStatistic.getModel();
        modelStatisticTable.setRowCount(0);
        for (com.prime.main_model.Statistic s : list) {
            modelStatisticTable.addRow(new Object[]{
                index += 1,
                s.getDate(),
                s.getQuantity(),
                s.getTotalCost()
            });
        }
    }

    private void fillToStatisticDay(List<com.prime.main_model.Statistic> list) throws SQLException {
        index = 0;
        modelStatisticTable = (DefaultTableModel) tblStatistic.getModel();
        modelStatisticTable.setRowCount(0);
        for (com.prime.main_model.Statistic s : list) {
            modelStatisticTable.addRow(new Object[]{
                index += 1,
                s.getCreatedAt(),
                s.getQuantity(),
                s.getTotalCost()
            });
        }
    }

    private void disableOption() {
        lblYear.setVisible(false);
        lblMonth.setVisible(false);
        lblStartDate.setVisible(false);
        lblEndDate.setVisible(false);
        cboYear.setVisible(false);
        cboMonth.setVisible(false);
        jdcStart.setVisible(false);
        jdcEnd.setVisible(false);
    }

    private void initData() {
        initCardData();
    }

    private void initCardData() {
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_BASKET, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        try {
            card1.setData(new ModelCard("Doanh thu", ss.getTotalCost(), 100, icon2));

            card2.setData(new ModelCard("Sản phẩm", ss.getQuantitySneakerDetail(), 100, icon3));

            card3.setData(new ModelCard("Nhân viên", ss.getQuantityStaff(), 100, icon4));

            card4.setData(new ModelCard("Khách hàng", ss.getQuantityCustomer(), 100, icon1));
        } catch (Exception e) {
        }
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    public void showChart(JPanel jpn) throws SQLException {

        final DefaultCategoryDataset d = new DefaultCategoryDataset();
        for (com.prime.main_model.Statistic s : ss.getStatisticOneWeek()) {
            d.addValue(s.getTotalCost(), "VNĐ", s.getCreatedAt());
        }
        JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ doanh thu 7 ngày gần nhất", "Ngày", "Tổng tiền", d);
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, new Color(39, 80, 150));
        renderer.setMaximumBarWidth(0.03);
        plot.setRenderer(renderer);
        ChartPanel c = new ChartPanel(barChart);
        c.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(c);
        jpn.validate();
        jpn.repaint();
    }

    public void showChartStatisticYear(JPanel jpn, String year) throws SQLException {

        final DefaultCategoryDataset d = new DefaultCategoryDataset();
        for (com.prime.main_model.Statistic s : ss.getStatisticYear(year)) {
            d.addValue(s.getTotalCost(), "VNĐ", s.getMonth() + "");
        }
        JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ doanh thu theo năm", "Tháng", "Tổng tiền", d);
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, new Color(39, 80, 150));
        renderer.setMaximumBarWidth(0.03);
        plot.setRenderer(renderer);
        ChartPanel c = new ChartPanel(barChart);
        c.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(c);
        jpn.validate();
        jpn.repaint();
    }

    public void showChartStatisticMonth(JPanel jpn, String year, String month) throws SQLException {

        final DefaultCategoryDataset d = new DefaultCategoryDataset();
        for (com.prime.main_model.Statistic s : ss.getStatisticMonth(year, month)) {
            d.addValue(s.getTotalCost(), "VNĐ", s.getDate() + "");
        }
        JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ doanh thu theo tháng", "Ngày", "Tổng tiền", d);
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, new Color(39, 80, 150));
        renderer.setMaximumBarWidth(0.03);
        plot.setRenderer(renderer);
        ChartPanel c = new ChartPanel(barChart);
        c.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(c);
        jpn.validate();
        jpn.repaint();
    }

    public void showChartStatisticDay(JPanel jpn, String startDate, String endDate) throws SQLException {

        final DefaultCategoryDataset d = new DefaultCategoryDataset();
        for (com.prime.main_model.Statistic s : ss.getStatisticDay(startDate, endDate)) {
            d.addValue(s.getTotalCost(), "VNĐ", s.getCreatedAt() + "");
        }
        JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ doanh thu theo từ ngày đến ngày", "Ngày", "Tổng tiền", d);
        CategoryPlot plot = barChart.getCategoryPlot();
        BarRenderer renderer = new BarRenderer();
        renderer.setSeriesPaint(0, new Color(39, 80, 150));
        renderer.setMaximumBarWidth(0.03);
        plot.setRenderer(renderer);
        ChartPanel c = new ChartPanel(barChart);
        c.setPreferredSize(new Dimension(jpn.getWidth(), 300));
        jpn.removeAll();
        jpn.setLayout(new CardLayout());
        jpn.add(c);
        jpn.validate();
        jpn.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabTong = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        card1 = new com.prime.component.Card();
        card2 = new com.prime.component.Card();
        card3 = new com.prime.component.Card();
        card4 = new com.prime.component.Card();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoanhThuTuan = new javax.swing.JTable();
        pnlChart = new javax.swing.JPanel();
        btnExcel = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        lblMonth = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        jdcStart = new com.toedter.calendar.JDateChooser();
        jdcEnd = new com.toedter.calendar.JDateChooser();
        lblEndDate = new javax.swing.JLabel();
        cboStatisticOption = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStatistic = new javax.swing.JTable();
        pnlStatistic = new javax.swing.JPanel();
        cboYear = new javax.swing.JComboBox<>();
        cboMonth = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        tabTong.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        card1.setColorGradient(new java.awt.Color(211, 28, 215));

        card2.setBackground(new java.awt.Color(10, 30, 214));
        card2.setColorGradient(new java.awt.Color(72, 111, 252));

        card3.setBackground(new java.awt.Color(194, 85, 1));
        card3.setColorGradient(new java.awt.Color(255, 212, 99));

        card4.setBackground(new java.awt.Color(60, 195, 0));
        card4.setColorGradient(new java.awt.Color(208, 255, 90));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Doanh thu tuần gần nhất"));

        tblDoanhThuTuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ngày", "Doanh thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDoanhThuTuan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlChart.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlChartLayout = new javax.swing.GroupLayout(pnlChart);
        pnlChart.setLayout(pnlChartLayout);
        pnlChartLayout.setHorizontalGroup(
            pnlChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlChartLayout.setVerticalGroup(
            pnlChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

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
                .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        tabTong.addTab("Tổng quan", jPanel6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Thống kê doanh thu");

        jLabel2.setText("Thống kê theo thời gian:");

        lblYear.setText("Năm");

        lblMonth.setText("Tháng");

        lblStartDate.setText("Từ ngày");

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

        lblEndDate.setText("Đến ngày");

        cboStatisticOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "Năm", "Tháng", "Ngày" }));
        cboStatisticOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboStatisticOptionActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảng thống kê doanh thu"));

        tblStatistic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Thời gian", "Số lượng sản phẩm", "Doanh thu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblStatistic);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlStatistic.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlStatisticLayout = new javax.swing.GroupLayout(pnlStatistic);
        pnlStatistic.setLayout(pnlStatisticLayout);
        pnlStatisticLayout.setHorizontalGroup(
            pnlStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlStatisticLayout.setVerticalGroup(
            pnlStatisticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        cboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024" }));
        cboYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboYearActionPerformed(evt);
            }
        });

        cboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cboMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMonthActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(39, 80, 150));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xuất Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cboStatisticOption, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(lblYear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(lblMonth)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(lblStartDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEndDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlStatistic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jdcEnd, jdcStart});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboStatisticOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblYear)
                                .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMonth)
                                .addComponent(cboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEndDate)
                            .addComponent(jdcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStartDate))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlStatistic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        tabTong.addTab("Doanh thu", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabTong)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabTong, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jdcStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcStartPropertyChange
//        System.out.println();
    }//GEN-LAST:event_jdcStartPropertyChange

    private void jdcEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcEndPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            Date startDate = jdcStart.getDate();
            Date endDate = jdcEnd.getDate();
            if (startDate != null && endDate != null) {
                if (endDate.before(startDate)) {
                    JOptionPane.showMessageDialog(this, "Đến ngày không được trước từ ngày");
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng ngày chỉ lấy ngày trong tháng
                String startDay = sdf.format(startDate); // Chuyển đổi ngày thành chuỗi
                String endDay = sdf.format(endDate);
                try {
                    //                System.out.println(startDay + " - " + endDay);
                    fillToStatisticDay(ss.getStatisticDay(startDay, endDay));
                    showChartStatisticDay(pnlStatistic, startDay, endDay);
                } catch (SQLException ex) {
                    Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Không có ngày nào được chọn");
            }
        }

    }//GEN-LAST:event_jdcEndPropertyChange

    private void cboStatisticOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboStatisticOptionActionPerformed
        if (cboStatisticOption.getSelectedIndex() == 0) {

        } else if (cboStatisticOption.getSelectedIndex() == 1) {
            lblYear.setVisible(true);
            cboYear.setVisible(true);
            lblMonth.setVisible(false);
            cboMonth.setVisible(false);
            lblStartDate.setVisible(false);
            lblEndDate.setVisible(false);
            jdcStart.setVisible(false);
            jdcEnd.setVisible(false);
            try {
                fillToStatisticYear(ss.getStatisticYear(cboYear.getSelectedItem() + ""));
                showChartStatisticYear(pnlStatistic, cboYear.getSelectedItem() + "");
            } catch (SQLException ex) {
                Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (cboStatisticOption.getSelectedIndex() == 2) {
            lblYear.setVisible(true);
            cboYear.setVisible(true);
            lblMonth.setVisible(true);
            cboMonth.setVisible(true);
            lblStartDate.setVisible(false);
            lblEndDate.setVisible(false);
            jdcStart.setVisible(false);
            jdcEnd.setVisible(false);
            try {
                fillToStatisticMonth(ss.getStatisticMonth(cboYear.getSelectedItem() + "", cboMonth.getSelectedItem() + ""));
                showChartStatisticMonth(pnlStatistic, cboYear.getSelectedItem() + "", cboMonth.getSelectedItem() + "");
            } catch (SQLException ex) {
                Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            lblYear.setVisible(false);
            cboYear.setVisible(false);
            lblMonth.setVisible(false);
            cboMonth.setVisible(false);
            lblStartDate.setVisible(true);
            lblEndDate.setVisible(true);
            jdcStart.setVisible(true);
            jdcEnd.setVisible(true);
            jdcStart.setDate(null);
            jdcEnd.setDate(null);
            try {
                fillToStatisticDay(ss.getStatisticDay("1900-01-01", "1900-01-01"));
                showChartStatisticDay(pnlStatistic, "1900-01-01", "1900-01-01");
            } catch (SQLException ex) {
                Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cboStatisticOptionActionPerformed

    private void cboYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboYearActionPerformed
        try {
            fillToStatisticYear(ss.getStatisticYear(cboYear.getSelectedItem() + ""));
            showChartStatisticYear(pnlStatistic, cboYear.getSelectedItem() + "");
        } catch (SQLException ex) {
            Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboYearActionPerformed

    private void cboMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMonthActionPerformed
        try {
            fillToStatisticMonth(ss.getStatisticMonth(cboYear.getSelectedItem() + "", cboMonth.getSelectedItem() + ""));
            showChartStatisticMonth(pnlStatistic, cboYear.getSelectedItem() + "", cboMonth.getSelectedItem() + "");
        } catch (SQLException ex) {
            Logger.getLogger(Statistic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboMonthActionPerformed

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
                for (int i = 0; i < tblDoanhThuTuan.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblDoanhThuTuan.getColumnName(i));
                }
                for (int j = 0; j < tblDoanhThuTuan.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblDoanhThuTuan.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblDoanhThuTuan.getValueAt(j, k) != null) {
                            cell.setCellValue(tblDoanhThuTuan.getValueAt(j, k).toString());
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Account");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblStatistic.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblStatistic.getColumnName(i));
                }
                for (int j = 0; j < tblStatistic.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblStatistic.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblStatistic.getValueAt(j, k) != null) {
                            cell.setCellValue(tblStatistic.getValueAt(j, k).toString());
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
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private com.prime.component.Card card1;
    private com.prime.component.Card card2;
    private com.prime.component.Card card3;
    private com.prime.component.Card card4;
    private javax.swing.JComboBox<String> cboMonth;
    private javax.swing.JComboBox<String> cboStatisticOption;
    private javax.swing.JComboBox<String> cboYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcEnd;
    private com.toedter.calendar.JDateChooser jdcStart;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblYear;
    private javax.swing.JPanel pnlChart;
    private javax.swing.JPanel pnlStatistic;
    private javax.swing.JTabbedPane tabTong;
    private javax.swing.JTable tblDoanhThuTuan;
    private javax.swing.JTable tblStatistic;
    // End of variables declaration//GEN-END:variables
}
