/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import java.sql.Timestamp;

/**
 *
 * @author Demirr
 */

@Entity
public class Seller extends BaseUser {

    @OneToOne(mappedBy = "seller", fetch = FetchType.EAGER)
    private Store store;
   
    public Seller() {
    }

    public Seller(Long id, String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, firstName, lastName, password, email, createdDate, lastModifiedDate);
    }

    public Seller(String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(firstName, lastName, password, email, createdDate, lastModifiedDate);
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    

}
