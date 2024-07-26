/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.services;

import com.prime.main_model.Bill;
import com.prime.main_model.BillDetail;
import com.prime.untilities.ConnectionJDBC;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillService {

    Connection con = ConnectionJDBC.getConnection();
    PreparedStatement pstm = null;
    ResultSet rs = null;
    String sql = null;

    public ArrayList<Bill> getAllBill() {
        ArrayList<Bill> listOrder = new ArrayList<>();
        String sql = "SELECT dbo.[Order].order_id, "
                + " dbo.[User].user_code, "
                + " dbo.Customer.full_name, "
                + " dbo.[Order].payment_method, "
                + " SUM(dbo.OrderDetail.quantity * dbo.OrderDetail.price) as total_cost, "
                + " dbo.[Order].created_at "
                + " FROM "
                + " dbo.[Order] LEFT JOIN "
                + " dbo.[User] ON dbo.[Order].user_id = dbo.[User].user_id LEFT JOIN "
                + " dbo.Customer ON dbo.[Order].customer_id = dbo.Customer.customer_id LEFT JOIN "
                + " dbo.OrderDetail ON dbo.OrderDetail.order_id = dbo.[Order].order_id "
                + " WHERE  dbo.[Order].status LIKE N'Đã thanh toán' "
                + " GROUP BY dbo.[Order].order_id, dbo.[User].user_code, dbo.Customer.full_name, dbo.[Order].payment_method, dbo.[Order].created_at "
                + " ORDER BY dbo.[Order].order_id ASC";
        try {
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setOrder_Id(rs.getInt("order_id"));
                bill.setStaff_id(rs.getString("user_code"));
                bill.setNameCustomer(rs.getString("full_name"));
                bill.setPaymentMethod(rs.getString("payment_method"));
                bill.setTotalCost(BigDecimal.ZERO);
                bill.setCreatedDay(rs.getDate("created_at"));
                listOrder.add(bill);
            }
        } catch (Exception e) {
            Logger.getLogger(BillService.class.getName()).log(Level.SEVERE, null, e);
        }
        return listOrder;
    }

    public List<Bill> timKiem(String timKiem, String hinhThucTT, String ngayBatDau, String ngayKetThuc) {
        List<Bill> listBillSearch = new ArrayList<>();

        String sql = "SELECT "
                + " DISTINCT dbo.[Order].order_id, "
                + " dbo.[User].user_code, "
                + " dbo.Customer.full_name, "
                + " dbo.[Order].payment_method, "
                + " SUM(dbo.OrderDetail.quantity * dbo.OrderDetail.price) as total_cost, "
                + " dbo.[Order].created_at "
                + " FROM dbo.[Order] "
                + " LEFT JOIN "
                + " dbo.Customer ON dbo.Customer.customer_id = dbo.[Order].customer_id "
                + " LEFT JOIN "
                + " dbo.[User] ON dbo.[Order].user_id = dbo.[User].user_id "
                + " LEFT JOIN "
                + " dbo.OrderDetail ON dbo.OrderDetail.order_id = dbo.[Order].order_id "
                + " WHERE dbo.[Order].status LIKE N'Đã thanh toán' "
                + " AND ( ? IS NULL OR dbo.[Order].payment_method LIKE ? ) "
                + " AND dbo.[Order].created_at BETWEEN ? AND ? "
                + " AND ( ? IS NULL OR dbo.[Order].order_id LIKE ? "
                + " OR dbo.[User].user_code LIKE ? "
                + " OR dbo.Customer.full_name LIKE ? ) "
                + " GROUP BY dbo.[Order].order_id, dbo.[User].user_code, dbo.Customer.full_name, dbo.[Order].payment_method, dbo.[Order].created_at"
                + " ORDER BY dbo.[Order].order_id ASC";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, hinhThucTT);
            pstm.setString(2, hinhThucTT);
            pstm.setString(3, ngayBatDau);
            pstm.setString(4, ngayKetThuc);
            pstm.setString(5, timKiem);
            pstm.setString(6, timKiem);
            pstm.setString(7, "%" + timKiem + "%");
            pstm.setString(8, "%" + timKiem + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setOrder_Id(rs.getInt("order_id"));
                bill.setStaff_id(rs.getString("user_code"));
                bill.setNameCustomer(rs.getString("full_name"));
                bill.setPaymentMethod(rs.getString("payment_method"));
                bill.setTotalCost(rs.getBigDecimal("total_cost"));
                bill.setCreatedDay(rs.getDate("created_at"));
                listBillSearch.add(bill);
            }
            return listBillSearch;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public List<BillDetail> getOrderDetai(int OrderId) {
        List<BillDetail> billDetail = new ArrayList<>();
        String sql = "SELECT [Order].order_id, "
                + "		Sneaker.sneaker_name, "
                + "		OrderDetail.quantity, "
                + "		OrderDetail.price "
                + "FROM [Order] "
                + "	JOIN OrderDetail ON [Order].order_id = OrderDetail.order_id "
                + "	JOIN SneakerDetail ON OrderDetail.sneaker_detail_id = SneakerDetail.sneaker_detail_id "
                + "	JOIN Sneaker ON SneakerDetail.sneaker_id = Sneaker.sneaker_id "
                + "Where [Order].order_id = ?";

        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, OrderId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BillDetail spct = new BillDetail();
                spct.setOrder_Id(rs.getInt("order_id"));
                spct.setProductName(rs.getString("sneaker_name"));
                spct.setQuantity(rs.getInt("quantity"));
                spct.setPrice(rs.getBigDecimal("price"));
                billDetail.add(spct);
            }

        } catch (Exception e) {
        }
        return billDetail;
    }
}
