/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.services;

import static com.itextpdf.kernel.xmp.PdfConst.Date;
import com.prime.main_model.Voucher;
import com.prime.main_model.VoucherAq;
import com.prime.untilities.ConnectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class VoucherService {

    PreparedStatement pstm = null;
    ResultSet rs = null;
    String sql = null;

    public ArrayList<VoucherAq> findAll() {
        ArrayList<VoucherAq> listVoucher = new ArrayList<>();
        String sql = """
                     SELECT voucher_code,
                            voucher_name,
                            voucher_type,
                            voucher_value,
                            min_order_value,
                            max_discount,
                            start_date,
                            end_date,
                            quantity, [status]
                     FROM dbo.Voucher
                     """;
        try {
            Connection con = ConnectionJDBC.getConnection();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                VoucherAq voucher = new VoucherAq();
                voucher.setVoucherCode(rs.getString("voucher_code"));
                voucher.setVoucherName(rs.getString("voucher_name"));
                voucher.setVoucherType(rs.getBoolean("voucher_type"));
                voucher.setVoucherValue(rs.getInt("voucher_value"));
                voucher.setMinOrderValue(rs.getLong("min_order_value"));
                voucher.setMaxDiscount(rs.getFloat("max_discount"));
                voucher.setStartDate(rs.getDate("start_date"));
                voucher.setEndDate(rs.getDate("end_date"));
                voucher.setQuantity(rs.getInt("quantity"));
                voucher.setStatus(rs.getString("status"));
                listVoucher.add(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listVoucher;
    }

    public Integer addVoucher(VoucherAq voucher) throws SQLException {
        Integer row = null;
        sql = """
              INSERT INTO Voucher (voucher_code, voucher_name, voucher_type, voucher_value, quantity, max_discount,min_order_value, [start_date], end_date, [status])
              VALUES (?,?,?,?,?,?,?,?,?,?)
              """;
        try {
            Connection con = ConnectionJDBC.getConnection();
            pstm = con.prepareStatement(sql);
            pstm.setObject(1, voucher.getVoucherCode());
            pstm.setObject(2, voucher.getVoucherName());
            pstm.setObject(3, voucher.isVoucherType());
            pstm.setObject(4, voucher.getVoucherValue());
            pstm.setObject(5, voucher.getQuantity());
            pstm.setObject(6, voucher.getMaxDiscount());
            pstm.setObject(7, voucher.getMinOrderValue());
            pstm.setObject(8, voucher.getStartDate());
            pstm.setObject(9, voucher.getEndDate());
            pstm.setObject(10, voucher.getStatus());
            row = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateVoucher(VoucherAq voucher) throws SQLException {
        Integer row = null;
        sql = """
              UPDATE Voucher
              SET voucher_name = ?,
              	voucher_type = ?,
              	voucher_value = ?,
              	quantity = ?,
              	max_discount =?,
              	min_order_value =?,
              	[start_date] = ?,
              	end_date = ?,
                [status] = ?
              WHERE voucher_code = ?
              """;
        Connection con = ConnectionJDBC.getConnection();

        try {
            pstm = con.prepareStatement(sql);
            pstm.setObject(1, voucher.getVoucherName());
            pstm.setObject(2, voucher.isVoucherType());
            pstm.setObject(3, voucher.getVoucherValue());
            pstm.setObject(4, voucher.getQuantity());
            pstm.setObject(5, voucher.getMaxDiscount());
            pstm.setObject(6, voucher.getMinOrderValue());
            pstm.setObject(7, voucher.getStartDate());
            pstm.setObject(8, voucher.getEndDate());
            pstm.setObject(9, voucher.getStatus());
            pstm.setObject(10, voucher.getVoucherCode());
            row = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public List<VoucherAq> timKiem(String timKiem, String trangThai, String ngayBatDau, String ngayKetThuc) throws SQLException {
        List<VoucherAq> list = new ArrayList<>();
        Connection con = null;
        String sql = """
                     SELECT voucher_code, voucher_name, voucher_type, voucher_value, min_order_value, max_discount, [start_date], end_date, quantity, [status]
                     FROM dbo.Voucher
                     WHERE (? is null or [status] like ?) and ([start_date] between ? and ? and end_date between ? and ?) and (? is null or voucher_code like ? or voucher_name like ?)
                     """;
        try {
            con = ConnectionJDBC.getConnection();
            pstm = con.prepareStatement(sql);

            pstm.setString(1, trangThai);
            pstm.setString(2, trangThai);
            pstm.setString(3, ngayBatDau);
            pstm.setString(4, ngayKetThuc);
            pstm.setString(5, ngayBatDau);
            pstm.setString(6, ngayKetThuc);
            pstm.setString(7, timKiem);
            pstm.setString(8, "%" + timKiem + "%");
            pstm.setString(9, "%" + timKiem + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                VoucherAq v = new VoucherAq();
                v.setVoucherCode(rs.getString("voucher_code"));
                v.setVoucherName(rs.getString("voucher_name"));
                v.setVoucherType(rs.getBoolean("voucher_type"));
                v.setVoucherValue(rs.getInt("voucher_value"));
                v.setMinOrderValue(rs.getLong("min_order_value"));
                v.setMaxDiscount(rs.getFloat("max_discount"));
                v.setStartDate(rs.getDate("start_date"));
                v.setEndDate(rs.getDate("end_date"));
                v.setQuantity(rs.getInt("quantity"));
                v.setStatus(rs.getString("status"));
                list.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            pstm.close();
            con.close();
        }
        return list;
    }
}
