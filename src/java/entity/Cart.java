/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author serki
 */
@Entity
public class Cart extends BaseEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Min(value = 0, message = "totalprice 0 dan buyuk olmalidir")
    private int toplamFiyat;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(Customer customer, int toplamFiyat, List<CartItem> cartItems) {
        this.customer = customer;
        this.toplamFiyat = toplamFiyat;
        this.cartItems = cartItems;
    }

    public Cart(Customer customer, int toplamFiyat, List<CartItem> cartItems, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
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

    public int getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(int toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    
    
    
    
    
    
    
    
    
    
    /*
    
// @OneToOne
    // @JoinColumn(name = "customerid")
    private Customer customer;

    private int toplamFiyat;

    // @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    public Cart() {
    }

    public Cart(Long id, Customer customer, List<CartItem> cartItems, int toplamFiyat, Timestamp createdDate, Timestamp lastModifiedDate) {
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
     */
}
