/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Customer;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author serki
 */
@Local
@Stateless
public class CustomerDAO extends BaseDAO<Customer> implements Serializable {

    public CustomerDAO() {
        super(Customer.class);
    }

    public Customer getLoginValid(String email, String pass) {
        Query q = this.em.createQuery("select u from Customer u where u.email = :email and u.password = :pass", Customer.class);
        q.setParameter("email", email);
        q.setParameter("pass", pass);
        List<Customer> l = q.getResultList();
        if (l.isEmpty()) {
            System.out.println("customer bulunmadı *****************");
            return null;
        } else {
            return l.get(0);
        }
    }

    public Customer login(Customer entity) {
        try {
            String jpql = "SELECT c FROM Customer c WHERE c.email = :email";
            List<Customer> customers = em.createQuery(jpql, Customer.class)
                    .setParameter("email", entity.getEmail())
                    .getResultList();

            if (!customers.isEmpty()) {
                return customers.get(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }
}

/*  public Customer login(Customer entity) {

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
            st.close();
            rs.close();

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
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Customer entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update customer set "
                    + "firstname = '" + entity.getFirstName() + "', "
                    + "lastname = '" + entity.getLastName() + "', "
                    + "password = '" + entity.getPassword() + "', "
                    + "email = '" + entity.getEmail() + "', "
                    + "addres = '" + entity.getAddres() + "', "
                    + "createddate = '" + entity.getCreatedDate() + "', "
                    + "lastmodifieddate = '" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'";

            st.executeUpdate(query);
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(Customer entity) {

        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from Customer where id = " + entity.getId());
            st.close();

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
            st.close();
            rs.close();
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
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return customer;

    }*/
