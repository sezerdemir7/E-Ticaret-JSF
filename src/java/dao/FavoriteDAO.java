/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
public class FavoriteDAO extends DBConnect implements BaseDAO<Favorite> {
    
    private ProductDAO productDAO;

    public ProductDAO getProductDAO() {
        if(this.productDAO==null){
            productDAO=new ProductDAO();
        }
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

 

    @Override
    public void create(Favorite favorite) {
        try {

            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into favorite(productid,customerid) values ('" + favorite.getProduct().getId() + "','" + favorite.getCustomer().getId() + "')");
            st.close();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Product> getFavoriteListByCustomerId(Long customerId) {
        List<Long> productList = new ArrayList<>();
        List<Product> productObjectList = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from favorite");

            while (rs.next()) {

                productList.add(rs.getLong("productid"));

            }
            st.close();
            rs.close();

        } catch (Exception e) {

            System.out.println("Error while reading product list: " + e.getMessage());
        }
        
        //productDAO.getProductListByProductId(productList);
        
        return getProductDAO().readList();
    }

    @Override
    public void update(Favorite entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Favorite entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Favorite> readList() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Favorite getEntityById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}