/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Customer;
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
public class PaymentDAO extends DBConnect implements BaseDAO<Payment> {

    private CustomerDAO customerDAO;

    @Override
    public void create(Payment entity) {

        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into Payment (Customer, odenenTutar, createdDate, lastModifiedDate) "
                    + "values ('" + entity.getCustomer().getId() + "',"
                    + "'" + entity.getOdenenTutar() + "',"
                    + "'" + entity.getCreatedDate() + "',"
                    + "'" + entity.getLastModifiedDate() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Payment entity) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update Payment set "
                    + "customer_id ='" + entity.getCustomer().getId() + "'  "
                    + "odenenTutar = '" + entity.getOdenenTutar() + "'"
                    + "createDate ='" + entity.getCreatedDate() + "'"
                    + "lastModifiedDate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Payment entity) {
        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from Payment where id = " + entity.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Payment> readList() {
        List<Payment> paymentList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Payment");

            while (rs.next()) {
                Customer customer = this.customerDAO.getEntityById(rs.getLong("customer_id"));
                paymentList.add(new Payment(
                        customer,
                        rs.getInt("odenenTutar"),
                        rs.getTimestamp("createdDate"),
                        rs.getTimestamp("lastModifiedDate")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return paymentList;

    }

    @Override
    public Payment getEntityById(Long id) {

        Payment payment = null;

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Payment where id = " + id);

            rs.next();

            Customer customer = this.getCustomerDAO().getEntityById(rs.getLong("id"));
            payment = new Payment(
                    customer,
                    rs.getInt("odenenTutar"),
                    rs.getTimestamp("createdDate"),
                    rs.getTimestamp("lastModifiedDate")
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return payment;

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

}
