/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Customer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author serki
 */
public class CustomerDAO extends DBConnect implements BaseDAO<Customer> {

    public Customer login(Customer entity) {

        Customer customer = null;

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from customer where email='" + entity.getEmail() + "'");
            if (rs.next()) {
                customer = new Customer(
                        rs.getLong("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("addres"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                );
            }

            return customer;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    //@Override
    public void create(Customer entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into Customer(firstname, lastname, password, email, addres) "
                    + "values ('" + entity.getFirstName() + "',"
                    + "'" + entity.getLastName() + "',"
                    + "'" + entity.getPassword() + "',"
                    + "'" + entity.getEmail() + "',"
                    + "'" + entity.getAddres() + "')";

            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Customer entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update customer set "
                    + "firstname ='" + entity.getFirstName() + "'  "
                    + "lastname = '" + entity.getLastName() + "' "
                    + "password = '" + entity.getPassword() + "' "
                    + "email = '" + entity.getEmail() + "' "
                    + "addres = '" + entity.getAddres() + "'"
                    + "createddate ='" + entity.getCreatedDate() + "'"
                    + "lastmodifieddate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "";

            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Customer entity) {

        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from Customer where id = " + entity.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Customer> readList() {

        List<Customer> customerList = new ArrayList<>();

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Customer");

            while (rs.next()) {
                customerList.add(new Customer(
                        rs.getLong("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("addres"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                ));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return customerList;

    }

    @Override
    public Customer getEntityById(Long id) {

        Customer customer = null;
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Customer where id = " + id);

            rs.next();

            customer = new Customer(
                    rs.getLong("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("addres"),
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return customer;

    }

}
