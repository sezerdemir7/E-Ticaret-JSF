/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartDAO;
import dao.CartItemDAO;
import dao.CustomerDAO;
import entity.Cart;
import entity.CartItem;
import entity.Customer;
import entity.Product;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class CartBean extends BaseBean<Cart, CartDAO> {
    private CustomerDAO customerDAO;
    private CartItemDAO cartItemDAO;

    public CartBean() {
        super(Cart.class, CartDAO.class);
    }

    public List<CartItem> getCartByCuctomerId(Customer customer) {
        Cart cart = new Cart();
        
        
        cart = getDao().getCartByCustomer(customer);
        cart.setCustomer(customer);
        this.setEntity(cart);
        
        List<CartItem> cartItems=getCartItemDAO().getCartItemsListByCart(cart);
        return cartItems;
    }

    public void addProductToCart(Product product) {

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
