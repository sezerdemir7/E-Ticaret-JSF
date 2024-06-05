/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseBean<T> implements Serializable {

    protected T entity;
    private List<T> list;
    private  final Class<T> entityClass;

    public BaseBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    public abstract void create();
    public abstract void update();
    public abstract void delete();
    public abstract List<T> getList();
    public abstract T getEntityById(Long id);

    
    public void clearForm() {
        try {
            this.entity = entityClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public T getEntity() {
        if (entity == null) {
            try {
                entity = entityClass.getDeclaredConstructor().newInstance();
            } catch (Exception ex) {
                throw new RuntimeException("Cannot create an instance of entity.", ex);
            }
        }
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

}
