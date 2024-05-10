/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CategoryDAO;
import entity.Category;
import entity.Product;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Demirr
 */
@FacesConverter("categoryConverter")
public class CategoryConverter implements Converter {

    private CategoryDAO categoryDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        Long id = Long.valueOf(string);
        Category category = this.getCategoryDAO().getEntityById(id);
        return category;

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Category category = (Category) t;
        return String.valueOf(category.getId());
    }

    public CategoryDAO getCategoryDAO() {
        if(this.categoryDAO==null){
            this.categoryDAO=new CategoryDAO();
        }
        return categoryDAO;
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    

}
