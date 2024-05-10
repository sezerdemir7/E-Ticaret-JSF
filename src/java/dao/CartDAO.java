/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Cart;
import entity.CartItem;
import java.sql.PreparedStatement;
import entity.Customer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author serki
 */
public class CartDAO extends DBConnect implements BaseDAO<Cart> {

    private CustomerDAO customerDAO;
    private CartItemDAO cartItemDAO;

    public void create(Cart entity) {

        try {
            String query = "INSERT INTO cart (customerid,toplamfiyat,createddate,lastmodifieddate) VALUES (?,?,?,?)";
            PreparedStatement ps = this.getConnect().prepareStatement(query);
            ps.setLong(1, entity.getCustomer().getId());
            ps.setInt(2, 0);
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(Cart entity) {

        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update cart set "
                    + "customerid ='" + entity.getCustomer().getId() + "',  "
                    + "toplamfiyat = " + entity.getToplamFiyat() + ", "
                    + "createddate ='" + "2024-04-21 19:00:37.89874" + "', "
                    + "lastmodifieddate ='" + "2024-04-21 19:00:37.89874" + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "");

            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Cart entity) {
        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from Cart where id = " + entity.getId());
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Cart> readList() {
        List<Cart> cartList = new ArrayList<>();
        /*Cart cart=null;
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Cart");
           while(rs.next()){
               
           }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         */

        return cartList;

    }

    @Override
    public Cart getEntityById(Long cartId) {
        Cart cart = new Cart();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cart WHERE id = " + cartId);
            rs.next();
            Customer customer = getCustomerDAO().getEntityById(rs.getLong("customerid"));
            List<CartItem> cartItems = getCartItemDAO().getCartItemsListByCartId(cartId);

           /* cart = new Cart(
                    cartId,
                    customer,
                    cartItems,
                    rs.getInt("toplamfiyat"),
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );
            */
            cart.setCartItems(cartItems);
            cart.setCustomer(customer);
            cart.setToplamFiyat( rs.getInt("toplamfiyat"));
            cart.setLastModifiedDate(rs.getTimestamp("lastmodifieddate"));
            cart.setCreatedDate(rs.getTimestamp("createddate"));

            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("****cart buulundu efendim 22222***** cart_id===" + cart.getId());
        return cart;
    }

    public Cart getCartByCustomerId(Long customerId) {
        Cart cart = new Cart();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cart WHERE customerid = " + customerId);
            if (rs.next()) {
                cart = getEntityById(rs.getLong("id"));

            } else {
                Customer customer = getCustomerDAO().getEntityById(customerId);
                cart = new Cart();
                cart.setCustomer(customer);
                create(cart);

            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cart;
    }

    public CustomerDAO getCustomerDAO() {
        if (this.customerDAO == null) {
            this.customerDAO = new CustomerDAO();
        }
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public CartItemDAO getCartItemDAO() {
        if (this.cartItemDAO == null) {
            this.cartItemDAO = new CartItemDAO();
        }
        return cartItemDAO;
    }

    public void setCartItemDAO(CartItemDAO cartItemDAO) {
        this.cartItemDAO = cartItemDAO;
    }

}
