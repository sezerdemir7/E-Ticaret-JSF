/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FavoriteDAO;
import entity.Favorite;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class FavoriteBean  extends  BaseBean<Favorite, FavoriteDAO>{
    
    public FavoriteBean(){
        super(null,null);
    }

    public FavoriteBean(Favorite entity, FavoriteDAO dao) {
        super(entity, dao);
    }

    @Override
    protected Favorite createEntityInstance() {
        return new Favorite();
    }

    @Override
    protected FavoriteDAO createDAOInstance() {
        return new FavoriteDAO();
    }
    
    
}
