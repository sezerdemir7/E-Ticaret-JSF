/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author Demirr
 */
public interface BaseDAO<T> {
    public abstract void create(T entity);
    public abstract void update(T entity);
    public abstract void delete(T entity);
    public abstract List<T> readList();
    public abstract T getEntityById(Long id);
}
