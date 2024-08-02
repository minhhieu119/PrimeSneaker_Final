/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prime.services;

import com.prime.main_model.ModelCustomer;
import com.prime.main_model.ModelUser;
import com.prime.model.Customer;
import com.prime.main_model.Order;
import com.prime.main_model.SneakerCart;
import com.prime.main_model.SneakerDetail;
import com.prime.main_model.User;
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
              where quantity > 0
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

    public Integer updateQuantityAddSneaker(String code, int quantity) throws SQLException {
        sql = """
              update SneakerDetail
              set quantity = quantity - ?
              where sneaker_detail_code = ?
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setString(2, code);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            c.close();
        }
        return null;
    }

    public Integer updateQuantityDeleteSneaker(String code, int quantity) throws SQLException {
        sql = """
              update SneakerDetail
              set quantity = quantity + ?
              where sneaker_detail_code = ?
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setString(2, code);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            c.close();
        }
        return null;
    }

    public List<Voucher> getVoucher() throws SQLException {
        List<Voucher> listVoucher = new ArrayList<>();
        sql = """
              select voucher_name
              from Voucher
              where deleted = 1 and start_date < getdate() and getdate() < end_date and quantity > 0
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

    public Voucher getOneVoucher(String name) throws SQLException {
        Voucher v = new Voucher();
        sql = """
              select voucher_id, voucher_code, voucher_name,voucher_type,voucher_value,quantity,  max_discount, min_order_value,  [start_date], end_date
                            from Voucher
                            where voucher_name like ?
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                v.setVoucherId(rs.getInt("voucher_id"));
                v.setVoucherCode(rs.getString("voucher_code"));
                v.setVoucherName(rs.getString("voucher_name"));
                v.setVoucherType(rs.getBoolean("voucher_type"));
                v.setVoucherValue(rs.getInt("voucher_value"));
                v.setMaxDiscount(rs.getFloat("max_discount"));
                v.setMinOrderValue(rs.getLong("min_order_value"));
                v.setQuantity(rs.getInt("quantity"));
                v.setStartDate(rs.getDate("start_date"));
                v.setEndDate(rs.getDate("end_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return v;
    }
    
    public Integer updateQuantityVoucher (String name) throws SQLException{
        sql = """
              update Voucher
              set quantity = quantity - 1
              where voucher_name like ?
              """;
        
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, name);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            c.close();
        }
        return null;
    }

    public List<SneakerDetail> searchSD(String key, long price) throws SQLException {
        List<SneakerDetail> listSD = new ArrayList<>();
//        sql = """
//              select sneaker_detail_code, sneaker_name, price, quantity, category_name, brand_name, color_name, material_name,sole_name, size_number 
//              from Sneaker s join Brand b on s.brand_id = b.brand_id
//              join Category c on s.category_id = c.category_id
//              join Sole so on s.sole_id = so.sole_id
//              join Material m on s.material_id = m.material_id
//              right join SneakerDetail sd on s.sneaker_id = sd.sneaker_id
//              join Size si on sd.size_id = si.size_id
//              join Color co on sd.color_id = co.color_id
//              where quantity > 0 and (sneaker_detail_code like ? or sneaker_name like ? or quantity like ? or brand_name like ?
//              or category_name like ? or color_name like ? or material_name like ? or sole_name like ? or size_number like ?)
//              """;
sql = """
      select sneaker_detail_code, sneaker_name, price, quantity, category_name, brand_name, color_name, material_name,sole_name, size_number 
                    from Sneaker s join Brand b on s.brand_id = b.brand_id
                    join Category c on s.category_id = c.category_id
                    join Sole so on s.sole_id = so.sole_id
                    join Material m on s.material_id = m.material_id
                    right join SneakerDetail sd on s.sneaker_id = sd.sneaker_id
                    join Size si on sd.size_id = si.size_id
                    join Color co on sd.color_id = co.color_id
                    where quantity > 0 and (? is null or sneaker_detail_code like ? or sneaker_name like ? or brand_name like ?
                    or category_name like ? or color_name like ? or material_name like ? or sole_name like ? or size_number like ?) and (price < ? or price < ?)
      """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
ps.setString(1, key);
            for (int i = 2; i <= 9; i++) {
                ps.setString(i, "%" + key + "%");
            }
            ps.setLong(10, price);
            ps.setLong(11, price);

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

    public List<SneakerDetail> searchPrice(long price) throws SQLException {
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
              having price < ? and quantity > 0
              order by price desc
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setLong(1, price);

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

    public Integer removeInvoice(int id) throws SQLException {
        sql = """
              delete from OrderDetail
              where order_id = ?
              delete from [Order]
              where order_id = ?
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            c.close();
        }
        return null;
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

    public Integer updateOrderPayment(Order o) throws SQLException {
        sql = """
              update [Order]
              set [user_id] = ?, customer_id = ?, voucher_id = ?, payment_method = ?, total_cost = ?, [status] = N'Đã thanh toán', updated_at = GETDATE()
              where order_id = ?
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setObject(1, o.getUserId());
            ps.setObject(2, o.getCustomerId());
            ps.setObject(3, o.getVoucherId());
            ps.setString(4, o.getPaymentMethod());
            ps.setLong(5, o.getTotalCost());
            ps.setObject(6, o.getOrderId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            c.close();
        }
        return null;
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

    public Integer addToCart(SneakerDetail sd, int orderId, int quantity) throws SQLException {
        sql = """
              insert into OrderDetail (sneaker_detail_id, order_id, quantity, price, total_cost)
              values (?,?,?,?,?)
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, sd.getSneakerId());
            ps.setInt(2, orderId);
            ps.setInt(3, quantity);
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

    public Integer updateStatusAllOrder(String status) throws SQLException {
        sql = """
              update [Order]
              set [status] = N'Đã hủy'
              where [status] like ?
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, status);
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
            ps.setString(1, phoneNumber);
            rs = ps.executeQuery();
            if (rs.next()) {
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

    public Order getOneOrder(int id) throws SQLException {
        Order o = new Order();

        sql = """
              select o.order_id, [user_id], voucher_name, o.created_at, sum(od.price * od.quantity) as total_cost, payment_method
              from [Order] o left join Voucher v on o.voucher_id = v.voucher_id
              join OrderDetail od on o.order_id = od.order_id
              where o.order_id = ?
              group by o.order_id, [user_id], voucher_name, o.created_at,  payment_method
              """;

        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                o.setOrderId(rs.getInt("order_id"));
                o.setUserId(rs.getInt("user_id"));
                o.setVoucherName(rs.getString("voucher_name"));
                o.setCreated_at(rs.getDate("created_at"));
                o.setTotalCost(rs.getLong("total_cost"));
                o.setPaymentMethod(rs.getString("payment_method"));
            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return o;
    }

    public Integer addCustomer(ModelCustomer mc) throws SQLException {
        sql = """
              insert into Customer (full_name, phone_number, gender, [address])
              values (?, ?, ?, ?)
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, mc.getCustomerName());
            ps.setString(2, mc.getPhoneNumber());
            ps.setBoolean(3, mc.isGender());
            ps.setString(4, mc.getAddress());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            c.close();
        }
        return null;
    }

    public List<ModelCustomer> getAllPhoneNumber() {
        List<ModelCustomer> list = new ArrayList<>();
        sql = """
              select full_name, phone_number, gender, [address]
              from Customer
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ModelCustomer mc = new ModelCustomer(rs.getString(1), rs.getBoolean(3), rs.getString(4), rs.getString(2));
                list.add(mc);
            }
            return list;
        } catch (Exception e) {
        }
        return list;
    }

    public Integer getIdByPhoneNumber(String p) throws SQLException {
        sql = """
              select customer_id
              from Customer
              where phone_number like ?
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, p);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("customer_id");
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

    public Integer getIdUserByUserCode(String code) throws SQLException {
        sql = """
             select [user_id]
             from [User]
             where user_code like ?
             """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, code);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_id");
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

    public ModelUser getOneUser(int userId) throws SQLException {
        ModelUser mu = new ModelUser();
        
        sql = """
              select user_code, full_name
              from [User]
              where [user_id] = ?
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                mu.setUserCode(rs.getString("user_code"));
                mu.setStaffName(rs.getString("full_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            c.close();
        }
        return mu;
    }

    public Integer getQuantity(String code) {

        sql = """
              select quantity
              from SneakerDetail
              where sneaker_detail_code = ?
              """;
        try {
            c = ConnectionJDBC.getConnection();
            ps = c.prepareStatement(sql);
            ps.setString(1, code);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }
        } catch (Exception e) {
        }
        return null;
    }
}
