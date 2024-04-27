/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartItemDAO;
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
public class CartItemBean extends BaseBean<CartItem,CartItemDAO> {
    
    public CartItemBean (){
        super(null,null);
    }

    public CartItemBean(CartItem entity, CartItemDAO dao) {
        super(entity, dao);
    }
    
    public void addProductToCartItem(Product product,Customer customer){
        this.getEntity().setProduct(product);
        getDao().createCartItem(getEntity(),customer);
    }

    public List<CartItem> getCartItemsListByCartId(Long cartId){
        return this.getDao().getCartItemsListByCartId(cartId);
    }
    
    public void deleteAndSetEntity(CartItem cartItem){
        setEntity(cartItem);
        this.getDao().delete(getEntity());
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
