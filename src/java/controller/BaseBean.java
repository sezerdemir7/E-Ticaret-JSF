/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BaseDAO;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

import java.util.List;

public abstract class BaseBean<T, D extends BaseDAO<T>> implements Serializable {

    private T entity;
    private D dao;
    private List<T> list;
    private Class<T> entityClass;
    private Class<D> daoClass;

    public BaseBean(Class<T> ec,Class<D> dc) {
       this.entityClass=ec;
       this.daoClass=dc;
    }
    public BaseBean(){
        
    }
    
     public void clearForm(){
        this.entity=null;
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
            try {
            entity=entityClass.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Cannot create an instance of entity.", ex);
        }
        }
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public D getDao() {
        if (dao == null) {
           try {
           dao= daoClass.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Cannot create an instance of DAO.", ex);
        }
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


}