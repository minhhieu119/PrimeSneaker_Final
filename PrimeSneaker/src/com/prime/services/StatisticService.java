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
              WITH RankedOrders AS (
                  SELECT CAST(o.updated_at AS DATE) AS order_date, SUM(o.total_cost) AS total_cost
                  FROM [Order] o
                  GROUP BY CAST(o.updated_at AS DATE)
              ),
              RankedDays AS (SELECT order_date, total_cost, ROW_NUMBER() OVER (ORDER BY order_date DESC) AS rn
                  FROM RankedOrders)
              SELECT order_date AS updated_at, total_cost
              FROM RankedDays
              WHERE rn <= 7
              ORDER BY order_date DESC;
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

    public List<Statistic> getStatisticYear(String year) throws SQLException {
        List<Statistic> list = new ArrayList<>();
        sql = """
              SELECT MONTH(o.updated_at) AS month,
                  SUM(o.total_cost) AS total_cost, 
                  SUM(od.quantity) AS quantity
              FROM [Order] o JOIN OrderDetail od ON o.order_id = od.order_id
              WHERE YEAR(o.updated_at) = ?
              GROUP BY MONTH(o.updated_at)
              ORDER BY month ASC;
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, year);
            rs = ps.executeQuery();
            while (rs.next()) {
                Statistic s = new Statistic();
                s.setMonth(rs.getInt("month"));
                s.setTotalCost(rs.getLong("total_cost"));
                s.setQuantity(rs.getInt("quantity"));
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
    
    public List<Statistic> getStatisticMonth(String year, String month) throws SQLException {
        List<Statistic> list = new ArrayList<>();
        sql = """
              SELECT DAY(o.updated_at) AS day, SUM(o.total_cost) AS total_cost, SUM(od.quantity) AS quantity
              FROM [Order] o JOIN OrderDetail od ON o.order_id = od.order_id
              WHERE YEAR(o.updated_at) = ? AND MONTH(o.updated_at) = ?
              GROUP BY DAY(o.updated_at)
              ORDER BY day ASC;
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, year);
            ps.setString(2, month);
            rs = ps.executeQuery();
            while (rs.next()) {
                Statistic s = new Statistic();
                s.setDate(rs.getInt("day"));
                s.setTotalCost(rs.getLong("total_cost"));
                s.setQuantity(rs.getInt("quantity"));
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
    
    public List<Statistic> getStatisticDay(String startDate, String endDate) throws SQLException {
        List<Statistic> list = new ArrayList<>();
        sql = """
              SELECT o.updated_at AS day, SUM(o.total_cost) AS total_cost, SUM(od.quantity) AS quantity
              FROM [Order] o JOIN OrderDetail od ON o.order_id = od.order_id
              WHERE o.updated_at BETWEEN ? AND ?
              GROUP BY o.updated_at
              ORDER BY day ASC;
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                Statistic s = new Statistic();
                s.setCreatedAt(rs.getDate("day"));
                s.setTotalCost(rs.getLong("total_cost"));
                s.setQuantity(rs.getInt("quantity"));
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
    
}
