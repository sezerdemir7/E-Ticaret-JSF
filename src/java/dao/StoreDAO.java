/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Seller;
import entity.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serki
 */
public class StoreDAO extends BaseDAO<Store> {

  
    public StoreDAO() {
        super(Store.class);
    }


    public void saveStore(Store entity) {
        try {
            Seller seller = em.find(Seller.class, entity.getSeller().getId());
            if (seller == null) {
                throw new IllegalArgumentException("seller not found!");
            }

            entity.setSeller(seller);
            em.persist(seller);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

/*
    private SellerDAO sellerDAO;

    @Override
    public void create(Store entity) {

        try {
            // PreparedStatement oluştur
            PreparedStatement pst = this.getConnect().prepareStatement(
                    "INSERT INTO store (name,sellerid) "
                    + "VALUES (?, ?)");

            // Parametreleri ayarla
            pst.setString(1, entity.getName());
            pst.setLong(2, entity.getSeller().getId());

            pst.executeUpdate();

            // PreparedStatement'ı kapat
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error while creating product: " + e.getMessage());
        }

    }

    @Override
    public void update(Store entity) {

        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("update Store set"
                    + " name = '" + entity.getName() + "'"
                    + "sellerid ='" + entity.getSeller().getId() + "' "
                    + "createddate ='" + entity.getCreatedDate() + "'"
                    + "lastmodifieddate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Store entity) {

        try {
            Statement st = this.getConnect().createStatement();
            st.executeUpdate("delete from Store where id =" + entity.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Store> readList() {

        List<Store> storeList = new ArrayList<>();

        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from Store");

            while (rs.next()) {
                Seller seller = this.getSellerDAO().getEntityById(rs.getLong("sellerid"));

                storeList.add(new Store(
                        rs.getString("name"),
                        seller,
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                ));
                 st.close();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return storeList;

    }

    @Override
    public Store getEntityById(Long id) {
        Store store =null;
        
        try{
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from store where id ="+id);
            
            rs.next();
            Seller seller = getSellerDAO().getEntityById(rs.getLong("sellerid"));

                store =new Store(
                        rs.getString("name"),
                        seller,
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                );
                 st.close();
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return store;


    }
    
    public Store getStoreBySellerId(long sellerId) {
        Store store =null;
        
        try{
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from store where sellerid ="+sellerId);
            
            rs.next();
            Seller seller = getSellerDAO().getEntityById(rs.getLong("sellerid"));

                store =new Store(
                        rs.getString("name"),
                        seller,
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                );
                 st.close();
                 rs.close();
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return store;
    }

    public SellerDAO getSellerDAO() {
        if (sellerDAO == null) {
            this.sellerDAO = new SellerDAO();
        }
        return sellerDAO;
    }

    public void setSellerDAO(SellerDAO sellerDAO) {
        this.sellerDAO = sellerDAO;
    }

    

}
 */
