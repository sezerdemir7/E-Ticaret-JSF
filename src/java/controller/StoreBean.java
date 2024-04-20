/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.StoreDAO;
import entity.Seller;
import entity.Store;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class StoreBean extends BaseBean<Store, StoreDAO> {

    public StoreBean(Store entity, StoreDAO dao) {
        super(entity, dao);
    }
    
    public StoreBean() {
        super(null, null);
    }
    
    

    
    public void create(Seller seller) {
        this.getEntity().setSeller(seller);
        super.create(); 
    }
    

    @Override
    protected Store createEntityInstance() {
        return new Store();
    }

    @Override
    protected StoreDAO createDAOInstance() {
        return new StoreDAO();
    }
    
}
