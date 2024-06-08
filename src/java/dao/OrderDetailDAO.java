/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.OrderDetail;
import entity.Orders;
import entity.Product;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serki
 */

@Local
@Stateless
public class OrderDetailDAO extends BaseDAO<OrderDetail> implements Serializable{

    public OrderDetailDAO() {
        super(OrderDetail.class);
    }
    
    //buradan sonrası ekleme yapıldı
    
     public List<OrderDetail> listOrderDetailByOrder(Orders order) {


        List<OrderDetail> orderDetailList = new ArrayList<>();
          try {
            TypedQuery<OrderDetail> query = em.createQuery(
                "SELECT od FROM OrderDetail od WHERE od.orders = :order", OrderDetail.class);
            query.setParameter("order", order);
            orderDetailList = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error listing order details: " + e.getMessage());
        }

        return orderDetailList;

    }

}


/*  private ProductDAO productDAO;
    private OrderDAO orderDAO;

    public List<OrderDetail> listOrderDetailByOrder(Order order) {


        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM orderdetail WHERE orderid = " + order.getId());


            while (rs.next()) {
                Product product = getProductDAO().getEntityById(rs.getLong("productid"));
                orderDetailList.add(new OrderDetail(rs.getInt("adet"), product, order,
                        rs.getLong("id"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate"))
                );

            }
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return orderDetailList;

    }

    @Override
    public void create(OrderDetail entity) {

        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into OrderDetail (adet, Productid, Orderid, lastmodifieddate) "
                    + "values ("
                    + "'" + entity.getAdet() + "', "
                    + "'" + entity.getProduct().getId() + "', "
                    + "'" + entity.getOrder().getId() + "', "
                    + "'" + new Timestamp(System.currentTimeMillis()) + "')");
            st.close();

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

            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(OrderDetail entity) {
        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from OrderDetail where id = " + entity.getId());
            st.close();

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
                Product product = getProductDAO().getEntityById(rs.getLong("productid"));
                Order order = getOrderDAO().getEntityById(rs.getLong("orderid"));
                orderDetailList.add(new OrderDetail(
                        rs.getInt("adet"),
                        product,
                        order,
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                ));
            }
            st.close();
            rs.close();

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

            Product product = this.getProductDAO().getEntityById(rs.getLong("productid"));
            Order order = this.getOrderDAO().getEntityById(rs.getLong("orderid"));
            orderDetail = new OrderDetail(
                    rs.getInt("adet"),
                    product,
                    order,
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );
            st.close();
            rs.close();

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
 */
