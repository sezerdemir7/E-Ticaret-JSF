/*
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;
import javax.naming.InitialContext;

public class jpadao {

    
//private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("deneme");


    @PersistenceContext(name = "deneme")
    private EntityManager em;
    
    /*public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
*//*
    public static void executeTransaction(TransactionAction action) {
        EntityManager em = getEntityManager();
        UserTransaction transaction = null;
        try {
            transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();

            em.joinTransaction();
            action.execute(em);

            transaction.commit();
        } catch (Exception e) {
            try {
                if (transaction != null) {
                    transaction.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @FunctionalInterface
    public interface TransactionAction {
        void execute(EntityManager entityManager);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
}










/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *//*
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.UserTransaction;
import javax.naming.InitialContext;
*/
/**
 *
 * @author EXCALIBUR
 *//*
public class jpadao {
    
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("deneme");

    public void saveJpa(Object entity) {
        EntityManager em = emf.createEntityManager();
        UserTransaction transaction = null;
        try {
            // JTA işlemini başlat
            transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();

            em.joinTransaction();
            em.persist(entity);

            // JTA işlemini bitir
            transaction.commit();
        } catch (Exception e) {
            try {
                if (transaction != null) {
                    transaction.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void close() {
        emf.close();
    }

    
}
*/