/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author Demirr
 */
public class Product extends BaseEntity{

    private String name;
    private int stock;
    private Category category;
    private int price;
    private Store store;

    public Product() {
    }

    public Product(Long id, Timestamp createdDate, Timestamp lastModifiedDate, String name, int stock, Category category, int price, Store store) {
        super(id, createdDate, lastModifiedDate);
        this.name = name;
        this.stock = stock;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}

