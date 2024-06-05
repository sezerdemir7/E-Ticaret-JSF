/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 *
 * @author serki
 */
@Entity
public class CartItem  extends BaseEntity{
    
    private int adet;
    private int toplamFiyat;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Cart cart;
   
    
    
    public CartItem() {
    }
    
    
    public CartItem(int adet, int toplamFiyat, Product product, Cart cart, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.adet = adet;
        this.toplamFiyat = toplamFiyat;
        this.product = product;
        this.cart = cart;
    }
    
    public CartItem(int adet, int toplamFiyat, Product product, Cart cart, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.adet = adet;
        this.toplamFiyat = toplamFiyat;
        this.product = product;
        this.cart = cart;
    }
    
    
    
    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(int toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*

    
    
   // @OneToOne
   // @JoinColumn(name = "productid")
    private Product product;
    
   // @ManyToOne
   // @JoinColumn(name = "cartid")
    private Cart cart;
    
    private int toplamFiyat;
    private int adet;

    public CartItem() {
    }

    public CartItem(Product product, Cart cart, int toplamFiyat, int adet, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.product = product;
        this.cart = cart;
        this.toplamFiyat = toplamFiyat;
        this.adet = adet;
    }

    public CartItem(Product product, Cart cart, int toplamFiyat, int adet, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.product = product;
        this.cart = cart;
        this.toplamFiyat = toplamFiyat;
        this.adet = adet;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(int toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }
    
    
    */



    

    
    
}
