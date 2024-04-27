/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author serki
 */
public class Cart extends BaseEntity {
    private Customer customer;
    private int toplamFiyat;
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart( Long id,Customer customer, List<CartItem> cartItems,int toplamFiyat,  Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.customer = customer;
        this.toplamFiyat = toplamFiyat;
        this.cartItems = cartItems;
    }

    public Cart(Customer customer, int toplamFiyat, List<CartItem> cartItems, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.customer = customer;
       
        this.toplamFiyat = toplamFiyat;
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

   

    public int getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(int toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    
    
}
