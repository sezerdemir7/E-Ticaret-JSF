
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProductDAO;
import entity.Product;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Demirr
 */
@Named
@SessionScoped

public class ProductBean extends BaseBean<Product> implements Serializable {

    @EJB
    private ProductDAO dao;

    public ProductBean() {
        super(Product.class);
    }

    @Override
    public void create() {
        this.dao.create(entity);
        this.clearForm();
    }

    @Override
    public void update() {
        this.dao.update(entity);
        this.clearForm();
    }

    @Override
    public void delete() {
        this.dao.delete(entity);
        this.clearForm();
    }

    private int epp = 3;
    private int cp = 1;
    private int pageValue;

    public int getPagesize() {
        this.pageValue = (int) Math.ceil(this.dao.Count() / (double) epp);
        return pageValue;
    }

    public void setPagesize(int pageValue) {
        this.pageValue = pageValue;
    }

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
        if (this.cp == this.getPagesize()) {
            this.cp = 1;
        } else {
            this.cp++;
        }

    }

    public void prev() {
        if (cp == 1) {
            this.cp = this.getPagesize();
        } else {
            this.cp--;
        }
    }

    @Override
    public List<Product> getList() {
        return this.dao.listele(this.getCp(), this.getEpp());
    }

    @Override
    public Product getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }

    /* public List<Product> getProductListByCategoryId(Long categoryId) {
        List<Product> productList = new ArrayList<>();
        productList = getDao().getProductListByCategoryId(categoryId);
        return productList;
    }
     */
 /* public void deleteProduct(Product product){
        getDao().delete(product);
    }*/
    //private List<Product> listeleme;
}
