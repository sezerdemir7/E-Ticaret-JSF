/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartDAO;
import entity.Cart;
import entity.CartItem;
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
    
    public CartBean() {
        super(null,null);
    }

    public CartBean(Cart entity, CartDAO dao) {
        super(entity, dao);
    }
    
    //Eğer customerin sepeti yoksa sepet oluşturu  ve bunu döndürür varsa var olana sepeti döndürür
    public List<CartItem>  getCartByCuctomerId(Long customerId){
       Cart cart=new Cart();
       cart=getDao().getEntityById(customerId);
       this.setEntity(cart);
       
       return getEntity().getCartItems();
    }
    
    public void addProductToCart(Product product){
        
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
