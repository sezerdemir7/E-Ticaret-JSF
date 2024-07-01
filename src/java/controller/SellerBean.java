/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Role;
import dao.SellerDAO;
import dao.StoreDAO;
import entity.Customer;
import entity.Seller;
import entity.Store;
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
 * @author Demirr
 */
@Named
@SessionScoped
public class SellerBean extends BaseBean<Seller> implements Serializable {

    @EJB
    private SellerDAO dao;
    @Inject
    private FacesContext fc;
    
    @EJB
    private StoreDAO storeDAO;

    public SellerBean() {
        super(Seller.class);
    }

    @Override
    public void create() {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(this.entity.getPassword().getBytes(StandardCharsets.UTF_8));
            String sha3Hex = bytesToHex(hashbytes);

            this.entity.setPassword(sha3Hex);
            this.entity.setRole(Role.SELLER);
            System.out.println("*******************");
            
            this.dao.create(this.entity);
            clearForm();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SellerBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update() {
        this.dao.update(entity);
        this.clearForm();
    }

    @Override
    public void delete() {
        this.dao.delete(entity);
        this.clearForm();
    }

    @Override
    public List<Seller> getList() {
        return this.dao.readList();
    }

    @Override
    public Seller getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }

   public String login() {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(this.entity.getPassword().getBytes(StandardCharsets.UTF_8));
            String sha3Hex = bytesToHex(hashbytes);

            // Hashlenmiş şifreyi kullanarak kullanıcı doğrulaması yapın
            Seller u = this.dao.getLoginValid(this.getEntity().getEmail(), sha3Hex);
            this.setEntity(u);
            if (u != null) {
                
                fc.getExternalContext().getSessionMap().put("validUser", u);
                return "/panel/seller/seller-home?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username veya şifre hatalı"));
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CustomerBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "/login?faces-redirect=true";
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
    
    public Store getStoreBySellerId(long sellerId){
        Store store=storeDAO.getStoreBySellerId(sellerId);
        this.getEntity().setStore(store);
       return store;
   }

}

/*

    public void create() {
        this.dao.create(entity);
        clearForm();
    }

    public void update() {
        this.dao.update(entity);
    }

    public void delete() {
        this.dao.delete(entity);
    }
    public Seller getEntity() {
        if(this.entity == null){
            this.entity = new Seller();
        }
        return entity;
    }

    public void setEntity(Seller entity) {
        this.entity = entity;
    }

    public List<Seller> getList() {
        return this.dao.readList();
    }

    public void setList(List<Seller> list) {
        this.list = list;
    }
 */
 /*

    public SellerBean() {
        super(Seller.class, SellerDAO.class);
    }
    public String login(){
        Seller sellerTest=this.getDao().login(this.getEntity());
       
        if(sellerTest!=null && sellerTest.getPassword().equals(this.getEntity().getPassword())){
            this.setEntity(sellerTest);
          return "/panel/seller/seller-home.xhtml?faces-redirect=true";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre Yanlış", "Şifre yanlış."));
            return null; // Başarısız giriş durumunda null döndürüyor
        }
    }


    
    
}*/
