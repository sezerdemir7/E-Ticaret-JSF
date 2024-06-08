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

    //bu eklendi 
    @EJB
    private CartDAO cartdao;

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

    //buradan sonrası eklendi
    public List<CartItem> getCartItemsListByCartId(Cart cart) {
        return this.dao.getCartItemsListByCart(cart);
    }

    public void deleteAndSetEntity(CartItem cartItem) {
        Cart cart=cartdao.getCartByCartId(cartItem.getCart().getId());
        cart.setToplamFiyat(cart.getToplamFiyat()-cartItem.getToplamFiyat());
        this.cartdao.update(cart);
        setEntity(cartItem);
        this.dao.delete(getEntity());
    }

    public void addProductToCartItem(Product product, Customer customer) {
        Cart cart = this.cartdao.getCartByCustomer(customer);

        List<CartItem> cartItems=this.dao.getCartItemsListByCart(cart);
        for (CartItem item : cartItems) {
            if (item.getProduct().equals(product)) {
                // Ürün zaten varsa, miktarını artır ve toplam fiyatı güncelle
                item.setAdet(item.getAdet() + 1);
                item.setToplamFiyat(item.getAdet() * product.getPrice());
                this.dao.update(item);

                // Sepetin toplam fiyatını güncelle
                cart.setToplamFiyat(cart.getToplamFiyat() + product.getPrice());
                this.cartdao.update(cart);

                return; // İşlem tamam, metottan çık
            }
        }

        // Ürün sepette yoksa yeni CartItem oluştur ve sepete ekle
        CartItem newItem = new CartItem();
        newItem.setProduct(product);
        newItem.setCart(cart);
        newItem.setAdet(1);
        newItem.setToplamFiyat(product.getPrice());

        cart.getCartItems().add(newItem);
        cart.setToplamFiyat(cart.getToplamFiyat() + product.getPrice());

        this.dao.create(newItem);
        this.cartdao.update(cart);
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
