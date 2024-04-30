/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Order;
import entity.OrderDetail;
import entity.Product;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author serki
 */
public class OrderDetailDAO extends DBConnect implements BaseDAO<OrderDetail> {

    private ProductDAO productDAO;
    private OrderDAO orderDAO;

    public List<OrderDetail> listOrderDetailByOrder(Order order) {
        
        System.out.println("*********");
        System.out.println("*********");System.out.println("*********");
        System.out.println("order id====="+order.getId());
        System.out.println("*********");
        

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from orderdetail where orders_id=" + order.getId());

            while (rs.next()) {
                Product product = getProductDAO().getEntityById(rs.getLong("productid"));
                orderDetailList.add(new OrderDetail(rs.getInt("adet"), product, order,
                        rs.getLong("id"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate"))
                );
            
         
                
                
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return orderDetailList;

    }

    @Override
    public void create(OrderDetail entity) {

        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into OrderDetail (adet, Productid, Ordersid, createddate, lastmodifieddate) "
                    + "values ("
                    + "'" + entity.getAdet() + "', "
                    + "'" + entity.getProduct().getId() + "', "
                    + "'" + entity.getOrder().getId() + "', "
                    + "'" + "2024-04-21 19:00:37.89874" + "', "
                    + "'" + "2024-04-21 19:00:37.89874" + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(OrderDetail entity) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update OrderDetail set adet = '" + entity.getAdet() + "'"
                    + "productid ='" + entity.getProduct().getId() + "'  "
                    + "orderid = '" + entity.getOrder().getId() + "'"
                    + "createdate ='" + entity.getCreatedDate() + "'"
                    + "lastmodifieddate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(OrderDetail entity) {
        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from OrderDetail where id = " + entity.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<OrderDetail> readList() {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from OrderDetail");

            while (rs.next()) {
                Product product = this.productDAO.getEntityById(rs.getLong("productid"));
                Order order = this.orderDAO.getEntityById(rs.getLong("orderid"));
                orderDetailList.add(new OrderDetail(
                        rs.getInt("adet"),
                        product,
                        order,
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return orderDetailList;

    }

    @Override
    public OrderDetail getEntityById(Long id) {

        OrderDetail orderDetail = null;

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from OrderDeatil where id = " + id);

            rs.next();

            Product product = this.productDAO.getEntityById(rs.getLong("productid"));
            Order order = this.orderDAO.getEntityById(rs.getLong("orderid"));
            orderDetail = new OrderDetail(
                    rs.getInt("adet"),
                    product,
                    order,
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return orderDetail;

    }

    public ProductDAO getProductDAO() {
        if (productDAO == null) {
            this.productDAO = new ProductDAO();
        }
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public OrderDAO getOrderDAO() {
        if (orderDAO == null) {
            this.orderDAO = new OrderDAO();

        }
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

}
