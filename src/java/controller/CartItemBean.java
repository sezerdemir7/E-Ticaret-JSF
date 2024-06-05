/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartItemDAO;
import entity.CartItem;
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
public class CartItemBean extends BaseBean<CartItem> implements Serializable {

    @EJB
    private CartItemDAO dao;

    public CartItemBean() {
        super(CartItem.class);
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
    public List<CartItem> getList() {
        return this.dao.readList();
    }

    @Override
    public CartItem getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }

}

/*
    public CartItemBean() {
        super(CartItem.class, CartItemDAO.class);
    }

    public void addProductToCartItem(Product product, Customer customer) {
        Cart cart =new Cart();
        cart.setCustomer(customer);
        cart = getCartDAO().getCartByCustomer(customer);

        this.getEntity().setProduct(product);
        this.getEntity().setCart(cart);
        this.getEntity().setToplamFiyat(product.getPrice()*1);
        cart.setToplamFiyat(cart.getToplamFiyat()+product.getPrice());
        getCartDAO().update(cart);

        getDao().create(this.getEntity());
        //getDao().createCartItem(getEntity(), customer);
    }

    public List<CartItem> getCartItemsListByCartId(Cart cart) {
        return this.getDao().getCartItemsListByCart(cart);
    }

    public void deleteAndSetEntity(CartItem cartItem) {
        setEntity(cartItem);
        this.getDao().delete(getEntity());
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
