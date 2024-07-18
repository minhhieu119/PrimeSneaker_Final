/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.services;

import com.prime.main_model.Order;
import com.prime.main_model.SneakerCart;
import com.prime.main_model.SneakerDetail;
import com.prime.main_model.Voucher;
import com.prime.untilities.ConnectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class OrderService {

    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql;

    public ArrayList<SneakerDetail> getAllSneakerDetail() throws SQLException {
        ArrayList<SneakerDetail> listSneaker = new ArrayList<>();

        sql = """
              select sneaker_detail_id, sneaker_detail_code, sneaker_name, price, quantity, category_name, brand_name, color_name, material_name,sole_name, size_number 
              from Sneaker s join Brand b on s.brand_id = b.brand_id
              join Category c on s.category_id = c.category_id
              join Sole so on s.sole_id = so.sole_id
              join Material m on s.material_id = m.material_id
              right join SneakerDetail sd on s.sneaker_id = sd.sneaker_id
              join Size si on sd.size_id = si.size_id
              join Color co on sd.color_id = co.color_id
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                SneakerDetail sd = new SneakerDetail();
                sd.setSneakerId(rs.getInt("sneaker_detail_id"));
                sd.setSneakerCode(rs.getString("sneaker_detail_code"));
                sd.setSneakerName(rs.getString("sneaker_name"));
                sd.setPrice(rs.getLong("price"));
                sd.setQuantity(rs.getInt("quantity"));
                sd.setCategory(rs.getString("category_name"));
                sd.setBrand(rs.getString("brand_name"));
                sd.setMaterial(rs.getString("material_name"));
                sd.setSole(rs.getString("sole_name"));
                sd.setColor(rs.getString("color_name"));
                sd.setSize(rs.getFloat("size_number"));
                listSneaker.add(sd);
            }
            return listSneaker;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return listSneaker;
    }

    public List<Voucher> getVoucher() throws SQLException {
        List<Voucher> listVoucher = new ArrayList<>();
        sql = """
              select voucher_name
              from Voucher
              where deleted = 1
              order by voucher_id asc
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Voucher v = new Voucher(rs.getString("voucher_name"));
                listVoucher.add(v);
            }
            return listVoucher;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return listVoucher;
    }

    public List<SneakerDetail> searchSD(String key) throws SQLException {
        List<SneakerDetail> listSD = new ArrayList<>();
        sql = """
              select sneaker_detail_code, sneaker_name, price, quantity, category_name, brand_name, color_name, material_name,sole_name, size_number 
              from Sneaker s join Brand b on s.brand_id = b.brand_id
              join Category c on s.category_id = c.category_id
              join Sole so on s.sole_id = so.sole_id
              join Material m on s.material_id = m.material_id
              right join SneakerDetail sd on s.sneaker_id = sd.sneaker_id
              join Size si on sd.size_id = si.size_id
              join Color co on sd.color_id = co.color_id
              where sneaker_detail_code like ? or sneaker_name like ? or quantity like ? or brand_name like ?
              or category_name like ? or color_name like ? or material_name like ? or sole_name like ? or size_number like ?
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);

            for (int i = 1; i <= 9; i++) {
                ps.setString(i, "%" + key + "%");
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                SneakerDetail sd = new SneakerDetail();
                sd.setSneakerCode(rs.getString("sneaker_detail_code"));
                sd.setSneakerName(rs.getString("sneaker_name"));
                sd.setPrice(rs.getLong("price"));
                sd.setQuantity(rs.getInt("quantity"));
                sd.setCategory(rs.getString("category_name"));
                sd.setBrand(rs.getString("brand_name"));
                sd.setMaterial(rs.getString("material_name"));
                sd.setSole(rs.getString("sole_name"));
                sd.setColor(rs.getString("color_name"));
                sd.setSize(rs.getFloat("size_number"));
                listSD.add(sd);
            }
            return listSD;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return listSD;
    }

    public List<SneakerDetail> searchPrice(int price) throws SQLException {
        List<SneakerDetail> listSD = new ArrayList<>();
        sql = """
              select sneaker_detail_code, sneaker_name, price, quantity, category_name, brand_name, color_name, material_name,sole_name, size_number 
              from Sneaker s join Brand b on s.brand_id = b.brand_id
              join Category c on s.category_id = c.category_id
              join Sole so on s.sole_id = so.sole_id
              join Material m on s.material_id = m.material_id
              right join SneakerDetail sd on s.sneaker_id = sd.sneaker_id
              join Size si on sd.size_id = si.size_id
              join Color co on sd.color_id = co.color_id
              group by sneaker_detail_code, sneaker_name, quantity, price, category_name, brand_name, color_name, material_name,sole_name, size_number
              having price < ?
              order by price desc
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, price);

            rs = ps.executeQuery();
            while (rs.next()) {
                SneakerDetail sd = new SneakerDetail();
                sd.setSneakerCode(rs.getString("sneaker_detail_code"));
                sd.setSneakerName(rs.getString("sneaker_name"));
                sd.setPrice(rs.getLong("price"));
                sd.setQuantity(rs.getInt("quantity"));
                sd.setCategory(rs.getString("category_name"));
                sd.setBrand(rs.getString("brand_name"));
                sd.setMaterial(rs.getString("material_name"));
                sd.setSole(rs.getString("sole_name"));
                sd.setColor(rs.getString("color_name"));
                sd.setSize(rs.getFloat("size_number"));
                listSD.add(sd);
            }
            return listSD;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return listSD;
    }

    public Integer addInvoice() {
        sql = """
              insert into [Order] ([status])
              values (N'Chờ thanh toán')
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Order> getOrder() throws SQLException {
        List<Order> listOder = new ArrayList<>();
        sql = """
              select distinct o.order_id, o.created_at, [user_id], sum(quantity) as quantity, [status]
              from [Order] o left join OrderDetail od on o.order_id = od.order_id
              where status like N'Chờ thanh toán'
              group by o.order_id, o.created_at, [user_id],[status]
              order by order_id desc
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Order o = new Order(rs.getInt("order_id"), rs.getInt("user_id"),
                        rs.getInt("quantity"), rs.getString("status"), rs.getDate("created_at"));
                listOder.add(o);
            }
            return listOder;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return listOder;
    }

    public List<SneakerCart> getToCart(int orderId) throws SQLException {
        List<SneakerCart> listSC = new ArrayList<>();
        sql = """
              select o.order_id, sneaker_detail_code, sneaker_name, od.quantity, od.price, b.brand_name, color_name, size_number
              from OrderDetail od left join [Order] o on od.order_id = o.order_id
              join SneakerDetail sd on od.sneaker_detail_id = sd.sneaker_detail_id
              join Color c on sd.color_id = c.color_id
              join Size si on sd.size_id = si.size_id
              join Sneaker s on sd.sneaker_id = s.sneaker_id
              join Brand b on s.brand_id = b.brand_id
              where o.order_id = ?
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, orderId);

            rs = ps.executeQuery();
            while (rs.next()) {
                SneakerCart sc = new SneakerCart(rs.getInt("order_id"), rs.getString("sneaker_detail_code"), rs.getString("sneaker_name"), rs.getInt("quantity"),
                        rs.getLong("price"), rs.getString("brand_name"), rs.getString("color_name"), rs.getFloat("size_number"));
                listSC.add(sc);
            }
            return listSC;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return listSC;
    }

    public SneakerDetail getSneakerDetail(String code) throws SQLException {
        SneakerDetail sd = new SneakerDetail();

        sql = """
              select sneaker_detail_id, sneaker_detail_code, sneaker_name, price, quantity, category_name, brand_name, color_name, material_name,sole_name, size_number 
              from Sneaker s join Brand b on s.brand_id = b.brand_id
              join Category c on s.category_id = c.category_id
              join Sole so on s.sole_id = so.sole_id
              join Material m on s.material_id = m.material_id
              right join SneakerDetail sd on s.sneaker_id = sd.sneaker_id
              join Size si on sd.size_id = si.size_id
              join Color co on sd.color_id = co.color_id
              where sneaker_detail_code like ?
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, code);
            rs = ps.executeQuery();
            while (rs.next()) {
                sd.setSneakerId(rs.getInt("sneaker_detail_id"));
                sd.setSneakerCode(rs.getString("sneaker_detail_code"));
                sd.setSneakerName(rs.getString("sneaker_name"));
                sd.setPrice(rs.getLong("price"));
                sd.setQuantity(rs.getInt("quantity"));
                sd.setCategory(rs.getString("category_name"));
                sd.setBrand(rs.getString("brand_name"));
                sd.setMaterial(rs.getString("material_name"));
                sd.setSole(rs.getString("sole_name"));
                sd.setColor(rs.getString("color_name"));
                sd.setSize(rs.getFloat("size_number"));
            }
            return sd;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return null;
    }

    public Integer getIdSneaker(String code) throws SQLException {
        sql = """
              select sneaker_detail_id
              from SneakerDetail
              where sneaker_detail_code = ?
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);

            ps.setString(1, code);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("sneaker_detail_id");
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

    public Integer addToCart(SneakerDetail sd, int orderId) throws SQLException {
        sql = """
              insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
              values (?,?,?,?,?)
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, sd.getSneakerId());
            ps.setInt(2, orderId);
            ps.setInt(3, 1);
            ps.setLong(4, sd.getPrice());
            ps.setLong(5, sd.getQuantity() * sd.getPrice());
            return ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            ps.close();
            c.close();
        }
        return null;
    }

    public Integer updateOrder(int orderId) throws SQLException {
        sql = """
              update [Order]
              set [status] = N'Đã hủy'
              where order_id = ?
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, orderId);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            c.close();
        }
        return null;
    }

    public Integer updateOrderDetailQuantity(int quantity, int orderId, int sdId) throws SQLException {
        sql = """
              update OrderDetail
              set quantity = ?
              where order_id = ? and sneaker_detail_id = ?
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, orderId);
            ps.setInt(3, sdId);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            c.close();
        }
        return null;
    }

    public Integer deleteOrderDetail(int orderId, int sdId) throws SQLException {
        sql = """
              delete from OrderDetail
              where order_id = ? and sneaker_detail_id = ?
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, sdId);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            c.close();
        }
        return null;
    }

    public String getCustomerName(String phoneNumber) throws SQLException {
        String name = "";
        sql = """
              select full_name
              from Customer
              where phone_number like ?
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, "%" + phoneNumber + "%");
            rs = ps.executeQuery();
            if(rs.next()){
                name = rs.getString("full_name");
            }
            
//            while (rs.next()) {                
//                name = rs.getString("full_name");
//                break;
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return name;
    }

//    public Order getOneOrder(int id) throws SQLException {
//        Order o = new Order();
//
//        sql = """
//              select sneaker_detail_id, sneaker_detail_code, sneaker_name, price, quantity, category_name, brand_name, color_name, material_name,sole_name, size_number 
//              from Sneaker s join Brand b on s.brand_id = b.brand_id
//              join Category c on s.category_id = c.category_id
//              join Sole so on s.sole_id = so.sole_id
//              join Material m on s.material_id = m.material_id
//              right join SneakerDetail sd on s.sneaker_id = sd.sneaker_id
//              join Size si on sd.size_id = si.size_id
//              join Color co on sd.color_id = co.color_id
//              where order_id like ?
//              """;
//
//        try {
//            c = ConnectionJDBC.getConnection();
//            ps = c.prepareStatement(sql);
//            ps.setString(1,code);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                sd.setSneakerId(rs.getInt("sneaker_detail_id"));
//                sd.setSneakerCode(rs.getString("sneaker_detail_code"));
//                sd.setSneakerName(rs.getString("sneaker_name"));
//                sd.setPrice(rs.getLong("price"));
//                sd.setQuantity(rs.getInt("quantity"));
//                sd.setCategory(rs.getString("category_name"));
//                sd.setBrand(rs.getString("brand_name"));
//                sd.setMaterial(rs.getString("material_name"));
//                sd.setSole(rs.getString("sole_name"));
//                sd.setColor(rs.getString("color_name"));
//                sd.setSize(rs.getFloat("size_number"));
//            }
//            return sd;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            rs.close();
//            ps.close();
//            c.close();
//        }
//        return null;
//    }
}
