/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartDAO;
import entity.Cart;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class CartBean extends BaseBean<Cart, CartDAO> {
    
    public CartBean() {
        super(null,null);
    }

    public CartBean(Cart entity, CartDAO dao) {
        super(entity, dao);
    }

    @Override
    protected Cart createEntityInstance() {
        
        return new Cart();
    }

    @Override
    protected CartDAO createDAOInstance() {

        return new CartDAO();
    }
    
}
