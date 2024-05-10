/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartDAO;
import dao.CartItemDAO;
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
public class CartItemBean extends BaseBean<CartItem, CartItemDAO> {

    private CartDAO cartDAO;

    public CartItemBean() {
        super(CartItem.class, CartItemDAO.class);
    }

    public void addProductToCartItem(Product product, Customer customer) {
        Cart cart = null;
        cart = getCartDAO().getCartByCustomerId(customer.getId());

        this.getEntity().setProduct(product);
        this.getEntity().setCart(cart);
        this.getEntity().setToplamFiyat(product.getPrice()*1);
        cart.setToplamFiyat(0);//this.getEntity().getAdet()
        getCartDAO().update(cart);

        getDao().create(this.getEntity());
        //getDao().createCartItem(getEntity(), customer);
    }

    public List<CartItem> getCartItemsListByCartId(Long cartId) {
        return this.getDao().getCartItemsListByCartId(cartId);
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
