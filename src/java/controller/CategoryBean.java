/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import entity.BaseUser;
import entity.Category;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
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
    @Inject
    private FacesContext fc;

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
        if (hasPermission()) {
            this.dao.delete(entity);
            this.clearForm();
        } else {
            throw new SecurityException("Yetkisiz Deneme.");
        }

    }

    @Override
    public List<Category> getList() {
        return this.dao.readList();
    }

    @Override
    public Category getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }

    private boolean hasPermission() {

        BaseUser user = (BaseUser) fc.getExternalContext().getSessionMap().get("validUser");

        if (user != null && "admin".equals(user.getRole().getRoleName())) {
            return true;
        }

        return false;
    }

}
