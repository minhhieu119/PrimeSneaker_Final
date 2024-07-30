/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.services;

import com.prime.main_model.Order;
import com.prime.main_model.SneakerDetail;
import com.prime.main_model.Statistic;
import com.prime.untilities.ConnectionJDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSII
 */
public class StatisticService {

    String sql;
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Integer getQuantityStaff() throws SQLException {
        sql = """
              select count([user_id]) as quantity
              from [User]
              where [status] like N'Đang làm việc'
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return null;
    }

    public Integer getQuantityCustomer() throws SQLException {
        sql = """
              select COUNT(customer_id) as quantity
              from Customer
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return null;
    }

    public Integer getQuantitySneakerDetail() throws SQLException {
        sql = """
              select COUNT(sneaker_detail_id) as quantity
              from SneakerDetail
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return null;
    }

    public Long getTotalCost() throws SQLException {
        sql = """
              select SUM(total_cost) as total_cost
              from [Order]
              where [status] like N'Đã thanh toán'
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getLong("total_cost");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return null;
    }

    public List<Statistic> getStatisticOneWeek() throws SQLException {
        List<Statistic> list = new ArrayList<>();
        sql = """
              SELECT updated_at, SUM(total_cost) AS total_cost
              FROM [Order]
              WHERE updated_at >= DATEADD(DAY, -6, CAST(GETDATE() AS DATE))
              GROUP BY updated_at
              ORDER BY updated_at DESC;
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Statistic s = new Statistic();
                s.setCreatedAt(rs.getDate("updated_at"));
                s.setTotalCost(rs.getLong("total_cost"));
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return list;
    }

    public SneakerDetail getOneSneakerDeatail() throws SQLException {
        SneakerDetail sd = new SneakerDetail();
        sql = """
                select top 1 sneaker_detail_code, s.sneaker_name, sum(od.quantity) as quantity, sum(od.total_cost) as total_cost
              	from OrderDetail od join SneakerDetail sd on od.sneaker_detail_id = sd.sneaker_detail_id
              	join Sneaker s on sd.sneaker_id = s.sneaker_id
              	group by sd.sneaker_detail_code, sneaker_name
              	order by quantity desc
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                sd.setSneakerCode(rs.getString("sneaker_detail_code"));
                sd.setSneakerName(rs.getString("sneaker_name"));
                sd.setQuantity(rs.getInt("quantity"));
                sd.setPrice(rs.getLong("total_cost"));
            }
            return sd;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return sd;
    }
    
    public SneakerDetail getOneSneakerDeatailPrice() throws SQLException {
        SneakerDetail sd = new SneakerDetail();
        sql = """
                select top 1 sneaker_detail_code, s.sneaker_name, sum(od.quantity) as quantity, sum(od.total_cost) as total_cost
                	from OrderDetail od join SneakerDetail sd on od.sneaker_detail_id = sd.sneaker_detail_id
                	join Sneaker s on sd.sneaker_id = s.sneaker_id
                	group by sd.sneaker_detail_code, sneaker_name
                	order by total_cost desc
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                sd.setSneakerCode(rs.getString("sneaker_detail_code"));
                sd.setSneakerName(rs.getString("sneaker_name"));
                sd.setQuantity(rs.getInt("quantity"));
                sd.setPrice(rs.getLong("total_cost"));
            }
            return sd;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return sd;
    }
    
    
}
