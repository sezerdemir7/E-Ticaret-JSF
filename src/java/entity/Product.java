/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Demirr
 */

@Entity
public class Product extends BaseEntity{
    
    private String name;
    private int stock;
   
    private String detail;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "product_category",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    
     private int price;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
    
    @ManyToMany(mappedBy = "products")
    private List<Orders> orders;
    
    public Product() {
    }

    public Product(String name, int stock, String detail, List<Category> category, int price, Store store, Long id, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(id, createdDate, lastModifiedDate);
        this.name = name;
        this.stock = stock;
        this.detail = detail;
        this.categories = category;
        this.price = price;
        this.store = store;
    }

    public Product(String name, int stock, String detail, List<Category> category, int price, Store store, Timestamp createdDate, Timestamp lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.name = name;
        this.stock = stock;
        this.detail = detail;
        this.categories = category;
        this.price = price;
        this.store = store;
    }


    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Category> getCategory() {
        return categories;
    }

    public void setCategory(List<Category> categories) {
        this.categories = categories;
    }

    

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
/*
    private String name;
    private int stock;
    private String fiyat;
    private List<Category> categories;
    private int price;
   // @OneToMany(mappedBy = "product")
    private List<Store> store;
    

    public Product() {
    }

    public Product(Long id, Timestamp createdDate, Timestamp lastModifiedDate, String name, int stock,String fiyats, List<Category> categories, int price, Store store) {
        super(id, createdDate, lastModifiedDate);
        this.name = name;
        this.stock = stock;
        this.categories = categories;
        this.price = price;
        this.store= (List<Store>) store;
    }

    public String getDetail() {
        return fiyat;
    }

    public void setDetail(String fiyat) {
        this.fiyat = fiyat;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Store> getStore() {
        return store;
    }

    public void setStore(List<Store> store) {
        this.store = store;
    }
*/

   

    
}

