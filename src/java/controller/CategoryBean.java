/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import entity.Category;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author Demirr
 */
@Named
@SessionScoped
public class CategoryBean extends BaseBean<Category, CategoryDAO>{

    public CategoryBean(Category entity, CategoryDAO dao) {
        super(entity, dao);
    }

    @Override
    protected Category createEntityInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected CategoryDAO createDAOInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
