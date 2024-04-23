/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Cart;
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
public class CartDAO  extends DBConnect implements BaseDAO<Cart> {

   
    @Override
    public void create(Cart entity) {

        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into Cart (toplamFiyat, createdDate, lastModifiedDate) "
                    + "values ("
                    + "'" + entity.getToplamFiyat() + "',"
                    + "'" + entity.getCreatedDate() + "',"
                    + "'" + entity.getLastModifiedDate() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Cart entity) {
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
    public void delete(Cart entity) {
        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from Cart where id = " + entity.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Cart> readList() {
        List<Cart> cartList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Cart");

            while (rs.next()) {
                paymentList.add(new Payment(
                        rs.getInt("odenenTutar"),
                        rs.getTimestamp("createdDate"),
                        rs.getTimestamp("lastModifiedDate")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cartList;

    }

    @Override
    public Cart getEntityById(Long id) {

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
    
}
