/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.Timestamp;
import java.util.Objects;

public abstract class BaseEntity {

    private Long id;
    private Timestamp createdDate;
    private Timestamp lastModifiedDate;

    public BaseEntity() {
    }

    public BaseEntity(Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        this.id = id;
        this.createdDate =  new Timestamp(System.currentTimeMillis());
        this.lastModifiedDate =  new Timestamp(System.currentTimeMillis());
    }

    public BaseEntity(Timestamp createdDate, Timestamp lastModifiedDate) {
        this.createdDate =  new Timestamp(System.currentTimeMillis());
        this.lastModifiedDate =  new Timestamp(System.currentTimeMillis());
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedDate() {
        return  new Timestamp(System.currentTimeMillis());
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastModifiedDate() {
        return  new Timestamp(System.currentTimeMillis());
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseEntity other = (BaseEntity) obj;
        return Objects.equals(this.id, other.id);
    }
    
}