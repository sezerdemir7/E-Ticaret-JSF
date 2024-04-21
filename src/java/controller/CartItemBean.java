/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartItemDAO;
import entity.CartItem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class CartItemBean extends BaseBean<CartItem,CartItemDAO> {
    
    public CartItemBean (){
        super(null,null);
    }

    public CartItemBean(CartItem entity, CartItemDAO dao) {
        super(entity, dao);
    }

    @Override
    protected CartItem createEntityInstance() {
        return new CartItem();
    }

    @Override
    protected CartItemDAO createDAOInstance() {
        return new CartItemDAO();
    }
    
}
