/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartDAO;
import dao.CustomerDAO;
import entity.Customer;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class CustomerBean extends BaseBean<Customer> implements Serializable {

    @EJB
    private CustomerDAO dao;

    public CustomerBean() {
        super(Customer.class);
    }

    @Override
    public void create() {
        this.dao.create(entity);
        clearForm();
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
        Customer customerTest = this.dao.login(this.getEntity());

        if (customerTest != null && customerTest.getPassword().equals(this.getEntity().getPassword())) {
            this.setEntity(customerTest);
            return "/panel/product/product-list.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Şifre yanlış", "şifre Yanlış"));
            return null;
        }
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
