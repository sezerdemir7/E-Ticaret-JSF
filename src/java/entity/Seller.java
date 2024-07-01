/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import common.Role;
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

    public Seller(Long id, String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate,Role role) {
        super(id, firstName, lastName, password, email, createdDate, lastModifiedDate,role);
    }

    public Seller(String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate,Role role) {
        super(firstName, lastName, password, email, createdDate, lastModifiedDate,role);
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    

}
