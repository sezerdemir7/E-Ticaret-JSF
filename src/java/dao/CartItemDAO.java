/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Cart;
import entity.CartItem;
import entity.Customer;
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
public class CartItemDAO extends DBConnect implements BaseDAO<CartItem> {

    private ProductDAO productDAO;
    private CartDAO cartDAO;

    @Override
    public void create(CartItem entity) {
        
        Cart cart=null;

        try {
            Statement st = this.getConnect().createStatement();
            
            st.executeUpdate("insert into CartItem (product_id, cart_id, toplamfiyat, adet, createddate, lastmodifieddate) "
                    + "values ('" + entity.getProduct().getId() + "',"
                    + "'" + 2 + "',"
                    + "'" + entity.getProduct().getPrice() + "',"
                    + "'" + 1 + "',"
                    + "'" + "2024-04-21 19:00:37.898743" + "',"
                    + "'" + "2024-04-21 19:00:37.898743" + "')");
            
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public void createCartItem(CartItem entity,Customer customer) {
        
        Cart cart=null;

        try {
            Statement st = this.getConnect().createStatement();
            
            cart=getCartDAO().getCartByCustomerId(customer.getId());
            
            st.executeUpdate("insert into CartItem (product_id, cart_id, toplamfiyat, adet, createddate, lastmodifieddate) "
                    + "values ('" + entity.getProduct().getId() + "',"
                    + "'" + cart.getId()+ "',"
                    + "'" + entity.getProduct().getPrice() + "',"
                    + "'" + 1 + "',"
                    + "'" + "2024-04-21 19:00:37.898743" + "',"
                    + "'" + "2024-04-21 19:00:37.898743" + "')");
            
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(CartItem entity) {
        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update CartItem set "
                    + "product_id ='" + entity.getProduct().getId() + "'  "
                    + "cart_id = '" + entity.getCart().getId() + "'"
                    + "toplamFiyat = '" + entity.getToplamFiyat() + "'"
                    + "adet = '" + entity.getAdet() + "'"
                    + "createDate ='" + entity.getCreatedDate() + "'"
                    + "lastModifiedDate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(CartItem entity) {
        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("delete from cartitem where id = " + entity.getId());

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
                Product product = this.productDAO.getEntityById(rs.getLong("product_id"));
                Cart cart = this.cartDAO.getEntityById(rs.getLong("cart_id"));
                cartItemList.add(new CartItem(
                        
                        product,
                        cart,
                        rs.getInt("toplamFiyat"),
                        rs.getInt("adet"),
                        rs.getLong("id"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                ));
            }

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

            Product product = this.productDAO.getEntityById(rs.getLong("product_id"));
            Cart cart = this.cartDAO.getEntityById(rs.getLong("cart_id"));
            cartItem = new CartItem(
                    product,
                    cart,
                    rs.getInt("toplamFiyat"),
                    rs.getInt("adet"),
                     rs.getLong("id"),
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cartItem;

    }

    public List<CartItem> getCartItemsListByCartId(Long cartId) {

        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem = new CartItem();
        Cart cart=getCartDAO().getEntityById(cartId);
        
        if(cart.getId()==null){
            System.out.println("********");
            System.out.println("********");
            System.out.println("burası cartItem Daao");
            System.out.println("********");
        }
        

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from cartitem where cart_id = " + cartId);

            while (rs.next()) {
                Product product = this.getProductDAO().getEntityById(rs.getLong("product_id"));
                cartItem = new CartItem(
                        product,
                        cart,
                        rs.getInt("toplamFiyat"),
                        rs.getInt("adet"),
                        rs.getLong("id"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                );
                cartItems.add(cartItem);

            }

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

}
