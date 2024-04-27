/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartDAO;
import dao.CustomerDAO;
import entity.Customer;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class CustomerBean extends BaseBean<Customer, CustomerDAO> {

    private CartDAO cartDAO;

    public CustomerBean() {
        super(null, null);
    }

    public CustomerBean(Customer entity, CustomerDAO dao) {
        super(entity, dao);
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

    @Override
    protected Customer createEntityInstance() {
        return new Customer();
    }

    @Override
    protected CustomerDAO createDAOInstance() {

        return new CustomerDAO();

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
