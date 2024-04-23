/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Cart;
import entity.CartItem;
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

        try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into CartItem (Product, Cart, toplamFiyat, adet, createdDate, lastModifiedDate) "
                    + "values ('" + entity.getProduct().getId() + "',"
                    + "'" + entity.getCart().getId() + "',"
                    + "'" + entity.getToplamFiyat() + "',"
                    + "'" + entity.getAdet() + "',"
                    + "'" + entity.getCreatedDate() + "',"
                    + "'" + entity.getLastModifiedDate() + "')");

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

            st.executeUpdate("delete from CartItem where id = " + entity.getId());

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
                        rs.getTimestamp("createdDate"),
                        rs.getTimestamp("lastModifiedDate")
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
                    rs.getTimestamp("createdDate"),
                    rs.getTimestamp("lastModifiedDate")
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cartItem;

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
