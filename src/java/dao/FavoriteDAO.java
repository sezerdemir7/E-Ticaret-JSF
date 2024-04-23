/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Customer;
import entity.Favorite;
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
public class FavoriteDAO extends DBConnect implements BaseDAO<Favorite>{

   private ProductDAO productDAO;
    private CustomerDAO customerDAO;

    @Override
    public void create(Favorite entity) {

        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into Favorite (Product, Customer, createdDate, lastModifiedDate) "
                    + "values ('" + entity.getProduct().getId() + "',"
                    + "'" + entity.getCustomer().getId() + "',"
                    + "'" + entity.getCreatedDate() + "',"
                    + "'" + entity.getLastModifiedDate() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Favorite entity) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update Favorite set "
                    + "product_id ='" + entity.getProduct().getId() + "'  "
                    + "cart_id = '" + entity.getCustomer().getId() + "'"
                    + "createDate ='" + entity.getCreatedDate() + "'"
                    + "lastModifiedDate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Favorite entity) {
        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from Favorite where id = " + entity.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Favorite> readList() {
        List<Favorite> favoriteList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from CartItem");

            while (rs.next()) {
                Product product = this.productDAO.getEntityById(rs.getLong("product_id"));
                Customer customer = this.customerDAO.getEntityById(rs.getLong("cart_id"));
                favoriteList.add(new Favorite(
                        product,
                        customer,
                        rs.getTimestamp("createdDate"),
                        rs.getTimestamp("lastModifiedDate")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return favoriteList;

    }

    @Override
    public Favorite getEntityById(Long id) {

        Favorite favorite = null;

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Favorite where id = " + id);

            rs.next();

            Product product = this.productDAO.getEntityById(rs.getLong("product_id"));
            Customer customer = this.customerDAO.getEntityById(rs.getLong("cart_id"));
            favorite = new Favorite(
                    product,
                    customer,
                    rs.getTimestamp("createdDate"),
                    rs.getTimestamp("lastModifiedDate")
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return favorite;

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

    public CustomerDAO getCustomerDAO() {
        if(customerDAO == null){
            this.customerDAO = new CustomerDAO();
        }
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    
    
}
