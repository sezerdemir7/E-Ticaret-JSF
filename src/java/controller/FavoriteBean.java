/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FavoriteDAO;
import entity.Customer;
import entity.Favorite;
import entity.Product;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class FavoriteBean extends BaseBean<Favorite> implements Serializable {

    @EJB
    private FavoriteDAO dao;

    public FavoriteBean() {
        super(Favorite.class);
    }

    @Override
    public void create() {
        if (!this.dao.isFavoriteExists(entity.getCustomer().getId(), entity.getProduct().getId())) {
            this.dao.create(this.getEntity());
        }
        this.clearForm();
    }

    public void createFavorite(Product product, Customer cutsomer) {
        this.getEntity().setCustomer(cutsomer);
        this.getEntity().setProduct(product);
        System.out.println("**************");
        System.out.println("**************");
        this.create();
    }

    @Override
    public void update() {
        this.dao.update(getEntity());
        this.clearForm();
    }

    @Override
    public void delete() {
        this.dao.delete(getEntity());
        this.clearForm();
    }

    public void deleteFavorite(Favorite favorite) {
        this.setEntity(favorite);
        delete();
    }

    @Override
    public List<Favorite> getList() {
        return this.dao.readList();
    }

    public List<Favorite> getListByCustomerId(Long customerId) {
        return this.dao.getListByCustomerId(customerId);
    }

    @Override
    public Favorite getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }

}
