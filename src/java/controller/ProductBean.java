/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProductDAO;
import entity.Product;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Demirr
 */
@Named
@SessionScoped

public class ProductBean extends BaseBean<Product, ProductDAO> {



    public ProductBean() {
        super(null, null);
    }

    @Override
    public void create() {

        super.create();
    }

    public List<Product> getProductListByCategoryId(Long categoryId) {
        List<Product> productList = new ArrayList<>();
        productList = getDao().getProductListByCategoryId(categoryId);
        return productList;
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
