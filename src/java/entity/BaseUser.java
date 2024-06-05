/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.sql.Timestamp;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

/**
 *
 * @author Demirr
 */
@MappedSuperclass
public abstract class BaseUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Timestamp createdDate;
    private Timestamp lastModifiedDate;
    

    public BaseUser() {
    }

    public BaseUser(Long id, String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.createdDate = new Timestamp(System.currentTimeMillis());
        this.lastModifiedDate =  new Timestamp(System.currentTimeMillis());
    }
    public BaseUser( String firstName, String lastName, String password, String email, Timestamp createdDate, Timestamp lastModifiedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.createdDate = new Timestamp(System.currentTimeMillis());
        this.lastModifiedDate =  new Timestamp(System.currentTimeMillis());
    }


     @PrePersist
    protected void onCreate(){
        this.createdDate = new Timestamp(System.currentTimeMillis());
        this.lastModifiedDate = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate(){
        this.lastModifiedDate = new Timestamp(System.currentTimeMillis());
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreatedDate() {
        return new Timestamp(System.currentTimeMillis());
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    public Timestamp getLastModifiedDate() {
        return new Timestamp(System.currentTimeMillis());
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = new Timestamp(System.currentTimeMillis());
    }
}