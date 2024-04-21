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
    
    public CategoryBean(){
        super(null,null);
    }

    public CategoryBean(Category entity, CategoryDAO dao) {
        super(entity, dao);
    }

    @Override
    protected Category createEntityInstance() {
        return new Category();
    }

    @Override
    protected CategoryDAO createDAOInstance() {
        return new CategoryDAO();
    }
    
}
