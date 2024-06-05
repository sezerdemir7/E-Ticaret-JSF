/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Demirr
 */
@Entity
public class Store extends BaseEntity{
   
     private String name;
    @OneToOne
    @JoinColumn(name = "seller_id",nullable = false)
    private Seller seller;
    @OneToMany(mappedBy = "store")
    private List<Product> products;

    @OneToMany(mappedBy = "store")
    private List<Orders> orders;

    
    
    public Store() {
    }
    
    public Store(String name, Seller seller, List<Product> products, List<Orders> orders, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.name = name;
        this.seller = seller;
        this.products = products;
        this.orders = orders;
    }

    public Store(String name, Seller seller, List<Product> products, List<Orders> orders, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.name = name;
        this.seller = seller;
        this.products = products;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*private String name;
    
    //@OneToOne
   // @JoinColumn(name = "sellerid")  
    private Seller seller;
    
   // @ManyToOne
   //@JoinColumn(name = "orderid")
    private Orders order;
    
    //@ManyToOne
    //@JoinColumn(name = "productid")
    private Product product;

    public Store(String name, Seller seller, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.name = name;
        this.seller = seller;
    }
    
    public Store(String name, Seller seller, Timestamp createdDate, Timestamp lastModifiedDate) {
        super( createdDate, lastModifiedDate);
        this.name = name;
        this.seller = seller;
    }

  
    

    public Store() {
    }

    public Store(String name, Seller seller) {
        this.name = name;
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return name;
    }
    */

}
