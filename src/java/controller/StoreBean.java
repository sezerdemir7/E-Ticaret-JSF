/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.StoreDAO;
import entity.Store;
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
public class StoreBean extends BaseBean<Store> implements Serializable {

    @EJB
    private StoreDAO dao;

    public StoreBean() {
        super(Store.class);
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
    public List<Store> getList() {
        return this.dao.readList();
    }

    @Override
    public Store getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }

}
/* public Store getStoreBySellerId(long sellerId){
       return getStoreDAO().getStoreBySellerId(sellerId);
   }*/
    /*
    public void create(Seller seller) {
        this.getEntity().setSeller(seller);
        super.create(); 
    }

    public StoreDAO getStoreDAO() {
        if(this.storeDAO==null){
            this.storeDAO=new StoreDAO();
        }
        return storeDAO;
    }

    public void setStoreDAO(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }
    
    


    
}
*/
