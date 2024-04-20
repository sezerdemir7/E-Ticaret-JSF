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
    private Store store;
    private int toplamFiyat;
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(Customer customer, Store store, int toplamFiyat, List<CartItem> cartItems, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.customer = customer;
        this.store = store;
        this.toplamFiyat = toplamFiyat;
        this.cartItems = cartItems;
    }

    public Cart(Customer customer, Store store, int toplamFiyat, List<CartItem> cartItems, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.customer = customer;
        this.store = store;
        this.toplamFiyat = toplamFiyat;
        this.cartItems = cartItems;
    }
    
    
}
