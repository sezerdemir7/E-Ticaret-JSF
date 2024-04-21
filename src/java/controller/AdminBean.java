/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AdminDAO;
import entity.Admin;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author serki
 */
@Named
@SessionScoped
public class AdminBean extends BaseBean<Admin, AdminDAO>{
    
    public AdminBean () {
        super(null,null);
    }
    
    
    public AdminBean(Admin entity, AdminDAO dao) {
        super(entity, dao);
    }

    @Override
    protected Admin createEntityInstance() {
           return new Admin();
    }

    @Override
    protected AdminDAO createDAOInstance() {
        return new AdminDAO();
    }
    
}
