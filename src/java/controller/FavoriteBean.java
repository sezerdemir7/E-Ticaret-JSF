/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FavoriteDAO;
import dao.ProductDAO;
import entity.Favorite;
import entity.Product;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class FavoriteBean extends BaseBean<Favorite, FavoriteDAO> {

    public FavoriteBean() {
        super(Favorite.class, FavoriteDAO.class);
    }

    public List<Product> getListProduct() {
        return this.getDao().getFavoriteListByCustomerId(1L);
    }

}
