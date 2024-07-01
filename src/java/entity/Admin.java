/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


import common.Role;
import jakarta.persistence.Entity;
import java.sql.Timestamp;

/**
 *
 * @author serki
 */
@Entity
public class Admin  extends BaseUser{

    public Admin() {
    }

    public Admin(Long id, String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate,Role role) {
        super(id, firstName, lastName, password, email, createdDate, lastModifiedDate,role);
    }

    public Admin(String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate,Role role) {
        super(firstName, lastName, password, email, createdDate, lastModifiedDate,role);
    }
    
    
}
