/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Customer;
import entity.Order;
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

    @Override
    public void create(Order entity) {

        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into Orders (Customer, orderDate,"
                    + " status, teslimatAdresi, Payment, toplamTutar,"
                    + " createdDate, lastModifiedDate) values('"
                    + entity.getCustomer().getId() + "',"
                    + " '" + entity.getOrderDate() + "',"
                    + " '" + entity.isStatus() + "',"
                    + " '" + entity.getTeslimatAdresi() + "',"
                    + " '" + entity.getPayment().getId() + "',"
                    + " '" + entity.getToplamTutar() + "',"
                    + " '" + entity.getCreatedDate() + "',"
                    + " '" + entity.getLastModifiedDate() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Order entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update Orders set "
                    + "customer_id ='" + entity.getCustomer().getId() + "'  "
                    + "orderDate = '" + entity.getOrderDate() + "' "
                    + "status = '" + entity.isStatus() + "' "
                    + "teslimatAdresi = '" + entity.getTeslimatAdresi() + "' "
                    + "payment_id = '" + entity.getPayment().getId() + "'"
                    + "toplamTutar = '" + entity.getToplamTutar() + "'"
                    + "createDate ='" + entity.getCreatedDate() + "'"
                    + "lastModifiedDate ='" + entity.getLastModifiedDate() + "' "
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

    @Override
    public List<Order> readList() {

        List<Order> orderList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from orders");

            while (rs.next()) {
                Customer customer = this.customerDAO.getEntityById(rs.getLong("customer_id"));
                Payment payment = this.paymentDAO.getEntityById(rs.getLong("payment_id"));
                orderList.add(new Order(
                        customer,
                        rs.getTimestamp("orderDate"),
                        rs.getBoolean("status"),
                        rs.getString("teslimatAdresi"),
                        payment,
                        rs.getInt("toplamTutar"),
                        rs.getLong("id"),
                        rs.getTimestamp("createdDate"),
                        rs.getTimestamp("lastModifiedDate")
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
        
        try{
            Statement st = this.getConnect().createStatement();
            
            ResultSet rs = st.executeQuery("select * from orders where id = "+id);
            
            rs.next();
            
            Customer customer = this.getCustomerDAO().getEntityById(rs.getLong("id"));
            Payment payment = this.getPaymentDAO().getEntityById(rs.getLong("id"));
            order =new Order(
                        customer,
                        rs.getTimestamp("orderDate"),
                        rs.getBoolean("status"),
                        rs.getString("teslimatAdresi"),
                        payment,
                        rs.getInt("toplamTutar"),
                        rs.getLong("id"),
                        rs.getTimestamp("createdDate"),
                        rs.getTimestamp("lastModifiedDate")
                );
            
            
            
        }catch(Exception e){
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

}
