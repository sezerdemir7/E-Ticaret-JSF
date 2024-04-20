/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BaseDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseBean<T, D extends BaseDAO<T>> implements Serializable {

    private T entity;
    private D dao;
    private List<T> list;

    public BaseBean(T entity, D dao) {
        this.entity = entity;
        this.dao = dao;
    }
    
     public void clearForm(){
        this.entity=createEntityInstance();
    }
    

    public void create() {        
        getDao().create(getEntity());
        clearForm();
    }

    public void update() {
        getDao().update(getEntity());
    }

    public void delete() {
        getDao().delete(getEntity());
    }

    public T getEntity() {
        if (entity == null) {
            entity = createEntityInstance();
        }
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public D getDao() {
        if (dao == null) {
            dao = createDAOInstance();
        }
        return dao;
    }

    public void setDao(D dao) {
        this.dao = dao;
    }

    public List<T> getList() {
        list = getDao().readList();
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    protected abstract T createEntityInstance();

    protected abstract D createDAOInstance();
}