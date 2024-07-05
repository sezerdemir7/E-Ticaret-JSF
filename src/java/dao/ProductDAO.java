package dao;

import entity.Category;
import entity.OrderDetail;
import entity.Product;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
public class ProductDAO extends BaseDAO<Product> implements Serializable {

    public ProductDAO() {
        super(Product.class);
    }

    public List<Product> listele(int cp, int epp) {
        List<Product> productList;
        try {
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
            query.setFirstResult((cp - 1) * epp);
            query.setMaxResults(epp);
            productList = query.getResultList();
            System.out.println("Product listing successful");
        } catch (Exception e) {
            System.out.println("Error while reading product list: " + e.getMessage());
            productList = new ArrayList<>();
        }
        return productList;
    }

    public int count(Category category) {
        int count = 0;
        if (category == null) {
            try {
                TypedQuery<Long> query = em.createQuery("SELECT COUNT(p) FROM Product p", Long.class);
                count = query.getSingleResult().intValue();
            } catch (Exception e) {
                System.out.println("Product count calculation failed: " + e.getMessage());
            }
        } else {
            try {
                TypedQuery<Long> query = em.createQuery(
                        "SELECT COUNT(p) FROM Product p JOIN p.categories c WHERE c.id = :categoryId",
                        Long.class);
                query.setParameter("categoryId", category.getId());
                count = query.getSingleResult().intValue();
            } catch (Exception e) {
                System.out.println("Product count calculation failed: " + e.getMessage());
            }
        }

        return count;
    }

   
    
    
    

    public List<Category> getProductCategories(Long productId) {
        List<Category> categoryList = null;
        try {
            TypedQuery<Category> query = em.createQuery(
                    "SELECT c FROM Category c WHERE c.id IN "
                    + "(SELECT pc.category.id FROM ProductCategory pc WHERE pc.product.id = :productId)",
                    Category.class);
            query.setParameter("productId", productId);
            categoryList = query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categoryList;
    }

    public List<Product> getProductListByCategoryId(Long categoryId, int cp, int epp) {
    List<Product> productList;
    try {
        TypedQuery<Product> query = em.createQuery(
            "SELECT p FROM Product p JOIN p.categories c WHERE c.id = :categoryId",
            Product.class);
        query.setParameter("categoryId", categoryId);
        query.setFirstResult((cp - 1) * epp);
        query.setMaxResults(epp);
        productList = query.getResultList();
        System.out.println("Product listing by category successful");
    } catch (Exception e) {
        System.out.println("Error while reading product list by category: " + e.getMessage());
        productList = new ArrayList<>();
    }
    return productList;
}
    
    public List<Product> getProductListByStoreId( Long storeId) {
    List<Product> productList;
    try {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.store.id = :storeId", Product.class);
        query.setParameter("storeId", storeId);
        
        productList = query.getResultList();
        System.out.println("Product listing successful");
    } catch (Exception e) {
        System.out.println("Error while reading product list: " + e.getMessage());
        productList = new ArrayList<>();
    }
    return productList;
}



}
