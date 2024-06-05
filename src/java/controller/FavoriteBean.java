/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FavoriteDAO;
import entity.Favorite;
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
public class FavoriteBean extends BaseBean<Favorite> implements Serializable{

    @EJB
    private FavoriteDAO dao;
    public FavoriteBean() {
        super(Favorite.class);
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

    @Override
    public List<Favorite> getList() {
        return this.dao.readList();
    }
     @Override
    public Favorite getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }


   

}
