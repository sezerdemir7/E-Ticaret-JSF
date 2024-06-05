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
public class OrderDetail extends BaseEntity{
    
    
    private int adet;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    
    public OrderDetail() {
    }
    
    
    public OrderDetail(int adet, Product product, Orders order, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.adet = adet;
        this.product = product;
        this.orders = order;
    }

    public OrderDetail(int adet, Product product, Orders order, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.adet = adet;
        this.product = product;
        this.orders = order;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrder() {
        return orders;
    }

    public void setOrder(Orders order) {
        this.orders = order;
    }
    
    
    
    
    
   /* private int adet;
    private Product product;
    
   // @ManyToOne
   // @JoinColumn(name = "orderid")
    private Orders order;

    public OrderDetail() {
    }

    public OrderDetail(int adet, Product product, Orders order, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.adet = adet;
        this.product = product;
        this.order = order;
    }

    public OrderDetail(int adet, Product product, Orders order, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.adet = adet;
        this.product = product;
        this.order = order;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
    
    
    */

}
