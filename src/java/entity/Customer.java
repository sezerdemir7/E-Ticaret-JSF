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
public class Customer extends BaseUser {
    private String addres;

    public Customer() {
    }

    public Customer(String addres, Long id, String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate) {
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
    
    
    
}
