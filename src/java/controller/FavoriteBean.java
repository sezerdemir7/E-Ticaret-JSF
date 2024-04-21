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
        super(null, null);
    }

    public FavoriteBean(Favorite entity, FavoriteDAO dao) {
        super(entity, dao);
    }

    public List<Product> getListProduct() {
        return getDao().getFavoriteListByCustomerId(1L);
    }

    @Override
    protected Favorite createEntityInstance() {
        return new Favorite();
    }

    @Override
    protected FavoriteDAO createDAOInstance() {
        return new FavoriteDAO(new ProductDAO());
    }

}
