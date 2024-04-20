/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BaseDAO;
import dao.SellerDAO;
import entity.Category;
import entity.Seller;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author Demirr
 */
@Named
@SessionScoped
public class SellerBean extends BaseBean<Seller, SellerDAO>{

    public SellerBean(Seller entity, SellerDAO dao) {
        super(entity, dao);
    }
    


    public SellerBean() {
        super(null, null);
    }

    @Override
    protected Seller createEntityInstance() {
        return new Seller();
    }

    @Override
    protected SellerDAO createDAOInstance() {
        return new SellerDAO();
    }

    @Override
    public void setList(List<Seller> list) {
        super.setList(list); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public List<Seller> getList() {
        return super.getList(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setDao(SellerDAO dao) {
        super.setDao(dao); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public SellerDAO getDao() {
        return super.getDao(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setEntity(Seller entity) {
        super.setEntity(entity); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Seller getEntity() {
        return super.getEntity(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void delete() {
        super.delete(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void update() {
        super.update(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void create() {
        super.create(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
