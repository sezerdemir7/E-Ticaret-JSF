/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import util.DBConnect;
import entity.Product;
import entity.Seller;
import entity.Store;
import java.sql.SQLException;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Demirr
 */
public class ProductDAO extends DBConnect implements BaseDAO<Product> {

    private CategoryDAO categoryDAO;
    private SellerDAO SellerDAO;
    private StoreDAO storeDAO;

    @Override
    public void create(Product product) {
        
        try {
            // PreparedStatement oluştur
            PreparedStatement pst = this.getConnect().prepareStatement(
                    "INSERT INTO product (name, stock, detail,category_id, price, store_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?)");

            // Parametreleri ayarla
            Category category = new Category(1L, "Teknoloji", Timestamp.valueOf("2024-04-18 17:08:26.247016"), Timestamp.valueOf("2024-04-18 17:08:26.247016"));

            Store store=null;
                    
            pst.setString(1, product.getName());
            pst.setInt(2, product.getStock());
            pst.setString(3, product.getDetail());
            pst.setLong(4, category.getId()); // Kategoriye referans
            pst.setInt(5, product.getPrice());
            pst.setLong(6, store.getId()); // Mağazaya referans

            // Sorguyu çalıştır
            pst.executeUpdate();

            // PreparedStatement'ı kapat
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error while creating product: " + e.getMessage());
        }
    }

    @Override
    public void update(Product entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Product entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Product> readList() {
        List<Product> productList = new ArrayList<>();
        Category category = null;
        Store store = null;
        try {
            PreparedStatement pst = this.getConnect().prepareStatement("SELECT * FROM Product");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setStock(rs.getInt("stock"));
                product.setDetail(rs.getString("detail"));

                category = getCategoryDAO().getEntityById(rs.getLong("category_id"));
                product.setCategory(category);
                product.setStore(store);

                product.setPrice(rs.getInt("price"));
                 product.setCreatedDate(rs.getTimestamp("created_date"));
                product.setLastModifiedDate(rs.getTimestamp("last_modified_date"));

                productList.add(product);

                System.out.println("product listeleme işlemei başarılı");
            }

            pst.close();
        } catch (SQLException e) {
            
            System.out.println("Error while reading product list: " + e.getMessage());
        }
        return productList;
    }

    public Product getEntityById(Long productId) {

        Product product = null;
        Category category = null;
        Store store = null;

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from product where id = " + productId);

            rs.next();

            category = getCategoryDAO().getEntityById(rs.getLong("category_id"));
            
            System.out.println("*** simdi product daodayım");
            
            store = getStoreDAO().getEntityById(rs.getLong("store_id"));

            product = new Product(
                    rs.getLong("id"),
                    rs.getTimestamp("created_date"),
                    rs.getTimestamp("last_modified_date"),
                    rs.getString("name"),
                    rs.getInt("stock"),
                    rs.getString("detail"),
                    category,
                    rs.getInt("price"),
                    store
            );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return product;

    }

    public CategoryDAO getCategoryDAO() {
        if (this.categoryDAO == null) {
            categoryDAO = new CategoryDAO();
        }
        return categoryDAO;
    }

    public StoreDAO getStoreDAO() {
        if (this.storeDAO == null) {
            storeDAO = new StoreDAO();
        }
        return storeDAO;
    }

    public List<Product> getProductListByCategoryId(Long categoryId) {
        List<Product> productList = new ArrayList<>();
        Category category = null;
        Store store = null;
        try {
            PreparedStatement pst = this.getConnect().prepareStatement("SELECT * FROM Product where category_id="+categoryId);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setStock(rs.getInt("stock"));
                product.setDetail(rs.getString("detail"));

                category = getCategoryDAO().getEntityById(rs.getLong("category_id"));
                product.setCategory(category);
                product.setStore(store);

                product.setPrice(rs.getInt("price"));
                 product.setCreatedDate(rs.getTimestamp("created_date"));
                product.setLastModifiedDate(rs.getTimestamp("last_modified_date"));

                productList.add(product);

                System.out.println("product listeleme işlemei başarılı");
            }

            pst.close();
        } catch (SQLException e) {
            
            System.out.println("Error while reading product list: " + e.getMessage());
        }
        return productList;
    }

}
