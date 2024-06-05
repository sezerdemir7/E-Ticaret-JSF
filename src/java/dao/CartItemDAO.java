/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Cart;
import entity.CartItem;
import entity.Customer;
import entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serki
 */
public class CartItemDAO extends BaseDAO<CartItem> {

    public CartItemDAO() {
        super(CartItem.class);
    }
}
    /*
    private ProductDAO productDAO;
    private CartDAO cartDAO;

    @Override
    public void create(CartItem entity) {
        
        

        try {
            Statement st = this.getConnect().createStatement();
            
            st.executeUpdate("insert into CartItem (productid, cartid, toplamfiyat, adet, createddate, lastmodifieddate) "
                    + "values ('" + entity.getProduct().getId() + "',"
                    + "'" + entity.getCart().getId() + "',"
                    + "'" + entity.getProduct().getPrice() + "',"
                    + "'" + 1 + "',"
                    + "'" + "2024-04-21 19:00:37.898743" + "',"
                    + "'" + "2024-04-21 19:00:37.898743" + "')");
            
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    /*public void createCartItem(CartItem entity,Customer customer) {
        
        Cart cart=null;

        try {
            Statement st = this.getConnect().createStatement();
           
            
            cart=getCartDAO().getCartByCustomerId(customer.getId());
             
             
            st.executeUpdate("insert into CartItem (productid, cartid, toplamfiyat, adet, createddate, lastmodifieddate) "
                    + "values ('" + entity.getProduct().getId() + "',"
                    + "'" + cart.getId()+ "',"
                    + "'" + entity.getProduct().getPrice() + "',"
                    + "'" + 1 + "',"
                    + "'" + "2024-04-21 19:00:37.898743" + "',"
                    + "'" + "2024-04-21 19:00:37.898743" + "')");
            
            st.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

    }*/
 /*
    @Override
    public void update(CartItem entity) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update CartItem set "
                    + "productid ='" + entity.getProduct().getId() + "'  "
                    + "cartid = '" + entity.getCart().getId() + "'"
                    + "toplamfiyat = '" + entity.getToplamFiyat() + "'"
                    + "adet = '" + entity.getAdet() + "'"
                    + "createdate ='" + entity.getCreatedDate() + "'"
                    + "lastmodifieddate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "");
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

   /* @Override
    public void delete(CartItem entity) {
        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from cartitem where id = " + entity.getId());
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<CartItem> readList() {
        List<CartItem> cartItemList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from CartItem");

            while (rs.next()) {
                Product product =getProductDAO().getEntityById(rs.getLong("productid"));
                Cart cart =getCartDAO().getEntityById(rs.getLong("cartid"));
                cartItemList.add(new CartItem(
                        
                        product,
                        cart,
                        rs.getInt("toplamfiyat"),
                        rs.getInt("adet"),
                        rs.getLong("id"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                ));
                
            }
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cartItemList;

    }

    @Override
    public CartItem getEntityById(Long id) {

        CartItem cartItem = null;

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from CartItem where id = " + id);

            rs.next();

            Product product = getProductDAO().getEntityById(rs.getLong("productid"));
            Cart cart = getCartDAO().getEntityById(rs.getLong("cartid"));
            cartItem = new CartItem(
                    product,
                    cart,
                    rs.getInt("toplamfiyat"),
                    rs.getInt("adet"),
                     rs.getLong("id"),
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cartItem;

    }

    public List<CartItem> getCartItemsListByCart(Cart cart) {

        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem = new CartItem();
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from cartitem where cartid = " + cart.getId());

            while (rs.next()) {
                Product product = this.getProductDAO().getEntityById(rs.getLong("productid"));
                cartItem = new CartItem(
                        product,
                        cart,
                        rs.getInt("toplamfiyat"),
                        rs.getInt("adet"),
                        rs.getLong("id"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                );
                cartItems.add(cartItem);

            }
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cartItems;

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

    public CartDAO getCartDAO() {
        if (cartDAO == null) {
            this.cartDAO = new CartDAO();
        }
        return cartDAO;
    }

    public void setCartDAO(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }
     */

