/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartItemDAO;
import entity.CartItem;

/**
 *
 * @author serki
 */
public class CartItemBean extends BaseBean<CartItem,CartItemDAO> {

    public CartItemBean(CartItem entity, CartItemDAO dao) {
        super(entity, dao);
    }

    @Override
    protected CartItem createEntityInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected CartItemDAO createDAOInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
