/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.sql.Timestamp;

/**
 *
 * @author serki
 */

@Entity
public class Payment extends BaseEntity {
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    
    private int odenenTutar;
    
    @OneToOne(mappedBy = "payment",  cascade = CascadeType.REMOVE)
    private Orders order;

    
    public Payment() {
    }
    
    public Payment(Customer customer, int odenenTutar, Orders order) {
        this.customer = customer;
        this.odenenTutar = odenenTutar;
        this.order = order;
    }

    public Payment(Customer customer, int odenenTutar, Orders order, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.customer = customer;
        this.odenenTutar = odenenTutar;
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOdenenTutar() {
        return odenenTutar;
    }

    public void setOdenenTutar(int odenenTutar) {
        this.odenenTutar = odenenTutar;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
    
    
    
    
    
    
    
    
    
    
    /*
    //@OneToOne(targetEntity = Payment.class)
    private Orders order;
    
   // @OneToOne
   // @JoinColumn(name = "customerid")
    private Customer customer ;
    private int odenenTutar ;

    public Payment() {
    }

    public Payment(Customer customer, int odenenTutar, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.customer = customer;
        this.odenenTutar = odenenTutar;
    }

    public Payment(Customer customer, int odenenTutar, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.customer = customer;
        this.odenenTutar = odenenTutar;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOdenenTutar() {
        return odenenTutar;
    }

    public void setOdenenTutar(int odenenTutar) {
        this.odenenTutar = odenenTutar;
    }
    

    

   
   */ 

    
    
    
}