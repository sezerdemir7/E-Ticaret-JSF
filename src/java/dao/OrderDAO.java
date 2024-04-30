/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Cart;
import entity.CartItem;
import entity.Customer;
import entity.Order;
import entity.OrderDetail;
import entity.Payment;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author serki
 */
public class OrderDAO extends DBConnect implements BaseDAO<Order> {
    
    private CustomerDAO customerDAO;
    private PaymentDAO paymentDAO;
    private CartDAO cartDAO;
    private CartItemDAO cartItemDAO;
    private OrderDetailDAO orderDetailDAO;
    
    public boolean saveOrder(Order order) {
        
        Cart cart = null;
        OrderDetail orderDetail = new OrderDetail();
        cart = getCartDAO().getCartByCustomerId(order.getCustomer().getId());
        order.setToplamTutar(cart.getToplamFiyat());
        
        Long orderId = createOrder(order);
        order.setId(orderId);
        for (CartItem cartItem : cart.getCartItems()) {
            orderDetail.setAdet(cartItem.getAdet());
            orderDetail.setOrder(order);
            orderDetail.setProduct(cartItem.getProduct());
            getOrderDetailDAO().create(orderDetail);
            getCartItemDAO().delete(cartItem);
        }
        
        cart.setCartItems(null);
        cart.setToplamFiyat(0);
        cart.setCustomer(order.getCustomer());
        
        getCartDAO().update(cart);
        
        return true;
    }
    
    public long createOrder(Order entity) {
        long generatedOrderId = -1; 

        try {
            Statement st = this.getConnect().createStatement();
            
            st.executeUpdate("insert into Orders (Customerid, orderdate,"
                    + " status, teslimatadresi, Paymentid, toplamtutar,"
                    + " createddate, lastmodifieddate) values('"
                    + entity.getCustomer().getId() + "',"
                    + " '" + "2024-04-21 19:00:37.89874" + "',"
                    + " '" + entity.isStatus() + "',"
                    + " '" + entity.getTeslimatAdresi() + "',"
                    + " '" + 2 + "',"
                    + " '" + entity.getToplamTutar() + "',"
                    + " '" + "2024-04-21 19:00:37.89874" + "',"
                    + " '" + "2024-04-21 19:00:37.89874" + "')", 
                    Statement.RETURN_GENERATED_KEYS);
            
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedOrderId = generatedKeys.getLong(1);
            } else {
                System.out.println("Sipariş kimliği alınamadı.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return generatedOrderId;
    }
    
    @Override
    public void create(Order entity) {
        
        try {
            Statement st = this.getConnect().createStatement();
            
            st.executeUpdate("insert into Orders (customerid, orderdate,"
                    + " status, teslimatadresi, paymentid, toplamtutar,"
                    + " createddate, lastmodifieddate) values('"
                    + entity.getCustomer().getId() + "',"
                    + " '" + "2024-04-21 19:00:37.89874" + "',"
                    + " '" + entity.isStatus() + "',"
                    + " '" + entity.getTeslimatAdresi() + "',"
                    + " '" + 2 + "',"
                    + " '" + entity.getToplamTutar() + "',"
                    + " '" + "2024-04-21 19:00:37.89874" + "',"
                    + " '" + "2024-04-21 19:00:37.89874" + "')");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    @Override
    public void update(Order entity) {
        
        try {
            Statement st = this.getConnect().createStatement();
            String query = "update Orders set "
                    + "customerid ='" + entity.getCustomer().getId() + "'  "
                    + "orderdate = '" + entity.getOrderDate() + "' "
                    + "status = '" + entity.isStatus() + "' "
                    + "teslimatadresi = '" + entity.getTeslimatAdresi() + "' "
                    + "paymentid = '" + entity.getPayment().getId() + "'"
                    + "toplamtutar = '" + entity.getToplamTutar() + "'"
                    + "createdate ='" + entity.getCreatedDate() + "'"
                    + "lastmodifieddate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "";
            
            st.executeUpdate(query);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    @Override
    public void delete(Order entity) {
        try {
            Statement st = this.getConnect().createStatement();
            
            st.executeUpdate("delete from orders where id = " + entity.getId());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public List<Order> readListByCustumerId(Long customerId) {
        
        List<Order> orderList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            
            ResultSet rs = st.executeQuery("select * from orders where customerid="+customerId);
            
            while (rs.next()) {
                Customer customer = this.getCustomerDAO().getEntityById(rs.getLong("customerid"));
                Payment payment = this.getPaymentDAO().getEntityById(rs.getLong("paymentid"));
                orderList.add(new Order(
                        customer,
                        rs.getTimestamp("orderdate"),
                        rs.getBoolean("status"),
                        rs.getString("teslimatadresi"),
                        payment,
                        rs.getInt("toplamtutar"),
                        rs.getLong("id"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                ));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return orderList;
    }
    
    @Override
    public List<Order> readList() {
        
        List<Order> orderList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            
            ResultSet rs = st.executeQuery("select * from orders ");
            
            while (rs.next()) {
                Customer customer = this.getCustomerDAO().getEntityById(rs.getLong("customerid"));
                Payment payment = this.getPaymentDAO().getEntityById(rs.getLong("paymentid"));
                orderList.add(new Order(
                        customer,
                        rs.getTimestamp("orderdate"),
                        rs.getBoolean("status"),
                        rs.getString("teslimatadresi"),
                        payment,
                        rs.getInt("toplamtutar"),
                        rs.getLong("id"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                ));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return orderList;
    }
    
    @Override
    public Order getEntityById(Long id) {
        
        Order order = null;
        
        try {
            Statement st = this.getConnect().createStatement();
            
            ResultSet rs = st.executeQuery("select * from orders where id = " + id);
            
            rs.next();
            
            Customer customer = this.getCustomerDAO().getEntityById(rs.getLong("id"));
            Payment payment = this.getPaymentDAO().getEntityById(rs.getLong("id"));
            order = new Order(
                    customer,
                    rs.getTimestamp("orderdate"),
                    rs.getBoolean("status"),
                    rs.getString("teslimatadresi"),
                    payment,
                    rs.getInt("toplamtutar"),
                    rs.getLong("id"),
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return order;
        
    }
    
    public CustomerDAO getCustomerDAO() {
        if (customerDAO == null) {
            this.customerDAO = new CustomerDAO();
        }
        return customerDAO;
    }
    
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    
    public PaymentDAO getPaymentDAO() {
        if (paymentDAO == null) {
            this.paymentDAO = new PaymentDAO();
        }
        return paymentDAO;
    }
    
    public void setPaymentDAO(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }
    
    public CartDAO getCartDAO() {
        if (this.cartDAO == null) {
            cartDAO = new CartDAO();
        }
        return cartDAO;
    }
    
    public void setCartDAO(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }
    
    public CartItemDAO getCartItemDAO() {
        if (this.cartItemDAO == null) {
            cartItemDAO = new CartItemDAO();
        }
        return cartItemDAO;
    }
    
    public void setCartItemDAO(CartItemDAO cartItemDAO) {
        this.cartItemDAO = cartItemDAO;
    }
    
    public OrderDetailDAO getOrderDetailDAO() {
        if (this.orderDetailDAO == null) {
            orderDetailDAO = new OrderDetailDAO();
        }
        return orderDetailDAO;
    }
    
    public void setOrderDetailDAO(OrderDetailDAO orderDetailDAO) {
        this.orderDetailDAO = orderDetailDAO;
    }
    
}
