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
    public  void create(T entity);
    public  void update(T entity);
    public  void delete(T entity);
    public  List<T> readList();
    public  T getEntityById(Long id);
}
