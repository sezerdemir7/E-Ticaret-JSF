/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Role;
import dao.CartDAO;
import dao.CustomerDAO;
import entity.Customer;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class CustomerBean extends BaseBean<Customer> implements Serializable {

    @EJB
    private CustomerDAO dao;
    @Inject
    private FacesContext fc;

    public CustomerBean() {
        super(Customer.class);
    }

    @Override
    public void create() {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(this.entity.getPassword().getBytes(StandardCharsets.UTF_8));
            String sha3Hex = bytesToHex(hashbytes);

            this.entity.setPassword(sha3Hex);
            this.entity.setRole(Role.CUSTOMER);
            System.out.println("*******************");
            
            this.dao.create(this.entity);
            clearForm();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CustomerBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update() {
        this.dao.update(entity);
    }

    @Override
    public void delete() {
        this.dao.delete(entity);
    }

    @Override
    public List<Customer> getList() {
        return this.dao.readList();

    }

    @Override
    public Customer getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }

    public String login() {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(this.entity.getPassword().getBytes(StandardCharsets.UTF_8));
            String sha3Hex = bytesToHex(hashbytes);

            // Hashlenmiş şifreyi kullanarak kullanıcı doğrulaması yapın
            Customer u = this.dao.getLoginValid(this.getEntity().getEmail(), sha3Hex);
            this.setEntity(u);
            if (u != null) {
                
                fc.getExternalContext().getSessionMap().put("validUser", u);
                return "/index?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username veya şifre hatalı"));
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CustomerBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "/login?faces-redirect=true";
    }
    public void deleteCustomer(Customer customer){
        this.dao.delete(customer);
       
    }
    private Customer entity;

    public void setEntity(Customer entity) {
        this.entity = entity;
    } 

    public String login21() {
        Customer customerTest = this.dao.login(this.getEntity());

        if (customerTest != null && customerTest.getPassword().equals(this.getEntity().getPassword())) {
            this.setEntity(customerTest);
            return "/panel/product/product-list.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre yanlış", "şifre Yanlış"));
            return null;
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}

/*private CartDAO cartDAO;

    public CustomerBean() {
        super(Customer.class, CustomerDAO.class);
    }


    public void deleteCustomer(Customer customer){
        setEntity(customer);
        getDao().delete(getEntity());
    }

    public String login() {
        Customer customerTest = this.getDao().login(this.getEntity());

        if (customerTest != null && customerTest.getPassword().equals(this.getEntity().getPassword())) {
            this.setEntity(customerTest);
            
            return "/panel/product/product-list.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre Yanlış", "Şifre yanlış."));
            return null; // Başarısız giriş durumunda null döndürüyor
        }
    }

    @Override
    public void create() {
        super.create();
    }


    public CartDAO getCartDAO() {
        if (this.cartDAO == null) {
            cartDAO = new CartDAO();
        }
        return cartDAO;
    }

    public void setCartDAO(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }

}
 */
