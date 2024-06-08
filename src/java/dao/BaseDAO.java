/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Local
@Stateless
public abstract class BaseDAO<T> implements Serializable{

    @PersistenceContext(unitName = "deneme")
    protected EntityManager em;

    private Class<T> entityClass;

    public BaseDAO(){
        
    }
    
    public BaseDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /*protected EntityManager getEntityManager() {

        return em;
    }*/

    public void create(T entity) {
        em.persist(entity);
    }

    public void update(T entity) {
        em.merge(entity);
    }

    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

    public List<T> readList() {
        // EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
        } finally {
            //getEntityManager().close();
        }
    }

    public T getEntityById(Object id) {
        // EntityManager em = jpadao.getEntityManager();
        try {
            return em.find(entityClass, id);
        } finally {
            em.close();
        }
    }
}
/*public void update(T entity) {
        jpadao.executeTransaction(entityManager -> entityManager.merge(entity));
    }

    public void delete(T entity) {
    jpadao.executeTransaction(entityManager -> {
        T managedEntity = entity;
        if (!entityManager.contains(entity)) {
            managedEntity = entityManager.merge(entity);
        }
        entityManager.remove(managedEntity);
    });
}
}





































/*
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Demirr
 *//*
public abstract class BaseDAO<T> {
    
    //@PersistenceContext(unitName = "deneme")
    
    public void create(T entity){
        
    }
    
    
    /*
    public  void create(T entity);
    public  void update(T entity);
    public  void delete(T entity);
    public  List<T> readList();
    public  T getEntityById(Long id);


}
 */
