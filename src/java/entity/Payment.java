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
public class Payment extends BaseEntity {
    
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
    

    

   
    
    
    
    
    
}
