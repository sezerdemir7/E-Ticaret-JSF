/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Favorite;
import entity.Product;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author serki
 */
@Local
@Stateless
public class FavoriteDAO extends BaseDAO<Favorite> implements Serializable{
    
    public FavoriteDAO() {
        super(Favorite.class);
    }

    
    public boolean isFavoriteExists(Long customerId, Long productId) {
        TypedQuery<Favorite> query = em.createQuery(
            "SELECT f FROM Favorite f WHERE f.customer.id = :customerId AND f.product.id = :productId", 
            Favorite.class
        );
        query.setParameter("customerId", customerId);
        query.setParameter("productId", productId);
        
        List<Favorite> results = query.getResultList();
        return !results.isEmpty();
    }
    
    
    
    
    public List<Product> getFavoriteListByCustomerId(Long customerId) {
        List<Product>productList = null;
        try {
            TypedQuery<Favorite> query = em.createQuery(
                "SELECT f FROM Favorite f WHERE f.customer.id = :customerId", 
                Favorite.class);
            query.setParameter("customerId", customerId);
            List<Favorite> favorites = query.getResultList();
            productList = favorites.stream().map(Favorite::getProduct).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error while reading favorite list: " + e.getMessage());
        }
        return productList;
    }
    
    public List<Favorite> getListByCustomerId(Long customerId){
        TypedQuery<Favorite> query = em.createQuery("SELECT f FROM Favorite f WHERE f.customer.id = :customerId", Favorite.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }
    
} 
   /* private ProductDAO productDAO;

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
    }*/
