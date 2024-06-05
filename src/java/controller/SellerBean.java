/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SellerDAO;
import entity.Seller;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Demirr
 */
@Named
@SessionScoped
public class SellerBean extends BaseBean<Seller> implements Serializable {

    @EJB
    private SellerDAO dao;

    public SellerBean() {
        super(Seller.class);
    }

    @Override
    public void create() {
        this.dao.create(entity);
        this.clearForm();
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
        Seller sellerTest = this.dao.login(this.getEntity());

        if (sellerTest != null && sellerTest.getPassword().equals(this.getEntity().getPassword())) {
            this.setEntity(sellerTest);
            return "/panel/seller/seller-home.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre yanlış", "şifre Yanlış"));
            return null;
        }
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
