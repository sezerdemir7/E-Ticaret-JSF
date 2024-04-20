/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BaseDAO;
import dao.SellerDAO;
import entity.Category;
import entity.Seller;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author Demirr
 */
@Named
@SessionScoped
public class SellerBean extends BaseBean<Seller, SellerDAO>{

    public SellerBean(Seller entity, SellerDAO dao) {
        super(entity, dao);
    }
    


    public SellerBean() {
        super(null, null);
    }
    public String login(){
        Seller sellerTest=this.getDao().login(this.getEntity());
       
        if(sellerTest!=null && sellerTest.getPassword().equals(this.getEntity().getPassword())){
            this.setEntity(sellerTest);
          return "/index.xhtml?faces-redirect=true";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre Yanlış", "Şifre yanlış."));
            return null; // Başarısız giriş durumunda null döndürüyor
        }
    }

    @Override
    protected Seller createEntityInstance() {
        return new Seller();
    }

    @Override
    protected SellerDAO createDAOInstance() {
        return new SellerDAO();
    }

    
    
}
