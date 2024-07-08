/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Statement;
import entity.Category;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serki
 */

@Local
@Stateless
public class CategoryDAO extends BaseDAO<Category> implements Serializable{

    public CategoryDAO() {
        super(Category.class);
    }
    public Category getCategoryById(Long id){
        
            return em.find(Category.class, id);
        
    }

}

   
