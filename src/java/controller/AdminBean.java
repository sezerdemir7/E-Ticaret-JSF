/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Role;
import dao.AdminDAO;
import entity.Admin;
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
public class AdminBean extends BaseBean<Admin> implements Serializable {

    @EJB
    private AdminDAO dao;
    @Inject
    private FacesContext fc;

    public AdminBean() {
        super(Admin.class);
    }
    
    @Override
    public void create() {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(this.entity.getPassword().getBytes(StandardCharsets.UTF_8));
            String sha3Hex = bytesToHex(hashbytes);

            this.entity.setPassword(sha3Hex);
            this.entity.setRole(Role.ADMIN);
            System.out.println("*******************");
            
            this.dao.create(this.entity);
            clearForm();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<Admin> getList() {
        return this.dao.readList();
    }
    @Override
    public Admin getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }
    public String login() {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(this.entity.getPassword().getBytes(StandardCharsets.UTF_8));
            String sha3Hex = bytesToHex(hashbytes);

            // Hashlenmiş şifreyi kullanarak kullanıcı doğrulaması yapın
            Admin u = this.dao.getLoginValid(this.getEntity().getEmail(), sha3Hex);
            this.setEntity(u);
            if (u != null) {
                
                fc.getExternalContext().getSessionMap().put("validUser", u);
                return "/panel/admin/admin-home?faces-redirect=true";
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username veya şifre hatalı"));
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "/login?faces-redirect=true";
    }
    
    

    
    public String login21(){
        Admin adminTest = this.dao.login(this.getEntity());
        
        if(adminTest != null && adminTest.getPassword().equals(this.getEntity().getPassword())){
            this.setEntity(adminTest);
            return "/panel/admin/admin-home.xhtml?faces-redirect=true";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Şifre yanlış", "şifre Yanlış"));
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
/*

    public void clearForm() {
        this.entity = new Admin();
    }

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
    public Admin getEntity() {
        if(this.entity == null){
            this.entity = new Admin();
        }
        return entity;
    }

    public void setEntity(Admin entity) {
        this.entity = entity;
    }*/
    
  

    /* public AdminBean() {
        super(Admin.class, AdminDAO.class);
    }*/

 /* public void login(){
        if(dao.){
            fc.getExternalContext().getSessionMap().put(key, this)
        }
    }
     */
 /*public Admin getAdmin() {
        if(this.admin == null){
            this.admin = new Admin();
        }
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    /*
    public jpadao getJp() {
        if(this.jp == null){
            this.jp = new jpadao();
        }
        return jp;
    }

    public void setJp(jpadao jp) {
        this.jp = jp;
    }
     */

 /*  private String email;
    private String password;
  /*  public String login() {
        boolean loggedIn = this.getDao().login(email,password);
        if (loggedIn) {
            // Başarılı giriş durumunda yönlendirme yapılabilir veya mesaj gösterilebilir
            return  "/panel/admin/admin-home.xhtml?faces-redirect=true";
        } else {
            // Başarısız giriş durumunda hata mesajı gösterilebilir
            return "failure";
        }
    }*/

 /* public AdminDAO getDao() {
        if(this.dao == null){
            this.dao = new AdminDAO();
        }
        return dao;
    }

    public void setDao(AdminDAO dao) {
        this.dao = dao;
    }*/
    // bundan öncesi bende
    /* Admin adminTest = this.getDao().login(this.getEntity());

        if (adminTest != null && adminTest.getPassword().equals(this.getEntity().getPassword())) {
            this.setEntity(adminTest);
            return "/panel/admin/admin-home.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre Yanlış", "Şifre yanlış."));
            return null; // Başarısız giriş durumunda null döndürüyor
        }*/
 /*public void save (Admin entity){
        getJp().saveJpa(entity);
    }*/

//}
