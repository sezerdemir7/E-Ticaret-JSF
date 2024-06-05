/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartDAO;
import entity.Cart;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class CartBean extends BaseBean<Cart> implements Serializable {

    @EJB
    private CartDAO dao;

    public CartBean() {
        super(Cart.class);
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
    public List<Cart> getList() {
        return this.dao.readList();
    }

    @Override
    public Cart getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }

}
  /*  public List<CartItem> getCartByCuctomerId(Customer customer) {
        Cart cart = new Cart();
        
        
        cart = getDao().getCartByCustomer(customer);
        cart.setCustomer(customer);
        this.setEntity(cart);
        
        List<CartItem> cartItems=getCartItemDAO().getCartItemsListByCart(cart);
        return cartItems;
    }

    public CustomerDAO getCustomerDAO() {
        if(this.customerDAO==null){
            this.customerDAO=new CustomerDAO();
        }
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public CartItemDAO getCartItemDAO() {
        if(this.cartItemDAO==null){
            cartItemDAO=new CartItemDAO();
        }
        return cartItemDAO;
    }

    public void setCartItemDAO(CartItemDAO cartItemDAO) {
        this.cartItemDAO = cartItemDAO;
    }
    
    
    

}
*/
