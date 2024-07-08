package controller;

import dao.ProductDAO;
import entity.BaseUser;
import entity.Category;
import entity.Product;
import entity.Store;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductBean extends BaseBean<Product> implements Serializable {

    @EJB
    private ProductDAO dao;
    @Inject
    private ImageBean imageBean;

    @Inject
    private FacesContext fc;

    private Category selectedCategory;
    private List<Product> filteredProducts;

    public ProductBean() {
        super(Product.class);
    }

    @Override
    public void create() {
        if (hasPermission() == true) {
            this.dao.create(this.getEntity());
            this.clearForm();
            refreshProducts();
        } else {
            throw new SecurityException("yetkisiz deneme.");
        }

    }

    public void createProduct(Store store) {
        this.getEntity().setImage(this.imageBean.upload());
        this.getEntity().setStore(store);
        create();
    }

    @Override
    public void update() {
        if (hasPermission() == true) {
            this.dao.update(entity);
            this.clearForm();
            refreshProducts();
        } else {
            throw new SecurityException("yetkisiz deneme.");
        }

    }

    @Override
    public void delete() {

        if (hasPermission() == true) {
            this.dao.delete(entity);
            this.clearForm();
            refreshProducts();
        } else {
            throw new SecurityException("yetkisiz deneme.");
        }

    }

    @Override
    public List<Product> getList() {
        return this.dao.listele(this.getCp(), this.getEpp());
    }

    @Override
    public Product getEntityById(Long id) {
        return this.dao.getEntityById(id);
    }

    public List<Product> getProductListByStoreId(Long StoreId) {
        return this.dao.getProductListByStoreId(StoreId);
    }

    public void deleteProduct(Product product) {
        this.dao.delete(product);
    }

    public void filterProductsByCategory(Category category) {
        this.selectedCategory = category;
        this.cp = 1;  // Reset to the first page when changing category
        refreshProducts();
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public List<Product> getFilteredProducts() {
        if (filteredProducts == null) {
            refreshProducts();
        }
        return filteredProducts;
    }

    private void refreshProducts() {
        if (selectedCategory == null) {
            filteredProducts = this.dao.listele(this.getCp(), this.getEpp());
        } else {
            filteredProducts = this.dao.getProductListByCategoryId(selectedCategory.getId(), this.getCp(), this.getEpp());
        }
    }

    private int epp = 3;
    private int cp = 1;
    private int pageValue;

    public int getPagesize() {
        this.pageValue = (int) Math.ceil(this.dao.count(selectedCategory) / (double) epp);
        return pageValue;
    }

    public void setPagesize(int pageValue) {
        this.pageValue = pageValue;
    }

    public int getEpp() {
        return epp;
    }

    public void setEpp(int epp) {
        this.epp = epp;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public void next() {
        if (this.cp < this.getPagesize()) {
            this.cp++;
            refreshProducts();
        }
    }

    public void prev() {
        if (this.cp > 1) {
            this.cp--;
            refreshProducts();
        }
    }

    private boolean hasPermission() {

        BaseUser user = (BaseUser) fc.getExternalContext().getSessionMap().get("validUser");

        if (user != null && (user.getRole().getRoleName().equals("Admin") || user.getRole().getRoleName().equals("Seller"))) {
            return true;
        }

        return false;
    }
}
