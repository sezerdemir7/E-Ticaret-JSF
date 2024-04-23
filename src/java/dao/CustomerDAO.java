/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Admin;
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

    @Override
    public void create(Customer entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "insert into Customer(firstName, lastName, password, email, addres, createdDate, lastModifiedDate) values ('"
                    + entity.getFirstName() + "',"
                    + "'" + entity.getLastName() + "',"
                    + "'" + entity.getPassword() + "'"
                    + ",'" + entity.getEmail() + "',"
                    + ",'" + entity.getAddres() + "',"
                    + "'" + entity.getCreatedDate() + "'"
                    + ",'" + entity.getLastModifiedDate() + "')";

            st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Customer entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update Customer set "
                    + "firstname ='" + entity.getFirstName() + "'  "
                    + "lastName = '" + entity.getLastName() + "' "
                    + "password = '" + entity.getPassword() + "' "
                    + "email = '" + entity.getEmail() + "' "
                    + "addres = '" + entity.getAddres() + "'"
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
                        rs.getString("addres"),
                        rs.getLong("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getTimestamp("createdDate"),
                        rs.getTimestamp("lastModifiedDate")
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
                    rs.getString("addres"),
                    rs.getLong("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getTimestamp("createdDate"),
                    rs.getTimestamp("lastModifiedDate")
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return customer;

    }

}
