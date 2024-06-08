/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import entity.Category;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Demirr
 */
@Named
@SessionScoped
public class CategoryBean extends BaseBean<Category> implements Serializable {

    @EJB
    private CategoryDAO dao;

    public CategoryBean() {
        super(Category.class);
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
    public List<Category> getList() {
        return this.dao.readList();
    }

    @Override
    public Category getEntityById(Long id) {
        return this.dao.getEntityById(id);
}

}
