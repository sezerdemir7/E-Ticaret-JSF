/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CategoryDAO;
import entity.Category;
import jakarta.annotation.ManagedBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Demirr
 */
@Named
@RequestScoped
@FacesConverter(value = "categoryConverter",managed = true)
public class CategoryConverter implements Converter, Serializable {
    @EJB
    private CategoryDAO categoryDAO;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		if (!string.isBlank()) {
			Long id = Long.valueOf(string);
			return categoryDAO.getCategoryById(id);
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object t) {
		if (t != null) {
			Category c = (Category) t;
			return c.getId().toString();
		} else {
			return "";
		}
	}

  

}
