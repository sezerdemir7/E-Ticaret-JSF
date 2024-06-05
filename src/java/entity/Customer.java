/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author serki
 */

@Entity
public class Customer extends BaseUser {
   
    
    
    private String addres;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private Cart cart;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Orders> orders;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Favorite> favorites;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Payment> payments;

    
    public Customer() {
    }
    
    public Customer(String addres, Cart cart, List<Orders> orders, List<Favorite> favorites, List<Payment> payments, Long id, String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, firstName, lastName, password, email, createdDate, lastModifiedDate);
        this.addres = addres;
        this.cart = cart;
        this.orders = orders;
        this.favorites = favorites;
        this.payments = payments;
    }

    public Customer(String addres, Cart cart, List<Orders> orders, List<Favorite> favorites, List<Payment> payments, String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(firstName, lastName, password, email, createdDate, lastModifiedDate);
        this.addres = addres;
        this.cart = cart;
        this.orders = orders;
        this.favorites = favorites;
        this.payments = payments;
    }
    
    
    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
   // @OneToOne(mappedBy = "customer")
    private Cart cart;
    private String addres;
   // @OneToOne(mappedBy = "customer")
    private Orders order;
    
   // @OneToOne(mappedBy = "customer")
    private Payment payment;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String password, String email,String addres, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, firstName, lastName, password, email, createdDate, lastModifiedDate);
        this.addres = addres;
    }

    public Customer(String addres, String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(firstName, lastName, password, email, createdDate, lastModifiedDate);
        this.addres = addres;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }
    */


    
    
    
}
