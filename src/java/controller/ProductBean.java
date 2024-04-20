/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProductDAO;
import entity.Product;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author Demirr
 */
@Named
@SessionScoped

public class ProductBean extends BaseBean<Product, ProductDAO> {

    public ProductBean(Product entity, ProductDAO dao) {
        super(entity, dao);
    }
    

    @Override
    protected Product createEntityInstance() {

        return new Product();
    }

    @Override
    protected ProductDAO createDAOInstance() {
        return new ProductDAO();
    }

    
}
