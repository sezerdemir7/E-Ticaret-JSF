/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Admin;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author serki
 */
@Local
@Stateless
public class AdminDAO extends BaseDAO<Admin> implements Serializable{

    
    public AdminDAO() {
        super(Admin.class);
    }

    
    public Admin login(Admin entity) {
        try {
            String jpql = "SELECT a FROM Admin a WHERE a.email = :email";
            List<Admin> sellers = em.createQuery(jpql, Admin.class)
                    .setParameter("email", entity.getEmail())
                    .getResultList();

            if (!sellers.isEmpty()) {
                return sellers.get(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    
    }
}
    
    /*public Admin login(Admin entity) {
        try {
            // Kullanıcıyı veritabanından sorgula
            //Query query = em.createQuery("select * from admin where email='"+admin.getEmail()+"' and password='"+admin.getPassword());
            Query query = em.createQuery("SELECT COUNT(a) FROM Admin a WHERE a.email = :email AND a.password = :password");
            query.setParameter("email", entity.getEmail());
            query.setParameter("password", entity.getPassword());
            Long count = (Long) query.getSingleResult();
            
            // Eğer kullanıcı bulundu ve şifre doğru ise giriş başarılı kabul edilir
            if (count == 1) {
                return entity;
            }
        } catch (Exception e) {
            System.out.println("giriş yapılamadı"+e.getMessage());
        }
        // Kullanıcı bulunamadı veya şifre yanlış ise giriş başarısızdır
        return null;
    }*/
    
    
        
   /* public void save(Admin entity) {
        em.persist(entity);

    }*/
    
    
    
   /* public AdminDAO(Class<Admin> entityClass) {
        super(entityClass);
    }
   
    public AdminDAO() {
        super(null);
    }*/

    
    /*
}
    
    
    
    
    
    
   /* public Admin login(Admin entity) {
        Admin admin = null;

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from admin where email='" + entity.getEmail() + "'");
            if (rs.next()) {
                admin = new Admin(
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
            rs.close();

            return admin;

        } catch (Exception e) {
            System.out.println("giriş yapılamadı"+e.getMessage());
        }
        return null;
    }

    @Override
    public void create(Admin entity) {
        
        
        
        
        
       /* try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into Admin(firstname, lastname, password, email, createddate, lastmodifieddate) values ('"
                    + entity.getFirstName() + "',"
                    + "'" + entity.getLastName() + "',"
                    + "'" + entity.getPassword() + "'"
                    + ",'" + entity.getEmail() + "',"
                    + "'" + "2024-04-21 19:00:37.898743" + "'"
                    + ",'" +" 2024-04-21 19:00:37.898743"+ "')");
            st.close();
            

        } catch (Exception e) {
            System.out.println("Admin kayıt edilemedi"+e.getMessage());
        }*/

    /*}

    @Override
    public void update(Admin entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update admin set "
                    + "firstname ='" + entity.getFirstName() + "'  "
                    + "lastname = '" + entity.getLastName() + "' "
                    + "password = '" + entity.getPassword() + "' "
                    + "email = '" + entity.getEmail() + "' "
                    + "createdate ='" + entity.getCreatedDate() + "'"
                    + "lastmodifieddate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "";

            st.executeUpdate(query);
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Admin entity) {

        try {
            Statement st = this.getConnect().createStatement();

            String query = "delete from Admin where id = " + entity.getId();
            st.executeUpdate(query);
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Admin> readList() {

        List<Admin> adminList = new ArrayList<>();

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Admin");

            while (rs.next()) {
                adminList.add(new Admin(
                        rs.getLong("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")));
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return adminList;
    }

    @Override
    public Admin getEntityById(Long id) {

        Admin admin = null;
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Admin where id = " + id);

            rs.next();

            admin = new Admin(
                    rs.getLong("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return admin;

    }*/


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   /* public Admin login(Admin entity) {
        Admin admin = null;

        Statement st;
        try {
            st = this.getConnect().createStatement();
            ResultSet rs = st.executeQuery("select * from admin where email='" + entity.getEmail() + "'");
            if (rs.next()) {
                admin = new Admin(
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
            rs.close();

            return admin;

        } catch (Exception e) {
            System.out.println("giriş yapılamadı"+e.getMessage());
        }
        return null;
    }

    @Override
    public void create(Admin entity) {
        
        
        
        
        
       /* try {
            Statement st = this.getConnect().createStatement();

            st.executeUpdate("insert into Admin(firstname, lastname, password, email, createddate, lastmodifieddate) values ('"
                    + entity.getFirstName() + "',"
                    + "'" + entity.getLastName() + "',"
                    + "'" + entity.getPassword() + "'"
                    + ",'" + entity.getEmail() + "',"
                    + "'" + "2024-04-21 19:00:37.898743" + "'"
                    + ",'" +" 2024-04-21 19:00:37.898743"+ "')");
            st.close();
            

        } catch (Exception e) {
            System.out.println("Admin kayıt edilemedi"+e.getMessage());
        }*/

    /*}

    @Override
    public void update(Admin entity) {

        try {
            Statement st = this.getConnect().createStatement();
            String query = "update admin set "
                    + "firstname ='" + entity.getFirstName() + "'  "
                    + "lastname = '" + entity.getLastName() + "' "
                    + "password = '" + entity.getPassword() + "' "
                    + "email = '" + entity.getEmail() + "' "
                    + "createdate ='" + entity.getCreatedDate() + "'"
                    + "lastmodifieddate ='" + entity.getLastModifiedDate() + "' "
                    + "where id = '" + entity.getId() + "'"
                    + "";

            st.executeUpdate(query);
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(Admin entity) {

        try {
            Statement st = this.getConnect().createStatement();

            String query = "delete from Admin where id = " + entity.getId();
            st.executeUpdate(query);
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Admin> readList() {

        List<Admin> adminList = new ArrayList<>();

        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Admin");

            while (rs.next()) {
                adminList.add(new Admin(
                        rs.getLong("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getTimestamp("createddate"),
                        rs.getTimestamp("lastmodifieddate")));
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return adminList;
    }

    @Override
    public Admin getEntityById(Long id) {

        Admin admin = null;
        try {
            Statement st = this.getConnect().createStatement();

            ResultSet rs = st.executeQuery("select * from Admin where id = " + id);

            rs.next();

            admin = new Admin(
                    rs.getLong("id"),
                    rs.getString("firstname"),
                    rs.getString("lastname"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getTimestamp("createddate"),
                    rs.getTimestamp("lastmodifieddate")
            );
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return admin;

    }*/