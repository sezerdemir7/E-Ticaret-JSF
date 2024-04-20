/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author serki
 */
public class Order extends BaseEntity{
    private Customer customer;
    private Timestamp orderDate;
    private boolean status;
    private String teslimatAdresi;
    private Payment payment;
    private int toplamTutar;

    public Order() {
    }

    public Order(Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
    }

    public Order(Customer customer, Timestamp orderDate, boolean status, String teslimatAdresi, Payment payment, int toplamTutar, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        this.teslimatAdresi = teslimatAdresi;
        this.payment = payment;
        this.toplamTutar = toplamTutar;
    }

    public Order(Customer customer, Timestamp orderDate, boolean status, String teslimatAdresi, Payment payment, int toplamTutar, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        this.teslimatAdresi = teslimatAdresi;
        this.payment = payment;
        this.toplamTutar = toplamTutar;
    }

    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTeslimatAdresi() {
        return teslimatAdresi;
    }

    public void setTeslimatAdresi(String teslimatAdresi) {
        this.teslimatAdresi = teslimatAdresi;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(int toplamTutar) {
        this.toplamTutar = toplamTutar;
    }
    
    
    
    
    
}

