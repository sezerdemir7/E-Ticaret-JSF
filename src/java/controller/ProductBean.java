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
        super(Product.class, ProductDAO.class);
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
    private List<Product> listeleme;

    private int epp = 2;
    private int cp = 0;

    public int getEpp() {
        return epp;
    }

    public void setEpp(int epp) {
        this.epp = epp;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void next() {
        int toplamveri= getListeleme().size();
        if(toplamveri > (cp+1) *(epp-1)){
            cp++;
        }
        
    }

    public void prev() {
        if (cp > 0) {
            cp--;
        }

    }

    public List<Product> getListeleme() {
        return this.getDao().listele(this.getCp(), this.getEpp());
    }
    
    
   

}
