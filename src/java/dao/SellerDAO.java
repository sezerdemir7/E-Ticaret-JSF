/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Seller;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Demirr
 */
@Stateless
public class SellerDAO extends BaseDAO<Seller> {

    public SellerDAO() {
        super(Seller.class);
    }

    public Seller login(Seller entity) {
        try {
            // Kullanıcıyı veritabanından sorgula
            Query query = em.createQuery("SELECT COUNT(s) FROM Seller s WHERE s.email = :email AND S.password = :password ");
            query.setParameter("email", entity.getEmail());
            query.setParameter("password", entity.getPassword());
            Long count = (Long) query.getSingleResult();

            // Eğer kullanıcı bulundu ve şifre doğru ise giriş başarılı kabul edilir
            if (count == 1) {
                return entity;
            }
        } catch (Exception e) {
            System.out.println("giriş yapılamadı" + e.getMessage());
        }
        // Kullanıcı bulunamadı veya şifre yanlış ise giriş başarısızdır
        return null;
    }

}

  /*  public Seller login(Seller entity) {

        Seller seller = null;

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from seller where email='" + entity.getEmail() + "'");
            if (rs.next()) {
                seller = new Seller(
                        rs.getLong("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                );
            }
            st.close();

            return seller;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public List<Seller> readList() {
        List<Seller> list = new ArrayList<>();
        try {
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from seller");

            while (rs.next()) {
                list.add(new Seller(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("email"),
                        rs.getString("password"), rs.getTimestamp("createddate"), rs.getTimestamp("lastmodifieddate")));
            }
             st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    public void create(Seller seller) {
        try {

            Statement st = this.getConnect().createStatement();
            st.executeUpdate("insert into seller(firstname,lastname,email,password) values ('" 
                    + seller.getFirstName() + "','" + seller.getLastName() + "',"
                    + "'" + seller.getEmail() + "','" + seller.getPassword() + "')");
             st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Seller entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Seller entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Seller getEntityById(Long id) {
        Seller seller =null;
        
        try{
            Statement st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from seller where id ="+id);
            
            rs.next();
            

                seller =new Seller(
                        rs.getLong("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")
                );
                 st.close();
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return seller;

    }

}
*/
