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

    @Override
    public void create(Product product) {
        try {
            // PreparedStatement oluştur
            PreparedStatement pst = this.getConnect().prepareStatement(
                    "INSERT INTO Product (name, stock, category_id, price, store_id, created_date, last_modified_date) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");

            // Parametreleri ayarla
            pst.setString(1, product.getName());
            pst.setInt(2, product.getStock());
            pst.setLong(3, product.getCategory().getId()); // Kategoriye referans
            pst.setInt(4, product.getPrice());
            pst.setLong(5, product.getStore().getId()); // Mağazaya referans

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
        try {
            // PreparedStatement oluştur
            PreparedStatement pst = this.getConnect().prepareStatement("SELECT * FROM Product");

            // Sorguyu çalıştır ve sonuçları al
            ResultSet rs = pst.executeQuery();

            // Her bir satırı işle
            while (rs.next()) {
                // Product nesnesini oluştur ve listeye ekle
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setStock(rs.getInt("stock"));

              
                //Category category = getCategoryById(rs.getLong("category_id"));
                Category category = new Category(1L, "Teknoloji", Timestamp.valueOf("2024-04-18 17:08:26.247016"), Timestamp.valueOf("2024-04-18 17:08:26.247016"));
                product.setCategory(category);

                //Store store = getStoreById(rs.getLong("store_id"));
                Seller seller=new Seller(1L,"deneme","tes","kjsadkvask","debb@lhsd.com",Timestamp.valueOf("2024-04-18 17:08:26.247016"),Timestamp.valueOf("2024-04-18 17:08:26.247016"));
                Store store=new Store("teknomarket",seller,1L,Timestamp.valueOf("2024-04-18 17:08:26.247016"),Timestamp.valueOf("2024-04-18 17:08:26.247016"));
                
                product.setStore(store);

                product.setPrice(rs.getInt("price"));
              //  product.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
               // product.setLastModifiedDate(rs.getTimestamp("last_modified_date").toLocalDateTime());

                productList.add(product);
                System.err.println("*******************");
                System.err.println("*******************");
                System.err.println("*******************");
                System.err.println("*******************");
                
                
                System.out.println("product listeleme işlemei başarılı");
            }

            // PreparedStatement'ı kapat
            pst.close();
        } catch (SQLException e) {
            System.err.println("*******************");
            System.err.println("*******************");
            System.err.println("*******************");
            System.err.println("*******************");
            System.out.println("Error while reading product list: " + e.getMessage());
        }
        return productList;
    }

    @Override
    public Product getEntityById(Long id) {
        return null;
    }

}
